/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.User;
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
import org.mindrot.jbcrypt.BCrypt;
import static sprintjavagui.User.LoginController.LoggedUser;

/**
 *
 * @author nouha
 */
public class UserServices {

    Connection conn = Connexion.getInstance().getConnexion();
    PreparedStatement ps;
    Statement s;
    public ResultSet res;

    public UserServices() {
        try {
            s = conn.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(UserServices.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void ajouter(User u) {

        String pw_hash = BCrypt.hashpw(u.getPassword(), BCrypt.gensalt());

        String query = "insert into User (username,username_canonical,email,email_canonical,enabled,password,last_login,roles,nom,prenom,numtel,Datenaiss,adresse,image,role) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        java.util.Date date_util = new java.util.Date();
        java.sql.Date date_sql = new java.sql.Date(date_util.getTime());
        try {
            ps = conn.prepareStatement(query);
            // ps.setInt(1, se.getId());
            ps.setString(1, u.getUsername());
            ps.setString(2, u.getUsername().toLowerCase());
            ps.setString(3, u.getEmail());
            ps.setString(4, u.getEmail().toLowerCase());
            ps.setBoolean(5, true);
            ps.setString(6, pw_hash);
            ps.setDate(7, date_sql);
            ps.setString(8, "a:1:{i:0;s:9:\"ROLE_USER\";}");
            ps.setString(9, u.getNom());
            ps.setString(10, u.getPrenom());
            ps.setInt(11, u.getNumtel());
            ps.setString(12, u.getDatenaiss());
            ps.setString(13, u.getAdresse());
            ps.setString(14, u.getImage());
            ps.setString(15, "utilisateur simple");
            ps.executeUpdate();
            System.out.println("User est ajoutée avec succés");
        } catch (SQLException ex) {
            Logger.getLogger(UserServices.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    /*public User login(User u) {
     List<User> l = new ArrayList<>();
     try {
     String rq = "select * from User where username= '" + u.getUsername() + "' and password='" + u.getPassword() + "'";
     s = conn.createStatement();
     res = s.executeQuery(rq);


     while (res.next()) {
     l.add(new User(res.getString("nom"), res.getString("prenom"), res.getString("email"), res.getString("adresse"),res.getString("username"), res.getString("password"), res.getInt("numtel"), res.getInt("id"), res.getDate(6),res.getString("datenaiss")),res.getString("image"));
     }
     } catch (SQLException ex) {
     Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
     }
     if (!l.isEmpty()) {
     return l.get(0);
     } else {
     u.setId(-1);
     return u;
     }
     }
     */

    public boolean CanLog(String pseudo, String password) throws SQLException {
        User user = null;
        String req = "SELECT (password) FROM user where (username_canonical=? OR email_canonical=?)";
        PreparedStatement st1 = conn.prepareStatement(req);
        st1.setString(1, pseudo.toLowerCase());
        st1.setString(2, pseudo.toLowerCase());
        ResultSet rs1 = st1.executeQuery();
        while (rs1.next()) {
            if (BCrypt.checkpw(password, "$2a$" + rs1.getString("password").substring(4, rs1.getString("password").length()))) {
                String requete = "SELECT * FROM user where (username_canonical=? OR email_canonical=?)";
                PreparedStatement st = conn.prepareStatement(requete);
                st.setString(1, pseudo.toLowerCase());
                st.setString(2, pseudo.toLowerCase());

                ResultSet rs = st.executeQuery();
                while (rs.next()) {
                    user = new User();
                    user.setId(rs.getInt("id"));
                    user.setUsername(rs.getString("username"));
                    user.setUsername_canonical(rs.getString("username_canonical"));
                    user.setEmail(rs.getString("email"));
                    user.setEmail_canonical(rs.getString("email_canonical"));
                    user.setPassword(rs.getString("password"));
                    user.setNom(rs.getString("nom"));
                    user.setPrenom(rs.getString("Prenom"));
                    user.setNumtel(rs.getInt("numtel"));
                    user.setAdresse(rs.getString("adresse"));
                    user.setImage(rs.getString("image"));
                    user.setRole(rs.getString("role"));
                    System.out.println("User found");
                    return true;
                }
            }
        }
        return false;
    }

    public int findByLogPass(String pseudo, String password) throws SQLException {
        int i = 0;

        String req = "SELECT (password) FROM user where (username_canonical=? OR email_canonical=?)";
        PreparedStatement st1 = conn.prepareStatement(req);
        st1.setString(1, pseudo.toLowerCase());
        st1.setString(2, pseudo.toLowerCase());
        ResultSet rs1 = st1.executeQuery();
        while (rs1.next()) {
            if (BCrypt.checkpw(password, "$2a$" + rs1.getString("password").substring(4, rs1.getString("password").length()))) {
                String requete = "SELECT * FROM user where (username_canonical=? OR email_canonical=?)";
                PreparedStatement st = conn.prepareStatement(requete);
                st.setString(1, pseudo.toLowerCase());
                st.setString(2, pseudo.toLowerCase());

                ResultSet rs = st.executeQuery();
                while (rs.next()) {
                    i = rs.getInt("id");
                }
            }
        }
        return i;

    }

    public User searchUserByEmail(String pseudo, String password) throws SQLException {
        User user = null;
        String req = "SELECT (password) FROM user where (username_canonical=? OR email_canonical=?)";
        PreparedStatement st1 = conn.prepareStatement(req);
        st1.setString(1, pseudo.toLowerCase());
        st1.setString(2, pseudo.toLowerCase());
        ResultSet rs1 = st1.executeQuery();
        while (rs1.next()) {
            if (BCrypt.checkpw(password, "$2a$" + rs1.getString("password").substring(4, rs1.getString("password").length()))) {
                String requete = "SELECT * FROM user where (username_canonical=? OR email_canonical=?)";
                PreparedStatement st = conn.prepareStatement(requete);
                st.setString(1, pseudo.toLowerCase());
                st.setString(2, pseudo.toLowerCase());

                ResultSet rs = st.executeQuery();
                while (rs.next()) {
                    user = new User();
                    user.setId(rs.getInt("id"));
                    user.setUsername(rs.getString("username"));
                    user.setUsername_canonical(rs.getString("username_canonical"));
                    user.setEmail(rs.getString("email"));
                    user.setEmail_canonical(rs.getString("email_canonical"));
                    user.setPassword(rs.getString("password"));
                    user.setNom(rs.getString("nom"));
                    user.setPrenom(rs.getString("Prenom"));
                    user.setNumtel(rs.getInt("numtel"));
                    user.setAdresse(rs.getString("adresse"));
                    user.setImage(rs.getString("image"));
                    user.setRole(rs.getString("role"));
                    System.out.println("User found");
                }
            } else {
                System.out.println("no");
            }
        }

        return user;
    }

    public void listpass() throws SQLException {
        String requete = "SELECT * FROM user";
        PreparedStatement st = conn.prepareStatement(requete);
        ResultSet rs = st.executeQuery();
        while (rs.next()) {
            System.out.println(rs.getString("password"));
        }

    }

    public ObservableList<User> afficheall() {
        ObservableList<User> ls = FXCollections.observableArrayList();
        String query = "select * from user ";
        try {
            ResultSet rs = s.executeQuery(query);
            while (rs.next()) {
                User se = new User();
                se.setId(rs.getInt(1));
                se.setUsername(rs.getString(2));
                se.setEmail(rs.getString(4));
                se.setNom(rs.getString(13));
                se.setPrenom(rs.getString(14));
                se.setNumtel(rs.getInt(15));
                se.setDatenaiss(rs.getString(16));
                se.setAdresse(rs.getString(17));
                se.setImage(rs.getString(18));
                se.setRole(rs.getString(19));
                ls.add(se);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ls;
    }

    public User afficheMonprofil() throws SQLException {
        User user = null;
        String query = "select * from user where username='" + LoggedUser.getUsername() + "'";
        ResultSet rs = s.executeQuery(query);
        while (rs.next()) {
            user = new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setUsername_canonical(rs.getString("username_canonical"));
            user.setEmail(rs.getString("email"));
            user.setEmail_canonical(rs.getString("email_canonical"));
            user.setPassword(rs.getString("password"));
            user.setNom(rs.getString("nom"));
            user.setPrenom(rs.getString("Prenom"));
            user.setNumtel(rs.getInt("numtel"));
            user.setAdresse(rs.getString("adresse"));
            user.setImage(rs.getString("image"));
            user.setRole(rs.getString("role"));
            user.setDatenaiss(rs.getString("Datenaiss"));
        }
        return user;
    }

    public User findbyUsername(String usernamee) throws SQLException {

        User user = null;
        String req = "SELECT * FROM user where username=?";
        PreparedStatement st1 = conn.prepareStatement(req);
        st1.setString(1, usernamee);
        ResultSet rs = st1.executeQuery();

        while (rs.next()) {
            user = new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setUsername_canonical(rs.getString("username_canonical"));
            user.setEmail(rs.getString("email"));
            user.setEmail_canonical(rs.getString("email_canonical"));
            user.setPassword(rs.getString("password"));
            user.setNom(rs.getString("nom"));
            user.setPrenom(rs.getString("Prenom"));
            user.setNumtel(rs.getInt("numtel"));
            user.setAdresse(rs.getString("adresse"));
            user.setImage(rs.getString("image"));
            user.setRole(rs.getString("role"));
        }

        return user;
    }

    /*public void validerRole(User u, String usernamee) {
     String query = "UPDATE User SET role=?,roles=? WHERE username='" + usernamee + "'";
     try {
     ps = conn.prepareStatement(query);
     ps.setString(1, u.getRole());
     ps.setString(2, u.getRoles());
     ps.executeUpdate();
     } catch (SQLException ex) {
     Logger.getLogger(UserServices.class.getName()).log(Level.SEVERE, null, ex);
     }

     }
     */
    public void enableaccount(Boolean enabled) throws SQLException {
        String query = "UPDATE user SET enabled=? WHERE username='" + LoggedUser.getUsername() + "'";
        PreparedStatement st1 = conn.prepareStatement(query);

        st1.setBoolean(1, enabled);
        st1.executeUpdate();
        System.out.println("User est desactivé avec succés");
    }

    public void modifier(User u,String username, String nom, String prenom, int numtel, String adresse, String image, String email, String datenaiss, int id) throws SQLException {

        String query = "UPDATE user SET username=?,username_canonical=?,email=?,email_canonical=?,nom=?,prenom=?,numtel=?,Datenaiss=?,adresse=?,image=? WHERE id =?";
        PreparedStatement st1 = conn.prepareStatement(query);
        st1.setString(1, username);
        st1.setString(2, username.toLowerCase());
        st1.setString(3, email);
        st1.setString(4, email.toLowerCase());

        st1.setString(5, nom);
        st1.setString(6, prenom);
        st1.setString(7, String.valueOf(numtel));
        st1.setString(8, datenaiss);

        st1.setString(9, adresse);

        st1.setString(10, image);

        st1.setString(11, String.valueOf(id));
        st1.executeUpdate();
        System.out.println("User est mis à jour");

    }
    
    public String Role() throws SQLException {

        String role = null;
        String req = "SELECT role FROM user where id='" + LoggedUser.getId()+ "'";
        PreparedStatement st1 = conn.prepareStatement(req);
        ResultSet rs = st1.executeQuery();

        while (rs.next()) {
            role=rs.getString("role");
        }

        return role;
    }
}
