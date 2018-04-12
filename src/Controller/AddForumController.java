/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import static sprintjavagui.User.LoginController.LoggedUser;
import java.util.logging.Logger;

import Dialog.AlertDialog;
import Model.Forum;
import Model.SmsSender;
import Model.User;
import Service.ForumService;
import Service.UserService;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author nessrine
 */
public class AddForumController implements Initializable {
	

    @FXML
    private JFXTextField titre;
    @FXML
    private JFXTextField tags;
    @FXML
    private JFXTextArea blog;
    @FXML
    private ImageView image;
    @FXML
    private JFXButton Ajouter;
    private File selectedFile;
    @FXML
    private JFXButton Addimage;
    @FXML
    private JFXButton Ajouter1;
    @FXML
    private JFXButton Ajouter11;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

   
 
    @FXML
	private void addImage(ActionEvent event) {
		FileChooser f = new FileChooser();
		selectedFile = f.showOpenDialog(null);
		if (selectedFile != null) {
			image.setImage(new Image("file:" + selectedFile.getPath()));
		}
	}

	public boolean controleSaisie() {
		if (tags.getText().isEmpty() || titre.getText().isEmpty()
				|| blog.getText().isEmpty()) {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setTitle("Required fields");
			alert.setHeaderText(null);
			alert.setContentText("Please fill in all fields");
			alert.show();
			return false;
		}
		return true;
	}

    @FXML
    private void AjouterSujet(ActionEvent event) {
        
        
        
	
		if (controleSaisie()) {
			
			String url_image = "";
			if (selectedFile != null) {
				url_image = selectedFile.getPath();
			}
                        
                        System.out.println("not ");
			Forum p = new Forum( titre.getText(), blog.getText(), new Date(), tags.getText(), url_image, LoggedUser.username,LoggedUser.id,0);
                        
                        
                        System.out.println("$$$$$$$$$$$$$$");

			//User u = new User();
			//u.setId(User.connected_id);
			ForumService F =new ForumService();
                        F.ajouterForum(p);
			
			AlertDialog.Display("info", "Le Sujet Est Ajouté");
			}
                 SmsSender msg = new SmsSender();
        try {
       
            msg.send();
        } 
        catch (URISyntaxException ex) {
            Logger.getLogger(AddForumController.class.getName()).log(Level.SEVERE, null, ex);
        }
		}

    @FXML
    private void AjouterSujetLink(ActionEvent event) throws IOException {
         	Parent list_page_parent = FXMLLoader.load(getClass().getResource("/View/AddForum.fxml"));
        Scene list_page_scene = new Scene(list_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

                app_stage.hide(); //optional
                app_stage.setScene(list_page_scene);
                app_stage.show();
    }

    @FXML
    private void AfficherSujet(ActionEvent event) throws IOException {
         	Parent list_page_parent = FXMLLoader.load(getClass().getResource("/View/Forum.fxml"));
        Scene list_page_scene = new Scene(list_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

                app_stage.hide(); //optional
                app_stage.setScene(list_page_scene);
                app_stage.show();
    }
	}
    
        
        
    
    

