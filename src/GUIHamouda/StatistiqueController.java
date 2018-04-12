/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.Annonce;
import Services.AnnonceServices;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author hamouda
 */
public class StatistiqueController implements Initializable {

    @FXML
    private Button retour;
    @FXML
    private PieChart pie;

    /**
     * Initializes the controller class.
     */
    int i,j,k;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
     
        
        AnnonceServices as = new AnnonceServices();
        try {
            i= as.count("Adoption");
        } catch (SQLException ex) {
            Logger.getLogger(StatistiqueController.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            j=as.count("Vente");
        } catch (SQLException ex) {
            Logger.getLogger(StatistiqueController.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            k= as.count("LostAndFound");
        } catch (SQLException ex) {
            Logger.getLogger(StatistiqueController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
       
        ObservableList<PieChart.Data> pieE =
             FXCollections.observableArrayList(
             new PieChart.Data("Adoption", i),
             new PieChart.Data("Vente", j),
             new PieChart.Data("LostAndFound", k)
            
        );
        pie.setData(pieE);

    
}

    @FXML
    private void Retour(ActionEvent event) throws IOException {
         Parent page_select_my = FXMLLoader.load(getClass().getResource("/GUIHamouda/Affichage2.fxml"));        
        Scene scene = new Scene(page_select_my);
        Stage app=(Stage)((Node)event.getSource() ).getScene().getWindow();
        app.setScene(scene);
        app.show();
    }
}
