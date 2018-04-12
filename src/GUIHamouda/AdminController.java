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
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author hamouda
 */
public class AdminController implements Initializable {
    
    
       AnnonceServices as=new AnnonceServices();
       
       ObservableList<Annonce> ccc=FXCollections.observableArrayList();

    @FXML
    private TableColumn<?, ?> categorie;
    @FXML
    private TableColumn<?, ?> animal;
    @FXML
    private TableColumn<?, ?> race;
    @FXML
    private TableColumn<?, ?> prix;
    @FXML
    private TableColumn<?, ?> date;
    @FXML
    private TableColumn<?, ?> estvalide;
    @FXML
    private TableColumn<?, ?> description;
    @FXML
    private Button recherche;
    @FXML
    private Button supprimer;
    @FXML
    private ComboBox<String> cb;
    @FXML
    private Button demande;
    @FXML
    private Button valider;
    @FXML
    private TableView<Annonce> table;
    @FXML
    private Button stat1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         cb.getItems().add("Vente");
        cb.getItems().add("Adoption");
          cb.getItems().add("LostAndFound");
          cb.getItems().add("tout afficher");
          
          Services.AnnonceServices as = new Services.AnnonceServices();
        
        ObservableList<Annonce> list= FXCollections.observableArrayList();
        
        for (Annonce a:as.afficheall() )
        {

                list.add(a);
                
            
            
        }
        

        
        
          categorie.setCellValueFactory(new PropertyValueFactory<>("categorie"));
       animal.setCellValueFactory(new PropertyValueFactory<>("animal"));
       race.setCellValueFactory(new PropertyValueFactory<>("race"));
       prix.setCellValueFactory(new PropertyValueFactory<>("prix"));
       description.setCellValueFactory(new PropertyValueFactory<>("description"));
        date.setCellValueFactory(new PropertyValueFactory<>("datecreation")); 
        estvalide.setCellValueFactory(new PropertyValueFactory<>("estvalide"));
        
           table.setItems(list);
        
        
        
        
      
        // TODO
    }    

    @FXML
    private void Recherche(ActionEvent event) {
        Services.AnnonceServices as = new Services.AnnonceServices();
       
        
        
         ObservableList<Annonce> list= FXCollections.observableArrayList();
        
        for (Annonce a:as.afficheall() )
        {
            
            
                list.add(a);
               
                
      
            
        }
        
        FilteredList<Annonce> filteredData = new FilteredList <> (list,p->true);
        filteredData.setPredicate(annonce->{
            if(annonce.getCategorie().contains(cb.getSelectionModel().getSelectedItem()))
                return(true);
            else {
               if(cb.getSelectionModel().getSelectedItem().equals("tout afficher")){
                   return true;
               }
            }
         return(false);   
        });
        SortedList<Annonce> sortedData = new SortedList<>(filteredData);
        
        sortedData.comparatorProperty().bind(table.comparatorProperty());
        
        table.setItems(sortedData);
        
    }

    @FXML
    private void Supprimer(ActionEvent event) {
               supprimer.setDisable(false);
         AnnonceServices as = new  AnnonceServices();
         Annonce a =table.getSelectionModel().getSelectedItem();
      
            as.supprimer(a.getId());
            table.getSelectionModel().clearSelection();
            table.getItems().remove(ccc);
            Alert al=new Alert(Alert.AlertType.INFORMATION);
            al.setTitle("INFORMATION");
            al.setHeaderText(null);
            al.setContentText("Annonce supprimée");
            al.showAndWait();
            
            
            ref();
    }


    @FXML
    private void demande(ActionEvent event) {
    }
     private void ref() {
        ccc.clear();
        ccc.addAll(as.afficheall());
        table.setItems(ccc);
        
    }

    @FXML
    private void Valider(ActionEvent event ) {
       
        
    }

    @FXML
    private void Stat1(ActionEvent event) throws IOException {
        Parent page_select_my = FXMLLoader.load(getClass().getResource("/GUIHamouda/Statistique.fxml"));        
        Scene scene = new Scene(page_select_my);
        Stage app=(Stage)((Node)event.getSource() ).getScene().getWindow();
        app.setScene(scene);
        app.show();
        
    }
    
}
