package sprintjavagui.Reclamation;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import jdk.nashorn.internal.ir.Statement;

/**
 * FXML Controller class
 *
 * @author mehdi
 */
public class ReclamationController implements Initializable {

    @FXML
    private Button creer;
    @FXML
    private Button liste;

    @FXML
    private void creerButtonAction(ActionEvent event) throws IOException {

        Parent home_page_parent = FXMLLoader.load(getClass().getResource("AddReclamation.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(home_page_scene);
        app_stage.show();
    }

    @FXML
    private void listeButtonAction(ActionEvent event) throws IOException {

        Parent home_page_parent = FXMLLoader.load(getClass().getResource("AfficherReclamations.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(home_page_scene);
        app_stage.show();

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
