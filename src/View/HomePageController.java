/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import static Controller.ForumController.l;
import static Controller.GestionUtilisateurController.ff;
import static Controller.RegisterController.LoggedUser;
import Dialog.AlertDialog;
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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author nessrine
 */
public class HomePageController implements Initializable {

    @FXML
    private Button Forum;
    @FXML
    private Label conncted;
    @FXML
    private ImageView forum1;
     int ab;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        //conncted.setText(String.valueOf(LoggedUser.nom+"  "+LoggedUser.prenom));
       // ab = LoggedUser.fenable;
        // System.out.println("---------------------"+ff);
    }    
    @FXML
    private void Forum(ActionEvent event) throws IOException {
        System.out.println("---------------------"+ab);
        if(LoggedUser.fenable==1)
        {
            AlertDialog.Display("info", "Vous ete  bani");
        }
        else{
            Parent list_page_parent = FXMLLoader.load(getClass().getResource("Forum.fxml"));
            Scene list_page_scene = new Scene(list_page_parent);
            Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            
            app_stage.hide(); //optional
            app_stage.setScene(list_page_scene);
            app_stage.show();
        }
    }

    private void Forum(MouseEvent event) throws IOException {
               	Parent list_page_parent = FXMLLoader.load(getClass().getResource("Forum.fxml"));
        Scene list_page_scene = new Scene(list_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

                app_stage.hide(); //optional
                app_stage.setScene(list_page_scene);
                app_stage.show();
    }

    @FXML
    private void Forum1(MouseEvent event) {
    }
    
}
