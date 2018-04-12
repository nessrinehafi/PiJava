/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entity.Rendez_vous;
import Entity.User;

import static GUI.ModifierrdvInterfaceController.idaccepteur;
import Utils.Mail;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Callback;
import jfxtras.scene.control.CalendarPicker;
import org.controlsfx.control.Notifications;
import static sprintjavagui.User.LoginController.LoggedUser;


/**
 * FXML Controller class
 *
 * @author haythem
 */
public class PrendrerdvInterfaceController implements Initializable {

    @FXML
    private TextArea message;
    @FXML
    private DatePicker date;
    @FXML
    private ComboBox<String> heure;
    @FXML
    private Button Valider;
    
    
    
    public static Integer id_accepteur;
    
    
    
    public String resultat;
    
    
    @FXML
    private Button rdvattenteuser;
    @FXML
    private Button listerdvvalider;
    
    @FXML
    private AnchorPane test;

List myList = new ArrayList();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        
        
        listerdvvalider.setVisible(false);
        
        
        rdvattenteuser.setVisible(false);
        
        if (LoggedUser.getRole().contains("Educateur canin") || LoggedUser.getRole().contains("Vétérinaire"))
        {
            
            listerdvvalider.setVisible(true);
        }
        
        if (LoggedUser.getRole().contains("utilisateur simple"))
        {
            rdvattenteuser.setVisible(true);
        }
        
        
        Services.CRUD s = new Services.CRUD() {};
        
       
        
        
        heure.getItems().add("8h");
        heure.getItems().add("9h");
        heure.getItems().add("10h");
        heure.getItems().add("11h");
        heure.getItems().add("14h");
        heure.getItems().add("15h");
        heure.getItems().add("16h");
        heure.getItems().add("17h");
        
        Valider.setVisible(false);
        
        

    }    
    
    
    
    
    
            
            
        @FXML
    private void verification(ActionEvent event) {
        
        Services.CRUD s = new Services.CRUD() {};
        

    if ( date.getValue() == null || heure.getValue().isEmpty())
        {
            Alert alert = new Alert(Alert.AlertType.ERROR, "champs vides");

            alert.showAndWait();
        }
        
    
        
    
    
        for (Rendez_vous r:s.afficheallrdv() )
        {
            
        String datee = date.getValue().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        
        String heuree = heure.getValue();
       
        
        if (r.getDate().equals(datee) && r.getHeure().equals(heuree) && r.getAccepteur_id()== id_accepteur && r.isRemove() == false) {
           
            
            resultat = "non";
            break;
            
           
            
                    
                
        }
        
        else {
            
            

             resultat = "oui";
             
             
              
             
        }
        
        
        }
       
       
        
        
        
         if ( resultat.equals("non") ){
            
         Alert alert1 = new Alert(Alert.AlertType.ERROR, "LA DATE CHOISI EST DÉJÀ PRISE, VEUILLEZ CHOISIR UNE AUTRE DATE. ");
          
         alert1.show();
         
         Valider.setVisible(false);
         
        }
         
         if(resultat.equals("oui")) {
            
            Alert alert2 = new Alert(Alert.AlertType.CONFIRMATION, "LA DATE CHOISIE EST DISPONIBLE, CLICKER SUR VALIDER. ");
            
            alert2.show();
            
            Valider.setVisible(true);
            
            
            
            
            
         }
    }
    
    

    @FXML
    private void Valider(ActionEvent event) throws IOException {
        
        Services.CRUD s = new Services.CRUD() {};
       

        
        
        if ( date.getValue() == null || heure.getValue().isEmpty())
        {
            Alert alert = new Alert(Alert.AlertType.ERROR, "champs vides");

            alert.showAndWait();
        }
        
        
        
        java.util.Date date_util = new java.util.Date();
        java.sql.Date date_sql = new java.sql.Date(date_util.getTime());
        
        String datee = date.getValue().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        
        
        
         Rendez_vous r = new Rendez_vous(message.getText(), datee, heure.getValue(),date_sql,date_sql,LoggedUser.getId(),false,id_accepteur,false,"Dressage");
         

         s.ajouter(r);

        
        User user = s.getMail(id_accepteur);
       
        
                Mail.send(LoggedUser.getEmail_canonical(), "Colocation Esprit", "votre rendez-vous a ete effectue veuillez voir sur notre site. ");
           
                
                Mail.send(user.getEmail_canonical(), "Colocation Esprit", "Vous avez un rendez-vous a valide veuillez voir sur notre site.");
               
                
                Notifications.create().title("Succes").text("votre rendez-vous a ete effectue avec succes").position(Pos.BOTTOM_RIGHT).showConfirm();
        
                    
                if(LoggedUser.getRole() == "utilisateur simple")
                {
                    Parent page_select_my = FXMLLoader.load(getClass().getResource("ListerdvattnteuserInterface.fxml"));        
        Scene scene = new Scene(page_select_my);
        Stage app=(Stage)((Node)event.getSource() ).getScene().getWindow();
        app.setScene(scene);
        app.show();
        
                }
                
                else
                {
                    Parent page_select_my = FXMLLoader.load(getClass().getResource("ListerdvattenteInterface.fxml"));        
        Scene scene = new Scene(page_select_my);
        Stage app=(Stage)((Node)event.getSource() ).getScene().getWindow();
        app.setScene(scene);
        app.show();
        
                }
                
                
        
        
    }

    @FXML
    private void Accueil(ActionEvent event) throws IOException {
        
                            
        Parent page_select_my = FXMLLoader.load(getClass().getResource("AccueilInterface.fxml"));        
        Scene scene = new Scene(page_select_my);
        Stage app=(Stage)((Node)event.getSource() ).getScene().getWindow();
        app.setScene(scene);
        app.show();
    }
    
    
    @FXML
    private void rdvattente(ActionEvent event) throws IOException {
        
      
            
            
        
        
        
            Parent page_select_my = FXMLLoader.load(getClass().getResource("ListerdvattnteuserInterface.fxml"));        
        Scene scene = new Scene(page_select_my);
        Stage app=(Stage)((Node)event.getSource() ).getScene().getWindow();
        app.setScene(scene);
        app.show();
        
        
    }

    @FXML
    private void rdvuser(ActionEvent event) throws IOException {
        
        
        Parent page_select_my = FXMLLoader.load(getClass().getResource("Listerdvuser.fxml"));        
        Scene scene = new Scene(page_select_my);
        Stage app=(Stage)((Node)event.getSource() ).getScene().getWindow();
        app.setScene(scene);
        app.show();
    }
    


    @FXML
    private void listerdvvalider(ActionEvent event) throws IOException {
        
        Parent page_select_my = FXMLLoader.load(getClass().getResource("ListerdvattenteInterface.fxml"));        
        Scene scene = new Scene(page_select_my);
        Stage app=(Stage)((Node)event.getSource() ).getScene().getWindow();
        app.setScene(scene);
        app.show();
        
        
    }






 

   
    
}
