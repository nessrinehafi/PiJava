/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import Entities.Evenement;
import Services.EvenementService;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.concurrent.Worker.State;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.web.WebView;
import javafx.scene.web.WebEngine;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class MapevenementController implements Initializable {
    
    @FXML
    private WebView webView; 
    EvenementService SBS = new EvenementService();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        final WebEngine webEngine = webView.getEngine();
        
        webEngine.load(getClass().getResource("/GUIDali/googlemap.html").toString());
        
        List<Evenement> list = SBS.afficherToutEvenements();//chargina liste bech n3abeha fi able view
        
        webEngine.getLoadWorker().stateProperty().addListener(
            new ChangeListener<State>() {
                @Override
                public void changed(ObservableValue<? extends State> ov, State oldState,     State newState) {
                    if (newState == State.SUCCEEDED) {
                        for (int i= 0 ; i<list.size(); i++){
                               /* webEngine.executeScript("addMarker("+list.get(i).getLatitute()+","
                                        +list.get(i).getLongitude()+");");
                                */
                            //x, y,type ,nom ,heuredebut, heurefin
                           // addMarker(10,10,"zqxd","azertyuiop","123516","xzqdqzxdqz","qcdqz");
                               webEngine.executeScript("addMarker("
                                        +list.get(i).getLatitute()+","
                                        +list.get(i).getLongitude()+",'"
                                        +list.get(i).getType().toString()+"','"
                                        +list.get(i).getNom()+"','"
                                        +list.get(i).getHeureDebut().toString()+"','"
                                        +list.get(i).getHeureFin().toString()+"');");
                        }
                        }       
                    }
                
            });  
    }
    }    
    

