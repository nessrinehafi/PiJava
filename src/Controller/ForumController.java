/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import static Controller.CommentaireController.i;
import static Controller.CommentaireController.testpersonne;
import static sprintjavagui.User.LoginController.LoggedUser;
import Dialog.AlertDialog;
import Model.Forum;
import Model.User;
import Service.ForumService;
import Service.UserService;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author nessrine
 */
public class ForumController implements Initializable {

	ObservableList<Forum> listU = FXCollections.observableArrayList();
    List< Forum> list2 = new ArrayList<Forum>();

    @FXML
    private JFXButton Ajouter1;
    @FXML
    private JFXButton Ajouter11;
    private JFXListView<String> listesujet;
        ForumService ForumService = new ForumService();
    List< Forum> listPublications = new ArrayList<Forum>();
    List< Integer> listIdPersonne = new ArrayList< Integer>();
    List< Integer> listIdPublication = new ArrayList< Integer>();
     public static int i;
    public static int j,l,aid;
     public static String t,a,cr,ta;
     
    public static Forum p;
        public static String testpersonne;
        private ResultSet rs=null;

    @FXML
    private TableView<Forum> Tablev;
    @FXML
    private TableColumn<Forum, String> auteur;
    @FXML
    private TableColumn<Forum, String> titre1;
    @FXML
    private TableColumn<Forum, String> tags1;
    @FXML
    private TableColumn<Forum, String> Blog1;
    @FXML
    private JFXTextField titre;
    @FXML
    private JFXTextField tags;
    @FXML
    private JFXTextArea blog;
    @FXML
    private JFXButton Addimage;
    @FXML
    private JFXButton Modifier;
    @FXML
    private JFXButton supprimer;
      private File selectedFile;
                  List<String> listPersonne = new ArrayList< String>();
 private ComboBox<String> cb;
      @FXML
    
    private ImageView image;
    @FXML
    private TableColumn<?, ?> Id;
    @FXML
    private Label id1;
    @FXML
    private JFXTextField SujetChercher;
    @FXML
    private JFXButton AfficheSujet;
    
DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
    @FXML
    private ImageView image1;
    @FXML
    private TableColumn<?, ?> auteurid;
    @FXML
    private Button SignalerSujet;

    /**
     * Initializes the controller class.
     */
        @Override

        public void initialize(URL location, ResourceBundle resources) {
            		ListerForum();
		
	
            try {
                loadList();
            } catch (SQLException ex) {
                Logger.getLogger(ForumController.class.getName()).log(Level.SEVERE, null, ex);
            }
                supprimer.setDisable(true);
                  Modifier.setDisable(true);
               //SearchSujet();
                     
          FilteredList<Forum> fil= new FilteredList<>(listU,e->true);
        SujetChercher.setOnKeyReleased((KeyEvent e) -> {
            SujetChercher.textProperty().addListener((ObservableValue<? extends String> observableValue, String oldValue, String newValue) -> {
                fil.setPredicate((Predicate <? super Forum>) Forum->{
                    if(newValue==null||newValue.isEmpty()){return true;}
                    String lower=newValue.toLowerCase();
                    if(Forum.getTags().toLowerCase().contains(lower)){return true;}
                    else if(Forum.getTags().toLowerCase().contains(lower)){return true;}
                    return false;
                });
            });
            SortedList<Forum> k = new SortedList<>(fil);
            k.comparatorProperty().bind(Tablev.comparatorProperty());
            Tablev.setItems(k);

                
	
	
	
    });
                }
          @FXML
	private void addImage(ActionEvent event) {
		FileChooser f = new FileChooser();
		selectedFile = f.showOpenDialog(null);
		if (selectedFile != null) {
			image.setImage(new Image("file:" + selectedFile.getPath()));
		}
	}
        public void ListerForum() 
        {

        auteur.setCellValueFactory(new PropertyValueFactory<>("Auteur"));
        titre1.setCellValueFactory(new PropertyValueFactory<>("Titre"));
        tags1.setCellValueFactory(new PropertyValueFactory<>("Tags"));
        Blog1.setCellValueFactory(new PropertyValueFactory<>("Blog"));
        Id.setCellValueFactory(new PropertyValueFactory<>("id"));
        auteurid.setCellValueFactory(new PropertyValueFactory<>("auteurid"));
          }
    	 private void loadList() throws SQLException {
        //listCov.clear();
        ForumService su=new ForumService();
       listU=su.selectForum();
       Tablev.setItems(listU);
        list2 = su.selectForum();
          for (int i = 0; i < list2.size(); i++) 
        {
//                    System.out.println(list2.get(i).getContenu());
              listPersonne.add(list2.get(i).getAuteur());
        }
     


       

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
    private void SupprimerSujet(ActionEvent event) {
        try {
			ForumService su=new ForumService();
			Forum u=Tablev.getSelectionModel().getSelectedItem();
			su.SupprimerForum(u.getId());
			
			ListerForum();
                        loadList();
		} catch (SQLException ex) {
		Logger.getLogger(ForumController.class.getName()).log(Level.SEVERE, null, ex);
		}
			titre.clear();
			blog.clear();
			tags.clear();
		
    }

    @FXML
    private void RemplirUtil(MouseEvent event) {
   
        
  i = Tablev.getSelectionModel().getSelectedIndex();
       testpersonne = listPersonne.get(i);
        if (testpersonne.equals(LoggedUser.username) ) {
            supprimer.setDisable(false);
        } else {
            supprimer.setDisable(true);

        }
        if (testpersonne.equals(LoggedUser.username)) {
            Modifier.setDisable(false);
        } else {
            Modifier.setDisable(true);

        }
		ForumService su = new ForumService();
	

		Forum u = Tablev.getSelectionModel().getSelectedItem();
		
	
		
		titre.setText(String.valueOf(u.getTitre()));
		blog.setText(String.valueOf(u.getBlog()));
		tags.setText(String.valueOf(u.getTags()));
                

                
               
		
	}  
	public boolean controleSaisie() {
		if (tags.getText().isEmpty() || titre.getText().isEmpty()
				|| blog.getText().isEmpty()) {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setTitle("Required fields");
			alert.setHeaderText(null);
			alert.setContentText("Please fill in all fields");
			alert.show();
			return false;
		}
		return true;
	}
        
    @FXML
    private void UpdateSujet(ActionEvent event) {
        try {
			ForumService su=new ForumService();
			Forum u=Tablev.getSelectionModel().getSelectedItem();
//			int l=u.getId();

			System.out.println(l);	

			
			String url_image = "";
			if (selectedFile != null) {
				url_image = selectedFile.getPath();
			}
				      
				//id=sa.findByAdresse(TfNumero.getText(),TfVille.getText(), TfRue.getText(),codep);
				u.setTitre(titre.getText());
				u.setTags(tags.getText());
				u.setBlog(blog.getText());
                             
                                u.setImage(url_image);
			
			
			//System.out.println(u.toString());

			su.ModifierSujet(u,u.getId());
		ListerForum();
		loadList();
						AlertDialog.Display("info", "Le Sujet Est Ajouté");

    } catch (SQLException ex) {
		Logger.getLogger(ForumController.class.getName()).log(Level.SEVERE, null, ex);
		}
			titre.clear();
			blog.clear();
			tags.clear();
		
    }
        private  Connection con;
private Statement ste;
private PreparedStatement pst;
/* 
private void SearchSujet()
    {
       SujetChercher.setOnKeyReleased(e->{
           if(SujetChercher.getText().equals(""))
           {
               System.out.println("nooo");
           }
           else{
               listU.clear();
       String sql="SELECT `id`,`Titre`, `Blog`, `Tags`,`Auteur` FROM `Forum` where Titre LIKE '%"+SujetChercher.getText()+"%' ";
           try {
               pst=con.prepareStatement(sql);
               pst.setString(1, SujetChercher.getText());
             pst.executeQuery();
             while(pst.executeQuery().next())
             {
                 listU.add(new Forum(rs.getInt("id"),rs.getString("Titre"),
					rs.getString("Blog"),
					
					rs.getString("Tags"),
                                rs.getString("Auteur")
			));
                 Tablev.setItems(listU);
             }
           } catch (SQLException ex) {
               Logger.getLogger(ForumController.class.getName()).log(Level.SEVERE, null, ex);
           }
       
           }        
       });
            
    }
    */

   
        @FXML
    private void Search(ActionEvent event) throws SQLException {
      
       ForumService as = new ForumService();
       
        
        
         ObservableList<Forum> list= FXCollections.observableArrayList();
        
        for (Forum a:as.selectForum())
        {
            
            
                list.add(a);
               
                
      
            
        }
        
        FilteredList<Forum> filteredData = new FilteredList <> (list,p->true);
        filteredData.setPredicate(Forum->{
            if(Forum.getTags().contains(cb.getSelectionModel().getSelectedItem()))
                return(true);
            else {
               if(cb.getSelectionModel().getSelectedItem().equals("tout afficher")){
                   return true;
               }
            }
         return(false);   
        });
        SortedList<Forum> sortedData = new SortedList<>(filteredData);
        
        sortedData.comparatorProperty().bind(Tablev.comparatorProperty());
        
        Tablev.setItems(sortedData);
        
    }

    @FXML
    private void AfficheSujet(ActionEvent event)throws IOException {
        System.out.println("!g,qebgovqeovbqdc"+a);
        p = Tablev.getSelectionModel().getSelectedItem();

        i = Tablev.getSelectionModel().getSelectedIndex();
       
        l=listU.get(i).getId();
        aid=listU.get(i).getAuteurid();
        t=listU.get(i).getTitre();
        a=listU.get(i).getAuteur();
        cr=listU.get(i).getBlog();
        ta=listU.get(i).getTags();
        //System.out.println(cr+"ffff");
        //Date d =listU.get(i).getCree();
        //cr=df.format(d);
      //System.out.println(cr+"ffff");

        Parent page = FXMLLoader.load(getClass().getResource("/View/Commentaire.fxml"));
        Scene scene = new Scene(page);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.hide();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void SignalerSujetAction(ActionEvent event) {
            try {
			ForumService su=new ForumService();
			Forum u=Tablev.getSelectionModel().getSelectedItem();
			su.SignalerForum(u.getId());
			
			ListerForum();
                        loadList();
		} catch (SQLException ex) {
		Logger.getLogger(ForumController.class.getName()).log(Level.SEVERE, null, ex);
		}
    }
    
    }



    

