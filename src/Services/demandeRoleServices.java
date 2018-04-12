/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.DemandeRole;
import Entities.User;
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
public class demandeRoleServices {

    Connection conn = Connexion.getInstance().getConnexion();
    PreparedStatement ps;
    Statement s;
    public ResultSet res;

    public demandeRoleServices() {
        try {
            s = conn.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(UserServices.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void ajouter(DemandeRole dr) {
        String query = "insert into demandeRole (nvrole,demandeur,dateDemande,demande,document,estvalide) values(?,?,?,?,?,?)";
        java.util.Date date_util = new java.util.Date();
        java.sql.Date date_sql = new java.sql.Date(date_util.getTime());
        try {
            ps = conn.prepareStatement(query);
            ps.setString(1, dr.getNvrole());
            ps.setString(2, LoggedUser.getUsername());
            ps.setDate(3, date_sql);
            ps.setString(4, dr.getDemande());
            ps.setString(5, dr.getDocument());
            ps.setInt(6, 0);
            ps.executeUpdate();
            System.out.println("Demande envoyé");
        } catch (SQLException ex) {
            Logger.getLogger(demandeRoleServices.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void supprimer(int id) {
        String query = "DELETE FROM demanderole WHERE id = " + id + ";";

        try {
            ps = conn.prepareStatement(query);
            ps.executeUpdate();
            System.out.println("demande supprimé");
        } catch (SQLException ex) {
            Logger.getLogger(demandeRoleServices.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public ObservableList<DemandeRole> afficheall() {
        ObservableList<DemandeRole> ls = FXCollections.observableArrayList();
        String query = "select * from demanderole ";
        try {
            ResultSet rs = s.executeQuery(query);
            while (rs.next()) {
                DemandeRole se = new DemandeRole();
                se.setId(rs.getInt(1));
                se.setNvrole(rs.getString(2));
                se.setDemandeur(rs.getString(3));
                se.setDateDemande(rs.getDate(4));
                se.setDemande(rs.getString(5));
                se.setDocument(rs.getString(6));
                se.setEstvalide(rs.getBoolean(7));
                ls.add(se);
            }
        } catch (SQLException ex) {
            Logger.getLogger(demandeRoleServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ls;
    }

    /*public DemandeRole findbyUsername(String usernamee) throws SQLException {

     DemandeRole dr = null;
     String req = "SELECT * FROM DemandeRole where username=?";
     PreparedStatement st1 = conn.prepareStatement(req);
     st1.setString(1, usernamee);
     ResultSet rs = st1.executeQuery();

     while (rs.next()) {
     dr = new DemandeRole();
     dr.setId(rs.getInt("id"));
     dr.setDemandeur(rs.getString("demandeur"));
     dr.setNvrole(rs.getString("nvrole"));
     dr.setDemande(rs.getString("demande"));
     dr.setDocument(rs.getString("document"));
     }

     return dr;
     }*/
    public void valider(String usernamee) throws SQLException {
        String req = "SELECT nvrole FROM demanderole where demandeur=?";
        PreparedStatement st1 = conn.prepareStatement(req);
        st1.setString(1, usernamee);
        ResultSet rs = st1.executeQuery();
        while (rs.next()) {
            String requete = "UPDATE user SET role='" + rs.getString("nvrole") + "' WHERE username=?";
            PreparedStatement st = conn.prepareStatement(requete);
            st.setString(1, usernamee);
            st.executeUpdate();
            System.out.println("role validé");
            String query = "SELECT role FROM user where username=?";
            PreparedStatement st3 = conn.prepareStatement(query);
            st3.setString(1, usernamee);
            ResultSet rss = st3.executeQuery();
            while (rss.next()) {
            if ("Vétérinaire".equals(rss.getString("role"))) {
                    String requ = "UPDATE user SET roles=? WHERE username=?";
                    PreparedStatement st4 = conn.prepareStatement(requ);
                    st4.setString(1, "a:1:{i:0;s:8:\"ROLE_VET\";}");
                    st4.setString(2, usernamee);
                    st4.executeUpdate();
                    System.out.println("roles validé");
                }
                else{
                    String reque = "UPDATE user SET roles=? WHERE username=?";
                    PreparedStatement st5 = conn.prepareStatement(reque);
                    st5.setString(1, "a:1:{i:0;s:8:\"ROLE_DRE\";}");
                    st5.setString(2, usernamee);
                    st5.executeUpdate();
                    System.out.println("roles validé");
                }
            }
        }
    }
}

    
    