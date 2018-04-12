/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sprintjavagui.Reclamation;

import Entities.Reclamation;
import Entities.User;
import Services.ReclamationServices;
import Utils.CategoryType;
import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import javafx.stage.Stage;
import static sprintjavagui.User.LoginController.LoggedUser;

public class AddReclamationController implements Initializable {

    @FXML
    private Button accueil;
    @FXML
    private Button liste;
    @FXML
    private ChoiceBox<String> motifCB;
    @FXML 
    private TextField titreTF;
    @FXML
    private TextArea descriptionTA; 
    
    ReclamationServices reclamationServices = new ReclamationServices();
    

    @FXML
    private void accueilButtonAction(ActionEvent event) throws IOException {

        Parent home_page_parent = FXMLLoader.load(getClass().getResource("Reclamation.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(home_page_scene);
        app_stage.show();
    }

    @FXML
    private void listeButtonAction(ActionEvent event) throws IOException {

        Parent home_page_parent = FXMLLoader.load(getClass().getResource("AfficherReclamations.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(home_page_scene);
        app_stage.show();
        
    }
    
    @FXML
    private void ajoutButtonAction(ActionEvent event) throws IOException{
        String titre = titreTF.getText() ;
        CategoryType categorie = CategoryType.valueOf(motifCB.getValue());
        String description = descriptionTA.getText();
        Date dateCreation = new Date();
        java.sql.Date sqlDateCreation = new java.sql.Date(dateCreation.getTime());
        User user = new User();
        user.setId(LoggedUser.getId());
        Reclamation nouvelleReclamation = new Reclamation(categorie, sqlDateCreation, titre, description, user);
        
        reclamationServices.insert(nouvelleReclamation);
        
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("AfficherReclamations.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(home_page_scene);
        app_stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        motifCB.getItems().add(CategoryType.Technique.name());  
        motifCB.getItems().add(CategoryType.Commercial.name());
        motifCB.getItems().add(CategoryType.Autres.name());
        motifCB.getSelectionModel().selectFirst();
    }

}
