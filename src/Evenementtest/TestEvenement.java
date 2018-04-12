/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Evenementtest;

import java.io.IOException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author Asus
 */
public class TestEvenement extends Application {
    
    @Override
    public void start(Stage Stage) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        //loader.setLocation(getClass().getResource("../GUI/Evenement.fxml")); // Admin
       loader.setLocation(getClass().getResource("../GUI/EvenementUser.fxml"));//user
        //loader.setLocation(getClass().getResource("../GUI/Login.fxml"));//user
        AnchorPane serviceindex = (AnchorPane) loader.load();
        Scene scene = new Scene(serviceindex);
        Stage.setScene(scene);
        Stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}