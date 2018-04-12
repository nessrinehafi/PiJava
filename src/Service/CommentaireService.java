/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Model.Commentaire;
import Model.User;
import Util.Connexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nessrine
 */
public class CommentaireService {
    
    private  Connection con;
private Statement ste;
private PreparedStatement pst;

    public CommentaireService() {
        con=Connexion.getInstance().getConnection();
    }

 
     public void add(Commentaire c) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   
       try{
           //System.out.println(t.getCom_created());
               Statement st = con.createStatement();
            
            st.executeUpdate("insert into commentaire(commentaire,Cree,User,blog) values('"+c.getCommentaire()+"',CURRENT_TIMESTAMP(),'"+c.getUser()+"','"+c.getBlog()+"')");

                
           }catch(SQLException ex){
               System.out.println(ex);
           }
     }
     
       public  List<Commentaire> displayAllById(int i) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    Commentaire c = null;
  List<Commentaire> commentaires =new ArrayList();
        try{
            pst = con.prepareStatement("select * from commentaire where blog="+i+" ");
            ResultSet rs = pst.executeQuery();
          
            while(rs.next()){
                //créer une instance vide de personne()
                c = new Commentaire();
              
                //récupérer les valeurs
                c.setId(rs.getInt(1));
                c.setBlog(rs.getInt(4));
                c.setUser(rs.getString(2));
                c.setCommentaire(rs.getString(3));
                c.setCree(rs.getDate(5));
                commentaires.add(c);
                //afficher l'instane 
                //System.out.println(l);
                  
            }
        
        } catch (SQLException ex) {
            Logger.getLogger(CommentaireService.class.getName()).log(Level.SEVERE, null, ex);
        }    
        
    return commentaires;

    }
        public void update1(int id,String c) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    try{
                      System.out.println(c);

      pst=con.prepareStatement("update commentaire set commentaire='"+c+"',Modifiee=CURRENT_TIMESTAMP where id='"+id+"'");
       
            pst.executeUpdate();
                
           }catch(SQLException ex){
               System.out.println(ex);
           }


    }
         public void deletebyid(int a) {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        try {

            pst = con.prepareStatement("delete from commentaire where id='" + a + "' ");

            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
           public User displayAllUser(String p)  {
     User user = null;

        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        try {
            pst = con.prepareStatement("select * from user where username='" + p + "'");
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                //créer une instance vide de personne()
                user = new User();

                //récupérer les valeurs
                user.setNom(rs.getString("nom"));
              user.setPrenom(rs.getString("prenom"));
               // user.setLogin(rs.getString("login"));
                //user.setMotPasse(rs.getString("mot_passe"));
           
              //  user.setMail(rs.getString("email"));

                //afficher l'instane 
                //System.out.println(l);
            }

        } catch (SQLException ex) {
            Logger.getLogger(CommentaireService.class.getName()).log(Level.SEVERE, null, ex);
        }

        return user;



    } 
    }
    

