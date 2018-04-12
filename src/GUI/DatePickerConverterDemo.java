/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entity.Rendez_vous;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import javafx.scene.control.DatePicker;
import javafx.stage.Stage;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
 
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import javafx.util.Callback;
/**
 *
 * @author haythem
 */
public  class DatePickerConverterDemo extends Application {
   
    
           public static Integer idaccepteur;
           
 
  Services.CRUD s = new Services.CRUD() {};
    // Factory to create Cell of DatePicker
    public Callback<DatePicker, DateCell> getDayCellFactory() {
 
        final Callback<DatePicker, DateCell> dayCellFactory = new Callback<DatePicker, DateCell>() {
 
            @Override
            public DateCell call(final DatePicker datePicker) {
                return new DateCell() {
                    @Override
                    public void updateItem(LocalDate item, boolean empty) {
                        super.updateItem(item, empty);
 
                        // Disable Monday, Tueday, Wednesday.
                         for (Rendez_vous r:s.afficheallrdv() )
                         {
                             if(r.getAccepteur_id() == idaccepteur && r.isValide() == true)
                             {
                                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                                String dateInString = r.getDate();

                                try {

                                    Date datee = formatter.parse(dateInString);
                                  
                                    
                                
                             LocalDate p = LocalDate.of(datee.getYear()+1900, datee.getMonth()+1, datee.getDate());
        
                             
                             if (p.getDayOfMonth() == item.getDayOfMonth() &&
                                     p.getMonth() == item.getMonth() &&
                                     p.getYear() == item.getYear()) {
                            setDisable(true);
                            setStyle("-fx-background-color: #ffc0cb;");
                        }

                                } catch (ParseException e) {
                                    e.printStackTrace();
                                }
                             
                                
                         }
                        }
                        
                    }
                };
            }
        };
        return dayCellFactory;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}