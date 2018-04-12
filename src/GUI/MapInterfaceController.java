package GUI;


import com.lynden.gmapsfx.GoogleMapView;
import com.lynden.gmapsfx.MapComponentInitializedListener;
import com.lynden.gmapsfx.javascript.object.GoogleMap;
import com.lynden.gmapsfx.javascript.object.InfoWindow;
import com.lynden.gmapsfx.javascript.object.InfoWindowOptions;
import com.lynden.gmapsfx.javascript.object.LatLong;
import com.lynden.gmapsfx.javascript.object.MapOptions;
import com.lynden.gmapsfx.javascript.object.MapTypeIdEnum;
import com.lynden.gmapsfx.javascript.object.Marker;
import com.lynden.gmapsfx.javascript.object.MarkerOptions;
import com.lynden.gmapsfx.service.geocoding.GeocoderStatus;
import com.lynden.gmapsfx.service.geocoding.GeocodingResult;
import com.lynden.gmapsfx.service.geocoding.GeocodingService;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.Stage;


public class MapInterfaceController implements Initializable, MapComponentInitializedListener {
    
    
    private GoogleMap map2;
    
    private Boolean ready;
    
    private GeocodingService G ;
    @FXML
    private GoogleMapView gmap;
    
    public static String adresse;
    @FXML
    private Button button;
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        gmap.addMapInializedListener(this);
    }    

     public void createMap() {
        map2 = new GoogleMap();
        G = new GeocodingService();
        MapOptions mapOptions = new MapOptions();
        mapOptions.center(new LatLong(35.6759137, 10.0919243))
                .mapType(MapTypeIdEnum.ROADMAP)
                .overviewMapControl(true)
                .panControl(true)
                .rotateControl(true)
                .scaleControl(true)
                .streetViewControl(true)
                .zoomControl(true)
                .zoom(12);

        map2 = gmap.createMap(mapOptions);
    }
    public void mapInitialized() {

        createMap();
        
        String adress = adresse;
       

        G.geocode(adress, (GeocodingResult[] results, GeocoderStatus status) -> {

            LatLong latLong;

            if (status == GeocoderStatus.ZERO_RESULTS) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "No matching address found");
                alert.show();
                return;
            } else if (results.length > 1) {
                Alert alert = new Alert(Alert.AlertType.WARNING, "Multiple results found, showing the first one.");
                alert.show();
                latLong = new LatLong(results[0].getGeometry().getLocation().getLatitude(), results[0].getGeometry().getLocation().getLongitude());
            } else {
                latLong = new LatLong(results[0].getGeometry().getLocation().getLatitude(), results[0].getGeometry().getLocation().getLongitude());
                MarkerOptions markerOptions = new MarkerOptions();
                System.out.println("result LG " + latLong.getLongitude() + "   " + latLong.getLatitude());
                markerOptions.position(latLong)
                        .visible(Boolean.TRUE)
                        .title("My Marker");

                Marker marker = new Marker(markerOptions);
                map2.addMarker(marker);

            }

            map2.setCenter(latLong);
        });
    }

    private void rdv(ActionEvent event) throws IOException {
        
                   Parent page_select_my = FXMLLoader.load(getClass().getResource("ListedresseurInterface.fxml"));        
        Scene scene = new Scene(page_select_my);
        Stage app=(Stage)((Node)event.getSource() ).getScene().getWindow();
        app.setScene(scene);
        app.show();
        
        

    }

    @FXML
    private void categorie(ActionEvent event) throws IOException {
        
        Parent page_select_my = FXMLLoader.load(getClass().getResource("ListedresseurInterface.fxml"));        
        Scene scene = new Scene(page_select_my);
        Stage app=(Stage)((Node)event.getSource() ).getScene().getWindow();
        app.setScene(scene);
        app.show();
    }
}