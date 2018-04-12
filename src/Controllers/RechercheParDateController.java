/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class RechercheParDateController implements Initializable {

    @FXML
    private TextField txtsearch;
    @FXML
    private JFXListView<?> listView;
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
    private JFXListView<?> listView1;
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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void HandelSearch(KeyEvent event) {
    }

    @FXML
    private void handleReserverEvent(ActionEvent event) {
    }

    @FXML
    private void initialize(Event event) {
    }

    @FXML
    private void MesReservation(Event event) {
    }
    
}
