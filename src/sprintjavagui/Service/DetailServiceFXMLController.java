/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sprintjavagui.Service;

import Entities.Service;
import Services.ServiceFavorisServices;
import Services.ServiceServices;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import static sprintjavagui.Service.ModifierServiceFXMLController.saveToFile;
import static sprintjavagui.Service.ServiceFXMLController.recherché;
import static sprintjavagui.User.LoginController.LoggedUser;

/**
 * FXML Controller class
 *
 * @author nouha
 */
public class DetailServiceFXMLController implements Initializable {

    @FXML
    private ImageView pic;
    @FXML
    private JFXTextField titre;
    @FXML
    private JFXTextArea description;
    @FXML
    private JFXTextField datec;
    @FXML
    private JFXTextField adresse;
    @FXML
    private JFXTextField numtel;
    @FXML
    private JFXTextField user;
    private AnchorPane Main;

    @FXML
    private JFXHamburger affmenu;
    @FXML
    private Circle userphoto;
    @FXML
    private Label username;

    @FXML
    private Label role;
    @FXML
    private JFXDrawer menu;
    @FXML
    private JFXTextField cat;
    @FXML
    private TextField idS;
    @FXML
    private JFXButton addfav;
    @FXML
    private ImageView addfav2;
    @FXML
    private JFXButton suppfav;
    @FXML
    private ImageView suppfav2;
    @FXML
    private TextField catservice;
    @FXML
    private Label estfav;
    @FXML
    private JFXButton monprofil;
    @FXML
    private Label loggedid;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
//        if ("true".equals(estfav.getText())) {
//            addfav.setVisible(false);
//            addfav2.setVisible(false);
//            
//            suppfav.setVisible(true);
//            suppfav2.setVisible(true);
//        } else if("false".equals(estfav.getText())){
//            addfav.setDisable(false);
//            addfav2.setDisable(false);
//            suppfav.setDisable(true);
//            suppfav2.setDisable(true);
//        }
//        suppfav.setVisible(false);

        try {
            // TODO

            username.setText(LoggedUser.getUsername());
            role.setText("(" + LoggedUser.getRole() + ")");
            final String imageURI = new File("C:/xampp/htdocs/Animauxcrud5/Animauxcrud/Animaux/Animaux/web/Pictures/" + LoggedUser.getImage()).toURI().toString();
            Image image = new Image(imageURI);
            userphoto.setFill(new ImagePattern(image));

            //************Design********************
            AnchorPane anchrone = FXMLLoader.load(getClass().getResource("Menu.fxml"));
            menu.setSidePane(anchrone);

for (Node node : anchrone.getChildren()) {
                if (node.getAccessibleText() != null) {
                    node.addEventHandler(MouseEvent.MOUSE_CLICKED, (e) -> {
                        switch (node.getAccessibleText()) {
                            case "homepage":
                                try {
                                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/AccueilGroupe.fxml"));
                                    AnchorPane an = new AnchorPane();
                                    an = (AnchorPane) loader.load();
                                    Stage stage = new Stage();
                                    stage.setScene(new Scene(an));
                                    stage.show();
                                } catch (IOException ex) {
                                    Logger.getLogger(ListecategoriesController.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                break;
                            case "services":
                                try {

                                    FXMLLoader loader = new FXMLLoader(getClass().getResource("Listecategories.fxml"));
                                    AnchorPane an = new AnchorPane();
                                    an = (AnchorPane) loader.load();
                                    Stage stage = new Stage();
                                    stage.setScene(new Scene(an));
                                    stage.show();

                                } catch (IOException ex) {
                                    Logger.getLogger(ListecategoriesController.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                break;
                            case "add":
                                try {

                                    FXMLLoader loader = new FXMLLoader(getClass().getResource("ServiceFXML.fxml"));
                                    AnchorPane an = new AnchorPane();
                                    an = (AnchorPane) loader.load();
                                    Stage stage = new Stage();
                                    stage.setScene(new Scene(an));
                                    stage.show();

                                } catch (IOException ex) {
                                    Logger.getLogger(ListecategoriesController.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                break;
                            case "fav":
                                try {

                                    FXMLLoader loader = new FXMLLoader(getClass().getResource("Messervicesfav.fxml"));
                                    AnchorPane an = new AnchorPane();
                                    an = (AnchorPane) loader.load();
                                    Stage stage = new Stage();
                                    stage.setScene(new Scene(an));
                                    stage.show();

                                } catch (IOException ex) {
                                    Logger.getLogger(ListecategoriesController.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                break;
                                
                                case "messervices":
                                try {

                                    FXMLLoader loader = new FXMLLoader(getClass().getResource("Messervices.fxml"));
                                    AnchorPane an = new AnchorPane();
                                    an = (AnchorPane) loader.load();
                                    Stage stage = new Stage();
                                    stage.setScene(new Scene(an));
                                    stage.show();

                                } catch (IOException ex) {
                                    Logger.getLogger(ListecategoriesController.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                break;
                                
                                
                                
                            case "deco":
                                node.setOnMouseClicked(new EventHandler<MouseEvent>() {

                                    @Override
                                    public void handle(MouseEvent event) {

                                        try {
                                            Parent list_page_parent = FXMLLoader.load(getClass().getResource("../User/Login.fxml"));
                                            Scene list_page_scene = new Scene(list_page_parent);
                                            Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                                            app_stage.hide(); //optional
                                            app_stage.setScene(list_page_scene);
                                            app_stage.show();
                                        } catch (IOException ex) {
                                            Logger.getLogger(ServiceFXMLController.class.getName()).log(Level.SEVERE, null, ex);
                                        }
                                    }
                                });
                                break;

                        }

                    });

                    Stage stage = new Stage();

                    //***************** menu Search************
                    if (node.getClass().getName().equals("com.jfoenix.controls.JFXTextField")) {
                        node.setOnKeyReleased(new EventHandler<KeyEvent>() {

                            @Override
                            public void handle(KeyEvent event) {

                                try {
                                    JFXTextField TE = (JFXTextField) node;
                                    recherché = TE.getText();
                                    FXMLLoader loader = new FXMLLoader(getClass().getResource("AffichageRecherche.fxml"));
                                    AnchorPane p = new AnchorPane();
                                    p = loader.load();

                                    stage.setScene(new Scene(p));

                                    System.out.println(TE.getText());

                                    stage.show();
                                } catch (IOException ex) {
                                    Logger.getLogger(ServiceFXMLController.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                        });

                    }
                }
            }


            HamburgerBackArrowBasicTransition burgerTask2 = new HamburgerBackArrowBasicTransition(affmenu);
            burgerTask2.setRate(-1);

            affmenu.addEventHandler(MouseEvent.MOUSE_PRESSED, (e) -> {
                burgerTask2.setRate(burgerTask2.getRate() * -1);
                burgerTask2.play();

                if (menu.isShown()) {
                    menu.close();
                } else {
                    menu.open();
                }
            }
            );
        } catch (IOException ex) {
            Logger.getLogger(DetailServiceFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void oldValues(int idd) {
        ServiceServices SS = new ServiceServices();
        Service s = SS.afficheall().filtered(e -> e.getId() == idd).get(0);
        titre.setText(s.getTitle());
        description.setText(s.getDescription());
        datec.setText(String.valueOf(s.getCreateDt()));
        adresse.setText(s.getAdresseS());
        numtel.setText(String.valueOf(s.getNumtel()));
        cat.setText(s.getCategorie());
        user.setText(s.getUserservice());
        catservice.setText(String.valueOf(s.getCatservice()));
        if(s.getFavori()){
            addfav.setVisible(false);
            addfav2.setVisible(false);
            
            suppfav.setVisible(true);
            suppfav2.setVisible(true);
        }
        else {
           addfav.setVisible(true);
         addfav2.setVisible(true);
         suppfav.setVisible(false);
         suppfav2.setVisible(false);
        }
        estfav.setText(String.valueOf(s.getFavori()));
        final String imageURI = new File("C:/xampp/htdocs/Animauxcrud5/Animauxcrud/Animaux/Animaux/web/Pictures/" + s.getImage()).toURI().toString();
        pic.setImage(new Image(imageURI));
        idS.setText(String.valueOf(s.getId()));

    }

    /*@FXML
     void ActionSupp(ActionEvent event) throws IOException {

     ServiceServices SS = new ServiceServices();

     SS.supprimer(Integer.parseInt(idS.getText()));
     Parent list_page_parent = FXMLLoader.load(getClass().getResource("Messervices.fxml"));
     Scene list_page_scene = new Scene(list_page_parent);
     Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
     app_stage.hide(); //optional
     app_stage.setScene(list_page_scene);
     app_stage.show();
                                   

     }
     */
    @FXML
    public void ajouterfav(ActionEvent event) throws IOException, SQLException {

        ServiceFavorisServices SS = new ServiceFavorisServices();
        Image image = pic.getImage();
        String nameImage = saveToFile(image);
        SS.ajouter(Integer.parseInt(idS.getText()), titre.getText(), description.getText(), adresse.getText(), Integer.parseInt(numtel.getText()), LoggedUser.getUsername(), nameImage, cat.getText(), datec.getText(), Integer.parseInt(catservice.getText()));
        ServiceServices se = new ServiceServices();
        se.modifierfav(true, Integer.parseInt(idS.getText()));
       
        Parent list_page_parent = FXMLLoader.load(getClass().getResource("Messervices.fxml"));
        Scene list_page_scene = new Scene(list_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.hide(); //optional
        app_stage.setScene(list_page_scene);
        app_stage.show();

        /* if (Boolean.parseBoolean(estfav.getText()) == true) {
         addfav.setVisible(false);
         addfav2.setVisible(false);
         suppfav.setVisible(true);
         suppfav2.setVisible(true);
         } else {
         addfav.setVisible(true);
         addfav2.setVisible(true);
         suppfav.setVisible(false);
         suppfav2.setVisible(false);
         }*/
    }

    @FXML
    public void suppfav(ActionEvent event) throws IOException, SQLException {

        ServiceFavorisServices SS = new ServiceFavorisServices();

        SS.supprimer(Integer.parseInt(idS.getText()));
        ServiceServices se = new ServiceServices();

        se.modifierfav(false, Integer.parseInt(idS.getText()));
        

        Parent list_page_parent = FXMLLoader.load(getClass().getResource("Messervices.fxml"));
        Scene list_page_scene = new Scene(list_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.hide(); //optional
        app_stage.setScene(list_page_scene);
        app_stage.show();


        /*try {
         if (SS.EstFav(Integer.parseInt(idS.getText()))) {
         addfav.setVisible(true);
         addfav2.setVisible(true);
         suppfav.setVisible(false);
         suppfav2.setVisible(false);
         } else {
         addfav.setVisible(false);
         addfav2.setVisible(false);
         suppfav.setVisible(true);
         suppfav2.setVisible(true);
         }
            
         } catch (SQLException ex) {
         Logger.getLogger(DetailServiceFXMLController.class.getName()).log(Level.SEVERE, null, ex);
         }*/
    }

    /*
     @FXML
     void Modifier(ActionEvent event) throws IOException, SQLException {

     ServiceServices SS = new ServiceServices();
        
     SS.modifier(SS.findbyId(Integer.parseInt(idS.getText())),titre.getText(),description.getText(),datec.getText(),adresse.getText(),Integer.parseInt(numtel.getText()),,Integer.parseInt(idS.getText()));
     Parent list_page_parent = FXMLLoader.load(getClass().getResource("Messervices.fxml"));
     Scene list_page_scene = new Scene(list_page_parent);
     Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
     app_stage.hide(); //optional
     app_stage.setScene(list_page_scene);
     app_stage.show();
                                   

     }*/
}
