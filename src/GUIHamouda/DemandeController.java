/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.Annonce;
import Entities.Demande;
import Services.AnnonceServices;
import Services.DemandeServices;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author hamouda
 */
public class DemandeController implements Initializable {
    
     DemandeServices as=new DemandeServices();
       
       ObservableList<Demande> ccc=FXCollections.observableArrayList();

    @FXML
    private Button retour;
    @FXML
    private TableColumn<?, ?> animal1;
    @FXML
    private TableColumn<?, ?> animal2;
    private TableColumn<?, ?> race2;
    @FXML
    private Button valider1;
    @FXML
    private Button supprimer1;
    @FXML
    private Button valider2;
    @FXML
    private Button supprimer2;
    @FXML
    private TableView<Demande> table1;
    @FXML
    private TableColumn<?, ?> q1;
    @FXML
    private TableColumn<?, ?> q2;
    @FXML
    private TableColumn<?, ?> q3;
    @FXML
    private TableColumn<?, ?> numero1;
    @FXML
    private TableView<Demande> table2;
    @FXML
    private TableColumn<?, ?> q7;
    @FXML
    private TableColumn<?, ?> q8;
    @FXML
    private TableColumn<?, ?> prixSecondaire;
    @FXML
    private TableColumn<?, ?> numero2;
    @FXML
    private TableColumn<?, ?> categorie;
    @FXML
    private TableColumn<?, ?> categorie2;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
          DemandeServices as = new DemandeServices();
        ArrayList A = (ArrayList) as.afficheallV("Adoption");
        ObservableList<Demande> list= FXCollections.observableArrayList(A);
  
         animal1.setCellValueFactory(new PropertyValueFactory<>("animal"));
       categorie.setCellValueFactory(new PropertyValueFactory<>("categorie"));
       q1.setCellValueFactory(new PropertyValueFactory<>("q1"));
       q2.setCellValueFactory(new PropertyValueFactory<>("q2"));
       q3.setCellValueFactory(new PropertyValueFactory<>("q3"));
        numero1.setCellValueFactory(new PropertyValueFactory<>("numTel")); 
   
           table1.setItems(list);
           
            ArrayList AA = (ArrayList) as.afficheallV("Vente");
        ObservableList<Demande> listt= FXCollections.observableArrayList(AA);
              animal2.setCellValueFactory(new PropertyValueFactory<>("animal"));
       categorie2.setCellValueFactory(new PropertyValueFactory<>("categorie"));
       q7.setCellValueFactory(new PropertyValueFactory<>("q7"));
       q8.setCellValueFactory(new PropertyValueFactory<>("q8"));
       prixSecondaire.setCellValueFactory(new PropertyValueFactory<>("prixSecondaire"));
        numero2.setCellValueFactory(new PropertyValueFactory<>("numTel")); 
         table2.setItems(listt);
        
        
    }    

    @FXML
    private void Retour(ActionEvent event) throws IOException {
               Parent page_select_my = FXMLLoader.load(getClass().getResource("/GUIHamouda/Affichage.fxml"));        
        Scene scene = new Scene(page_select_my);
        Stage app=(Stage)((Node)event.getSource() ).getScene().getWindow();
        app.setScene(scene);
        app.show();
    }
    
      private void ref1() {
        ccc.clear();
        ccc.addAll(as.afficheall());
        table1.setItems(ccc);
        
    }
       private void ref2() {
        ccc.clear();
        ccc.addAll(as.afficheall());
        table2.setItems(ccc);
        
    }

    @FXML
    private void Valider1(ActionEvent event) {
    }

    @FXML
    private void Supprimer1(ActionEvent event) {
              supprimer1.setDisable(false);
         DemandeServices ds = new  DemandeServices();
         Demande d =table1.getSelectionModel().getSelectedItem();
      
            ds.supprimer(d.getId());
            table1.getSelectionModel().clearSelection();
            table1.getItems().remove(ccc);
            Alert al=new Alert(Alert.AlertType.INFORMATION);
            al.setTitle("INFORMATION");
            al.setHeaderText(null);
            al.setContentText("Demande ignorée");
            al.showAndWait();
            
            
            ref1();
    }

    @FXML
    private void Valider2(ActionEvent event) {
    }

    @FXML
    private void Supprimer2(ActionEvent event) {
              supprimer2.setDisable(false);
         DemandeServices ds = new  DemandeServices();
         Demande d =table2.getSelectionModel().getSelectedItem();
      
            ds.supprimer(d.getId());
            table2.getSelectionModel().clearSelection();
            table2.getItems().remove(ccc);
            Alert al=new Alert(Alert.AlertType.INFORMATION);
            al.setTitle("INFORMATION");
            al.setHeaderText(null);
            al.setContentText("Demande ignorée");
            al.showAndWait();
            
            
            ref2();
    }

    
}
