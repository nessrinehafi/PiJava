/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Entities.Evenement;
import Services.EvenementService;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.io.File;
import java.net.MalformedURLException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import jfxtras.scene.control.LocalDateTimePicker;
import jfxtras.scene.control.LocalDateTimeTextField;
import utils.PostFile;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class EditEventController {

    @FXML
    private JFXTextField nom;
    @FXML
    private JFXTextField desc;
    @FXML
    private JFXTextField type;
    @FXML
    private JFXTextField nbplace;
    @FXML
    private JFXTextField latitute;
    @FXML
    private JFXTextField longtitude;
    @FXML
    private LocalDateTimeTextField datedeb;
    @FXML
    private LocalDateTimeTextField datefin;
    @FXML
    private ImageView pic;

    File f;

    public void initialize() {
    }

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
            pic.setImage(image);
        }
    }

    private boolean isInputValid() {
        String errorMessage = "";

        if (nom.getText() == null || nom.getText().length() == 0) {
            errorMessage += "No valid  name!\n";
        }
        if (desc.getText() == null || desc.getText().length() == 0) {
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

        if (nbplace.getText() == null || nbplace.getText().length() == 0) {
            errorMessage += "No valid nombre !\n";
        } else {
            // try to parse the postal code into an int.
            try {
                int x = Integer.parseInt(nbplace.getText());
                if (x == 0) {
                    errorMessage += "Aucun place ???\n";
                }

            } catch (NumberFormatException e) {
                errorMessage += "No valid  nombre de place (must be a int)!\n";
            }
        }
        if (type.getText() == null || type.getText().length() == 0) {
            errorMessage += "No valid  type!\n";
        }
        if (latitute.getText() == null || latitute.getText().length() == 0) {
            errorMessage += "No valid nombre !\n";
        } else {
            // try to parse the postal code into an int.
            try {
                double x = Double.parseDouble(latitute.getText());
                if (x == 0) {
                    errorMessage += "Aucun place ???\n";
                }

            } catch (NumberFormatException e) {
                errorMessage += "No valid  latitude(must be a int)!\n";
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
                errorMessage += "No valid  latitude(must be a int)!\n";
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
    Evenement event;

    @FXML
    private void handleOk() throws Exception {
        EvenementService es = new EvenementService();
        if (isInputValid()) {
            event.setNom(nom.getText());
            event.setDescription(desc.getText());
            event.setHeureDebut(datedeb.getLocalDateTime());
            event.setHeureFin(datefin.getLocalDateTime());
            event.setType(type.getText());
            event.setNbrpalacedispo(Integer.parseInt(nbplace.getText()));
            event.setLatitute(Double.parseDouble(latitute.getText()));
            event.setLongitude(Double.parseDouble(longtitude.getText()));
            if (f != null) {
                event.setMonImage(PostFile.upload(f.getAbsolutePath()));
            }
            es.modifierEvenement(event);
        }

    }

    public void setEvent(Evenement e) {
        this.event = e;
        if (e != null) {
            nom.setText(e.getNom());
            desc.setText(e.getDescription());
            latitute.setText("" + e.getLatitute());
            longtitude.setText("" + e.getLongitude());
            nbplace.setText("" + e.getNbrpalacedispo());
            type.setText(e.getType());
            datedeb.setLocalDateTime(e.getHeureDebut());
            datefin.setLocalDateTime(e.getHeureFin());
            Image image = new Image("http://localhost/pidevfinal/web/images/" + e.getMonImage());
            pic.setImage(image);
        }
    }

    @FXML
    private void handleCancel() {
        stage.close();
    }
    Stage stage;

    public void setDialogStage(Stage dialogStage) {
        this.stage = dialogStage;
    }

}
