/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.Demande;
import static GUI.JeAcheterController.annonce_id;
import Services.DemandeServices;
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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import static sprintjavagui.User.LoginController.LoggedUser;

/**
 * FXML Controller class
 *
 * @author hamouda
 */
public class ItsMineController implements Initializable {

    @FXML
    private Label l1;
    @FXML
    private Label l2;
    @FXML
    private Label l3;
    @FXML
    private Label l4;
    @FXML
    private TextField t3;
    @FXML
    private TextField t4;
    @FXML
    private Button btn;
    @FXML
    private TextField t1;
    @FXML
    private TextField t2;
    @FXML
    private Button retour;
    
    public static int annonce_id;
    public static String animal;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Retour(ActionEvent event) throws IOException {
         Parent page_select_my = FXMLLoader.load(getClass().getResource("/GUIHamouda/AffichageLostAndFound.fxml"));        
        Scene scene = new Scene(page_select_my);
        Stage app=(Stage)((Node)event.getSource() ).getScene().getWindow();
        app.setScene(scene);
        app.show();
    }

    @FXML
    private void Ajout(ActionEvent event) {
        
        DemandeServices ds = new DemandeServices();
      
        
        Demande d = new Demande(LoggedUser.getId(), annonce_id,"LostAndFound",2,
              
        t1.getText(),t2.getText(),t3.getText(),t4.getText(),animal );
        
       
        ds.Ajouter(d);
         Alert al=new Alert(Alert.AlertType.INFORMATION);
            al.setTitle("INFORMATION");
            al.setHeaderText(null);
            al.setContentText("demande de recuperation envoyée");
            al.showAndWait();
    }
    
}
