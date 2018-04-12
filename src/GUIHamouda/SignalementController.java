/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.Signalement;
import Services.SignalementServices;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import static sprintjavagui.User.LoginController.LoggedUser;

/**
 * FXML Controller class
 *
 * @author hamouda
 */
public class SignalementController implements Initializable {

    @FXML
    private Label l2;
    @FXML
    private ComboBox<String> cb;
    @FXML
    private Button signaler;
    @FXML
    private Label l1;
    @FXML
    private Button retour;
    
    public static int id;
        public  int score1;
            public  int score2;
                public  int score3;
                    public  int score4;
                        public  int score5;
                            public  int scorefinale;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
          cb.getItems().add("Contenu inaproprie");
        cb.getItems().add("Informations incorrectes");
          cb.getItems().add("ce n'est pas interessant");
          cb.getItems().add("spam");
          cb.getItems().add("Autres");
        // TODO
    }    

    @FXML
    private void Signaler(ActionEvent event) {
        
          SignalementServices ss = new SignalementServices();
          
          for ( Signalement s:ss.afficheall()){
                    score1 = ss.CountSignalementByType(s.getAnnonce_id(), 1);
                 score2=ss.CountSignalementByType(s.getAnnonce_id(), 2);
                 score3=ss.CountSignalementByType(s.getAnnonce_id(), 3);
                  score4=ss.CountSignalementByType(s.getAnnonce_id(), 4);
                 score5=ss.CountSignalementByType(s.getAnnonce_id(), 5);
                
                  scorefinale = (5* score1)+(4* score2)+(3* score3)+(2* score4)+ score5;
                
         if(cb.getSelectionModel().getSelectedItem().equals("Contenu inaproprie")){
                    Signalement s1 = new Signalement(LoggedUser.getId(),id,1,scorefinale);
                     ss.Ajouter(s1);
         Alert al=new Alert(Alert.AlertType.INFORMATION);
            al.setTitle("INFORMATION");
            al.setHeaderText(null);
            al.setContentText("Signalement done");
            al.showAndWait();
                break;
               }
                  if(cb.getSelectionModel().getSelectedItem().equals("Informations incorrectes")){
                    Signalement s1 = new Signalement(LoggedUser.getId(),id,2,scorefinale);
                     ss.Ajouter(s1);
         Alert al=new Alert(Alert.AlertType.INFORMATION);
            al.setTitle("INFORMATION");
            al.setHeaderText(null);
            al.setContentText("Signalement done");
            al.showAndWait();
            break;

               }
                  if(cb.getSelectionModel().getSelectedItem().equals("ce n'est pas interessant")){
                    Signalement s1 = new Signalement(LoggedUser.getId(),id,3,scorefinale);
                     ss.Ajouter(s1);
         Alert al=new Alert(Alert.AlertType.INFORMATION);
            al.setTitle("INFORMATION");
            al.setHeaderText(null);
            al.setContentText("Signalement done");
            al.showAndWait();
            break;

               }
                    if(cb.getSelectionModel().getSelectedItem().equals("spam")){
                    Signalement s1 = new Signalement(LoggedUser.getId(),id,4,scorefinale);
                     ss.Ajouter(s1);
         Alert al=new Alert(Alert.AlertType.INFORMATION);
            al.setTitle("INFORMATION");
            al.setHeaderText(null);
            al.setContentText("Signalement done");
            al.showAndWait();
            break;

               }
                     if(cb.getSelectionModel().getSelectedItem().equals("Autres")){
                    Signalement s1 = new Signalement(LoggedUser.getId(),id,5,scorefinale);
                     ss.Ajouter(s1);
                     Alert al=new Alert(Alert.AlertType.INFORMATION);
                     al.setTitle("INFORMATION");
                     al.setHeaderText(null);
                     al.setContentText("Signalement done");
                     al.showAndWait();
                     break;

                     }
                     }
                     
                     
                     
                  
       
        
       
               
        
    }

    @FXML
    private void Retour(ActionEvent event) throws IOException {
         Parent page_select_my = FXMLLoader.load(getClass().getResource("/GUIHamouda/Acceuil.fxml"));        
        Scene scene = new Scene(page_select_my);
        Stage app=(Stage)((Node)event.getSource() ).getScene().getWindow();
        app.setScene(scene);
        app.show();
    }
    
}
