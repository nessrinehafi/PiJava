/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Service;
import Utils.Connexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import static sprintjavagui.User.LoginController.LoggedUser;

/**
 *
 * @author nouha
 */
public class ServiceServices {

    Connection conn = Connexion.getInstance().getConnexion();
    PreparedStatement ps;
    Statement s;

    public ServiceServices() {
        try {
            s = conn.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceServices.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void ajouter(Service se) {
        String query = "insert into services (title,description,createDt,adresseS,numtel,userservice,image,categorie,catservice) values(?,?,?,?,?,?,?,?,?)";
        java.util.Date date_util = new java.util.Date();
        java.sql.Date date_sql = new java.sql.Date(date_util.getTime());

        try {
            ps = conn.prepareStatement(query);
            // ps.setInt(1, se.getId());
            ps.setString(1, se.getTitle());
            ps.setString(2, se.getDescription());
            ps.setDate(3, date_sql);
            ps.setString(4, se.getAdresseS());
            ps.setInt(5, se.getNumtel());
            ps.setString(6, LoggedUser.getUsername());
            ps.setString(7, se.getImage());
            ps.setString(8, se.getCategorie());
            if (se.getCategorie().equals("Vétérinaires")) {
                ps.setString(9, "1");
            } else if (se.getCategorie().equals("Garde pour animaux")) {
                ps.setString(9, "3");
            } else {
                ps.setString(9, "2");
            }
            ps.executeUpdate();
            System.out.println("Service est ajoutée avec succés");
        } catch (SQLException ex) {
            Logger.getLogger(ServiceServices.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void supprimer(int id) {
        String query = "DELETE FROM services WHERE id = " + id + ";";

        try {
            ps = conn.prepareStatement(query);
            ps.executeUpdate();
            System.out.println("Service est supprimé");
        } catch (SQLException ex) {
            Logger.getLogger(ServiceServices.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public Service trouver(int id) {

        String query = "Select * from services where id = " + id + ";";
        Service se = new Service();

        try {
            ResultSet rs = s.executeQuery(query);
            while (rs.next()) {
                //se.setId(rs.getInt(1));
                se.setTitle(rs.getString(3));
                se.setDescription(rs.getString(4));
                se.setCreateDt(rs.getDate(8));
                se.setAdresseS(rs.getString(10));
                se.setNumtel(rs.getInt(11));
                se.setCatservice(rs.getInt(2));
                se.setUserservice(rs.getString(13));
                //se.setFavori(rs.getBoolean(9));
                se.setImage(rs.getString(12));
                se.setImage(rs.getString(14));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        return se;

    }

    public ObservableList<Service> afficheall() {
        ObservableList<Service> ls = FXCollections.observableArrayList();
        String query = "select * from services ";
        try {
            ResultSet rs = s.executeQuery(query);
            while (rs.next()) {
                Service se = new Service();
                se.setId(rs.getInt(1));
                se.setTitle(rs.getString(3));
                se.setDescription(rs.getString(4));
                se.setCreateDt(rs.getDate(8));
                se.setAdresseS(rs.getString(10));
                se.setNumtel(rs.getInt(11));
                se.setUserservice(rs.getString(13));
                se.setImage(rs.getString(12));
                se.setCategorie(rs.getString(14));
                se.setFavori(rs.getBoolean(9));

                ls.add(se);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ls;
    }

    public ObservableList<Service> afficheVet() {
        ObservableList<Service> ls = FXCollections.observableArrayList();
        String query = "select * from services where categorie='Vétérinaires'";
        //PreparedStatement st1 = conn.prepareStatement(query);
        //st1.setString(1,cat);
        try {
            ResultSet rs = s.executeQuery(query);
            while (rs.next()) {
                Service se = new Service();
                se.setId(rs.getInt(1));
                se.setTitle(rs.getString(3));
                se.setDescription(rs.getString(4));
                se.setCreateDt(rs.getDate(8));
                se.setAdresseS(rs.getString(10));
                se.setNumtel(rs.getInt(11));
                se.setUserservice(rs.getString(13));
                se.setImage(rs.getString(12));
                se.setCategorie(rs.getString(14));
                se.setFavori(rs.getBoolean(9));

                ls.add(se);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ls;
    }

    public ObservableList<Service> afficheEd() {
        ObservableList<Service> ls = FXCollections.observableArrayList();
        String query = "select * from services where categorie='Education Canine'";
        //PreparedStatement st1 = conn.prepareStatement(query);
        //st1.setString(1,cat);
        try {
            ResultSet rs = s.executeQuery(query);
            while (rs.next()) {
                Service se = new Service();
                se.setId(rs.getInt(1));
                se.setTitle(rs.getString(3));
                se.setDescription(rs.getString(4));
                se.setCreateDt(rs.getDate(8));
                se.setAdresseS(rs.getString(10));
                se.setNumtel(rs.getInt(11));
                se.setUserservice(rs.getString(13));
                se.setImage(rs.getString(12));
                se.setCategorie(rs.getString(14));
                se.setFavori(rs.getBoolean(9));

                ls.add(se);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ls;
    }

    public ObservableList<Service> affichePet() {
        ObservableList<Service> ls = FXCollections.observableArrayList();
        String query = "select * from services where categorie='Garde pour animaux'";
        //PreparedStatement st1 = conn.prepareStatement(query);
        //st1.setString(1,cat);
        try {
            ResultSet rs = s.executeQuery(query);
            while (rs.next()) {
                Service se = new Service();
                se.setId(rs.getInt(1));
                se.setTitle(rs.getString(3));
                se.setDescription(rs.getString(4));
                se.setCreateDt(rs.getDate(8));
                se.setAdresseS(rs.getString(10));
                se.setNumtel(rs.getInt(11));
                se.setUserservice(rs.getString(13));
                se.setImage(rs.getString(12));
                se.setCategorie(rs.getString(14));
                se.setFavori(rs.getBoolean(9));

                ls.add(se);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ls;
    }

    public ObservableList<Service> affichemesservices() {
        ObservableList<Service> ls = FXCollections.observableArrayList();
        String query = "select * from services where userservice='" + LoggedUser.getUsername() + "'";
        //PreparedStatement st1 = conn.prepareStatement(query);
        //st1.setString(1,cat);
        try {
            ResultSet rs = s.executeQuery(query);
            while (rs.next()) {
                Service se = new Service();
                se.setId(rs.getInt(1));
                se.setTitle(rs.getString(3));
                se.setDescription(rs.getString(4));
                se.setCreateDt(rs.getDate(8));
                se.setAdresseS(rs.getString(10));
                se.setNumtel(rs.getInt(11));
                se.setUserservice(rs.getString(13));
                se.setImage(rs.getString(12));
                se.setCategorie(rs.getString(14));
                se.setFavori(rs.getBoolean(9));

                ls.add(se);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ls;
    }

    public Service findbyId(int idd) throws SQLException {
        Service se = null;
        String req = "SELECT * FROM services where id=?";
        PreparedStatement st1 = conn.prepareStatement(req);
        st1.setString(1, String.valueOf(idd));
        ResultSet rs = st1.executeQuery();

        while (rs.next()) {

            se = new Service();
            se.setId(rs.getInt("id"));
            se.setTitle(rs.getString("title"));
            se.setDescription(rs.getString("description"));
            se.setCreateDt(rs.getDate("createDt"));
            se.setAdresseS(rs.getString("adresseS"));
            se.setNumtel(rs.getInt("numtel"));
            se.setUserservice(rs.getString("userservice"));
            se.setImage(rs.getString("image"));
            se.setCategorie(rs.getString("categorie"));
        }

        return se;
    }

    public void modifier(Service se, String title, String description, String adresseS, int numtel, String image, int id) throws SQLException {

        String query = "UPDATE services SET title=?,description=?,adresseS=?,numtel=?,image=? WHERE id =?";
        PreparedStatement st1 = conn.prepareStatement(query);

        st1.setString(1, title);
        st1.setString(2, description);
        st1.setString(3, adresseS);
        st1.setString(4, String.valueOf(numtel));
        st1.setString(5, image);
        st1.setString(6, String.valueOf(id));
        st1.executeUpdate();
        System.out.println("Service est mis à jour");

    }

    public void modifierfav(Boolean fav, int id) throws SQLException {

        String query = "UPDATE services SET favori=? WHERE id =?";
        PreparedStatement st1 = conn.prepareStatement(query);

        st1.setBoolean(1, fav);

        st1.setString(2, String.valueOf(id));

        st1.executeUpdate();
        System.out.println("Service est mis à jour");

    }

    //recherche service by Titre ,description,adresse,user,numtel
    public ObservableList<Service> RechercheService(String parameter) {
        ObservableList<Service> services = FXCollections.observableArrayList();

        String query = "Select * from services where title like '" + parameter + "%' or description like '" + parameter + "%' or adresseS like '" + parameter + "%' or userservice like'" + parameter + "%' or numtel like'" + parameter + "%' or categorie like'" + parameter + "%'";

        try {
            ResultSet rs = s.executeQuery(query);
            while (rs.next()) {
                //se.setId(rs.getInt(1));
//               Service e= new Service(rs.getString(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getString(5),rs.getString(6));
                Service se = new Service();
                se.setId(rs.getInt(1));
                se.setTitle(rs.getString(3));
                se.setDescription(rs.getString(4));
                se.setCreateDt(rs.getDate(8));
                se.setAdresseS(rs.getString(10));
                se.setNumtel(rs.getInt(11));
                se.setUserservice(rs.getString(13));
                se.setImage(rs.getString(12));
                se.setCategorie(rs.getString(14));
                se.setFavori(rs.getBoolean(9));
                services.add(se);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceServices.class.getName()).log(Level.SEVERE, null, ex);
        
        }
        return services;

    }

    public ObservableList<Service> meservicesfavs() {
        ObservableList<Service> ls = FXCollections.observableArrayList();
        String query = "select * from services where favori='1' and userservice='" + LoggedUser.getUsername() + "'";
        //PreparedStatement st1 = conn.prepareStatement(query);
        //st1.setString(1,cat);
        try {
            ResultSet rs = s.executeQuery(query);
            while (rs.next()) {
                Service se = new Service();
                se.setId(rs.getInt(1));
                se.setTitle(rs.getString(3));
                se.setDescription(rs.getString(4));
                se.setCreateDt(rs.getDate(8));
                se.setAdresseS(rs.getString(10));
                se.setNumtel(rs.getInt(11));
                se.setUserservice(rs.getString(13));
                se.setImage(rs.getString(12));
                se.setCategorie(rs.getString(14));
                se.setFavori(rs.getBoolean(9));

                ls.add(se);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ls;
    }

}
