/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sprintjavagui.User;

import Entities.DemandeRole;
import Services.demandeRoleServices;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author nouha
 */
public class AfficherDemandeRoleController implements Initializable {

    @FXML
    private JFXButton home;
    @FXML
    private JFXTextField username;
    @FXML
    private JFXTextField nvrole;
    @FXML
    private JFXTextField demande;
    @FXML
    private ImageView image;
    @FXML
    private JFXButton valider;
    @FXML
    private JFXButton supp;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void oldValues(int idd) {
        demandeRoleServices SS = new demandeRoleServices();
        DemandeRole s = SS.afficheall().filtered(e -> e.getId() == idd).get(0);
        username.setText(s.getDemandeur());
        nvrole.setText(s.getNvrole());
        demande.setText(s.getDemande());
        final String imageURI = new File("C:/xampp/htdocs/Animauxcrud5/Animauxcrud/Animaux/Animaux/web/Pictures/" + s.getDocument()).toURI().toString();
        image.setImage(new Image(imageURI));
    }

    @FXML
    public void Valider(ActionEvent event) throws IOException, SQLException {
        demandeRoleServices SS = new demandeRoleServices();
        DemandeRole s = SS.afficheall().get(0);
        SS.valider(s.getDemandeur());
        SS.supprimer(s.getId());
        Parent list_page_parent = FXMLLoader.load(getClass().getResource("ListeDemandeRoleadmin.fxml"));
        Scene list_page_scene = new Scene(list_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        app_stage.hide(); //optional
        app_stage.setScene(list_page_scene);
        app_stage.show();
    }

    @FXML
    void ActionSupp(ActionEvent event) throws IOException {
        demandeRoleServices SS = new demandeRoleServices();
        DemandeRole s = SS.afficheall().get(0);
        SS.supprimer(s.getId());

        Parent list_page_parent = FXMLLoader.load(getClass().getResource("ListeDemandeRoleadmin.fxml"));
        Scene list_page_scene = new Scene(list_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        app_stage.hide(); //optional
        app_stage.setScene(list_page_scene);
        app_stage.show();

    }

}
