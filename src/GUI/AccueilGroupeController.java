/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import com.jfoenix.controls.JFXButton;
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
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author haythem
 */
public class AccueilGroupeController implements Initializable {

    @FXML
    private Button rdv;
    @FXML
    private JFXButton accueil;
    @FXML
    private JFXButton evenement;
    @FXML
    private JFXButton service;
    @FXML
    private JFXButton forum;
    @FXML
    private JFXButton reclamation;
    @FXML
    private JFXButton annonce;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void rdv(ActionEvent event) throws IOException {
        
        Parent page_select_my = FXMLLoader.load(getClass().getResource("Accueilinterface.fxml"));        
        Scene scene = new Scene(page_select_my);
        Stage app=(Stage)((Node)event.getSource() ).getScene().getWindow();
        app.setScene(scene);
        app.show();
    }

    @FXML
    private void accueil(ActionEvent event) {
    }

    @FXML
    private void evenement(ActionEvent event) throws IOException {
        
        Parent page_select_my = FXMLLoader.load(getClass().getResource("/GUIDali/EvenementUser.fxml"));        
        Scene scene = new Scene(page_select_my);
        Stage app=(Stage)((Node)event.getSource() ).getScene().getWindow();
        app.setScene(scene);
        app.show();
    }

    @FXML
    private void service(ActionEvent event) throws IOException {
        
        Parent page_select_my = FXMLLoader.load(getClass().getResource("/sprintjavagui/Service/Listecategories.fxml"));        
        Scene scene = new Scene(page_select_my);
        Stage app=(Stage)((Node)event.getSource() ).getScene().getWindow();
        app.setScene(scene);
        app.show();
    }

    @FXML
    private void forum(ActionEvent event) throws IOException {
        
        Parent page_select_my = FXMLLoader.load(getClass().getResource("/View/Forum.fxml"));        
        Scene scene = new Scene(page_select_my);
        Stage app=(Stage)((Node)event.getSource() ).getScene().getWindow();
        app.setScene(scene);
        app.show();
        
    }

    @FXML
    private void reclamation(ActionEvent event) throws IOException {
        
        Parent page_select_my = FXMLLoader.load(getClass().getResource("/sprintjavagui/Reclamation/Reclamation.fxml"));        
        Scene scene = new Scene(page_select_my);
        Stage app=(Stage)((Node)event.getSource() ).getScene().getWindow();
        app.setScene(scene);
        app.show();
        
    }

    @FXML
    private void annonce(ActionEvent event) throws IOException {
        
        Parent page_select_my = FXMLLoader.load(getClass().getResource("/GUIHamouda/Acceuil.fxml"));        
        Scene scene = new Scene(page_select_my);
        Stage app=(Stage)((Node)event.getSource() ).getScene().getWindow();
        app.setScene(scene);
        app.show();
    }
    
}
