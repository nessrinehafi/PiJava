/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.Evenement;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class EventItemController {
    @FXML
    private HBox Hbox;
    @FXML
    private ImageView img;
    @FXML
    private Label nom;
    @FXML
    private Label datedeb;
    @FXML
    private Label datefin;
    @FXML
    private Label desc;

    /**
     * Initializes the controller class.
     */
    public void initialize() {
        // TODO
    }    

    public EventItemController() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/GUIDali/EventItem.fxml"));
        fxmlLoader.setController(this);
        try
        {
            fxmlLoader.load();
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }
     public void setInfo(Evenement string)
    {
        nom.setText(string.getNom());
        desc.setText(string.getDescription());
        datedeb.setText(""+string.getHeureDebut());
        datefin.setText(""+string.getHeureFin());
        Image image = new Image("http://localhost/Animaux/web/Pictures/"+string.getMonImage());
        if(image != null){
            img.setImage(image);
        }
        
    }

    public HBox getBox()
    {
        return Hbox;
    }
    
    
}
