/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import static Controller.CommentaireController.p;
import static sprintjavagui.User.LoginController.LoggedUser;
import Model.Conversation;
import Model.User;
import Service.ConversationService;
import Service.UserService;
import java.net.URL;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author badis
 */
public class ConversationViewController implements Initializable {

    @FXML
    private ScrollPane convs;
    @FXML
    private VBox cons;
        List<Button> conversation = new ArrayList<>();
    
    int i ; 
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        goConversations();
        System.out.println(p+"$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
      
    } 
    
    
    
    
   private Parent goConversations() {
       
        ConversationService cs = ConversationService.getInstance();
        UserService ms = UserService.getInstance();

        try {
            Conversation c = new Conversation();
            c.setPerson1Id(LoggedUser.getId());
            List<Conversation> convers = cs.getAll(c);
           
            convers.forEach(e -> {

                User m = new User();
                m.setId(e.getPerson1Id() == LoggedUser.getId() ? e.getPerson2Id() : e.getPerson1Id());
                Timestamp timestamp = e.getSeenDate();
                String x = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss").format(timestamp);
                String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(e.getSeenDate());
                String seen = e.isSeen() ? e.getSeenDate().toString() : "no";
                Button bc = new Button();
                bc.setMinWidth(407);
                bc.setText(" " + e.getLabel() + "\n " + m.getUsername() + " \n Seen :" + e.getSeenDate().toString());
                bc.getStyleClass().add("recu");
                String isConnected = m.isConnected() ? "Online" : "Offline";
                bc.setAlignment(Pos.CENTER);
                bc.setId(e.getId() + "");
                bc.setPrefWidth(268);
                bc.getStyleClass().add("recu");
                cons.getChildren().add(bc);
                i = i + 1;
            });

        } catch (Exception e) {
            Logger.getLogger(ConversationViewController.class.getName()).log(Level.SEVERE, null, e);
        }

        
       
        return cons;
    }

}
