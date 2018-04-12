/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sprintjavagui.User;

import Entities.User;
import Services.UserServices;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXHamburger;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import static sprintjavagui.User.LoginController.LoggedUser;

/**
 * FXML Controller class
 *
 * @author nouha
 */
public class ProfilUserrController implements Initializable {

    @FXML
    private Label username;
    @FXML
    private Label nom;
    @FXML
    private Label prenom;
    @FXML
    private Label email;
    @FXML
    private Label numtel;
    @FXML
    private Label adresse;
    @FXML
    private JFXTextField fusername;
    @FXML
    private JFXTextField fnom;
    @FXML
    private JFXTextField fprenom;
    @FXML
    private JFXTextField femail;
    @FXML
    private JFXTextField fnumtel;
    @FXML
    private JFXTextField fadresse;
    @FXML
    private JFXTextField frole;
    @FXML
    private JFXTextField fdate;
    @FXML
    private JFXHamburger open;
    @FXML
    private Label role;
    @FXML
    private Circle userphoto;
    @FXML
    private Circle photo;
    @FXML
    private JFXTextField fid;
    @FXML
    private JFXButton monprofil;
    @FXML
    private Label loggedid;
    @FXML
    private AnchorPane woh;
    @FXML
    private JFXButton edit;
    @FXML
    private JFXButton desactiver;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        username.setText(LoggedUser.getUsername());
        role.setText("(" + LoggedUser.getRole() + ")");
        final String imageURI = new File("C:/xampp/htdocs/Animauxcrud5/Animauxcrud/Animaux/Animaux/web/Pictures/" + LoggedUser.getImage()).toURI().toString();
        Image image = new Image(imageURI);
        userphoto.setFill(new ImagePattern(image));
    }

    public void MyoldValues() throws SQLException {
        UserServices SS = new UserServices();
        User s = SS.afficheMonprofil();

        fusername.setText(s.getUsername());
        fnom.setText(s.getNom());
        fprenom.setText(s.getPrenom());
        fnumtel.setText(String.valueOf(s.getNumtel()));
        femail.setText(s.getEmail_canonical());
        fadresse.setText(s.getAdresse());
        fdate.setText(s.getDatenaiss());
        frole.setText(s.getRole());
        loggedid.setText(String.valueOf(s.getId()));
        final String imageURI = new File("C:/xampp/htdocs/Animauxcrud5/Animauxcrud/Animaux/Animaux/web/Pictures/" + s.getImage()).toURI().toString();
        Image image = new Image(imageURI);
        photo.setFill(new ImagePattern(image));

    }

    @FXML
    public void Desactiver(ActionEvent event) throws SQLException, IOException {
        UserServices SS = new UserServices();
        SS.enableaccount(false);
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Désactiver mon compte");
        alert.setHeaderText("Votre Compte a été désactivé avec succès! Veuillez se connectez pour le reactiver.");
        alert.showAndWait();
        Parent list_page_parent = FXMLLoader.load(getClass().getResource("Login.fxml"));
        Scene list_page_scene = new Scene(list_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.hide(); //optional
        app_stage.setScene(list_page_scene);
        app_stage.show();

    }

    @FXML
    public void gomodif(ActionEvent event) throws SQLException, IOException {

//        FXMLLoader loader = new FXMLLoader(getClass().getResource("EditProfil.fxml"));
//
//        Parent list_page_parent = FXMLLoader.load(getClass().getResource("EditProfil.fxml"));
//
//        Scene list_page_scene = new Scene(list_page_parent);
//        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//        app_stage.hide(); //optional
//        app_stage.setScene(list_page_scene);
//        EditProfilController ds = loader.getController();
//
//        ds.oldValues();
//        app_stage.show();
//        Stage stage = new Stage();
//
//        FXMLLoader loader = new FXMLLoader(getClass().getResource("EditProfil.fxml"));
//        AnchorPane p = new AnchorPane();
//        p = loader.load();
//        EditProfilController ds = loader.getController();
//
//        ds.MyoldValues();
//
//        stage.setScene(new Scene(p));
//        stage.show();
        UserServices SS = new UserServices();

        User s = SS.afficheMonprofil();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("EditProfil.fxml"));
        Parent root = loader.load();
        EditProfilController ds = loader.getController();
        ds.MyoldValues();
        woh.getScene().setRoot(root);

    }

}
