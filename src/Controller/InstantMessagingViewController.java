/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import static Controller.ForumController.a;
import static Controller.ForumController.aid;
import static Controller.ForumController.l;
import static sprintjavagui.User.LoginController.LoggedUser;
import Dialog.AlertDialog;
import Model.Commentaire;
import Model.Forum;
import Model.Message;
import Service.CommentaireService;
import Service.ForumService;
import Service.MessageService;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author nessrine
 */
public class InstantMessagingViewController implements Initializable {
     
    @FXML
    private VBox users;
    @FXML
    private JFXTextField message;
    @FXML
    private Button send;
    @FXML
    private Label reciever;
    List< Message> list2 = new ArrayList<Message>();
    @FXML
    private JFXListView<String> ListMessage;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         reciever.setText(String.valueOf(l));
        try {
            affichageInterface();
        } catch (SQLException ex) {
            Logger.getLogger(InstantMessagingViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    @FXML
    private void sendAction(ActionEvent event) throws SQLException {
    
  
        
	
		
                        
                        System.out.println("not ");
			Message p = new Message(message.getText(), new Date(),LoggedUser.id,aid);
                        System.out.println("$$$$$$$$$$$$$$");

			//User u = new User();
			//u.setId(User.connected_id);
			MessageService F =new MessageService();
                        F.Sendmessage(p);
			affichageInterface();
			AlertDialog.Display("info", "Le message Est envoyer");
			}
    
     public void affichageInterface() throws SQLException {

         MessageService su=new MessageService();

        list2 = su.selectMessage( LoggedUser.id , aid);

        ObservableList<String> itemss = FXCollections.observableArrayList();

        for (int i = 0; i < list2.size(); i++) {
//                    System.out.println(list2.get(i).getContenu());
     
        if (list2.get(i).getSenderId()==LoggedUser.id)
        {  itemss.add( "                                                   "+list2.get(i).getContent()+":you " 
        );}
        
        else
        {
                            itemss.add(a +": " 
                    + list2.get(i).getContent());
                }}
        ListMessage.setItems(itemss);
    }
    
    
		}
    
    

