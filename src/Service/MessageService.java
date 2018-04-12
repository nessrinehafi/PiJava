/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;


import Model.Commentaire;
import Model.Forum;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import Model.User;
import Model.Message;
import Model.User;
import Util.Connexion;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Elyes
 */
public class MessageService  {
    Statement st;
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
      public MessageService() {
        con=Connexion.getInstance().getConnection();
    }

  	public void Sendmessage(Message p) {
		String rq = "insert into messages (content,date,senderId,receiverId) values (?,?,?,?)";
		try {
			pst = con.prepareStatement(rq);
			
			pst.setString(1, p.getContent());
			
                        pst.setInt(3, p.getSenderId());
                        pst.setInt(4, p.getReceiverId());
                        pst.setDate(2, new java.sql.Date(p.getDate().getTime()));
		
			pst.executeUpdate();

		} catch (SQLException ex) {
			Logger.getLogger(MessageService.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
             	public ObservableList<Message> selectMessage(int sender1,int receiver1) throws SQLException {
		
		ObservableList<Message> list= FXCollections.observableArrayList();

		String req = "SELECT `id`,`content`, `senderId`, `receiverId` FROM `messages` WHERE senderId="+sender1+" && receiverId="+receiver1+" || senderId="+receiver1+" && receiverId="+sender1+"  ";
		PreparedStatement ste = con.prepareStatement(req);
		ResultSet result = ste.executeQuery();

		while (result.next()) {
			Message M = new Message(result.getInt("id"),result.getString("content"),
					result.getInt("senderId"),
					
                                result.getInt("receiverId")
			);

			list.add(M);
		}
		return list;
	}
               public  List<Message> displayAllById(int i) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    Message c = null;
  List<Message> messages =new ArrayList();
        try{
            pst = con.prepareStatement("select * from messages where senderId="+i+" ");
            ResultSet rs = pst.executeQuery();
          
            while(rs.next()){
                //créer une instance vide de personne()
                c = new Message();
              
                //récupérer les valeurs
                c.setId(rs.getInt(1));
                c.setContent(rs.getString(2));
             
                messages.add(c);
                //afficher l'instane 
                //System.out.println(l);
                  
            }
        
        } catch (SQLException ex) {
            Logger.getLogger(CommentaireService.class.getName()).log(Level.SEVERE, null, ex);
        }    
        
    return messages;

    }
}
