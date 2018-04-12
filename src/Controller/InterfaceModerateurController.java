/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Forum;
import Service.ForumAdminService;
import Service.ForumService;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author nessrine
 */
public class InterfaceModerateurController implements Initializable {
	ObservableList<Forum> listU = FXCollections.observableArrayList();

    @FXML
    private TableColumn<Forum, String> id;
    @FXML
    private TableColumn<Forum, String> auteur;
    @FXML
    private TableColumn<Forum, String> titre;
    @FXML
    private TableColumn<Forum, String> contenu;
    @FXML
    private TableColumn<Forum, String> tag;
    @FXML
    private TableColumn<Forum, String> cree;
    @FXML
    private TableColumn<Forum, String> signal;
    @FXML
    private TableView<Forum> Tablev;
    @FXML
    private Label users;
    @FXML
    private Button guser;
    @FXML
    private Button gAnnonce;
    @FXML
    private Button gevent;
    @FXML
    private Button gforum;
    @FXML
    private Button gservice;
    @FXML
    private Button grendezvous;
    @FXML
    private Button greclamation;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
 		ListerForum();
            try {
                loadList();
                
                
                // TODO
            } catch (SQLException ex) {
                Logger.getLogger(InterfaceModerateurController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }   
      public void ListerForum() 
        {

        auteur.setCellValueFactory(new PropertyValueFactory<>("Auteur"));
        titre.setCellValueFactory(new PropertyValueFactory<>("Titre"));
        tag.setCellValueFactory(new PropertyValueFactory<>("Tags"));
        contenu.setCellValueFactory(new PropertyValueFactory<>("Blog"));
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        cree.setCellValueFactory(new PropertyValueFactory<>("Cree"));
        signal.setCellValueFactory(new PropertyValueFactory<>("signe"));




        }
      	 private void loadList() throws SQLException 
        {
        //listCov.clear();
        ForumService su=new ForumService();
       listU=su.selectForum();
              Tablev.setItems(listU);

         }


    @FXML
    private void GestionUser(ActionEvent event) throws IOException {
         Parent list_page_parent = FXMLLoader.load(getClass().getResource("/View/GestionUtilisateur.fxml"));
        Scene list_page_scene = new Scene(list_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

                app_stage.hide(); //optional
                app_stage.setScene(list_page_scene);
                app_stage.show();
    }

    @FXML
    private void GestionAnnonce(ActionEvent event) {
    }

    @FXML
    private void GestionEvenement(ActionEvent event) {
    }

    @FXML
    private void GestionForum(ActionEvent event) {
    }

    @FXML
    private void GestionService(ActionEvent event) {
    }

    @FXML
    private void GestionRendezVous(ActionEvent event) {
    }

    @FXML
    private void GestionReclamation(ActionEvent event) {
    }
      
    
     
	      
        
   

 
      
    
}
