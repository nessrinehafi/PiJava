/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import DataStorage.MyDB;
import Entities.Evenement;
import Entities.Reservation;
import IServices.IReservation;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import static sprintjavagui.User.LoginController.LoggedUser;

/**
 *
 * @author Asus
 */
public class ReservationService implements IReservation {

    Connection conn;
    private ObservableList<Evenement> data;

    public ReservationService() {
        this.conn = MyDB.getInstance().getConnexion();
    }

    @Override
    public void reserver(Reservation r) {
        try {
            String sql = "Insert into reservation(idinvite,idevenement) values (" + LoggedUser.getId() + ","
                    + r.getEvent().getId() + ") ;";
            String sqls = "select * from evenement where id=" + r.getEvent().getId() + ";";

            Statement stl2 = conn.createStatement();
            ResultSet rs = stl2.executeQuery(sqls);
            rs.next();
            String sqlupdate = "UPDATE evenement SET nbrpalacedispo =" + (rs.getInt("nbrpalacedispo") - 1) + " "
                    + "where id =" + r.getEvent().getId() + ";";
            Statement stl3 = conn.createStatement();
            stl3.executeUpdate(sqlupdate);
            System.out.println(sql);
            Statement stl = conn.createStatement();
            stl.executeUpdate(sql);
            System.out.println("Reservation Done");
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Reservation confirmation");
            alert.setHeaderText(null);
            alert.setContentText("Reservation  succes!");
            alert.showAndWait();
        } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
            System.err.println("SQLState: " + ex.getSQLState());
            System.err.println("VendorError: " + ex.getErrorCode());
        }
    }

    @Override
    public void annulerReservation(Reservation r) {
        try {
            String sqls = "select * from evenement where id=" + r.getEvent().getId() + ";";

            Statement stl2 = conn.createStatement();
            ResultSet rs2 = stl2.executeQuery(sqls);
            rs2.next();
            String sqlupdate = "UPDATE evenement SET nbrpalacedispo =" + (rs2.getInt("nbrpalacedispo") + 1) + " "
                    + "where id =" + r.getEvent().getId() + ";";
            Statement stl3 = conn.createStatement();
            stl3.executeUpdate(sqlupdate);
            String sql = "select * from reservation where  (idinvite = " + LoggedUser.getId() + " ) AND ( idevenement = " + r.getEvent().getId() + ");";
            Statement stl = conn.createStatement();
            ResultSet rs = stl.executeQuery(sql);
            rs.next();
            String sql1 = "delete from reservation where id =" + rs.getInt("id");
            Statement stl1 = conn.createStatement();
            stl1.executeUpdate(sql1);
            System.out.println("Reservation Annullé");
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Reservation Annulation");
            alert.setHeaderText(null);
            alert.setContentText("Reservation  Annullé!");
            alert.showAndWait();

        } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
            System.err.println("SQLState: " + ex.getSQLState());
            System.err.println("VendorError: " + ex.getErrorCode());
        }
    }

    @Override
    public boolean VerfierReservation(Reservation r) {
        try {
            String sql = "select * from reservation where ( idinvite =" + LoggedUser.getId() + " ) AND  (idevenement =" + r.getEvent().getId() + ");";
            Statement stl = conn.createStatement();
            ResultSet rs = stl.executeQuery(sql);
            if (rs.next()) {
                return true;
            }
        } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
            System.err.println("SQLState: " + ex.getSQLState());
            System.err.println("VendorError: " + ex.getErrorCode());
        }
        return false;
    }

}
