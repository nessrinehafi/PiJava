/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sprintjavagui.Reclamation;

import Entities.Reclamation;
import Entities.User;
import Services.ReclamationServices;
import Utils.CategoryType;
import com.jfoenix.controls.JFXTreeTableColumn;
import com.jfoenix.controls.JFXTreeTableView;
import com.jfoenix.controls.RecursiveTreeItem;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.function.Predicate;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author mehdi
 */
public class AfficherReclamationsController implements Initializable {

    ReclamationServices reclamationServices = new ReclamationServices();
    
    @FXML
    private Button accueil;

    @FXML
    private Button creer;

    @FXML
    private JFXTreeTableView<ReclamationListObject> reclamationTableId;
    @FXML
    private TextField search;

    @FXML
    private void accueilButtonAction(ActionEvent event) throws IOException {

        Parent home_page_parent = FXMLLoader.load(getClass().getResource("Reclamation.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(home_page_scene);
        app_stage.show();
    }

    @FXML
    private void creerButtonAction(ActionEvent event) throws IOException {

        Parent home_page_parent = FXMLLoader.load(getClass().getResource("AddReclamation.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(home_page_scene);
        app_stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        JFXTreeTableColumn<ReclamationListObject, String> titreClmn = new JFXTreeTableColumn<>("Titre");
        titreClmn.setCellValueFactory((TreeTableColumn.CellDataFeatures<ReclamationListObject, String> param) -> param.getValue().getValue().getTitre());

        JFXTreeTableColumn<ReclamationListObject, String> descriptionClmn = new JFXTreeTableColumn<>("Description");
        descriptionClmn.setCellValueFactory((TreeTableColumn.CellDataFeatures<ReclamationListObject, String> param) -> param.getValue().getValue().getDescription());

        JFXTreeTableColumn<ReclamationListObject, String> categorieClmn = new JFXTreeTableColumn<>("Categorie");
        categorieClmn.setCellValueFactory((TreeTableColumn.CellDataFeatures<ReclamationListObject, String> param) -> param.getValue().getValue().getCategorie());

        JFXTreeTableColumn<ReclamationListObject, String> dateCreationClmn = new JFXTreeTableColumn<>("Date de Creation");
        dateCreationClmn.setCellValueFactory((TreeTableColumn.CellDataFeatures<ReclamationListObject, String> param) -> param.getValue().getValue().getDateCreation());

        JFXTreeTableColumn<ReclamationListObject, String> statutClmn = new JFXTreeTableColumn<>("Statut");
        statutClmn.setCellValueFactory((TreeTableColumn.CellDataFeatures<ReclamationListObject, String> param) -> param.getValue().getValue().getStatut());

        JFXTreeTableColumn<ReclamationListObject, String> reponseClmn = new JFXTreeTableColumn<>("Reponse");
        reponseClmn.setCellValueFactory((TreeTableColumn.CellDataFeatures<ReclamationListObject, String> param) -> param.getValue().getValue().getReponse());

        ObservableList<ReclamationListObject> reclamationListObjectObservableList = FXCollections.observableArrayList();

        List<Reclamation> reclamationList = reclamationServices.getAll();

        for (Reclamation r : reclamationList){
            reclamationListObjectObservableList.add(new ReclamationListObject(r));
        }
        
        final TreeItem<ReclamationListObject> root = new RecursiveTreeItem<ReclamationListObject>(reclamationListObjectObservableList, RecursiveTreeObject::getChildren);
        reclamationTableId.getColumns().setAll(titreClmn, descriptionClmn, categorieClmn, dateCreationClmn, statutClmn, reponseClmn);

        titreClmn.prefWidthProperty().bind(reclamationTableId.widthProperty().divide(reclamationTableId.getColumns().size()));
        descriptionClmn.prefWidthProperty().bind(reclamationTableId.widthProperty().divide(reclamationTableId.getColumns().size()));
        categorieClmn.prefWidthProperty().bind(reclamationTableId.widthProperty().divide(reclamationTableId.getColumns().size()));
        dateCreationClmn.prefWidthProperty().bind(reclamationTableId.widthProperty().divide(reclamationTableId.getColumns().size()));
        statutClmn.prefWidthProperty().bind(reclamationTableId.widthProperty().divide(reclamationTableId.getColumns().size()));
        reponseClmn.prefWidthProperty().bind(reclamationTableId.widthProperty().divide(reclamationTableId.getColumns().size()));

        reclamationTableId.setRoot(root);
        reclamationTableId.setShowRoot(false);
        reclamationTableId.setPlaceholder(new Label("Liste de reclamation vide"));
        
        
     
    }

    class ReclamationListObject extends RecursiveTreeObject<ReclamationListObject> {

        //IntegerProperty id;
        StringProperty titre;
        StringProperty description;
        StringProperty categorie;
        StringProperty dateCreation;
        StringProperty statut;
        StringProperty reponse;

        Reclamation reclamation;

        public ReclamationListObject(Reclamation reclamation) {
            //this.id = new SimpleIntegerProperty(reclamation.getId());
            this.titre = new SimpleStringProperty(reclamation.getTitre());
            this.description = new SimpleStringProperty(reclamation.getDescription());
            this.categorie = new SimpleStringProperty(reclamation.getCategorie().name());
            this.dateCreation = new SimpleStringProperty(reclamation.getDateCreation().toString());
            this.statut = new SimpleStringProperty(reclamation.getStatut().name());
            this.reponse = new SimpleStringProperty(reclamation.getReponse());
        }

        public StringProperty getTitre() {
            return titre;
        }

        public void setTitre(StringProperty titre) {
            this.titre = titre;
        }

        public StringProperty getDescription() {
            return description;
        }

        public void setDescription(StringProperty description) {
            this.description = description;
        }

        public StringProperty getCategorie() {
            return categorie;
        }

        public void setCategorie(StringProperty categorie) {
            this.categorie = categorie;
        }

        public StringProperty getDateCreation() {
            return dateCreation;
        }

        public void setDateCreation(StringProperty dateCreation) {
            this.dateCreation = dateCreation;
        }

        public StringProperty getStatut() {
            return statut;
        }

        public void setStatut(StringProperty statut) {
            this.statut = statut;
        }

        public StringProperty getReponse() {
            return reponse;
        }

        public void setReponse(StringProperty reponse) {
            this.reponse = reponse;
        }

        public Reclamation getReclamation() {
            return reclamation;
        }

        public void setReclamation(Reclamation reclamation) {
            this.reclamation = reclamation;
        }

    }
}
