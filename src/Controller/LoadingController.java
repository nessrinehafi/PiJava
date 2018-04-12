/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import com.jfoenix.controls.JFXProgressBar;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author nessrine
 */
public class LoadingController implements Initializable {

    @FXML
    private JFXProgressBar pbar;
    @FXML
    private ProgressIndicator pindicator;
    @FXML
    private AnchorPane anchorpanel;
    private Task taskWorker(int seconds) 
    {
        return new Task() {
            @Override
            protected Object call() throws Exception {
                for(int i=0 ;i<seconds; i++)
                {
                    updateProgress(i,seconds);
                    Thread.sleep(1000);
                }
                return true;
            };
        } ;
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Task task=taskWorker(3);
         pbar.progressProperty().unbind();
        pindicator.progressProperty().unbind();

        pbar.progressProperty().bind(task.progressProperty());
        pindicator.progressProperty().bind(task.progressProperty());
        task.setOnSucceeded(e->{
        Stage stage =(Stage) anchorpanel.getScene().getWindow();
        stage.close();
            try {
                Parent root=FXMLLoader.load(getClass().getResource("/View/Register.fxml"));
                Stage stage2= new Stage();
                Scene scene =new Scene(root);
                stage2.setScene(scene);
                stage2.show();
           
            } catch (IOException ex) {
                Logger.getLogger(LoadingController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
         Thread thread = new Thread(task) ;
         thread.start();
        
    }    
    
}
