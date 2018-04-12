/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Controllers.EditEventController;
import Entities.Evenement;
import GUI.ListViewEventCell;
import Services.EvenementService;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Parameter;
import com.restfb.types.FacebookType;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.Set;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import jfxtras.scene.control.LocalDateTimeTextField;
import org.controlsfx.control.textfield.TextFields;
import utils.PostFile;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class EvenementController {
    

    @FXML
    private JFXTextField nom;
    @FXML
    private JFXTextArea description;
    @FXML
    private JFXTextField type;
    @FXML
    private JFXTextField latitude;
    @FXML
    private JFXTextField longtitude;
    @FXML
    private JFXTextField nbplacedispo;
    @FXML
    private ImageView img;
    @FXML
    private LocalDateTimeTextField datedeb;

    @FXML
    private LocalDateTimeTextField datefin;

    @FXML
    private JFXListView<Evenement> listView;

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
    private Label lbldesc;
    @FXML
    private Label lbllatitude;
    @FXML
    private HBox details;
    @FXML
    private TextField txtsearch;
    
    private Label nbtotal;

    private Label eventDejapasse;

    private Label prochaineEvent;

    private Label todayEvents;

    private Label Weekevent;

    private Label MonthEvent;
    private BarChart<String, Integer> statchart;
    private CategoryAxis xAxis;

    ObservableList<Evenement> data;
    EvenementService es = new EvenementService();
    Evenement e = new Evenement();
    @FXML
    private JFXButton btndelete;
    @FXML
    private JFXButton btnedit;
    @FXML
    private AnchorPane imgeva;
    @FXML
    private JFXButton MAP;

    /**
     * Initializes the controller class.
     */
    @FXML
    public void initialize() {
        TextFields.bindAutoCompletion(txtsearch, es.EvenementsByName());
        details.setVisible(false);
        List<Evenement> ls = es.afficherToutEvenements();
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

    public void showEventDetails(Evenement p) {
        if (p != null) {
            details.setVisible(true);
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

    /**
     * Called when the user clicks on the delete button.
     */
    @FXML
    private void handleDeleteEvent() {
        int selectedIndex = listView.getSelectionModel().getSelectedIndex();
        Evenement selectedevent = listView.getSelectionModel().getSelectedItem();
        if (selectedIndex >= 0) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Alerte suppression");
            alert.setHeaderText("Suppression d'un évènement");
            alert.setContentText("Êtes-vous sûr(e) de vouloir supprimer?");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                listView.getItems().remove(selectedIndex);
                es.supprimerEvenement(selectedevent);
            }
        } else {
            // Nothing selected.
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("No Selection");
            alert.setHeaderText("No Event Selected");
            alert.setContentText("Please select a Event in the List.");
            alert.showAndWait();
        }
    }

    @FXML
    private void handleAjouter() throws Exception {
        if (isInputValid()) {
            e.setNom(nom.getText());
            e.setDescription(description.getText());
            e.setHeureDebut(datedeb.getLocalDateTime());
            e.setHeureFin(datefin.getLocalDateTime());
            e.setType(type.getText());
            e.setNbrpalacedispo(Integer.parseInt(nbplacedispo.getText()));
            e.setLatitute(Integer.parseInt(latitude.getText()));
            e.setLongitude(Integer.parseInt(longtitude.getText()));
            if (f != null) {
                e.setMonImage(PostFile.upload(f.getAbsolutePath()));
            }
            es.ajouterEvenement(e);

            initialize();
            videChamps();
        }
    }

    /**
     * Validates the user input in the text fields.
     *
     * @return true if the input is valid
     */
    private boolean isInputValid() {
        String errorMessage = "";

        if (nom.getText() == null || nom.getText().length() == 0) {
            errorMessage += "No valid  name!\n";
        }
        if (description.getText() == null || description.getText().length() == 0) {
            errorMessage += "No valid description !\n";
        }
        if (datedeb.getText() == null || datedeb.getText().length() == 0) {
            errorMessage += "No valid date debut !\n";
        }
        if (datefin.getText() == null || datefin.getText().length() == 0) {
            errorMessage += "No valid date fin !\n";
        } else if (datefin.getLocalDateTime().isBefore(datedeb.getLocalDateTime())) {
            errorMessage += "DAte fin before date debut ?? !\n";
        }

        if (nbplacedispo.getText() == null || nbplacedispo.getText().length() == 0) {
            errorMessage += "No valid nombre !\n";
        } else {
            // try to parse the postal code into an int.
            try {
                int x = Integer.parseInt(nbplacedispo.getText());
                if (x == 0) {
                    errorMessage += "Aucun place ???\n";
                }

            } catch (NumberFormatException e) {
                errorMessage += "No valid  nombre de place (Doit etre un nombre)!\n";
            }
        }
        if (type.getText() == null || type.getText().length() == 0) {
            errorMessage += "No valid  type!\n";
        }
        if (latitude.getText() == null || latitude.getText().length() == 0) {
            errorMessage += "No valid nombre !\n";
        } else {
            // try to parse the postal code into an int.
            try {
                double x = Double.parseDouble(latitude.getText());
                if (x == 0) {
                    errorMessage += "Aucun place ???\n";
                }

            } catch (NumberFormatException e) {
                errorMessage += "No valid  latitude(Doit etre un nombre)!\n";
            }
        }
        if (longtitude.getText() == null || longtitude.getText().length() == 0) {
            errorMessage += "No valid nombre !\n";
        } else {
            // try to parse the postal code into an int.
            try {
                double x = Double.parseDouble(longtitude.getText());
                if (x == 0) {
                    errorMessage += "Aucun place ???\n";
                }

            } catch (NumberFormatException e) {
                errorMessage += "No valid  latitude(Doit etre un nombre)!\n";
            }
        }

        if (errorMessage.length() == 0) {
            return true;
        } else {
            // Show the error message.
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Invalid Fields");
            alert.setHeaderText("Please correct invalid fields");
            alert.setContentText(errorMessage);
            alert.showAndWait();
            return false;
        }

    }
    File f;

    @FXML
    public void uploadPhoto() throws MalformedURLException, Exception {
        FileChooser.ExtensionFilter imageFilter
                = new FileChooser.ExtensionFilter("Image Files", "*.jpg", "*.png");
        FileChooser fc = new FileChooser();
        fc.getExtensionFilters().add(imageFilter);
        File selectedFile = fc.showOpenDialog(null);
        if (selectedFile != null) {
            String imageFile = selectedFile.toURI().toURL().toString();
            this.f = selectedFile;
            System.out.println(imageFile);
            System.out.println(selectedFile.getAbsolutePath());
            Image image = new Image(imageFile);
            img.setImage(image);

        }
    }

    private void videChamps() {
        nom.setText("");
        description.setText("");
        latitude.setText("");
        longtitude.setText("");
        nbplacedispo.setText("");
        datedeb.setText("");
        datefin.setText("");
        type.setText("");
    }
    private ObservableList<String> typenames = FXCollections.observableArrayList();
    public void stat(){
        int nbtotal1 = es.getNbtotal();
        int deja = es.getEventpasse();
        int prochain = es.getEventprohain();
        int today = es.getTodayEvent();
        int week = es.getWeekevent();
        int mounth = es.getmounthEvent();
        todayEvents.setText(today+" Evenement ajourd'hui");
        Weekevent.setText(week + " Evenemenet cette semaine");
        MonthEvent.setText(mounth +" Evenement ce mois");
        nbtotal.setText(nbtotal1 +" Evenements ");
        eventDejapasse.setText(deja +" Evenements deja passé");
        prochaineEvent.setText(prochain + " Evenement à venir");
        typenames.addAll(es.getStat().keySet());
        xAxis.setCategories(typenames);
        XYChart.Series<String, Integer> series = new XYChart.Series<>();
        typenames.stream().forEach((j)->{
            series.getData().add(new XYChart.Data<>(j,es.getStat().get(j)));
        });
        statchart.getData().add(series);
        
    }

    @FXML
    public void partagerSurFb() {
        Evenement selectedItem = listView.getSelectionModel().getSelectedItem();
        String accessToken = "EAACEdEose0cBACo2xwkkSWmaZAnlwZBFuZApogLJjJObYB6Il5lcpqglN9RPuL1Py4ZBVzRtwaSo7Ye0f97WhwvMnDXGclmZAJyNAckE1MfM35KjQllLK4BZBglzk6OojqMUnmVB6OZBZAC2vTkXvUOjyZAFdn1MT2NxRL6xMcvNlZCcs8Op5zXQZBg62YyBjpgemYQ71UqmgFx7QZDZD";
        Scanner s = new Scanner(System.in);
        FacebookClient fbClient = new DefaultFacebookClient(accessToken);
        FacebookType response = fbClient.publish("me/feed", FacebookType.class,
                Parameter.with("message", "Evenement" + selectedItem.getNom() + " at" + selectedItem.getDescription()),
                Parameter.with("link", "http://127.168.0.1/"));
        System.out.println("fb.com/" + response.getId());
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("success");
        alert.setContentText("Votre Evenement à été publié");
        alert.showAndWait();

    }

    @FXML
    public void HandelEdit() {
        Evenement selectedEvenement = listView.getSelectionModel().getSelectedItem();
        if (selectedEvenement != null) {
            try {
                FXMLLoader loader2 = new FXMLLoader();
                loader2.setLocation(getClass().getResource("/GUIDali/EditEvent.fxml"));
                // Create the dialog Stage.
                Stage dialogStage = new Stage();
                AnchorPane page = (AnchorPane) loader2.load();
                dialogStage.setTitle("Edit Evenement");
                dialogStage.initModality(Modality.WINDOW_MODAL);
                Scene scene = new Scene(page);
                dialogStage.setScene(scene);
                // Set the person into the controller.
                EditEventController controller = loader2.getController();
                controller.setEvent(selectedEvenement);
                controller.setDialogStage(dialogStage);
                // Show the dialog and wait until the user closes it
                dialogStage.showAndWait();
            } catch (IOException e) {
                System.err.println(e.toString());
                e.printStackTrace();
            }
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
    private void VoirSurMap(ActionEvent event) throws IOException {
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUIDali/Mapevenement.fxml"));
        Parent root = loader.load();
        root.setId("pane");
        
        Scene scene1 = new Scene(root);
        stage.setScene(scene1);
//        scene1.getStylesheets().addAll(this.getClass().getResource("/Content/style.css").toExternalForm());
        stage.show();
    }

}
