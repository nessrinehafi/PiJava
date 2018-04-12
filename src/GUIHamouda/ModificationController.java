/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.Annonce;
import Services.AnnonceServices;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
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
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.controlsfx.control.Notifications;
import static sprintjavagui.User.LoginController.LoggedUser;

/**
 * FXML Controller class
 *
 * @author hamouda
 */
public class ModificationController implements Initializable {

    
    @FXML
    private TextField animal;
    @FXML
    private TextField race;
    @FXML
    private TextField prix;
    private TextField image;
    @FXML
    private Button btn;
    @FXML
    private ComboBox<String> categorie;
    @FXML
    private TextField description;
    @FXML
    private Button retour;
      public static int t;
     
      public static String t2;
       public static String t3;
        public static String t4;
        public static String t5;
        public static float t6;
        public static int id;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
           categorie.getItems().add("Vente");
        categorie.getItems().add("Adoption");
          categorie.getItems().add("LostAndFound");
          
         
         categorie.getSelectionModel().select(t2);
                
         animal.setText(t3);
         race.setText(t4);
        description.setText(t5);
      
        prix.setText(Float.toString(t6));
        
        // TODO
    }    

    @FXML
    private void modifier(ActionEvent event) throws IOException {
         java.util.Date date_util = new java.util.Date();
        java.sql.Date date_sql = new java.sql.Date(date_util.getTime());
        AnnonceServices as = new AnnonceServices();
        
         Annonce a = new Annonce(id,categorie.getValue(),date_sql,
              
        animal.getText(),description.getText(),race.getText(),Float.valueOf(prix.getText()));
         
         
         
         a.setUser_id(LoggedUser.getId());
         a.setCategorie(categorie.getValue());
         a.setAnimal(animal.getText());
         a.setDescription(description.getText());
         a.setRace(race.getText());
         a.setPrix(Float.valueOf(prix.getText()));
         a.setDatecreation(date_sql);
         
         
         
         as.modifier(a,id);
         Alert al=new Alert(Alert.AlertType.INFORMATION);
            al.setTitle("INFORMATION");
            al.setHeaderText(null);
            al.setContentText("Annonce modifiée");
            al.showAndWait();
            Notifications.create().title("Succes").text("Annonce modifiée").position(Pos.BOTTOM_RIGHT).showConfirm();
                     Parent page_select_my = FXMLLoader.load(getClass().getResource("/GUIHamouda/Affichage.fxml"));        
        Scene scene = new Scene(page_select_my);
        Stage app=(Stage)((Node)event.getSource() ).getScene().getWindow();
        app.setScene(scene);
        app.show();
       
    }

    @FXML
    private void Retour(ActionEvent event) throws IOException {
            Parent page_select_my = FXMLLoader.load(getClass().getResource("/GUIHamouda/Affichage.fxml"));        
        Scene scene = new Scene(page_select_my);
        Stage app=(Stage)((Node)event.getSource() ).getScene().getWindow();
        app.setScene(scene);
        app.show();

    }
    
}
