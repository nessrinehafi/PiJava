/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sprintjavagui.User;

import Entities.LectureEcriture;
import Entities.User;
import Services.UserServices;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import org.mindrot.jbcrypt.BCrypt;

/**
 * FXML Controller class
 *
 * @author nessrine
 */
public class LoginController implements Initializable {
          public static User LoggedUser;

    @FXML
    private JFXTextField username;
    @FXML
    private JFXPasswordField password;
    @FXML
    private JFXButton login;
    @FXML
    private ImageView image;
    @FXML
    private JFXButton sign;
    @FXML
    private JFXCheckBox remember_me;

     @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
    
    @FXML
    private void SignUpAction(ActionEvent event) throws IOException {
        Parent list_page_parent = FXMLLoader.load(getClass().getResource("registerr.fxml"));
		Scene list_page_scene = new Scene(list_page_parent);
	
		Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

		app_stage.hide(); //optional
		app_stage.setScene(list_page_scene);
		app_stage.show();
    }

     @FXML
    private void LoginAction(ActionEvent event) {
        try {
			UserServices su = new UserServices();

			

			if (!username.getText().equals("") || !password.getText().equals("")) 
			{
				//if ((su.IsActif(username.getText(), password.getText())) ) 
				
					if ((su.CanLog(username.getText(), password.getText()))) 
					{	//si le prestataire can login

						LoggedUser = su.searchUserByEmail(password.getText(), username.getText());
						/*
					Alert alert = new Alert(Alert.AlertType.INFORMATION);
					alert.setTitle("Infos");
					alert.setHeaderText(null);
					alert.setContentText(LoggedUtilisateur.toString());
					alert.showAndWait();*/

						//if (su.IsAdmin(LoggedUser.getUsername(), LoggedUser.getPassword())) {	//si lutilisateur est un admin
							
                                                
                                                
                                                        Parent list_page_parent = FXMLLoader.load(getClass().getResource("/GUI/AccueilGroupe.fxml"));
							Scene list_page_scene = new Scene(list_page_parent);
							Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

							app_stage.hide(); //optional
							app_stage.setScene(list_page_scene);
							app_stage.show();

                                                           
						/*} else {	//sinon c un membre
							Parent list_page_parent = FXMLLoader.load(getClass().getResource("InterfaceUtilisateur.fxml"));
							Scene list_page_scene = new Scene(list_page_parent);
							Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

							app_stage.hide();
							app_stage.setScene(list_page_scene);
							app_stage.show();
						}*/

					} else {
						/*if (sps.CanLog(TfLogin.getText(), Pw.getText())) 
					{
						// si le prestataire can login
						LoggedPrestataire_service = sps.findByLgPw(Pw.getText(), TfLogin.getText());
						LoggedPrestataire_service.setId_prest(su.findByLogPass(LoggedPrestataire_service.getLogin_prest(), LoggedPrestataire_service.getMdp_prest()));

						Parent list_page_parent = FXMLLoader.load(getClass().getResource("InterfacePrest.fxml"));
						Scene list_page_scene = new Scene(list_page_parent);
						Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

						app_stage.hide(); //optional
						app_stage.setScene(list_page_scene);
						app_stage.show();
					} else */
                                            //{//sinon sil nest ni membre ni admin ni prest ERROR
						/*Alert alert = new Alert(Alert.AlertType.ERROR);
						alert.setTitle("Login Invalide");
						alert.setHeaderText("Verifiez vos parametres !");
						Optional<ButtonType> result = alert.showAndWait();*/
                                            System.out.println("invalid");
					}
                        }	
			 else 
			{
				Alert alert = new Alert(Alert.AlertType.ERROR);
				alert.setTitle("Champs vides!");
				alert.setHeaderText("Veuillez saisir Votre login et mot de passe !");
				Optional<ButtonType> result = alert.showAndWait();
			}

		} catch (Exception ex) {
			Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
			System.out.println("IOE exeption");
		}
    }

   
    
}
    

