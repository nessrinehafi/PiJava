/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sprintjavagui.Service;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;

import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import Services.ServiceServices;
import javafx.scene.control.TextField;

import Entities.Service;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import java.awt.image.BufferedImage;
import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
import org.apache.commons.lang3.RandomStringUtils;
import static sprintjavagui.User.LoginController.LoggedUser;
import sprintjavagui.User.ProfilUserrController;

/**
 * FXML Controller class
 *
 * @author nouha
 */
public class ServiceFXMLController implements Initializable {

    @FXML
    private Label username;
    @FXML
    private TextField titre;
    @FXML
    private JFXTextArea description;
    @FXML
    private TextField numtel;
    @FXML
    private TextField adresse;
    @FXML
    private JFXButton valider;
    @FXML
    private JFXButton image;
    @FXML
    private ImageView pic;
    @FXML
    private JFXComboBox<String> categorie;
    @FXML
    private Circle userphoto;
    @FXML
    private Label role;
    @FXML
    private JFXHamburger affmenu;
    @FXML
    private JFXDrawer menu;
    @FXML
    private AnchorPane anchrone;
    @FXML
    private Pane tab;
    public static String recherché;
    @FXML
    private JFXButton monprofil;
    @FXML
    private Label loggedid;

    @FXML
    public void addImage(ActionEvent event) throws IOException {
        FileChooser fc = new FileChooser();

        FileChooser.ExtensionFilter extFilterJPG = new FileChooser.ExtensionFilter("JPG files (*.jpg)", "*.JPG");
        FileChooser.ExtensionFilter extFilterPNG = new FileChooser.ExtensionFilter("PNG files (*.png)", "*.PNG");
        fc.getExtensionFilters().addAll(extFilterJPG, extFilterPNG);
        File selectedFile = fc.showOpenDialog(null);
        try {
            BufferedImage bufferedImage = ImageIO.read(selectedFile);
            Image image = SwingFXUtils.toFXImage(bufferedImage, null);
            pic.setImage(image);
        } catch (IOException ex) {
            Logger.getLogger(ServiceFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void ajouterService(ActionEvent event) throws IOException {
        Image image = pic.getImage();
        String nameImage = saveToFile(image);
        Service service = new Service(titre.getText(), description.getText(), adresse.getText(), Integer.parseInt(numtel.getText()), nameImage, categorie.getValue());
        ServiceServices SS = new ServiceServices();

        SS.ajouter(service);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Ajouter un service");
        alert.setHeaderText("Service a été ajouté avec succès!");
        alert.showAndWait();

    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            username.setText(LoggedUser.getUsername());
            role.setText("(" + LoggedUser.getRole() + ")");
            final String imageURI = new File("C:/xampp/htdocs/Animauxcrud5/Animauxcrud/Animaux/Animaux/web/Pictures/" + LoggedUser.getImage()).toURI().toString();
            Image image = new Image(imageURI);
            userphoto.setFill(new ImagePattern(image));
            List<String> categories = new ArrayList<>();
            if (null != LoggedUser.getRole()) {
                switch (LoggedUser.getRole()) {
                    case "Vétérinaire":
                        categories.add("Vétérinaires");
                        categories.add("Garde pour animaux");
                        break;
                    case "Educateur canin":
                        categories.add("Education Canine");
                        categories.add("Garde pour animaux");
                        break;
                    default:
                        categories.add("Garde pour animaux");
                        break;
                }
            }
            ObservableList<String> o = FXCollections.observableArrayList(categories);
            categorie.setItems(o);

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
            Logger.getLogger(ServiceFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static String saveToFile(Image image) {

        String ext = "jpg";
        File dir = new File("C:/xampp/htdocs/Animauxcrud5/Animauxcrud/Animaux/Animaux/web/Pictures");
        String name = String.format("%s.%s", RandomStringUtils.randomAlphanumeric(8), ext);
        File outputFile = new File(dir, name);
        BufferedImage bImage = SwingFXUtils.fromFXImage(image, null);
        try {
            ImageIO.write(bImage, "png", outputFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return name;
    }

    @FXML
    private void Monprofil(ActionEvent event) throws IOException, SQLException {
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
