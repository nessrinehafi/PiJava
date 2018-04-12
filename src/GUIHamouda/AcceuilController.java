/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

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
 * @author hamouda
 */
public class AcceuilController implements Initializable {

    @FXML
    private Button vendre;
    @FXML
    private Button adopter;
    @FXML
    private Button lost;
    @FXML
    private Button profil;
    @FXML
    private Button admin;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    private void BtnVente(ActionEvent event) throws IOException {
        Parent page_select_my = FXMLLoader.load(getClass().getResource("/GUIHamouda/AffichageVente.fxml"));        
        Scene scene = new Scene(page_select_my);
        Stage app=(Stage)((Node)event.getSource() ).getScene().getWindow();
        app.setScene(scene);
        app.show();

    }

    @FXML
    private void Vente(ActionEvent event) throws IOException {
         Parent page_select_my = FXMLLoader.load(getClass().getResource("/GUIHamouda/AffichageVente.fxml"));        
        Scene scene = new Scene(page_select_my);
        Stage app=(Stage)((Node)event.getSource() ).getScene().getWindow();
        app.setScene(scene);
        app.show();
    }

    @FXML
    private void Adopter(ActionEvent event) throws IOException {
         Parent page_select_my = FXMLLoader.load(getClass().getResource("/GUIHamouda/AffichageAdoption.fxml"));        
        Scene scene = new Scene(page_select_my);
        Stage app=(Stage)((Node)event.getSource() ).getScene().getWindow();
        app.setScene(scene);
        app.show();
    }

    @FXML
    private void Lost(ActionEvent event) throws IOException {
         Parent page_select_my = FXMLLoader.load(getClass().getResource("/GUIHamouda/AffichageLostAndFound.fxml"));        
        Scene scene = new Scene(page_select_my);
        Stage app=(Stage)((Node)event.getSource() ).getScene().getWindow();
        app.setScene(scene);
        app.show();
    }

    @FXML
    private void Profil(ActionEvent event) throws IOException {
         Parent page_select_my = FXMLLoader.load(getClass().getResource("/GUIHamouda/Affichage.fxml"));        
        Scene scene = new Scene(page_select_my);
        Stage app=(Stage)((Node)event.getSource() ).getScene().getWindow();
        app.setScene(scene);
        app.show();
    }

    @FXML
    private void Admin(ActionEvent event) throws IOException {
           Parent page_select_my = FXMLLoader.load(getClass().getResource("/GUIHamouda/Affichage2.fxml"));        
        Scene scene = new Scene(page_select_my);
        Stage app=(Stage)((Node)event.getSource() ).getScene().getWindow();
        app.setScene(scene);
        app.show();
    }
    
}
