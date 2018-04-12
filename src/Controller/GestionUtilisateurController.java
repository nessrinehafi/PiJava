/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import static Controller.ForumController.i;
import static Controller.ForumController.l;
import static Controller.ForumController.testpersonne;
import static sprintjavagui.User.LoginController.LoggedUser;
import Model.Forum;
import Model.User;
import Service.ForumService;
import Service.UserService;
import java.net.URL;
import java.sql.SQLException;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author nessrine
 */
public class GestionUtilisateurController implements Initializable {

    @FXML
    private Button guser;
    @FXML
    private Label users;
    @FXML
    private TableView<User> tablev;
    @FXML
    private TableColumn<User, String> id;
    @FXML
    private TableColumn<User, String> nom;
    @FXML
    private TableColumn<User, String> prenom;
    @FXML
    private TableColumn<User, String> username;
    @FXML
    private TableColumn<User, String> fenable;
	ObservableList<User> listU = FXCollections.observableArrayList();
    @FXML
    private Button banirforum;
        public static int ff;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        	ListerUsers();
            try {
                loadList();
                
                
                // TODO
            } catch (SQLException ex) {
                Logger.getLogger(GestionUtilisateurController.class.getName()).log(Level.SEVERE, null, ex);
            }
            ff=listU.get(LoggedUser.id).getFenable();
        // TODO
    }    
 public void ListerUsers() 
        {

        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        prenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        username.setCellValueFactory(new PropertyValueFactory<>("username"));
        fenable.setCellValueFactory(new PropertyValueFactory<>("fenable"));
 




        }
      	 private void loadList() throws SQLException 
        {
        //listCov.clear();
        UserService su=new UserService();
       listU=su.selectUsers();
              tablev.setItems(listU);

         }

    @FXML
    private void GestionUser(ActionEvent event) {
    }
    @FXML
    private void RemplirUtil(MouseEvent event) {
   
        
  i = tablev.getSelectionModel().getSelectedIndex();

    
		ForumService su = new ForumService();
	

		User u = tablev.getSelectionModel().getSelectedItem();
		
	} 

    @FXML
    private void banirForumAction(ActionEvent event) {
  
        try {
			UserService su=new UserService();
			User u=tablev.getSelectionModel().getSelectedItem();
			su.BanirForum(u.getId());
			
			ListerUsers();
                        loadList();
		} catch (SQLException ex) {
		Logger.getLogger(ForumController.class.getName()).log(Level.SEVERE, null, ex);
		}
		
    }
    }
    

