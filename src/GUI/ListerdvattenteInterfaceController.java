/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Services.*;
import Entity.Rendez_vous;
import Entity.User;
import Utils.Mail;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.controlsfx.control.Notifications;
import static sprintjavagui.User.LoginController.LoggedUser;

/**
 * FXML Controller class
 *
 * @author haythem
 */
public class ListerdvattenteInterfaceController implements Initializable {

    Services.CRUD s =new Services.CRUD();
        
    
    ObservableList<Rendez_vous> ccc=FXCollections.observableArrayList();
    
    @FXML
    private TableView<Rendez_vous> table;
    @FXML
    private TableColumn<Rendez_vous, Integer> id;
    @FXML
    private TableColumn<Rendez_vous, String> message;
    @FXML
    private TableColumn<Rendez_vous, String> date;
    @FXML
    private TableColumn<Rendez_vous, String> heure;
    @FXML
    private TableColumn<Rendez_vous, String> service;
    @FXML
    private Button modifier;
    @FXML
    private Button annuler;
    @FXML
    private Button valider;
    
    public static Integer iddemandeur;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        ObservableList<Rendez_vous> list= FXCollections.observableArrayList();
        
        
        for (Rendez_vous r:s.afficheallrdv() )
        {
            if (r.isValide() == false && r.getAccepteur_id()== LoggedUser.getId() && r.isRemove() == false)
            {
                list.add(r);
            }
            
            iddemandeur = r.getDemandeur_id();
        }
        
        
      
 id.setCellValueFactory(new PropertyValueFactory<>("id"));
 message.setCellValueFactory(new PropertyValueFactory<>("message"));
 date.setCellValueFactory(new PropertyValueFactory<>("date"));
 heure.setCellValueFactory(new PropertyValueFactory<>("heure"));
 service.setCellValueFactory(new PropertyValueFactory<>("service"));
 
  
        
        
        table.setItems(list);
        
        
    }
        // TODO

    @FXML
    private void Accueil(ActionEvent event) throws IOException {
        
             Parent page_select_my = FXMLLoader.load(getClass().getResource("AccueilInterface.fxml"));        
        Scene scene = new Scene(page_select_my);
        Stage app=(Stage)((Node)event.getSource() ).getScene().getWindow();
        app.setScene(scene);
        app.show();
        

    }

    @FXML
    private void rdvuser(ActionEvent event) throws IOException {
        
             Parent page_select_my = FXMLLoader.load(getClass().getResource("Listerdvuser.fxml"));        
        Scene scene = new Scene(page_select_my);
        Stage app=(Stage)((Node)event.getSource() ).getScene().getWindow();
        app.setScene(scene);
        app.show();
        

    }

    @FXML
    private void deco(ActionEvent event) {
    }

    @FXML
    private void modifier(ActionEvent event) throws IOException {
        
        ModifierrdvInterfaceController.id= table.getSelectionModel().getSelectedItem().getId();
            ModifierrdvInterfaceController.t1= table.getSelectionModel().getSelectedItem().getDate();
            ModifierrdvInterfaceController.t2= table.getSelectionModel().getSelectedItem().getHeure();
            ModifierrdvInterfaceController.idaccepteur= table.getSelectionModel().getSelectedItem().getAccepteur_id();

         Parent page_select_my = FXMLLoader.load(getClass().getResource("ModifierrdvInterface.fxml"));        
        Scene scene = new Scene(page_select_my);
        Stage app=(Stage)((Node)event.getSource() ).getScene().getWindow();
        app.setScene(scene);
        app.show();
    }
    
    
    
    private void ref() {
        ccc.clear();
        ccc.addAll();
        
        ObservableList<Rendez_vous> list= FXCollections.observableArrayList();
        for (Rendez_vous r:s.afficheallrdv() )
        {
            if (r.isValide() == false && r.getAccepteur_id()== LoggedUser.getId() && r.isRemove() == false)
            {
                list.add(r);
            }
            
            iddemandeur = r.getDemandeur_id();
        }
        
        table.setItems(list);
        
    }

    @FXML
    private void annuler(ActionEvent event) {
        
         Services.CRUD s = new Services.CRUD() {};

            Rendez_vous r = new Rendez_vous();
         
            int id = table.getSelectionModel().getSelectedItem().getId();
         
            s.supprimer(id);
            table.getSelectionModel().clearSelection();
            table.getItems().remove(ccc);
         
          
       
        User user = s.getMail(iddemandeur);
        
        
         Mail.send(LoggedUser.getEmail_canonical(), "Colocation Esprit", "Vous avez annuler votre rendez-vous veuillez voir sur notre site.");

                
                
         Mail.send(user.getEmail_canonical(), "Colocation Esprit", "votre rdv a ete annulee ");
                
               
                
                ref();
                
     Notifications.create().title("Succes").text("Votre rendez-vous a ete annule avec succes.").position(Pos.BOTTOM_RIGHT).showConfirm();

    }

    @FXML
    private void Valider(ActionEvent event) {
        
        Services.CRUD s = new Services.CRUD() {};
        
          Rendez_vous r = new Rendez_vous();
           
           int id = table.getSelectionModel().getSelectedItem().getId();
          
          s.valider(r, id);
            table.getSelectionModel().clearSelection();
            table.getItems().remove(ccc);
           
            
            ref();
            
                 Notifications.create().title("Succes").text("Votre rendez-vous a ete valide avec succes.").position(Pos.BOTTOM_RIGHT).showConfirm();

    }

    
      
    
    
   
    
}