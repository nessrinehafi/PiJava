/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sprintjavagui.Service;

import Entities.Service;
import Entities.User;
import Services.UserServices;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import static sprintjavagui.Service.ServiceFXMLController.recherché;
import static sprintjavagui.User.LoginController.LoggedUser;
import sprintjavagui.User.ProfilUserrController;

/**
 * FXML Controller class
 *
 * @author nouha
 */
public class ListecategoriesController implements Initializable {

    @FXML
    private AnchorPane anchrone;

    @FXML
    private Label role;
    @FXML
    private JFXDrawer menu;
    @FXML
    private JFXHamburger affmenu;
    @FXML
    private JFXButton vet;
    @FXML
    private JFXButton ed;
    @FXML
    private JFXButton pet;
    @FXML
    private JFXButton monprofil;
    @FXML
    private Label loggedid;
    @FXML
    private Circle userphoto;
    @FXML
    private Label username;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO
            username.setText(LoggedUser.getUsername());
            role.setText("(" + LoggedUser.getRole() + ")");
            final String imageURI = new File("C:/xampp/htdocs/Animauxcrud5/Animauxcrud/Animaux/Animaux/web/Pictures/" + LoggedUser.getImage()).toURI().toString();
            Image image = new Image(imageURI);
            userphoto.setFill(new ImagePattern(image));
            //************Design********************

            AnchorPane anchrone = FXMLLoader.load(getClass().getResource("Menu.fxml"));
            menu.setSidePane(anchrone);

            for (Node node : anchrone.getChildren()) {
                if (node.getAccessibleText() != null) {
                    node.addEventHandler(MouseEvent.MOUSE_CLICKED, (e) -> {
                        switch (node.getAccessibleText()) {
                            case "homepage":
                                try {
                                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/AccueilGroupe.fxml"));
                                    AnchorPane an = new AnchorPane();
                                    an = (AnchorPane) loader.load();
                                    Stage stage = new Stage();
                                    stage.setScene(new Scene(an));
                                    stage.show();
                                } catch (IOException ex) {
                                    Logger.getLogger(ListecategoriesController.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                break;
                            case "services":
                                try {

                                    FXMLLoader loader = new FXMLLoader(getClass().getResource("Listecategories.fxml"));
                                    AnchorPane an = new AnchorPane();
                                    an = (AnchorPane) loader.load();
                                    Stage stage = new Stage();
                                    stage.setScene(new Scene(an));
                                    stage.show();

                                } catch (IOException ex) {
                                    Logger.getLogger(ListecategoriesController.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                break;
                            case "add":
                                try {

                                    FXMLLoader loader = new FXMLLoader(getClass().getResource("ServiceFXML.fxml"));
                                    AnchorPane an = new AnchorPane();
                                    an = (AnchorPane) loader.load();
                                    Stage stage = new Stage();
                                    stage.setScene(new Scene(an));
                                    stage.show();

                                } catch (IOException ex) {
                                    Logger.getLogger(ListecategoriesController.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                break;
                            case "fav":
                                try {

                                    FXMLLoader loader = new FXMLLoader(getClass().getResource("Messervicesfav.fxml"));
                                    AnchorPane an = new AnchorPane();
                                    an = (AnchorPane) loader.load();
                                    Stage stage = new Stage();
                                    stage.setScene(new Scene(an));
                                    stage.show();

                                } catch (IOException ex) {
                                    Logger.getLogger(ListecategoriesController.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                break;
                                
                                case "messervices":
                                try {

                                    FXMLLoader loader = new FXMLLoader(getClass().getResource("Messervices.fxml"));
                                    AnchorPane an = new AnchorPane();
                                    an = (AnchorPane) loader.load();
                                    Stage stage = new Stage();
                                    stage.setScene(new Scene(an));
                                    stage.show();

                                } catch (IOException ex) {
                                    Logger.getLogger(ListecategoriesController.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                break;
                                
                                
                                
                            case "deco":
                                node.setOnMouseClicked(new EventHandler<MouseEvent>() {

                                    @Override
                                    public void handle(MouseEvent event) {

                                        try {
                                            Parent list_page_parent = FXMLLoader.load(getClass().getResource("../User/Login.fxml"));
                                            Scene list_page_scene = new Scene(list_page_parent);
                                            Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                                            app_stage.hide(); //optional
                                            app_stage.setScene(list_page_scene);
                                            app_stage.show();
                                        } catch (IOException ex) {
                                            Logger.getLogger(ServiceFXMLController.class.getName()).log(Level.SEVERE, null, ex);
                                        }
                                    }
                                });
                                break;

                        }

                    });

                    Stage stage = new Stage();

                    //***************** menu Search************
                    if (node.getClass().getName().equals("com.jfoenix.controls.JFXTextField")) {
                        node.setOnKeyReleased(new EventHandler<KeyEvent>() {

                            @Override
                            public void handle(KeyEvent event) {

                                try {
                                    JFXTextField TE = (JFXTextField) node;
                                    recherché = TE.getText();
                                    FXMLLoader loader = new FXMLLoader(getClass().getResource("AffichageRecherche.fxml"));
                                    AnchorPane p = new AnchorPane();
                                    p = loader.load();

                                    stage.setScene(new Scene(p));

                                    System.out.println(TE.getText());

                                    stage.show();
                                } catch (IOException ex) {
                                    Logger.getLogger(ServiceFXMLController.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                        });

                    }
                }
            }

            HamburgerBackArrowBasicTransition burgerTask2 = new HamburgerBackArrowBasicTransition(affmenu);
            burgerTask2.setRate(-1);

            affmenu.addEventHandler(MouseEvent.MOUSE_PRESSED, (e) -> {
                burgerTask2.setRate(burgerTask2.getRate() * -1);
                burgerTask2.play();

                if (menu.isShown()) {
                    menu.close();
                } else {
                    menu.open();
                    menu.toFront();
                }
            }
            );
        } catch (IOException ex) {
            Logger.getLogger(ListecategoriesController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    public void medicalPage(ActionEvent event) throws IOException {

        Parent list_page_parent = FXMLLoader.load(getClass().getResource("Listemedical.fxml"));
        Scene list_page_scene = new Scene(list_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        app_stage.hide(); //optional
        app_stage.setScene(list_page_scene);
        app_stage.show();
    }

    @FXML
    public void edPage(ActionEvent event) throws IOException {

        Parent list_page_parent = FXMLLoader.load(getClass().getResource("ListeEd.fxml"));
        Scene list_page_scene = new Scene(list_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        app_stage.hide(); //optional
        app_stage.setScene(list_page_scene);
        app_stage.show();
    }

    @FXML
    public void petPage(ActionEvent event) throws IOException {

        Parent list_page_parent = FXMLLoader.load(getClass().getResource("ListePet.fxml"));
        Scene list_page_scene = new Scene(list_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        app_stage.hide(); //optional
        app_stage.setScene(list_page_scene);
        app_stage.show();
    }

    @FXML
    public void Monprofil(ActionEvent event) throws IOException, SQLException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("../User/ProfilUserr.fxml"));
        AnchorPane p = new AnchorPane();
        p = loader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(p));
        ProfilUserrController ds = loader.getController();

        ds.MyoldValues();

        stage.show();

    }

}
