/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Entities.Evenement;
import Entities.Reservation;
import Entities.User;
import GUI.ListViewEventCell;
import Services.EvenementService;
import Services.ReservationService;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import org.controlsfx.control.textfield.TextFields;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;


/**
 * FXML Controller class
 *
 * @author Asus
 */
public class EvenementUserController {

    @FXML
    private TextField txtsearch;
    @FXML
    private JFXListView<Evenement> listView;
    @FXML
    private HBox details;
    @FXML
    private Label lbllontitude;
    @FXML
    private Label lblnom;
    @FXML
    private Label lbldateDeb;
    @FXML
    private Label lblDateFin;
    @FXML
    private Label lblnnbplace;
    @FXML
    private Label lbltype;
    @FXML
    private Label lbllatitude;
    @FXML
    private Label lbldesc;
    @FXML
    private JFXButton btnreserver;
    @FXML
    private TextField txtsearch1;

    @FXML
    private JFXListView<Evenement> listView1;

    @FXML
    private HBox details1;

    @FXML
    private Label lbllontitude1;

    @FXML
    private Label lblnom1;

    @FXML
    private Label lbldateDeb1;

    @FXML
    private Label lblDateFin1;

    @FXML
    private Label lblnnbplace1;

    @FXML
    private Label lbltype1;

    @FXML
    private Label lbllatitude1;

    @FXML
    private Label lbldesc1;

    ObservableList<Evenement> data;
    ObservableList<Evenement> datar;
    EvenementService es = new EvenementService();
    ReservationService rs = new ReservationService();
    Evenement e = new Evenement();
    User u = new User();
    @FXML
    private Button add;

    /**
     * ConseilService cs=new ConseilService();
        List<Conseil> lst=new ArrayList<>();
                lst=cs.affiche();
for(Conseil c : lst){
    logo=new Image("/images/cs.jpg");
          TrayNotification tn = new TrayNotification(c.getTitre(),c.getContenu(), NotificationType.SUCCESS);
     */
    @FXML
    public void initialize() {
        EvenementService cs=new EvenementService();
        
    List<Evenement> lst=new ArrayList<>();
//     lst=cs.afficherToutEvenements();
//     for(Evenement c : lst){
//     TrayNotification tn = new TrayNotification("Bonjour",c.getNom(), NotificationType.SUCCESS);
//    //c.getMonImage();
//           tn.setRectangleFill(Color.web("#E12336"));
//         tn.showAndWait();
 //}
        u.setId(2);
        TextFields.bindAutoCompletion(txtsearch, es.EvenementsByName());
        details.setVisible(false);
        List<Evenement> ls = es.afficherToutEvenements();
        data = FXCollections.observableArrayList();

        ls.stream().forEach((j) -> {
            data.add(j);
        });

        listView.setItems(data);
        listView.setCellFactory((ListView<Evenement> param) -> new ListViewEventCell());
        showEventDetails(null);
        listView.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showEventDetails(newValue));

    }

    @FXML
    public void MesReservation() {
        details1.setVisible(false);
        datar = FXCollections.observableArrayList();
        List<Evenement> ls = new ArrayList<>();
        ls = es.afficherMesEvenement();
        ls.stream().forEach((j) -> {
            datar.add(j);
        });
        List<String> l = new ArrayList<>();
        ls.stream().forEach((j) -> {
            l.add(j.getNom());
        });
        TextFields.bindAutoCompletion(txtsearch1, l);
        listView1.setItems(datar);
        listView1.setCellFactory((ListView<Evenement> param) -> new ListViewEventCell());
        showEventDetails1(null);
        listView1.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showEventDetails1(newValue));

    }

    public void showEventDetails(Evenement p) {
        if (p != null) {
            details.setVisible(true);
            Reservation r = new Reservation();
            r.setEvent(p);
            r.setUser(u);
            if (rs.VerfierReservation(r)) {
                btnreserver.setText("Annuler Reservation");
            } else {
                btnreserver.setText("Reserver");
            }
            if (p.getNbrpalacedispo() == 0) {
                btnreserver.setDisable(false);
            } else {
                btnreserver.setDisable(true);
            }
            if (p.getHeureDebut().isAfter(LocalDateTime.now())) {
                System.out.println(p.getHeureDebut().isAfter(LocalDateTime.now()));
                btnreserver.setDisable(false);
            } else {
                btnreserver.setDisable(true);
            }
            lblnom.setText(p.getNom());
            lbldateDeb.setText("" + p.getHeureDebut());
            lblDateFin.setText("" + p.getHeureFin());
            lbllatitude.setText("" + p.getLatitute());
            lbltype.setText(p.getType());
            lbllontitude.setText("" + p.getLongitude());
            lblnnbplace.setText("" + p.getNbrpalacedispo());
            lbldesc.setText(p.getDescription());
        } else {
            lblnom.setText("");
            lbldateDeb.setText("");
            lblDateFin.setText("");
            lbllatitude.setText("");
            lbltype.setText("");
            lbllontitude.setText("");
            lblnnbplace.setText("");
            lbldesc.setText("");
        }
    }

    @FXML
    public void HandelSearch() {
        details.setVisible(false);

        List<Evenement> ls = es.SearchEvenementsByName(txtsearch.getText());
        data = FXCollections.observableArrayList();
        ls.stream().forEach((j) -> {
            data.add(j);
        });
        System.out.println(data.size());
        listView.setItems(data);
        listView.setCellFactory((ListView<Evenement> param) -> new ListViewEventCell());
        showEventDetails(null);
        listView.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showEventDetails(newValue));

    }

    @FXML
    public void handleReserverEvent() {
        Reservation r = new Reservation();
        Evenement selectedEvent = listView.getSelectionModel().getSelectedItem();
        r.setEvent(selectedEvent);
        r.setUser(u);
        if (rs.VerfierReservation(r)) {
            rs.annulerReservation(r);
        } else {
            rs.reserver(r);
           
       
        }
        initialize();
    }

    private void showEventDetails1(Evenement p) {
        if (p != null) {
            details1.setVisible(true);
            lblnom1.setText(p.getNom());
            lbldateDeb1.setText("" + p.getHeureDebut());
            lblDateFin1.setText("" + p.getHeureFin());
            lbllatitude1.setText("" + p.getLatitute());
            lbltype1.setText(p.getType());
            lbllontitude1.setText("" + p.getLongitude());
            lblnnbplace1.setText("" + p.getNbrpalacedispo());
            lbldesc1.setText(p.getDescription());
        } else {
            lblnom1.setText("");
            lbldateDeb1.setText("");
            lblDateFin1.setText("");
            lbllatitude1.setText("");
            lbltype1.setText("");
            lbllontitude1.setText("");
            lblnnbplace1.setText("");
            lbldesc1.setText("");
        }
    }

    @FXML
    private void toadd(ActionEvent event) throws IOException {
          FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUIDali/Evenement.fxml"));
         Parent root = loader.load();
         Stage stage = new Stage();
         Scene scene = new Scene(root);
         stage.setScene(scene);
         stage.show();
        
    }

}
