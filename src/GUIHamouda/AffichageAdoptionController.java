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
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.function.Predicate;
import javafx.beans.value.ObservableValue;
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
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import static sprintjavagui.User.LoginController.LoggedUser;

/**
 * FXML Controller class
 *
 * @author hamouda
 */
public class AffichageAdoptionController implements Initializable {

    @FXML
    private Button signalerbtn;
    @FXML
    private Button acheterbtn;
    @FXML
    private Button picturebtn;
    @FXML
    private TableColumn<?, ?> animal;
    @FXML
    private TableColumn<?, ?> race;
    @FXML
    private TableColumn<?, ?> description;
    private ComboBox<String> cb;
    @FXML
    private Button retour;
    @FXML
    private TableView<Annonce> table;
    @FXML
    private TextField seach;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
         AnnonceServices as = new AnnonceServices();
        ArrayList A = (ArrayList) as.afficheallV("Adoption");
        ObservableList<Annonce> list= FXCollections.observableArrayList(A);
  
       animal.setCellValueFactory(new PropertyValueFactory<>("animal"));
       race.setCellValueFactory(new PropertyValueFactory<>("race"));
      
       description.setCellValueFactory(new PropertyValueFactory<>("description"));
     
      
      
           table.setItems(list);
        
        
          FilteredList<Annonce> fil= new FilteredList<>(list,e->true);
        seach.setOnKeyReleased((KeyEvent e) -> {
            seach.textProperty().addListener((ObservableValue<? extends String> observableValue, String oldValue, String newValue) -> {
                fil.setPredicate((Predicate <? super Annonce>) Annonce->{
                    if(newValue==null||newValue.isEmpty()){return true;}
                    String lower=newValue.toLowerCase();
                    if(Annonce.getAnimal().toLowerCase().contains(lower)){return true;}
                    else if(Annonce.getCategorie().toLowerCase().contains(lower)){return true;}
                    return false;
                });
            });
            SortedList<Annonce> k = new SortedList<>(fil);
            k.comparatorProperty().bind(table.comparatorProperty());
            table.setItems(k);
        });
        // TODO
    }    

    @FXML
    private void Signaler(ActionEvent event) throws IOException {
         JeAdopterController.animal= table.getSelectionModel().getSelectedItem().getAnimal();
         SignalementController.id= table.getSelectionModel().getSelectedItem().getId();
         Parent page_select_my = FXMLLoader.load(getClass().getResource("/GUIHamouda/Signalement.fxml"));        
        Scene scene = new Scene(page_select_my);
        Stage app=(Stage)((Node)event.getSource() ).getScene().getWindow();
        app.setScene(scene);
        app.show();
    }


    @FXML
    private void Photo(ActionEvent event) {
    }

    @FXML
    private void Adopter(ActionEvent event) throws IOException {
        JeAdopterController.animal= table.getSelectionModel().getSelectedItem().getAnimal();
        JeAdopterController.annonce_id= table.getSelectionModel().getSelectedItem().getId();
          Parent page_select_my = FXMLLoader.load(getClass().getResource("/GUIHamouda/JeAdopter.fxml"));        
        Scene scene = new Scene(page_select_my);
        Stage app=(Stage)((Node)event.getSource() ).getScene().getWindow();
        app.setScene(scene);
        app.show();
    }

    @FXML
    private void Retour(ActionEvent event) throws IOException {
         Parent page_select_my = FXMLLoader.load(getClass().getResource("/GUIHamouda/Acceuil.fxml"));        
        Scene scene = new Scene(page_select_my);
        Stage app=(Stage)((Node)event.getSource() ).getScene().getWindow();
        app.setScene(scene);
        app.show();
    }

    private void recherche(ActionEvent event) {
        Services.AnnonceServices as = new Services.AnnonceServices();
       
        
        
         ObservableList<Annonce> list= FXCollections.observableArrayList();
        
        for (Annonce a:as.afficheall() )
        {
            
            
                list.add(a);
               
                
      
            
        }
        
        FilteredList<Annonce> filteredData = new FilteredList <> (list,p->true);
        filteredData.setPredicate(annonce->{
            if(annonce.getAnimal().contains(cb.getSelectionModel().getSelectedItem()))
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
    
}
