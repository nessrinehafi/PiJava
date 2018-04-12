/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Model.like;
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
 * @author sahar ghorch
 */
public  class LikeService  {
private  Connection con;
private Statement ste;
private PreparedStatement pst;

    public LikeService() {
        con=Connexion.getInstance().getConnection();
    }
    public void add1(like t, int id_pub) {
        try{
           //System.out.println(t.getCom_created());
               Statement st = con.createStatement();
          
            st.executeUpdate("insert into likes(blog,user) values('"+id_pub+"','"+t.getUser()+"')");

                
           }catch(SQLException ex){
               System.out.println(ex);
           }
    }
    /* public String afficher(int id_pub){
        try{
            pst = con.prepareStatement("select count(*) from jaime where id_pub = "+id_pub+" ");
            ResultSet rs = pst.executeQuery();
        int var=rs.getInt(1);
            return Integer.toString(var);
        }
      
        catch (SQLException ex) {
            Logger.getLogger(CommentaireDAO.class.getName()).log(Level.SEVERE, null, ex);
        }    
         return "0"; 
    }*/
    public int displayAllById(int i) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  
  List<Integer> list =new ArrayList();
        try{
            pst = con.prepareStatement("select * from likes where blog="+i+" ");
            ResultSet rs = pst.executeQuery();
          
            while(rs.next()){
                //créer une instance vide de personne()
              
                list.add(rs.getInt(1));
                //afficher l'instane 
                //System.out.println(l);
                  
            }
        
        } catch (SQLException ex) {
            Logger.getLogger(CommentaireService.class.getName()).log(Level.SEVERE, null, ex);
        }    
             System.out.println(list);
        return list.size();
   

    }
    
   
     public int liked(int i,String j) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  
  List<Integer> list =new ArrayList();
        try{
            pst = con.prepareStatement("select * from likes where blog="+i+"&& user="+j+"  ");
            ResultSet rs = pst.executeQuery();
          
            while(rs.next()){
                //créer une instance vide de personne()
              
                list.add(rs.getInt(1));
                //afficher l'instane 
                //System.out.println(l);
                  
            }
        
        } catch (SQLException ex) {
            Logger.getLogger(CommentaireService.class.getName()).log(Level.SEVERE, null, ex);
        }    
             System.out.println(list);
        return list.size();
   

    }
    /*
    public int plusjaime() {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
     
  List<Integer> list =new ArrayList();
         try{
  pst = con.prepareStatement("select  like.blog from like inner join forum on like.blog=forum.id where extract(month from forum.Cree)=extract(month from curdate()) group by id_pub limit 1");
             ResultSet rs = pst.executeQuery();

             while(rs.next()){
                
                 list.add(rs.getInt(1));

              
             }

         } catch (SQLException ex) {
             Logger.getLogger(PublicationDAO.class.getName()).log(Level.SEVERE, null, ex);
         }    

     return list.get(0);


    }
     */

    public void addlike(like p) {
		String rq = "insert into likes (blog,user) values (?,?);";
		try {
			pst = con.prepareStatement(rq);
			
			pst.setInt(1, p.getBlog());
			pst.setString(2, p.getUser());
			
		
			pst.executeUpdate();

		} catch (SQLException ex) {
			Logger.getLogger(LikeService.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
    
    }
/*
    @Override
    public void update(jaime t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(jaime t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<jaime> displayAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public jaime findById(jaime t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void add(jaime t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
*/
    

