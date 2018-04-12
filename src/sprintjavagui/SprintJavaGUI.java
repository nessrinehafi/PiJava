/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sprintjavagui;

import java.io.IOException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author nouha
 */
public class SprintJavaGUI extends Application {
    
    public static Stage primaryStage;
    private AnchorPane mainLayout;
    
    @Override
    public void start(Stage primaryStage) throws IOException {
        
        this.primaryStage = primaryStage;
        

        FXMLLoader loader = new FXMLLoader();
        
        loader.setLocation(SprintJavaGUI.class.getResource("/sprintjavagui/Reclamation/Reclamation.fxml"));
        
        mainLayout = loader.load();
        
        Scene scene = new Scene(mainLayout);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
