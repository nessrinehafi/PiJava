/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sprintjavagui.User;

import Entities.DemandeRole;
import Services.demandeRoleServices;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextArea;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
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
import static sprintjavagui.User.LoginController.LoggedUser;

/**
 * FXML Controller class
 *
 * @author nouha
 */
public class DemandeRoleController implements Initializable {

    @FXML
    private JFXTextArea demande;
    @FXML
    private ImageView pic;
    @FXML
    private JFXComboBox<String> nvrole;
    @FXML
    private JFXButton valider;
    @FXML
    private JFXButton image;
    @FXML
    private AnchorPane woh;
    @FXML
    private Label role;
    @FXML
    private Label username;
    @FXML
    private JFXButton monprofil;
    @FXML
    private Circle userphoto;
    @FXML
    private Label loggedid;

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
        
        List<String> roles = new ArrayList<>();
        roles.add("Vétérinaire");
        roles.add("Educateur canin");
        ObservableList<String> o = FXCollections.observableArrayList(roles);
        nvrole.setItems(o);

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
            Logger.getLogger(DemandeRoleController.class.getName()).log(Level.SEVERE, null, ex);
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
    private void ajouterDemande(ActionEvent event) throws IOException {

        Image image = pic.getImage();
        String nameImage = saveToFile(image);
        DemandeRole dr = new DemandeRole(demande.getText(), nameImage, nvrole.getValue());
        demandeRoleServices SS = new demandeRoleServices();

        SS.ajouter(dr);
               Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Changer du role");
        alert.setHeaderText("Votre demande de changement du role a été envoyé avec succès.Veuillez attendre la confirmation de l'administrateur.Merci.");
        alert.showAndWait();
        

    }
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
