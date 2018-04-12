/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sprintjavagui.Service;

import Entities.Service;
import Services.ServiceServices;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Pagination;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeLineCap;
import javafx.scene.shape.StrokeLineJoin;
import javafx.scene.shape.StrokeType;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
import static sprintjavagui.Service.ServiceFXMLController.recherché;
import static sprintjavagui.User.LoginController.LoggedUser;
import sprintjavagui.User.ProfilUserrController;

/**
 * FXML Controller class
 *
 * @author nouha
 */
public class MesservicesController implements Initializable {

    @FXML
    private AnchorPane Main;
    @FXML
    private Circle userphoto;
    @FXML
    private Label username;
    @FXML
    private Label role;
    @FXML
    private JFXHamburger affmenu;
    @FXML
    private JFXDrawer menu;
    @FXML
    private JFXButton monprofil;
    @FXML
    private Label loggedid;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        try {
            // TODO
            username.setText(LoggedUser.getUsername());
            role.setText("(" + LoggedUser.getRole() + ")");
            final String imageURI = new File("C:/xampp/htdocs/Animauxcrud5/Animauxcrud/Animaux/Animaux/web/Pictures/" + LoggedUser.getImage()).toURI().toString();
            Image image = new Image(imageURI);
            userphoto.setFill(new ImagePattern(image));

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
                    menu.toFront();
                }
            }
            );

            ServiceServices rs = new ServiceServices();
            ObservableList<Service> ls = rs.afficheVet();
            int pages = ls.size() / itemsPerPage() + 1;
            Pagination pagination = new Pagination(pages, 0);
            pagination.setMaxPageIndicatorCount(3);
            pagination.setPrefHeight(451);
            pagination.setPrefWidth(662);
            pagination.setLayoutX(50);
            pagination.setLayoutY(150);
            pagination.setPageFactory((Integer pageIndex) -> createPage(pageIndex));
            Main.getChildren().add(pagination);
        } catch (IOException ex) {
            Logger.getLogger(ListemedicalController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public int itemsPerPage() {
        return 6;
    }

    public AnchorPane createPage(int pageIndex) {

        AnchorPane ap = new AnchorPane();
        ap.setPrefHeight(451);
        ap.setMaxHeight(451);
        ap.setMaxWidth(662);
        ap.setPrefWidth(662);
        ap.setLayoutX(70);
        ap.setLayoutY(30);
        ap.setStyle("-fx-border-color : #dadada; -fx-border-radius: 10; -fx-background-color: rgba(255, 255, 255, .7); -fx-background-radius: 10; -fx-background-position: center center;");

        TilePane element = new TilePane();

        element.setPadding(new javafx.geometry.Insets(30));
        element.setPrefColumns(3);
        element.setPrefRows(2);

        ServiceServices rs = new ServiceServices();
        ObservableList<Service> list = rs.affichemesservices();
        int page = pageIndex * itemsPerPage();
        for (int i = page; i < page + itemsPerPage(); i++) {
            if (i <= list.size() - 1) {

                //String[] auNomDe=list.get(i).getAunomde().split(" ", 0);
                //String auN="";
                    /*for(int j=0; j< auNomDe.length;j++){
                 String s=auNomDe[j].toUpperCase().substring(0,1)+""+auNomDe[j].substring(1,auNomDe[j].length());
                 auN=auN+s;
                 if(i!= auNomDe.length){
                 auN=auN;
                 }*/
                Label titre = new Label();
                Label adresse = new Label();
                Label user = new Label();
                Label dateR = new Label();
                titre.setText(list.get(i).getTitle());
                titre.setStyle("-fx-font-size : 16; ");
                adresse.setText(list.get(i).getAdresseS());
                adresse.setStyle("-fx-text-fill : #707070;");
                user.setText(list.get(i).getUserservice());
                user.setStyle("-fx-text-fill : #707070;");

                dateR.setText("Date : " + String.valueOf(list.get(i).getCreateDt()));
                dateR.setStyle("-fx-text-fill : #707070;");

                Rectangle etabPhoto = new Rectangle(80, 80);

                etabPhoto.setStroke(Color.WHITE);
                etabPhoto.setStrokeWidth(3);
                etabPhoto.setSmooth(true);
                etabPhoto.setStrokeLineCap(StrokeLineCap.ROUND);
                etabPhoto.setStrokeMiterLimit(10);
                etabPhoto.setArcHeight(5);
                etabPhoto.setArcWidth(5);
                etabPhoto.setStrokeLineJoin(StrokeLineJoin.MITER);
                etabPhoto.setStrokeType(StrokeType.OUTSIDE);

                File file = new File("C:/xampp/htdocs/Animauxcrud5/Animauxcrud/Animaux/Animaux/web/Pictures/" + list.get(i).getImage());
                try {

                    BufferedImage bufferedImage = ImageIO.read(file);
                    Image image = SwingFXUtils.toFXImage(bufferedImage, null);
                    etabPhoto.setFill(new ImagePattern(image));

                } catch (IOException ex) {
                    Logger.getLogger(ListemedicalController.class.getName()).log(Level.SEVERE, null, ex);
                }

                VBox infos;
                HBox allRes;
                Label id = new Label();
                JFXButton b = new JFXButton("Détails");
                b.setStyle("-fx-background-color: #F59B89;-fx-text-inner-color: white;");

                id.setText(String.valueOf(list.get(i).getId()));
                id.setVisible(false);
                b.setOnMouseClicked(e -> {
                    try {
                        ServiceServices SS = new ServiceServices();
                        Service s = SS.afficheall().filtered(a -> a.getId() == Integer.parseInt(id.getText())).get(0);
//                        FXMLLoader loader = new FXMLLoader(getClass().getResource("DetailServiceFXML.fxml"));
//                        Parent root = loader.load();
//                        DetailServiceFXMLController ds = loader.getController();
//                        ds.oldValues(s.getId());
//                        Main.getScene().setRoot(root);
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("DetailServiceFXML.fxml"));
                        AnchorPane an = new AnchorPane();
                        an = (AnchorPane) loader.load();
                        Stage stage = new Stage();
                        stage.setScene(new Scene(an));
                        DetailServiceFXMLController ds = loader.getController();
                        ds.oldValues(s.getId());
                        stage.show();

                    } catch (IOException ex) {
                        Logger.getLogger(MesservicesController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                });

                JFXButton m = new JFXButton("Modifier");
                m.setStyle("-fx-background-color: #F59B89;-fx-text-inner-color: white;");
                m.setOnMouseClicked(e -> {
                    try {
                        ServiceServices SS = new ServiceServices();
                        Service s = SS.afficheall().filtered(a -> a.getId() == Integer.parseInt(id.getText())).get(0);
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("ModifierServiceFXML.fxml"));
                        Parent root = loader.load();
                        ModifierServiceFXMLController ds = loader.getController();
                        ds.oldValues(s.getId());
                        Main.getScene().setRoot(root);
                    } catch (IOException ex) {
                        Logger.getLogger(MesservicesController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                });

                JFXButton supp = new JFXButton("Supprimer");
                supp.setStyle("-fx-background-color: #F59B89;-fx-text-inner-color: white;");
                supp.setOnMouseClicked(e -> {
                    try {
                        ServiceServices SS = new ServiceServices();
                        SS.supprimer(Integer.parseInt(id.getText()));
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("Messervices.fxml"));
                        Parent root = loader.load();

                        Main.getScene().setRoot(root);
                    } catch (IOException ex) {
                        Logger.getLogger(MesservicesController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                });

                infos = new VBox(2, titre, adresse, user, dateR, id, b, m, supp);
                allRes = new HBox(etabPhoto, infos);
                allRes.setPrefWidth(300);
                allRes.setPrefHeight(200);
                TilePane a = new TilePane();
                a.setMaxSize(100, 200);
                a.getChildren().addAll(allRes);
                a.setStyle(" -fx-padding:5; ");

//                 a.setVgap(10);
                a.setPrefHeight(60);
                a.setPrefWidth(400);
                element.getChildren().add(a);
                element.setHgap(55);
                element.setVgap(10);
                //element.setPrefWidth(480);
            }
        }
        ap.getChildren().addAll(element);

        return ap;

    }

    @FXML
    public void Monprofil(ActionEvent event) throws IOException, SQLException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("../User/ProfilUserr.fxml"));
        AnchorPane p = new AnchorPane();
        p = loader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(p));
        ProfilUserrController ds = loader.getController();

        ds.MyoldValues();

        stage.show();

    }

}
