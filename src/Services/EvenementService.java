/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import DataStorage.MyDB;
import Entities.Evenement;
import Entities.User;
import IServices.IEvenement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import static sprintjavagui.User.LoginController.LoggedUser;
import utils.Sms;
import utils.SMSAnnulerEvenement;

/**
 *
 * @author Asus
 */
public class EvenementService implements IEvenement {

    Connection conn;
    private ObservableList<Evenement> data;

    public EvenementService() {
        this.conn = MyDB.getInstance().getConnexion();
    }

    @Override
    public void ajouterEvenement(Evenement e) {

        String sql = "Insert into evenement (nom,description,type,HeureDebut,HeureFin,latitute,longitude,nbrpalacedispo"
                + ",monImage) values ('" + e.getNom() + "','" + e.getDescription() + "','"
                + e.getType() + "','" + e.getHeureDebut() + "','" + e.getHeureFin() + "'," + e.getLatitute() + ","
                + e.getLongitude() + "," + e.getNbrpalacedispo() + ",'" + e.getMonImage() + "');";
        try {
            System.out.println(sql);
            Statement stl = conn.createStatement();
            stl.executeUpdate(sql);
            System.out.println("Add Done");
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Ajout évenement confirmation");
            alert.setHeaderText(null);
            alert.setContentText("Evénement ajouté!");
            alert.showAndWait();

        } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
            System.err.println("SQLState: " + ex.getSQLState());
            System.err.println("VendorError: " + ex.getErrorCode());
        }
    }

    @Override
    public void supprimerEvenement(Evenement e) {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Alerte suppression");
        alert.setHeaderText("Suppression d'un évènement");
        alert.setContentText("Êtes-vous sûr(e) de vouloir supprimer?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            try {
                String sql = "DELETE FROM evenement  WHERE id=" + e.getId() + ";";
                Statement stl = conn.createStatement();
                stl.executeUpdate(sql);
                SMSAnnulerEvenement.send(e);
                Alert alert7 = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("confirmation");
                alert.setHeaderText(null);
                alert.setContentText("Evenement supprimé!");
                alert.showAndWait();
                System.out.println("Delete Evenement Done");
            } catch (SQLException ex) {
                System.out.println("SQLException: " + ex.getMessage());
                System.out.println("SQLState: " + ex.getSQLState());
                System.out.println("VendorError: " + ex.getErrorCode());
            }
        }
    }

    @Override
    public void modifierEvenement(Evenement e) {
        String sql = "UPDATE evenement SET HeureDebut = '" + e.getHeureDebut() + "',HeureFin = '"
                + e.getHeureFin() + "',description = '" + e.getDescription() + "',nbrpalacedispo ="
                + e.getNbrpalacedispo() + ",type = '" + e.getType() + "',nom = '" + e.getNom() + "',monimage ='" + e.getMonImage() + "'"
                + "WHERE id =" + e.getId() + ";";
        try {
            Statement stl = conn.createStatement();
            stl.executeUpdate(sql);
            Sms.send(e);
            System.out.println("Update Evenement done");
        } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
            System.err.println("SQLState: " + ex.getSQLState());
            System.err.println("VendorError: " + ex.getErrorCode());
        }
    }

    public List<Evenement> afficherToutEvenements() {
        List<Evenement> ListEvent = new ArrayList<Evenement>();
        ResultSet rs;
        try {
            String sql2 = "SELECT *FROM evenement ";
            Statement st2 = conn.createStatement();
            ResultSet rs2 = st2.executeQuery(sql2);
            System.out.println("Affichage Done");

            while (rs2.next()) {
                Evenement event = new Evenement();
                event.setId(rs2.getInt("id"));
                event.setDescription(rs2.getString("description"));
                event.setNom(rs2.getString("nom"));
                event.setHeureDebut(rs2.getTimestamp("HeureDebut").toLocalDateTime());
                event.setHeureFin(rs2.getTimestamp("HeureFin").toLocalDateTime());
                event.setMonImage(rs2.getString("monImage"));
                event.setType(rs2.getString("type"));
                event.setLatitute(rs2.getDouble("latitute"));
                event.setLongitude(rs2.getDouble("longitude"));
                event.setNbrpalacedispo(rs2.getInt("nbrpalacedispo"));

                ListEvent.add(event);
                System.out.println(event.toString());
            }
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }

        return ListEvent;

    }

    public List<String> EvenementsByName() {
        List<String> ListEvent = new ArrayList<String>();
        try {
            String sql2 = "SELECT * FROM evenement ;";
            Statement st2 = conn.createStatement();
            ResultSet rs2 = st2.executeQuery(sql2);
            System.out.println("Affichage Done");

            while (rs2.next()) {
                Evenement event = new Evenement();
                event.setId(rs2.getInt("id"));
                event.setDescription(rs2.getString("description"));
                event.setNom(rs2.getString("nom"));
                event.setHeureDebut(rs2.getTimestamp("HeureDebut").toLocalDateTime());
                event.setHeureFin(rs2.getTimestamp("HeureFin").toLocalDateTime());
                event.setMonImage(rs2.getString("monImage"));
                event.setType(rs2.getString("type"));
                event.setLatitute(rs2.getDouble("latitute"));
                event.setLongitude(rs2.getDouble("longitude"));
                event.setNbrpalacedispo(rs2.getInt("nbrpalacedispo"));

                ListEvent.add(event.getNom());
                System.out.println(event.toString());
            }
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }

        return ListEvent;

    }

    public List<Evenement> SearchEvenementsByName(String nom) {
        List<Evenement> ListEvent = new ArrayList<Evenement>();
        try {
            String sql2 = "SELECT * FROM evenement where nom LIKE '%" + nom + "%' ;";
            Statement st2 = conn.createStatement();
            ResultSet rs2 = st2.executeQuery(sql2);
            System.out.println("Affichage Done");

            while (rs2.next()) {
                Evenement event = new Evenement();
                event.setId(rs2.getInt("id"));
                event.setDescription(rs2.getString("description"));
                event.setNom(rs2.getString("nom"));
                event.setHeureDebut(rs2.getTimestamp("HeureDebut").toLocalDateTime());
                event.setHeureFin(rs2.getTimestamp("HeureFin").toLocalDateTime());
                event.setMonImage(rs2.getString("monImage"));
                event.setType(rs2.getString("type"));
                event.setLatitute(rs2.getDouble("latitute"));
                event.setLongitude(rs2.getDouble("longitude"));
                event.setNbrpalacedispo(rs2.getInt("nbrpalacedispo"));

                ListEvent.add(event);
                System.out.println(event.toString());
            }
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }

        return ListEvent;

    }

    public List<Evenement> afficherMesEvenement() {
        List<Evenement> ListEvent = new ArrayList<Evenement>();
        try {
            String sql2 = "SELECT * FROM evenement e inner join reservation r on e.id = r.idevenement"
                    + " WHERE r.idinvite = " + LoggedUser.getId() + " ORDER BY e.HeureDebut DESC ;";
            Statement st2 = conn.createStatement();
            ResultSet rs2 = st2.executeQuery(sql2);
            System.out.println("Affichage Done");

            while (rs2.next()) {
                Evenement event = new Evenement();
                event.setId(rs2.getInt("id"));
                event.setDescription(rs2.getString("description"));
                event.setNom(rs2.getString("nom"));
                event.setHeureDebut(rs2.getTimestamp("HeureDebut").toLocalDateTime());
                event.setHeureFin(rs2.getTimestamp("HeureFin").toLocalDateTime());
                event.setMonImage(rs2.getString("monImage"));
                event.setType(rs2.getString("type"));
                event.setLatitute(rs2.getDouble("latitute"));
                event.setLongitude(rs2.getDouble("longitude"));
                event.setNbrpalacedispo(rs2.getInt("nbrpalacedispo"));

                ListEvent.add(event);
                System.out.println(event.toString());
            }
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }

        return ListEvent;
    }

    public int getNbtotal() {
        try {
            String sql2 = "SELECT count(*) as nbtotal FROM evenement ";
            Statement st2 = conn.createStatement();
            ResultSet rs2 = st2.executeQuery(sql2);
            System.out.println("Affichage Done");

            while (rs2.next()) {
                return rs2.getInt("nbtotal");
            }
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        return 0;
    }

    public int getEventpasse() {
        try {
            String sql2 = "SELECT count(*) as nbtotal FROM evenement where HeureDebut < '"+LocalDateTime.now()+"';";
            Statement st2 = conn.createStatement();
            ResultSet rs2 = st2.executeQuery(sql2);
            System.out.println("Affichage Done");

            while (rs2.next()) {
                return rs2.getInt("nbtotal");
            }
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        return 0;
    }
     public int getEventprohain() {
        try {
            String sql2 = "SELECT count(*) as nbtotal FROM evenement where HeureDebut > '"+LocalDateTime.now()+"';";
            System.out.println(sql2);
            Statement st2 = conn.createStatement();
            ResultSet rs2 = st2.executeQuery(sql2);
            System.out.println("Affichage Done");

            while (rs2.next()) {
                return rs2.getInt("nbtotal");
            }
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        return 0;
    }

    public int getTodayEvent() {
try {
            String sql2 = "SELECT count(*) as nbtotal FROM evenement where HeureDebut = '"+LocalDate.now()+"';";
            Statement st2 = conn.createStatement();
            ResultSet rs2 = st2.executeQuery(sql2);
            System.out.println("Affichage Done");

            while (rs2.next()) {
                return rs2.getInt("nbtotal");
            }
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        return 0;    }

    public int getWeekevent() {
try {
            String sql2 = "SELECT count(*) as nbtotal FROM evenement where HeureDebut < '"+LocalDateTime.now().plusDays(7)+"';";
            Statement st2 = conn.createStatement();
            ResultSet rs2 = st2.executeQuery(sql2);
            System.out.println("Affichage Done");

            while (rs2.next()) {
                return rs2.getInt("nbtotal");
            }
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        return 0;    }

    public int getmounthEvent() {
try {
            String sql2 = "SELECT count(*) as nbtotal FROM evenement where HeureDebut < '"+LocalDateTime.now().plusDays(30)+"';";
            Statement st2 = conn.createStatement();
            ResultSet rs2 = st2.executeQuery(sql2);
            System.out.println("Affichage Done");

            while (rs2.next()) {
                return rs2.getInt("nbtotal");
            }
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        return 0;    }
    
    public Map<String,Integer> getStat() {
        Map<String,Integer> map = new HashMap<String, Integer>();
try {
            
            String sql2 = "SELECT type ,COUNT(*) as nb FROM evenement GROUP BY type ;";
            Statement st2 = conn.createStatement();
            ResultSet rs2 = st2.executeQuery(sql2);
            System.out.println("Affichage Done");

            while (rs2.next()) {
                map.put(rs2.getString("type"),rs2.getInt("nb"));
            }
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        return map ;
    }
     public List<Evenement> notif() {
        List<Evenement> notif = new ArrayList<Evenement>();
        ResultSet rs;
        try {
            String sql2 = "SELECT * FROM evenement ';";
            Statement st2 = conn.createStatement();
            ResultSet rs2 = st2.executeQuery(sql2);
            System.out.println("Affichage Done");

            while (rs2.next()) {
                Evenement event = new Evenement();
                event.setId(rs2.getInt("id"));
                event.setDescription(rs2.getString("description"));
                event.setNom(rs2.getString("nom"));
                event.setHeureDebut(rs2.getTimestamp("HeureDebut").toLocalDateTime());
                event.setHeureFin(rs2.getTimestamp("HeureFin").toLocalDateTime());
                event.setMonImage(rs2.getString("monImage"));
                event.setType(rs2.getString("type"));
                event.setLatitute(rs2.getDouble("latitute"));
                event.setLongitude(rs2.getDouble("longitude"));
                event.setNbrpalacedispo(rs2.getInt("nbrpalacedispo"));

                notif.add(event);
                System.out.println(event.toString());
            }
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }

        return notif;

    }

}
