/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sprintjavagui.Service;

import Entities.Service;
import Services.ServiceServices;
import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.shape.Circle;

/**
 * FXML Controller class
 *
 * @author nouha
 */
public class ListeVetController implements Initializable {
    @FXML
    private Circle userphoto;
    @FXML
    private Label username;
    @FXML
    private Label role;
    @FXML
    private TableView<Service> table;
    @FXML
    private TableColumn<Service, Integer> id;
    @FXML
    private TableColumn<Service, String> titre;
    @FXML
    private TableColumn<Service, String> description;
    @FXML
    private TableColumn<Service, Date> datec;
    @FXML
    private TableColumn<Service, String> adresse;
    @FXML
    private TableColumn<Service, String> numtel;
    @FXML
    private TableColumn<Service, String> user;
    @FXML
    private JFXButton afficher;
    @FXML
    private JFXButton modifier;
    @FXML
    private JFXButton supprimer;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ActionEvent eventt=null;
        try {
            ListerServices(eventt);
        } catch (IOException ex) {
            Logger.getLogger(ListeVetController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ListeVetController.class.getName()).log(Level.SEVERE, null, ex);
        }
        // TODO
    }
    
    public void ListerServices(ActionEvent event) throws IOException, SQLException{
        ServiceServices SS=new ServiceServices();
        String categorie="Vétérinaires";
        ObservableList observableList=FXCollections.observableArrayList(SS.afficheVet());
        table.setItems(observableList);
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        titre.setCellValueFactory(new PropertyValueFactory<>("title"));
        description.setCellValueFactory(new PropertyValueFactory<>("description"));
        datec.setCellValueFactory(new PropertyValueFactory<>("createDt"));
        adresse.setCellValueFactory(new PropertyValueFactory<>("adresseS"));
        numtel.setCellValueFactory(new PropertyValueFactory<>("numtel"));
        user.setCellValueFactory(new PropertyValueFactory<>("userservice"));
   
    }

    @FXML
    private void AfficherPage(ActionEvent event) {
    }

    @FXML
    private void ModifierPage(ActionEvent event) {
    }

    @FXML
    private void ActionSupp(ActionEvent event) {
    }
    
}
