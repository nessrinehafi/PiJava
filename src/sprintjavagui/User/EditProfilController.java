/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sprintjavagui.User;

import Entities.User;
import Services.ServiceServices;
import Services.UserServices;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.controls.JFXTextField;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
import org.apache.commons.lang3.RandomStringUtils;
import static sprintjavagui.Service.ModifierServiceFXMLController.saveToFile;
import sprintjavagui.Service.ServiceFXMLController;
import static sprintjavagui.User.LoginController.LoggedUser;

/**
 * FXML Controller class
 *
 * @author nouha
 */
public class EditProfilController implements Initializable {

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
    private Circle photo;
    @FXML
    private JFXHamburger open;
    @FXML
    private JFXTextField fid;
    @FXML
    private JFXButton edit;
    @FXML
    private JFXButton demanderole;
    @FXML
    private Label role;
    @FXML
    private JFXButton monprofil;
    @FXML
    private Circle userphoto;
    @FXML
    private Label loggedid;
    @FXML
    private ImageView pic;
    @FXML
    private JFXTextField Nusername;
    @FXML
    private JFXTextField Nnom;
    @FXML
    private JFXTextField Nprenom;
    @FXML
    private JFXTextField Nemail;
    @FXML
    private JFXTextField Nnumtel;
    @FXML
    private JFXTextField Nadresse;
    @FXML
    private JFXTextField Ndate;
    @FXML
    private AnchorPane woh;

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
        Nusername.setText(s.getUsername());
        Nnom.setText(s.getNom());
        Nprenom.setText(s.getPrenom());
        Nnumtel.setText(String.valueOf(s.getNumtel()));
        Nemail.setText(s.getEmail_canonical());
        Nadresse.setText(s.getAdresse());
        Ndate.setText(s.getDatenaiss());
        loggedid.setText(String.valueOf(s.getId()));
        final String imageURI = new File("C:/xampp/htdocs/Animauxcrud5/Animauxcrud/Animaux/Animaux/web/Pictures/" + s.getImage()).toURI().toString();
        Image image = new Image(imageURI);
        photo.setFill(new ImagePattern(image));

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
            photo.setFill(new ImagePattern(image));
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

        UserServices SS = new UserServices();
        Image image = pic.getImage();
        String nameImage = saveToFile(image);
        SS.modifier(SS.findbyUsername(LoggedUser.getUsername()), Nusername.getText(), Nnom.getText(), Nprenom.getText(), Integer.parseInt(Nnumtel.getText()), Nadresse.getText(), nameImage, Nemail.getText(), Ndate.getText(), LoggedUser.getId());
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Modifier mon profil");
        alert.setHeaderText("Opération réussite!");
        alert.showAndWait();
        Stage stage = new Stage();
//go back to profil
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ProfilUserr.fxml"));
        woh = loader.load();
        stage.setScene(new Scene(woh));
        ProfilUserrController ds = loader.getController();

        ds.MyoldValues();

        stage.show();

    }
}
