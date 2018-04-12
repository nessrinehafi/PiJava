/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sprintjavagui.User;

import Entities.User;
import Services.UserServices;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
import org.apache.commons.lang3.RandomStringUtils;
import sprintjavagui.Service.ServiceFXMLController;

/**
 * FXML Controller class
 *
 * @author nouha
 */
public class RegisterrController implements Initializable {
    @FXML
    private ImageView home;
    @FXML
    private JFXTextField username;
    @FXML
    private JFXTextField name;
    @FXML
    private JFXTextField fname;
    @FXML
    private JFXTextField email;
    @FXML
    private JFXButton register;
    @FXML
    private JFXButton login;
    @FXML
    private JFXPasswordField password;
    @FXML
    private JFXTextField numtel;
    @FXML
    private JFXTextField dn;
    @FXML
    private JFXTextField adresse;
    @FXML
    private Label eUsername;
    @FXML
    private Label epassword;
    @FXML
    private Label ename;
    @FXML
    private Label efname;
    @FXML
    private Label eemail;
    @FXML
    private Label enumtel;
    @FXML
    private Label edn;
    @FXML
    private Label eadresse;
    @FXML
    private JFXButton image;
    @FXML
    private ImageView pic;

    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
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
        }}

    

    @FXML
    private void register(ActionEvent event) {
        Image image = pic.getImage();
        String nameImage = saveToFile(image);
        boolean isUsernameEmpty=Utils.TextFieldValidation.TextFieldNotEmpty(username, eUsername, "missing username");
        boolean isPasswordEmpty=Utils.TextFieldValidation.TextFieldNotEmpty(password, epassword, "missing Password ");
        boolean isNameEmpty=Utils.TextFieldValidation.TextFieldNotEmpty(name, ename, "missing Name ");
        boolean isFnameEmpty=Utils.TextFieldValidation.TextFieldNotEmpty(fname, efname, "missing Family Name ");    
        boolean isEmailEmpty=Utils.TextFieldValidation.TextFieldNotEmpty(email, eemail, "missing Email "); 
        boolean isPhoneNumberEmpty=Utils.TextFieldValidation.TextFieldNotEmpty(numtel, enumtel, "missing Phone Number "); 
        boolean isPhoneNumberNotNumber=Utils.TextFieldValidation.TextFieldNumber(numtel, enumtel, "missing Phone Number "); 
        boolean isBirthdayEmpty=Utils.TextFieldValidation.TextFieldNotEmpty(dn, edn, "missing Birth date "); 
        boolean isAdresseEmpty=Utils.TextFieldValidation.TextFieldNotEmpty(adresse, eadresse, "missing Adresse  "); 
        
        
            User user=new User(username.getText(),email.getText(),password.getText(),fname.getText(),name.getText(),Integer.parseInt(numtel.getText()),dn.getText(),adresse.getText(),nameImage);
        UserServices US=new UserServices();
        
        US.ajouter(user);
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
    public void LoginPage(ActionEvent event) throws IOException {
                Parent list_page_parent = FXMLLoader.load(getClass().getResource("Login.fxml"));
		Scene list_page_scene = new Scene(list_page_parent);
		Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		app_stage.hide(); //optional
		app_stage.setScene(list_page_scene);
		app_stage.show();
	}
    
    

    
}
