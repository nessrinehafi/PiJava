/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sprintjavagui.User;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import Services.UserServices;
/**
 * FXML Controller class
 *
 * @author nouha
 */
public class ProfilUserController implements Initializable {
    @FXML
    private JFXButton home;
    @FXML
    private ImageView pic;
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
    private JFXTextField fusername;
    @FXML
    private JFXTextField fnom;
    @FXML
    private JFXTextField fprenom;
    @FXML
    private JFXTextField femail;
    @FXML
    private JFXTextField fnumtel;
    @FXML
    private JFXTextField fadresse;
    @FXML
    private Label role;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    /*public void oldValues(int idd){
        UserServices SS=new UserServices();    
        user u=SS.afficheall().filtered(e->e.getId()==idd).get(0);
        titre.setText(s.getTitle());
        description.setText(s.getDescription());
        //datec.setText(s.getCreateDt
        adresse.setText(s.getAdresseS());
        numtel.setText(String.valueOf(s.getNumtel()));
        idc.setText(String.valueOf(s.getCatservice()));
        user.setText(s.getUserservice());
        //id.setText(String.valueOf(s.getId()));
        
        
        
    }*/
    
}
