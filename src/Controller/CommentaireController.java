/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import static Controller.ForumController.a;
import static Controller.ForumController.aid;
import static Controller.ForumController.cr;
import static Controller.ForumController.j;
import static Controller.ForumController.l;
import static Controller.ForumController.t;
import static sprintjavagui.User.LoginController.LoggedUser;
import Model.Commentaire;
import Model.Forum;
import Model.like;
import Service.CommentaireService;
import Service.ForumService;
import Service.LikeService;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author nessrine
 */
public class CommentaireController implements Initializable {

    @FXML
    private Label id; 
    @FXML
    private ListView<String> listcom;
    List< Commentaire> list2 = new ArrayList<Commentaire>();
    @FXML
    private JFXButton Ajouter1;
    @FXML
    private JFXButton Ajouter11;
    @FXML
    private JFXTextField commentaire;
       like likee = new like(); 
    @FXML
    private JFXButton commenter;
 Commentaire com=new Commentaire();
         CommentaireService su=new CommentaireService();
         LikeService li=new LikeService();

    @FXML
    private JFXButton modifier;
    @FXML
    private JFXButton supprimer;
     public static int i;
             public static String testpersonne;
              List<String> listPersonne = new ArrayList< String>();
    @FXML
    private Label titre;
    @FXML
    private Label auteur;
    @FXML
    private Label date;
    @FXML
    private Label contenu;
    @FXML
    private Label tag;
    @FXML
    private JFXButton like;
    @FXML
    private Label likes;
    @FXML
    private JFXButton Envoyermessage;
     public static int p;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       afficherID();
       affichageInterface();
       supprimer.setDisable(true);
       modifier.setDisable(true);
       affichagelike();
       int nbr = li.liked(j, LoggedUser.username) ;
        if (nbr < 1) {
        like.setDisable(false);
        }
        else
        {
            like.setDisable(true);
        }

    }
    public boolean controleSaisie() {
		if (commentaire.getText().isEmpty() ) {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setTitle("Required fields");
			alert.setHeaderText(null);
			alert.setContentText("Please fill in all fields");
			alert.show();
			return false;
		}
		return true;
	}

      
     public void afficherID()
     {
         id.setText(String.valueOf(l));
         System.out.println(l);
         titre.setText(String.valueOf(t));
         auteur.setText(String.valueOf(a));
         contenu.setText(String.valueOf(cr));
         tag.setText(String.valueOf(cr));
         
     }
     
     
    public void affichageInterface() {

         CommentaireService su=new CommentaireService();

        list2 = su.displayAllById(l);

        ObservableList<String> itemss = FXCollections.observableArrayList();

        for (int i = 0; i < list2.size(); i++) {
//                    System.out.println(list2.get(i).getContenu());
            listPersonne.add(list2.get(i).getUser());
            System.out.println(su.displayAllUser(list2.get(i).getUser()).getNom());
            itemss.add("Le membre: "+ su.displayAllUser(list2.get(i).getUser()).getNom() + " " + su.displayAllUser(list2.get(i).getUser()).getPrenom() +" a commenté : "
                    + list2.get(i).getCommentaire());
        }
        listcom.setItems(itemss);
    }

    @FXML
    private void AjouterSujetLink(ActionEvent event) throws IOException {
        Parent list_page_parent = FXMLLoader.load(getClass().getResource("/View/AddForum.fxml"));
        Scene list_page_scene = new Scene(list_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

                app_stage.hide(); //optional
                app_stage.setScene(list_page_scene);
                app_stage.show();
    }

    @FXML
    private void AfficherSujet(ActionEvent event) throws IOException {
        	Parent list_page_parent = FXMLLoader.load(getClass().getResource("/View/Forum.fxml"));
        Scene list_page_scene = new Scene(list_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

                app_stage.hide(); //optional
                app_stage.setScene(list_page_scene);
                app_stage.show();
    }

    @FXML
    private void commenter(ActionEvent event) {
        
       if (controleSaisie()) {
        com.setCommentaire(commentaire.getText());
        com.setBlog(l);
        com.setUser(LoggedUser.username);
        su.add(com);
        affichageInterface();
       }
    }

    @FXML
    private void modifier(ActionEvent event) {

          su.update1(list2.get(i).getId(), commentaire.getText());
        affichageInterface();
        System.out.println("Modification avec succes ");
        
    }

    @FXML
    private void supprimer(ActionEvent event) {
              
            su.deletebyid(list2.get(i).getId());
        
        affichageInterface();
        System.out.println("Supprimer avec succes ");
    }

    @FXML
    private void listCom_Clicked(MouseEvent event) {
           i = listcom.getSelectionModel().getSelectedIndex();
            testpersonne = listPersonne.get(i);
        if (testpersonne.equals(LoggedUser.username) ) {
            supprimer.setDisable(false);
        } else {
            supprimer.setDisable(true);

        }
        if (testpersonne.equals(LoggedUser.username)) {
            modifier.setDisable(false);
        } else {
            modifier.setDisable(true);

        }
        
       commentaire.setText(list2.get(i).getCommentaire());

    }

    @FXML
    private void LikeAction(ActionEvent event) {
        
        like lik = new like(l, LoggedUser.username);
       
         li.addlike(lik);
			
        affichageInterface();
        affichagelike();
        System.out.println("ajouter");
        int nbr = li.liked(l, LoggedUser.username) ;
        if (nbr < 1) {
        like.setDisable(false);
        }
        else
        {
            like.setDisable(true);
        }
    }

    @FXML
    private void affichagelike() {

        int k;
        k= li.displayAllById(l);
        System.out.println(k);

        likes.setText(Integer.toString(k) +" "+" j'aime");

    }

    @FXML
    private void EnvoyerAction(ActionEvent event) throws IOException {
        p=aid;
          Parent page = FXMLLoader.load(getClass().getResource("/View/InstantMessagingView.fxml"));
        Scene scene = new Scene(page);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.hide();
        stage.setScene(scene);
        stage.show();
    }
    }
    
    
    

