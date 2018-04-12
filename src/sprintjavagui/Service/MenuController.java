/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sprintjavagui.Service;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author nouha
 */
public class MenuController implements Initializable {
    public static String recherché;

    @FXML
    private JFXButton homepage;
    @FXML
    private JFXButton services;
    @FXML
    private JFXButton addservice;
    @FXML
    private JFXButton favs;
    @FXML
    private JFXButton signout;
    @FXML
    private JFXTextField recherche;
    @FXML
    private AnchorPane meni;
    @FXML
    private JFXButton messervices;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // TODO
        
        
//            for (Node node : meni.getChildren()) {
//                if (node.getClass().getName().equals("com.jfoenix.controls.JFXTextField")) {
//                        node.setOnKeyReleased(new EventHandler<KeyEvent>() {
//
//                            @Override
//                            public void handle(KeyEvent event) {
//                                JFXTextField TE=(JFXTextField)node;
//                                recherché=TE.getText();
//                                System.out.println(TE.getText());
//                                
//                                
//                            }
//                        });
//                    }
//            }

    }
    
  
    

//    @FXML
//    public void HomepageUserPage(ActionEvent event) throws IOException {
//
//        /*Parent list_page_parent = FXMLLoader.load(getClass().getResource("DetailServiceFXML.fxml"));
//         Scene list_page_scene = new Scene(list_page_parent);
//         Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//         app_stage.hide(); //optional
//         app_stage.setScene(list_page_scene);
//         app_stage.show();*/
//        FXMLLoader loader = new FXMLLoader(getClass().getResource("../User/HomepageUser.fxml"));
//        Parent root = loader.load();
//
//    }
//
//    @FXML
//    public void ListecatégoriesPage(ActionEvent event) throws IOException {
//
//        /*Parent list_page_parent = FXMLLoader.load(getClass().getResource("DetailServiceFXML.fxml"));
//         Scene list_page_scene = new Scene(list_page_parent);
//         Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//         app_stage.hide(); //optional
//         app_stage.setScene(list_page_scene);
//         app_stage.show();*/
//        FXMLLoader loader = new FXMLLoader(getClass().getResource("Listecategories.fxml"));
//        Parent root = loader.load();
//
//    }
//
//    @FXML
//    public void AjoutservicePage(ActionEvent event) throws IOException {
//
//        /*Parent list_page_parent = FXMLLoader.load(getClass().getResource("DetailServiceFXML.fxml"));
//         Scene list_page_scene = new Scene(list_page_parent);
//         Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//         app_stage.hide(); //optional
//         app_stage.setScene(list_page_scene);
//         app_stage.show();*/
//        FXMLLoader loader = new FXMLLoader(getClass().getResource("ServiceFXML.fxml"));
//        Parent root = loader.load();
//
//    }
//
//    @FXML
//    public void ServiceFavorisPage(ActionEvent event) throws IOException {
//
//        /*Parent list_page_parent = FXMLLoader.load(getClass().getResource("DetailServiceFXML.fxml"));
//         Scene list_page_scene = new Scene(list_page_parent);
//         Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//         app_stage.hide(); //optional
//         app_stage.setScene(list_page_scene);
//         app_stage.show();*/
//        FXMLLoader loader = new FXMLLoader(getClass().getResource(""));
//        Parent root = loader.load();
//
//    }
//
//    @FXML
//    public void LoginPage(ActionEvent event) throws IOException {
//
//        /*Parent list_page_parent = FXMLLoader.load(getClass().getResource("DetailServiceFXML.fxml"));
//         Scene list_page_scene = new Scene(list_page_parent);
//         Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//         app_stage.hide(); //optional
//         app_stage.setScene(list_page_scene);
//         app_stage.show();*/
//        FXMLLoader loader = new FXMLLoader(getClass().getResource("../User/Login.fxml"));
//        Parent root = loader.load();
//
//    }
//    /* @FXML
//     public void */
//
//    
}


