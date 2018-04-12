/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.User;
import Service.UserService;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author nessrine
 */
public class RegisterController implements Initializable {

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
    public static User LoggedUser;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO     public static User LoggedUser;
    }    

    @FXML
    private void register(ActionEvent event) throws IOException {
        boolean isUsernameEmpty=Util.TextFieldValidation.TextFieldNotEmpty(username, eUsername, "missing username");
        boolean isPasswordEmpty=Util.TextFieldValidation.TextFieldNotEmpty(password, epassword, "missing Password ");
        boolean isNameEmpty=Util.TextFieldValidation.TextFieldNotEmpty(name, ename, "missing Name ");
        boolean isFnameEmpty=Util.TextFieldValidation.TextFieldNotEmpty(fname, efname, "missing Family Name ");    
        boolean isEmailEmpty=Util.TextFieldValidation.TextFieldNotEmpty(email, eemail, "missing Email "); 
        boolean isPhoneNumberEmpty=Util.TextFieldValidation.TextFieldNotEmpty(numtel, enumtel, "missing Phone Number "); 
        boolean isPhoneNumberNotNumber=Util.TextFieldValidation.TextFieldNumber(numtel, enumtel, "missing Phone Number "); 
        boolean isBirthdayEmpty=Util.TextFieldValidation.TextFieldNotEmpty(dn, edn, "missing Birth date "); 
        boolean isAdresseEmpty=Util.TextFieldValidation.TextFieldNotEmpty(adresse, eadresse, "missing Adresse  "); 
        
            User user=new User(username.getText(),email.getText(),password.getText(),name.getText(),fname.getText(),Integer.parseInt(numtel.getText()),dn.getText(),adresse.getText());
        UserService US=new UserService();
        
        US.ajouter(user);
        Parent list_page_parent = FXMLLoader.load(getClass().getResource("/View/Login.fxml"));
        Scene list_page_scene = new Scene(list_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

                app_stage.hide(); //optional
                app_stage.setScene(list_page_scene);
                app_stage.show();
    }

    @FXML
    private void LoginLink(ActionEvent event) throws IOException {
         	Parent list_page_parent = FXMLLoader.load(getClass().getResource("/View/Login.fxml"));
        Scene list_page_scene = new Scene(list_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

                app_stage.hide(); //optional
                app_stage.setScene(list_page_scene);
                app_stage.show();
    }
    
}
