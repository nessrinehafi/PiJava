package Services;

import Utils.Connexion;
import Entities.Reclamation;
import Entities.User;
import Utils.CategoryType;
import Utils.StatutType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import static sprintjavagui.User.LoginController.LoggedUser;

/**
 *
 * @author Mega pc
 */
public class ReclamationServices {
    
    private Connexion con;

    public ReclamationServices() {
        con = Connexion.getInstance();
    }

    public int insert(Reclamation reclamation) {
        try {
            PreparedStatement ps = con.getConnexion().prepareStatement("INSERT INTO `reclamation`(`categorie`, `date_creation`, `titre`, `description`, `reponse`, `statut`, `user`) VALUES (?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, reclamation.getCategorie().name());
            ps.setDate(2, reclamation.getDateCreation());
            ps.setString(3, reclamation.getTitre());
            ps.setString(4, reclamation.getDescription());
            ps.setString(5, reclamation.getReponse());
            ps.setString(6, reclamation.getStatut().name());
            ps.setInt(7, reclamation.getUser().getId());

            
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            int id = rs.getInt(1);

            return id;

        } catch (SQLException ex) {
            Logger.getLogger(ReclamationServices.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }

    public Reclamation getById(int id) {
        try {
            PreparedStatement ps = con.getConnexion().prepareStatement("SELECT * FROM `reclamation` WHERE id=?");

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.first()) {
                if (rs.wasNull()) {
                    return new Reclamation();
                } else {
                    //TODO: GET DYNAMIC USER
                    User user = new User();
                    return new Reclamation(rs.getInt("id"), CategoryType.valueOf(rs.getString("categorie")), rs.getDate("date_creation"), rs.getString("titre"), rs.getString("description") , rs.getString("reponse"), StatutType.valueOf(rs.getString("statut")),user);
                }
            } else {
                return null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReclamationServices.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public boolean delete(int id) {
        try {
            PreparedStatement ps = con.getConnexion().prepareStatement("DELETE FROM reclamation WHERE id = ?");
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(ReclamationServices.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    
    public boolean update(Reclamation reclamation) {
        try {
            PreparedStatement ps = con.getConnexion().prepareStatement("UPDATE `reclamation` SET `categorie`=?,`date_creation`=?,`titre`=?,`description`=?,`reponse`=?,`statut`=? WHERE id = ?");
            ps.setString(1, reclamation.getCategorie().name());
            ps.setDate(2, reclamation.getDateCreation());
            ps.setString(3, reclamation.getTitre());
            ps.setString(4, reclamation.getDescription());
            ps.setString(5, reclamation.getReponse());
            ps.setString(6, reclamation.getStatut().name());
            ps.setInt(7, reclamation.getId());

            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(ReclamationServices.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public List<Reclamation>getAll() {
     List<Reclamation> reclamationList = new ArrayList<>();
        try {
            PreparedStatement ps = con.getConnexion().prepareStatement("SELECT * FROM Reclamation");
            ResultSet rs = ps.executeQuery();
            
            if (rs.first()) {
                do {                    
                    User user = new User();
                    user.setId(LoggedUser.getId());
                    user.setNom(user.getNom());
                    reclamationList.add(new Reclamation(rs.getInt("id"), CategoryType.valueOf(rs.getString("categorie")), rs.getDate("date_creation"), rs.getString("titre"), rs.getString("description") , rs.getString("reponse"), StatutType.valueOf(rs.getString("statut")),user));
                } while (rs.next());
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReclamationServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        return reclamationList;
    }


}
