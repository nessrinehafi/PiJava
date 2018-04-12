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
public class ForumAdminService {
    private  Connection con;
private Statement ste;
private PreparedStatement pst;

    public ForumAdminService() {
        con=Connexion.getInstance().getConnection();
    }
   	public void ajouterForum(Forum p) {
		String rq = "insert into Forum (Titre,Blog,Image,Tags,Cree,Auteur) values (?,?,?,?,?,?)";
		try {
			pst = con.prepareStatement(rq);
			
			pst.setString(1, p.getTitre());
			pst.setString(6, p.getAuteur());
			pst.setString(2, p.getBlog());
                        pst.setString(3, "file:" + p.getImage());
			pst.setString(4, p.getTags());
                        pst.setDate(5, new java.sql.Date(p.getCree().getTime()));
		
			pst.executeUpdate();

		} catch (SQLException ex) {
			Logger.getLogger(ForumAdminService.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
        
     
    	public void ModifierSujet(Forum p, int id) throws SQLException {

		String req = "UPDATE Forum SET Titre=?,Blog=?,Tags=?,Image=? WHERE id='"+id+"'";
		PreparedStatement pre = con.prepareStatement(req);

		pre.setString(1, p.getTitre());
		pre.setString(2, p.getBlog());
		pre.setString(3, p.getTags());
               //  pre.setDate(4, new java.sql.Date(p.getModifiee().getTime()));

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
        
      
                     	public ObservableList<Forum> selectForum() throws SQLException {
		
		ObservableList<Forum> list= FXCollections.observableArrayList();

		String req = "SELECT `id`,`Titre`, `Blog`, `Tags`,`Auteur`,`Cree`,`signe` FROM `Forum`";
		PreparedStatement ste = con.prepareStatement(req);
		ResultSet result = ste.executeQuery();

		while (result.next()) {
			Forum F = new Forum(result.getInt("id"),result.getString("Titre"),
					result.getString("Blog"),
					
					result.getString("Tags"),
                                result.getString("Auteur"), result.getDate("Cree"), result.getInt("signe")
			);

			list.add(F);
		}
		return list;
	}
}
