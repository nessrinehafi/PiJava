/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.Annonce;
import Services.AnnonceServices;
import static com.sun.xml.internal.fastinfoset.alphabet.BuiltInRestrictedAlphabets.table;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author hamouda
 */
public class AffichageController implements Initializable {
    
    

       AnnonceServices as=new AnnonceServices();
       
       ObservableList<Annonce> ccc=FXCollections.observableArrayList();
    
    

    @FXML
    private TableColumn<Annonce, String> categorie;
    @FXML
    private TableColumn<Annonce, String> animal;
    @FXML
    private TableColumn<Annonce, String> race;
    @FXML
    private TableColumn<Annonce, Float> prix;
    @FXML
    private TableColumn<Annonce, String> description;
    @FXML
    private TableColumn<Annonce, String> date;
    @FXML
    private TableColumn<Annonce, Boolean> estvalide;
    @FXML
    private Button recherche;
    @FXML
    private Button supprimer;
    @FXML
    private Button modifier;
    @FXML
    private ComboBox<String> cb;
    @FXML
    private Button retour;
    @FXML
    private Button vente;
    @FXML
    private Button demande;
    @FXML
    private TableView<Annonce> table;
    @FXML
    private ImageView image;

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
       
        
           table.setItems(list);
           
           table.getSelectionModel().selectedItemProperty().addListener((obs,oldSelection,newSelection)->{
               if (newSelection!=null){
               ObservableList<Annonce> annonce;
               File f = new File("C:\\wamp64\\www\\Animaux\\web\\Picture\\"+newSelection.getImage());
               Image img = new Image (f.toURI().toString());
               image.setImage(img);
               
               
               }
           });
        
        
        
        
      
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
    
    
    private void ref() {
        ccc.clear();
        ccc.addAll(as.afficheall());
        table.setItems(ccc);
        
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
    private void Modifier(ActionEvent event) {
          
        try {
            ModificationController.t= table.getSelectionModel().getSelectedItem().getId();
            ModificationController.t2= table.getSelectionModel().getSelectedItem().getCategorie();
            ModificationController.t3= table.getSelectionModel().getSelectedItem().getAnimal();
           ModificationController.t4= table.getSelectionModel().getSelectedItem().getRace();
           ModificationController.t5= table.getSelectionModel().getSelectedItem().getDescription();
             ModificationController.t6= table.getSelectionModel().getSelectedItem().getPrix();
             
             ModificationController.id= table.getSelectionModel().getSelectedItem().getId();
             
            
           Parent page_select_my = FXMLLoader.load(getClass().getResource("/GUIHamouda/Modification.fxml"));        
        Scene scene = new Scene(page_select_my);
        Stage app=(Stage)((Node)event.getSource() ).getScene().getWindow();
        app.setScene(scene);
        app.show();
        } catch (IOException ex) {
           System.out.println(ex.toString());
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


    @FXML
    private void demande(ActionEvent event) throws IOException {
               Parent page_select_my = FXMLLoader.load(getClass().getResource("/GUIHamouda/Demande.fxml"));        
        Scene scene = new Scene(page_select_my);
        Stage app=(Stage)((Node)event.getSource() ).getScene().getWindow();
        app.setScene(scene);
        app.show();
    }

    @FXML
    private void Add(ActionEvent event) throws IOException {
           Parent page_select_my = FXMLLoader.load(getClass().getResource("/GUIHamouda/Ajout.fxml"));        
        Scene scene = new Scene(page_select_my);
        Stage app=(Stage)((Node)event.getSource() ).getScene().getWindow();
        app.setScene(scene);
        app.show();
    }
    
    
    
}
