/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.Annonce;
import Entities.Signalement;
import Services.AnnonceServices;
import Services.SignalementServices;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
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
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author hamouda
 */
public class Statistique2Controller implements Initializable {

    @FXML
    private Pane paneview;
    @FXML
    private Button retour;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
           loadDataBarChart();
        // TODO
    }  private void loadDataBarChart(){
        
        
        
        paneview.getChildren().clear();
        CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel("Type Signalement");
        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Nombre Signalement ");
        BarChart statsChart = new BarChart(xAxis, yAxis);
        statsChart.setTitle("Statitisques des type de signalement");
        XYChart.Series series = new XYChart.Series();
        series.setName("stats prod");
        
     SignalementServices ss = new SignalementServices();
       Signalement s = new Signalement();
       ArrayList<Signalement> statsLCMD = ss.Statistique2();
        
        System.out.println(statsChart);
        
       for(Signalement aa : statsLCMD){
            series.getData().add(new XYChart.Data<>(aa.getTypestat(),aa.getNbsignalement()));
        }
           
       
        statsChart.getData().add(series);
        paneview.getChildren().add(statsChart);
        
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
