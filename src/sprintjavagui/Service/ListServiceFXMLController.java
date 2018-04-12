/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sprintjavagui.Service;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import Entities.Service;
import Services.ServiceServices;
import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

        

/**
 * FXML Controller class
 *
 * @author nouha
 */
public class ListServiceFXMLController implements Initializable {
    	ObservableList<Service> listU = FXCollections.observableArrayList();

    @FXML
    private TableView<Service> table;
    @FXML
    private TableColumn<Service, Integer> id;
    @FXML
    private TableColumn<Service, String> titre;
    @FXML
    private TableColumn<Service, String> description;
    @FXML
    private TableColumn<Service, Date> datec;
    @FXML
    private TableColumn<Service, String> adresse;
    @FXML
    private TableColumn<Service, String> numtel;
    @FXML
    private TableColumn<Service, Integer> idc;
    @FXML
    private TableColumn<Service, String> user;
        public static int i;
    public static int j;
    public static String p; 
        public static int testpersonne; 
    @FXML
    private JFXButton afficher;
    @FXML
    private JFXButton modifier;
    @FXML
    private JFXButton supprimer;
   
    
    
    public void ListerServices(ActionEvent event) throws IOException{
        ServiceServices SS=new ServiceServices();
        ObservableList observableList=FXCollections.observableArrayList(SS.afficheall());
        table.setItems(observableList);
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        titre.setCellValueFactory(new PropertyValueFactory<>("title"));
        description.setCellValueFactory(new PropertyValueFactory<>("description"));
        datec.setCellValueFactory(new PropertyValueFactory<>("createDt"));
        adresse.setCellValueFactory(new PropertyValueFactory<>("adresseS"));
        numtel.setCellValueFactory(new PropertyValueFactory<>("numtel"));
        idc.setCellValueFactory(new PropertyValueFactory<>("catservice"));
        user.setCellValueFactory(new PropertyValueFactory<>("userservice"));




        
    }
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       ActionEvent event=null;
        try {
            ListerServices(event);
        } catch (IOException ex) {
            Logger.getLogger(ListServiceFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     private void loadCovList() throws SQLException {
        //listCov.clear();
        ServiceServices ss=new ServiceServices();
       listU=ss.afficheall();
       table.setItems(listU);

    }
    
    @FXML
    void ActionSupp(ActionEvent event) throws IOException {
       try{
        Service selectedItem = table.getSelectionModel().getSelectedItem();
        ServiceServices SS=new ServiceServices();
        
        SS.supprimer(selectedItem.getId());
                loadCovList();
        ListerServices(event);}
        catch (SQLException ex) {
		Logger.getLogger(ListServiceFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }

        }
   
    @FXML
    public void ModifierPage(ActionEvent event) throws IOException {
               
		
               /* FXMLLoader loader=new FXMLLoader(getClass().getResource("ModifierServiceFXML.fxml"));
        Parent root=loader.load();
                ModifierServiceFXMLController ms=loader.getController();
        Service s = table.getSelectionModel().getSelectedItem();
        ms.ModifierS(s.getId());
        //ms.Modifier(s.getId());
        table.getScene().setRoot(root);
                */
           
	}
    
    @FXML
    public void AfficherPage(ActionEvent event) throws IOException {
               
		/*Parent list_page_parent = FXMLLoader.load(getClass().getResource("DetailServiceFXML.fxml"));
		Scene list_page_scene = new Scene(list_page_parent);
		Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		app_stage.hide(); //optional
		app_stage.setScene(list_page_scene);
		app_stage.show();*/
        FXMLLoader loader=new FXMLLoader(getClass().getResource("DetailServiceFXML.fxml"));
        Parent root=loader.load();
                DetailServiceFXMLController ds=loader.getController();
        Service s = table.getSelectionModel().getSelectedItem();
        ds.oldValues(s.getId());
        table.getScene().setRoot(root);
        
        

                
                
	}
    
                    

    }

