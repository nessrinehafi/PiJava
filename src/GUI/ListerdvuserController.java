/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entity.Rendez_vous;
import Entity.User;
import Utils.Mail;
import com.sun.prism.impl.Disposer;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.util.Callback;
import org.controlsfx.control.Notifications;
import static sprintjavagui.User.LoginController.LoggedUser;

/**
 * FXML Controller class
 *
 * @author haythem
 */
public class ListerdvuserController implements Initializable {

    
    
    Services.CRUD s =new Services.CRUD();
    
            ObservableList<Rendez_vous> ccc=FXCollections.observableArrayList();

 
    
    @FXML
    private TableView<Rendez_vous> table;
    @FXML
    private TableColumn<Rendez_vous, Integer> id;
    @FXML
    private TableColumn<Rendez_vous, String> message;
    @FXML
    private TableColumn<Rendez_vous, String> date;
    @FXML
    private TableColumn<Rendez_vous, String> heure;
    @FXML
    private TableColumn<Rendez_vous, String> service;
    @FXML
    private Button modifier;
    
    public static Integer idaccepteur;
    @FXML
    private Button annuler;
    @FXML
    private Button rdvattenteuser;
    @FXML
    private Button listerdvvalider;
    

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
        
        
        
        
        
        
        ObservableList<Rendez_vous> list= FXCollections.observableArrayList();
        
        
        
        if (LoggedUser.getRole().contains("utilisateur simple"))
        {
        
        for (Rendez_vous r:s.afficheallrdv() )
        {
            if (r.isValide() == true && r.getDemandeur_id() == LoggedUser.getId() && r.isRemove() == false)
            {
                list.add(r);
            }
            
            idaccepteur = r.getAccepteur_id();
        }
        }
        
        
        if (LoggedUser.getRole().contains("Educateur canin") || LoggedUser.getRole().contains("Vétérinaire"))
        {
        
        for (Rendez_vous r:s.afficheallrdv() )
        {
            if (r.isValide() == true && r.getAccepteur_id()== LoggedUser.getId() && r.isRemove() == false)
            {
                list.add(r);
            }
            
            idaccepteur = r.getAccepteur_id();
        }
        }
        
      User user = s.getMail(idaccepteur);
      
 id.setCellValueFactory(new PropertyValueFactory<>("id"));
 message.setCellValueFactory(new PropertyValueFactory<>("message"));
 date.setCellValueFactory(new PropertyValueFactory<>("date"));
 heure.setCellValueFactory(new PropertyValueFactory<>("heure"));
 service.setCellValueFactory(new PropertyValueFactory<>("service"));
 
        
        
        table.setItems(list);
        
        
        
        
    }
        // TODO

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
    private void Modifier(ActionEvent event) throws IOException {
        
        ModifierrdvInterfaceController.id= table.getSelectionModel().getSelectedItem().getId();
            ModifierrdvInterfaceController.t1= table.getSelectionModel().getSelectedItem().getDate();
            ModifierrdvInterfaceController.t2= table.getSelectionModel().getSelectedItem().getHeure();
            ModifierrdvInterfaceController.idaccepteur= table.getSelectionModel().getSelectedItem().getAccepteur_id();

         Parent page_select_my = FXMLLoader.load(getClass().getResource("ModifierrdvInterface.fxml"));        
        Scene scene = new Scene(page_select_my);
        Stage app=(Stage)((Node)event.getSource() ).getScene().getWindow();
        app.setScene(scene);
        app.show();
        

    }
    
    private void ref() {
        ccc.clear();
        ccc.addAll();
        
        ObservableList<Rendez_vous> list= FXCollections.observableArrayList();
        if (LoggedUser.getRole().contains("utilisateur simple"))
        {
        
        for (Rendez_vous r:s.afficheallrdv() )
        {
            if (r.isValide() == true && r.getDemandeur_id() == LoggedUser.getId() && r.isRemove() == false)
            {
                list.add(r);
            }
            
            idaccepteur = r.getAccepteur_id();
        }
        }
        
        
        if (LoggedUser.getRole().contains("Educateur canin") || LoggedUser.getRole().contains("Vétérinaire"))
        {
        
        for (Rendez_vous r:s.afficheallrdv() )
        {
            if (r.isValide() == true && r.getAccepteur_id()== LoggedUser.getId() && r.isRemove() == false)
            {
                list.add(r);
            }
            
            idaccepteur = r.getAccepteur_id();
        }
        }
        
        table.setItems(list);
        
        
    }

    
    @FXML
    private void annuler(ActionEvent event) {
        
        Services.CRUD s = new Services.CRUD() {};

            Rendez_vous r = new Rendez_vous();
         
            int id = table.getSelectionModel().getSelectedItem().getId();
         
            s.supprimer(id);
            table.getSelectionModel().clearSelection();
            table.getItems().remove(ccc);
          
        
            ref();
            
             Notifications.create().title("Succes").text("Votre rendez-vous a ete annule avec succes.").position(Pos.BOTTOM_RIGHT).showConfirm();

        
        User user = s.getMail(idaccepteur);
       
        
         Mail.send(LoggedUser.getEmail_canonical(), "Colocation Esprit", "Vous avez annuler votre rendez-vous veuillez voir sur notre site.");

                
                
         Mail.send(user.getEmail_canonical(), "Colocation Esprit", "votre rendez-vous a ete annulee ");
                
                
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