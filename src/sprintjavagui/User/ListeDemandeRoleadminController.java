/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sprintjavagui.User;

import Entities.DemandeRole;
import Entities.Service;
import Services.demandeRoleServices;
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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import sprintjavagui.Service.DetailServiceFXMLController;
import sprintjavagui.Service.ListServiceFXMLController;

/**
 * FXML Controller class
 *
 * @author nouha
 */
public class ListeDemandeRoleadminController implements Initializable {

    ObservableList<DemandeRole> listU = FXCollections.observableArrayList();

    @FXML
    private TableView<DemandeRole> table;
    @FXML
    private TableColumn<DemandeRole, Integer> id;
    @FXML
    private TableColumn<DemandeRole, String> username;
    @FXML
    private TableColumn<DemandeRole, String> nvrole;
    @FXML
    private JFXButton afficher;
    @FXML
    private TableColumn<DemandeRole, Date> date;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ActionEvent event = null;
        try {
            ListerDemande(event);
        } catch (IOException ex) {
            Logger.getLogger(ListServiceFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void ListerDemande(ActionEvent event) throws IOException {
        demandeRoleServices SS = new demandeRoleServices();
        ObservableList observableList = FXCollections.observableArrayList(SS.afficheall());
        table.setItems(observableList);
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        username.setCellValueFactory(new PropertyValueFactory<>("demandeur"));
        nvrole.setCellValueFactory(new PropertyValueFactory<>("nvrole"));
        date.setCellValueFactory(new PropertyValueFactory<>("dateDemande"));

    }

    private void loadCovList() throws SQLException {
        //listCov.clear();
        demandeRoleServices ss = new demandeRoleServices();
        listU = ss.afficheall();
        table.setItems(listU);

    }

    @FXML
    public void AfficherPage(ActionEvent event) throws IOException {

        /*Parent list_page_parent = FXMLLoader.load(getClass().getResource("DetailServiceFXML.fxml"));
         Scene list_page_scene = new Scene(list_page_parent);
         Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
         app_stage.hide(); //optional
         app_stage.setScene(list_page_scene);
         app_stage.show();*/
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AfficherDemandeRole.fxml"));
        Parent root = loader.load();
        AfficherDemandeRoleController ds = loader.getController();
        DemandeRole s = table.getSelectionModel().getSelectedItem();
        ds.oldValues(s.getId());
        table.getScene().setRoot(root);
    }

}
