/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;


import Entity.User;
import Services.CRUD;
import com.sun.prism.impl.Disposer;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Predicate;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.util.Callback;
import static sprintjavagui.User.LoginController.LoggedUser;

/**
 * FXML Controller class
 *
 * @author haythem
 */
public class ListedresseurInterfaceController implements Initializable {

    
    Services.CRUD s =new Services.CRUD();
 
    
    
    @FXML
    private TableView<User> table;
    @FXML
    private TableColumn<User, Integer> id;
    @FXML
    private TableColumn<User, String> nom;
    @FXML
    private TableColumn<User, String> prenom;
    @FXML
    private TableColumn<User, Integer> numtel;
    @FXML
    private TableColumn<User, String> email;
    @FXML
    private TableColumn<User, String> adresse;
    @FXML
    private Button prendrerdv;
    @FXML
    private Button Destination;
    private ComboBox<String> lieuc;
    @FXML
    private TextField search;
    @FXML
    private Button rdvattenteuser;
    @FXML
    private Button listerdvvalider;
    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        listerdvvalider.setVisible(false);
        
        
        rdvattenteuser.setVisible(false);
        
        if (LoggedUser.getRole().contains("Educateur canin") || LoggedUser.getRole().contains("Vétérinaire"))
        {
            
            listerdvvalider.setVisible(true);
        }
        
        if (LoggedUser.getRole().contains("utilisateur simple"))
        {
            rdvattenteuser.setVisible(true);
        }
        
        ObservableList<User> list= FXCollections.observableArrayList();
        
        for (User r:s.affichealluser() )
        {
            if (r.getRole().contains("Educateur canin"))
            {
                list.add(r);
                
                
                
            }
            
            
        }
        
        
        
       
        
      
 id.setCellValueFactory(new PropertyValueFactory<>("id"));
 nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
 prenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
 numtel.setCellValueFactory(new PropertyValueFactory<>("numtel"));
 email.setCellValueFactory(new PropertyValueFactory<>("email"));
 adresse.setCellValueFactory(new PropertyValueFactory<>("adresse"));
 

        table.setItems(list);
        
                  FilteredList<User> fil= new FilteredList<>(list,e->true);
        search.setOnKeyReleased((KeyEvent e) -> {
            search.textProperty().addListener((ObservableValue<? extends String> observableValue, String oldValue, String newValue) -> {
                fil.setPredicate((Predicate <? super User>) User->{
                    if(newValue==null||newValue.isEmpty()){return true;}
                    String lower=newValue.toLowerCase();
                    if(User.getNom().toLowerCase().contains(lower)){return true;}
    
                    return false;
                });
            });
            SortedList<User> k = new SortedList<>(fil);
            k.comparatorProperty().bind(table.comparatorProperty());
            table.setItems(k);
        });
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
    private void rdvattente(ActionEvent event) throws IOException {
        
       
            
            
        
        
        
            Parent page_select_my = FXMLLoader.load(getClass().getResource("ListerdvattnteuserInterface.fxml"));        
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
    private void rdv(ActionEvent event) throws IOException {
        
            Parent page_select_my = FXMLLoader.load(getClass().getResource("CategorieInterface.fxml"));        
        Scene scene = new Scene(page_select_my);
        Stage app=(Stage)((Node)event.getSource() ).getScene().getWindow();
        app.setScene(scene);
        app.show();
    }


    @FXML
    private void deco(ActionEvent event) {
        
        
    }   

    @FXML
    private void prendrerdv(ActionEvent event) throws IOException {
        
        PrendrerdvInterfaceController.id_accepteur= table.getSelectionModel().getSelectedItem().getId();
        
        
        
        
        
        Parent page_select_my = FXMLLoader.load(getClass().getResource("PrendrerdvInterface.fxml"));        
        Scene scene = new Scene(page_select_my);
        Stage app=(Stage)((Node)event.getSource() ).getScene().getWindow();
        app.setScene(scene);
        app.show();
    }

    @FXML
    private void Destination(ActionEvent event) throws IOException {
        
      MapInterfaceController.adresse= table.getSelectionModel().getSelectedItem().getAdresse();
      
      
      
      
      
      Parent page_select_my = FXMLLoader.load(getClass().getResource("MapInterface.fxml"));        
        Scene scene = new Scene(page_select_my);
        Stage app=(Stage)((Node)event.getSource() ).getScene().getWindow();
        app.setScene(scene);
        app.show();
    }

    private void calendar(ActionEvent event) throws IOException {
        
        Parent page_select_my = FXMLLoader.load(getClass().getResource("Calendrier.fxml"));        
        Scene scene = new Scene(page_select_my);
        Stage app=(Stage)((Node)event.getSource() ).getScene().getWindow();
        app.setScene(scene);
        app.show();
        
    }

    @FXML
    private void listerdvvalider(ActionEvent event) throws IOException {
        
        Parent page_select_my = FXMLLoader.load(getClass().getResource("ListerdvattenteInterface.fxml"));        
        Scene scene = new Scene(page_select_my);
        Stage app=(Stage)((Node)event.getSource() ).getScene().getWindow();
        app.setScene(scene);
        app.show();
    }

    

    
    
}
