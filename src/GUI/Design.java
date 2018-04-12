/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author haythem
 */
public class Design extends Application {
    
    private Stage stage;
    private static Design instance;
    private Scene scene;
    
    
    public Design() throws IOException, InterruptedException {
        instance = this;
        scene = new Scene(FXMLLoader.load(getClass().getResource("AccueilInterface.fxml")));

    }
     public static Design getInstance() {
        return instance;
    }

    public Stage getStage() {
        return stage;
    }
    @Override
    public void start(Stage stage) throws Exception {
        this.stage = stage;

        stage.setScene(this.scene);
        stage.initStyle(StageStyle.DECORATED);// reduire et fermer decoredet* - 
        stage.centerOnScreen();
        stage.show();
    }
    
  public void changescene(Scene scene) {
        this.scene = scene;
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }
    /*public void start(Stage primaryStage) throws IOException {
        Parent root= FXMLLoader.load(getClass().getResource("AjoutInterface.fxml"));
   
        Scene scene = new Scene(root);
        
        primaryStage.setTitle("Ajouter rendez-vous");
        primaryStage.setScene(scene);
        primaryStage.show();
    }*/

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
