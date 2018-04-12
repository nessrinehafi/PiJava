/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import sprintjavagui.User.*;
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
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import static sprintjavagui.User.LoginController.LoggedUser;

/**
 * FXML Controller class
 *
 * @author haythem
 */
public class CategorieInterfaceController implements Initializable {

    @FXML
    private Button rdvattenteuser;
    @FXML
    private Button listerdvvalider;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        listerdvvalider.setVisible(false);
        
        
        rdvattenteuser.setVisible(false);
        
        if (LoggedUser.getRole().contains("Educateur canin") || LoggedUser.getRole().contains("Vétérinaire"))
        {
            
            listerdvvalider.setVisible(true);
        }
        
        if (LoggedUser.getRole().contains("utilisateur simple"))
        {
            rdvattenteuser.setVisible(true);
        }
        // TODO
    }    

    @FXML
    private void listedresseur(ActionEvent event) throws IOException {
        

      
        Parent page_select_my = FXMLLoader.load(getClass().getResource("ListedresseurInterface.fxml"));        
        Scene scene = new Scene(page_select_my);
        Stage app=(Stage)((Node)event.getSource() ).getScene().getWindow();
        app.setScene(scene);
        app.show();
    }

    @FXML
    private void listevet(ActionEvent event) throws IOException {
        
               
             Parent page_select_my = FXMLLoader.load(getClass().getResource("ListevetInterface.fxml"));        
        Scene scene = new Scene(page_select_my);
        Stage app=(Stage)((Node)event.getSource() ).getScene().getWindow();
        app.setScene(scene);
        app.show();
    }

    @FXML
    private void listegarde(ActionEvent event) throws IOException {
        
               
             Parent page_select_my = FXMLLoader.load(getClass().getResource("ListegardeInterface.fxml"));        
        Scene scene = new Scene(page_select_my);
        Stage app=(Stage)((Node)event.getSource() ).getScene().getWindow();
        app.setScene(scene);
        app.show();
    }

    

    @FXML
    private void Accueil(ActionEvent event) throws IOException {
        
                       
        Parent page_select_my = FXMLLoader.load(getClass().getResource("AccueilInterface.fxml"));        
        Scene scene = new Scene(page_select_my);
        Stage app=(Stage)((Node)event.getSource() ).getScene().getWindow();
        app.setScene(scene);
        app.show();
    }

    @FXML
    private void rdvattente(ActionEvent event) throws IOException {
        
                       
       
            
     
        
        
            Parent page_select_my = FXMLLoader.load(getClass().getResource("ListerdvattnteuserInterface.fxml"));        
        Scene scene = new Scene(page_select_my);
        Stage app=(Stage)((Node)event.getSource() ).getScene().getWindow();
        app.setScene(scene);
        app.show();
        
    }

    @FXML
    private void rdvuser(ActionEvent event) throws IOException {
        
                    
                    Parent page_select_my = FXMLLoader.load(getClass().getResource("Listerdvuser.fxml"));        
        Scene scene = new Scene(page_select_my);
        Stage app=(Stage)((Node)event.getSource() ).getScene().getWindow();
        app.setScene(scene);
        app.show();
    }

    @FXML
    private void deco(ActionEvent event) throws IOException {
    }
    
    @FXML
    private void listerdvvalider(ActionEvent event) throws IOException {
        
        Parent page_select_my = FXMLLoader.load(getClass().getResource("ListerdvattenteInterface.fxml"));        
        Scene scene = new Scene(page_select_my);
        Stage app=(Stage)((Node)event.getSource() ).getScene().getWindow();
        app.setScene(scene);
        app.show();
    }
    
}
