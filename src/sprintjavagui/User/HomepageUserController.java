/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sprintjavagui.User;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import static sprintjavagui.User.LoginController.LoggedUser;

/**
 * FXML Controller class
 *
 * @author nouha
 */
public class HomepageUserController implements Initializable {
    @FXML
    private ImageView userphoto;
    @FXML
    private Label username;
    @FXML
    private Label role;
    @FXML
    private MenuItem listeVet;
    @FXML
    private MenuItem listePet;
    @FXML
    private MenuItem listeEd;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
                username.setText(LoggedUser.getUsername());
                role.setText("("+LoggedUser.getRole()+")");
                final String imageURI = new File("C:/xampp/htdocs/Animauxcrud5/Animauxcrud/Animaux/Animaux/web/Pictures/" +LoggedUser.getImage()).toURI().toString();
        userphoto.setImage(new Image(imageURI));

    }
    @FXML
    public void ListVetPage(ActionEvent event) throws IOException {
                Parent list_page_parent = FXMLLoader.load(getClass().getResource("../Service/ListeVet.fxml"));
		Scene list_page_scene = new Scene(list_page_parent);
		Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		app_stage.hide(); //optional
		app_stage.setScene(list_page_scene);
		app_stage.show();
	}

    @FXML
    private void ListVetPage(Event event) throws IOException {
        Parent list_page_parent = FXMLLoader.load(getClass().getResource("../Service/ListeVet.fxml"));
		Scene list_page_scene = new Scene(list_page_parent);
		Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		app_stage.hide(); //optional
		app_stage.setScene(list_page_scene);
		app_stage.show();
    }
   
    
}
