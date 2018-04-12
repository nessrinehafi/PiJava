/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sprintjavagui.Service;

import Entities.Service;
import Services.ServiceServices;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
import org.apache.commons.lang3.RandomStringUtils;
import static sprintjavagui.User.LoginController.LoggedUser;

/**
 * FXML Controller class
 *
 * @author nouha
 */
public class ModifierServiceFXMLController implements Initializable {

    @FXML
    private ImageView pic;
    @FXML
    private JFXTextField titre;
    @FXML
    private JFXTextArea description;
    private JFXTextField datec;
    @FXML
    private JFXTextField adresse;
    @FXML
    private JFXTextField numtel;
    @FXML
    private AnchorPane Main;
    @FXML
    private JFXHamburger affmenu;
    @FXML
    private Circle userphoto;
    @FXML
    private Label username;
    @FXML
    private Label role;
    @FXML
    private JFXDrawer menu;
    @FXML
    private JFXButton edit;
    @FXML
    private TextField idS;
    @FXML
    private JFXButton image;
    @FXML
    private ImageView pic1;

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
                                    Main = (AnchorPane) loader.load();
                                    Stage stage = new Stage();
                                    stage.setScene(new Scene(Main));
                                    stage.show();
                                } catch (IOException ex) {
                                    Logger.getLogger(ModifierServiceFXMLController.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                break;
                            case "services":
                                try {

                                    FXMLLoader loader = new FXMLLoader(getClass().getResource("Listecategories.fxml"));
                                    Main = (AnchorPane) loader.load();
                                    Stage stage = new Stage();
                                    stage.setScene(new Scene(Main));
                                    stage.show();

                                } catch (IOException ex) {
                                    Logger.getLogger(ModifierServiceFXMLController.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                break;

                        }

                    });
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
                }
            }
            );
        } catch (IOException ex) {
            Logger.getLogger(ModifierServiceFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void oldValues(int idd) {
        ServiceServices SS = new ServiceServices();
        Service s = SS.afficheall().filtered(e -> e.getId() == idd).get(0);
        titre.setText(s.getTitle());
        description.setText(s.getDescription());
        adresse.setText(s.getAdresseS());
        numtel.setText(String.valueOf(s.getNumtel()));
        final String imageURI = new File("C:/xampp/htdocs/Animauxcrud5/Animauxcrud/Animaux/Animaux/web/Pictures/" + s.getImage()).toURI().toString();
        pic.setImage(new Image(imageURI));
        idS.setText(String.valueOf(s.getId()));

    }

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
    public void modifier(ActionEvent event) throws IOException, SQLException {

        ServiceServices SS = new ServiceServices();
        Image image = pic.getImage();
        String nameImage = saveToFile(image);
        SS.modifier(SS.findbyId(Integer.parseInt(idS.getText())), titre.getText(), description.getText(), adresse.getText(), Integer.parseInt(numtel.getText()), nameImage, Integer.parseInt(idS.getText()));
        Parent list_page_parent = FXMLLoader.load(getClass().getResource("Messervices.fxml"));
        Scene list_page_scene = new Scene(list_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.hide(); //optional
        app_stage.setScene(list_page_scene);
        app_stage.show();

    }

}
