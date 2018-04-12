/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Model.Forum;
import Model.User;
import Util.Connexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author nessrine
 */
public class ForumService {
   private  Connection con;
private Statement ste;
private PreparedStatement pst;
    private static ConversationService conversationService;
    public ForumService() {
        con=Connexion.getInstance().getConnection();
    }
   	public void ajouterForum(Forum p) {
		String rq = "insert into Forum (Titre,Blog,Image,Tags,Cree,Auteur,auteurid,signe) values (?,?,?,?,?,?,?,?)";
		try {
			pst = con.prepareStatement(rq);
			
			pst.setString(1, p.getTitre());
			pst.setString(6, p.getAuteur());
			pst.setString(2, p.getBlog());
                        pst.setString(3, "file:" + p.getImage());
			pst.setString(4, p.getTags());
                        pst.setInt(7, p.getAuteurid());
                        pst.setDate(5, new java.sql.Date(p.getCree().getTime()));
                        pst.setInt(8, p.getSigne());
		
			pst.executeUpdate();

		} catch (SQLException ex) {
			Logger.getLogger(ForumService.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
        
     

                
      
                     	public ObservableList<Forum> selectForum() throws SQLException {
		
		ObservableList<Forum> list= FXCollections.observableArrayList();

		String req = "SELECT `id`,`Titre`, `Blog`, `Tags`,`Auteur`,`auteurid` FROM `Forum` WHERE `signe`< 3";
		PreparedStatement ste = con.prepareStatement(req);
		ResultSet result = ste.executeQuery();

		while (result.next()) {
			Forum F = new Forum(result.getInt("id"),result.getString("Titre"),
					result.getString("Blog"),
					
					result.getString("Tags"),
                                result.getString("Auteur"),
                                result.getInt("auteurid")
			);

			list.add(F);
		}
		return list;
	}
    	public void ModifierSujet(Forum p, int id) throws SQLException {

		String req = "UPDATE Forum SET Titre=?,Blog=?,Tags=?,Image=?,Modifiee=CURRENT_TIMESTAMP WHERE id='"+id+"'";
		PreparedStatement pre = con.prepareStatement(req);

		pre.setString(1, p.getTitre());
		pre.setString(2, p.getBlog());
		pre.setString(3, p.getTags());
            

                pre.setString(4, "file:" + p.getImage());
		

		pre.executeUpdate();
		System.out.println("Sujet mise à jour");
	}
        public void SupprimerForum(int id) throws SQLException {
		String req = "DELETE FROM `Forum` WHERE id=" + id;
		Statement pre = con.createStatement();
		pre.executeUpdate(req);
		System.out.println("Forum Supprimée");
	}
        
        public void SignalerForum(int id) throws SQLException {
		String req = "Update `Forum` SET signe=signe+1  WHERE id=" + id;
		Statement pre = con.createStatement();
		pre.executeUpdate(req);
		System.out.println("Sujet Signaler");
	}
                     
}
