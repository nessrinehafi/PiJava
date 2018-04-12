/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidv;

import Entity.Rendez_vous;
import Services.CRUD;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import sprintjavagui.SprintJavaGUI;

/**
 *
 * @author haythem
 */
public class PIDV {
    
    
    public static Stage primaryStage;
    private AnchorPane mainLayout;
    
    public void start(Stage primaryStage) throws IOException {
        
        this.primaryStage = primaryStage;
        

        FXMLLoader loader = new FXMLLoader();
        
        loader.setLocation(SprintJavaGUI.class.getResource("/sprintjavagui/User/Login.fxml"));
        
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
