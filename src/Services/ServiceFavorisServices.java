/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.ServiceFavoris;
import Utils.Connexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import static sprintjavagui.User.LoginController.LoggedUser;

/**
 *
 * @author nouha
 */
public class ServiceFavorisServices {

    Connection conn = Connexion.getInstance().getConnexion();
    PreparedStatement ps;
    Statement s;

    public ServiceFavorisServices() {
        try {
            s = conn.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceFavorisServices.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void ajouter(int id, String title, String description, String adresseS, int numtel, String username, String image, String categorie, String date, int catservice) {
        String query = "insert into favoris (id,title,description,adresseS,numtel,userservice,image,categorie,createDt,catservice) values(?,?,?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement st1 = conn.prepareStatement(query);
            st1.setInt(1, id);

            st1.setString(2, title);
            st1.setString(3, description);
            st1.setString(4, adresseS);
            st1.setInt(5, numtel);
            st1.setString(6, username);

            st1.setString(7, image);
            st1.setString(8, categorie);
            st1.setString(9, date);

            st1.setInt(10, catservice);
            st1.executeUpdate();
            System.out.println("Service est ajouté aux favoris");
        } catch (SQLException ex) {
            Logger.getLogger(ServiceFavorisServices.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void supprimer(int id) {
        String query = "DELETE FROM favoris WHERE id = " + id + ";";

        try {
            ps = conn.prepareStatement(query);
            ps.executeUpdate();
            System.out.println("Service est supprimé des favoris");
        } catch (SQLException ex) {
            Logger.getLogger(ServiceFavorisServices.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public ObservableList<ServiceFavoris> afficheall() {
        ObservableList<ServiceFavoris> ls = FXCollections.observableArrayList();
        String query = "select * from favoris where userservice='" + LoggedUser.getUsername() + "'";
        //PreparedStatement st1 = conn.prepareStatement(query);
        //st1.setString(1,cat);
        try {
            ResultSet rs = s.executeQuery(query);
            while (rs.next()) {
                ServiceFavoris se = new ServiceFavoris();
                se.setId(rs.getInt(1));
                se.setTitle(rs.getString(3));
                se.setDescription(rs.getString(4));
                se.setCreateDt(rs.getDate(8));
                se.setAdresseS(rs.getString(10));
                se.setNumtel(rs.getInt(11));
                se.setUserservice(rs.getString(13));
                se.setImage(rs.getString(12));
                se.setCategorie(rs.getString(14));
                ls.add(se);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceFavorisServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ls;
    }

    public Boolean EstFav(int id) throws SQLException {
        ServiceFavoris se = null;

        String query = "SELECT * FROM favoris where where id=?";
        PreparedStatement st = conn.prepareStatement(query);
        st.setInt(1, id);
        ResultSet rs = st.executeQuery();

        while (rs.next()) {

            se = new ServiceFavoris();
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

        if (se != null) {
            return true;
        } else {
            return false;
        }
    }

    public ServiceFavoris findbyIdfav(int idd) throws SQLException {
        ServiceFavoris se = null;
        String req = "SELECT * FROM favoris where id=?";
        PreparedStatement st1 = conn.prepareStatement(req);
        st1.setString(1, String.valueOf(idd));
        ResultSet rs = st1.executeQuery();

        while (rs.next()) {

            se = new ServiceFavoris();
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
    
    public void modifier(Boolean fav, int id) throws SQLException {

        String query = "UPDATE favoris SET favori=? WHERE id =?";
        PreparedStatement st1 = conn.prepareStatement(query);

        st1.setBoolean(1, fav);

        st1.setString(2, String.valueOf(id));
                st1.executeUpdate();

            System.out.println("Service est mis à jour");

        

    }
}
