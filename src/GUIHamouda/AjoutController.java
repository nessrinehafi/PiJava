/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.Annonce;
import Services.AnnonceServices;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import utils.Utils;
import org.controlsfx.control.Notifications;
import static sprintjavagui.User.LoginController.LoggedUser;

/**
 * FXML Controller class
 *
 * @author hamouda
 */
public class AjoutController implements Initializable {

    @FXML
    private TextField animal;
    @FXML
    private ComboBox<String> categorie;
    @FXML
    private TextField description;
    @FXML
    private TextField race;
    private DatePicker datecreation;
    @FXML
    private TextField prix;
    @FXML
    private Button image;
    @FXML
    private Button btn;
    @FXML
    private Button retour;
    @FXML
    private ImageView imageV;
    
    private FileChooser fc;
    
    private File f ;
    
    private Image image2 ;
    
    private String uuid;
    @FXML
    private TextField lieu;
    @FXML
    private Label prixL;
    @FXML
    private Label dt;
    @FXML
    private Label lieuL;
    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        categorie.getItems().add("Vente");
         categorie.getItems().add("Adoption");
          categorie.getItems().add("LostAndFound");
       
    }    

    @FXML
    private void ajouter(ActionEvent event) {
        
        java.util.Date date_util = new java.util.Date();
        java.sql.Date date_sql = new java.sql.Date(date_util.getTime());
        
        
         AnnonceServices aS = new AnnonceServices();
          if(categorie.getSelectionModel().getSelectedItem().equals("Adoption")){
          prix.setEditable(false);
          
            }
             if (categorie.getSelectionModel().getSelectedItem().equals("LostAndFound")){
            prix.setEditable(false);
            
            } 
      
        
        Annonce a = new Annonce(LoggedUser.getId(),categorie.getValue(),date_sql,
              
        animal.getText(),description.getText(),race.getText(),Float.valueOf(prix.getText()),uuid);
        a.setLieu(lieu.getText());
        
       
        aS.Ajouter(a);
         Alert al=new Alert(Alert.AlertType.INFORMATION);
            al.setTitle("INFORMATION");
            al.setHeaderText(null);
            al.setContentText("Annonce Ajoutée");
            al.showAndWait();
            
            
            Notifications.create().title("Succes").text("Annonce Ajoutée").position(Pos.BOTTOM_RIGHT).showConfirm();
            
            
            
            
           
        
    }

    @FXML
    private void Retour(ActionEvent event) throws IOException {
              Parent page_select_my = FXMLLoader.load(getClass().getResource("/GUIHamouda/Affichage.fxml"));        
        Scene scene = new Scene(page_select_my);
        Stage app=(Stage)((Node)event.getSource() ).getScene().getWindow();
        app.setScene(scene);
        app.show();
    }

    @FXML
    private void imageAction(ActionEvent event) throws IOException
    {
        fc = new FileChooser();
        f = fc.showOpenDialog(null);
        if ( f!=null)
        { uuid = f.getName();
        image2 = new Image (f.toURI().toString(),100,150,true,true);
        imageV.setImage(image2);
        Utils u = new Utils();
        String Emp="C:\\wamp64\\www\\Animaux\\web\\Picture\\"+uuid;
        u.CopyImage(Emp, f.toPath().toString());
        
        
        }
        
        
    }
    
}
