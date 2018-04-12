/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Annonce;
import Entities.Signalement;
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

/**
 *
 * @author hamouda
 */
public class AnnonceServices {
    
     Connection c=Connexion.getInstance().getConnexion();
        PreparedStatement st;
            Statement st2;

    public AnnonceServices() {
        try {
                st2=c.createStatement();
            } catch (SQLException ex) {
                Logger.getLogger(AnnonceServices.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    public void Ajouter(Annonce a){
        String query="insert into annonce values(?,?,?,?,?,?,?,?,?,?,?,?)";
        
         try {
             st=c.prepareStatement(query);
             
              st.setInt(1, a.getId());
               st.setInt(2, a.getUser_id());
                st.setString(3, a.getCategorie());
                st.setDate(4, a.getDatecreation());
                st.setBoolean(5, a.isEstvalide());
                st.setBoolean(6, a.isAnnonceFin());
                st.setString(7, a.getAnimal());
                st.setString(8, a.getDescription());
                st.setString(9, a.getRace());
                st.setFloat(10, a.getPrix());
                st.setString(11, a.getImage());
                st.setString(12, a.getLieu());
                
                st.executeUpdate();
   
             
         } catch (SQLException ex) {
             Logger.getLogger(AnnonceServices.class.getName()).log(Level.SEVERE, null, ex);
         }
        
        
    
    }
    
    public void supprimer(int id){
    String query="DELETE FROM annonce WHERE id = " + id + ";";
    
        try {
            st=c.prepareStatement(query);
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AnnonceServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public List<Annonce> afficheall(){
    List<Annonce> ls=new ArrayList<Annonce>();
    String query="select * from Annonce";
        try {
            ResultSet rs=st2.executeQuery(query);
            while(rs.next()){
            Annonce an=new Annonce();
            an.setId(rs.getInt(1));
            an.setUser_id(rs.getInt(2));
            an.setCategorie(rs.getString(3));
            an.setDatecreation(rs.getDate(4));
            an.setEstvalide(rs.getBoolean(5));
             an.setAnnonceFin(rs.getBoolean(6));
             an.setAnimal(rs.getString(7));
             an.setDescription(rs.getString(8));
             an.setRace(rs.getString(9));
             an.setPrix(rs.getFloat(10));
             an.setImage(rs.getString(11));
             an.setLieu(rs.getString(12));
            
     
            ls.add(an);
                }
        } catch (SQLException ex) {
            Logger.getLogger(AnnonceServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ls;
    }
    
    public Annonce trouver(int id){
        
    String query="Select * from Annonce where id = '"+id+"'";
    Annonce an=new Annonce();

             
            try {
                ResultSet rs = st2.executeQuery(query);
                while(rs.next()){
            an.setId(rs.getInt(1));
            an.setUser_id(rs.getInt(2));
            an.setCategorie(rs.getString(3));
            an.setDatecreation(rs.getDate(4));
            an.setEstvalide(rs.getBoolean(5));
             an.setAnnonceFin(rs.getBoolean(6));
             an.setAnimal(rs.getString(7));
             an.setDescription(rs.getString(8));
             an.setRace(rs.getString(9));
             an.setPrix(rs.getFloat(10));
             an.setImage(rs.getString(11));
            
                }
            } catch (SQLException ex) {
                Logger.getLogger(AnnonceServices.class.getName()).log(Level.SEVERE, null, ex);
            }
            return an;
        
    }
    
        public void modifier(Annonce a,int id){
        
    String query="UPDATE annonce SET user_id='"+a.getUser_id()+"',categorie='"+a.getCategorie()+"', datecreation='"+a.getDatecreation()+"', estvalide="+a.isEstvalide()+", annonceFin="+a.isAnnonceFin()+", animal='"+a.getAnimal()+"',description='"+a.getDescription()+"', race='"+a.getRace()+"', prix='"+a.getPrix()+"', image='"+a.getImage()+"' where id = "+id+";";
	
        try {
            st=c.prepareStatement(query);
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AnnonceServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
        
       
     
     
     public List<Annonce> afficheallV(String categorie){
    List<Annonce> ls=new ArrayList<Annonce>();
    String query="select * from Annonce where categorie = '"+categorie+"'";
        try {
            ResultSet rs=st2.executeQuery(query);
            while(rs.next()){
            Annonce an=new Annonce();
            an.setId(rs.getInt(1));
            an.setUser_id(rs.getInt(2));
            an.setCategorie(rs.getString(3));
            an.setDatecreation(rs.getDate(4));
            an.setEstvalide(rs.getBoolean(5));
             an.setAnnonceFin(rs.getBoolean(6));
             an.setAnimal(rs.getString(7));
             an.setDescription(rs.getString(8));
             an.setRace(rs.getString(9));
             an.setPrix(rs.getFloat(10));
             an.setImage(rs.getString(11));
             an.setLieu(rs.getString(12));
            
     
            ls.add(an);
                }
        } catch (SQLException ex) {
            Logger.getLogger(AnnonceServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ls;
    }
    
      public void valider(Annonce a,int id){
        
    String query="UPDATE annonce SET estvalide='"+1+"' where id = "+id+";";
	
        try {
            st=c.prepareStatement(query);
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AnnonceServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
      
      public int count(String ev) throws SQLException
	{
            int i=0;
            String query  = "select * from annonce where categorie ='"+ev+"'";
            st = c.prepareStatement(query);
            ResultSet rs = st.executeQuery(query);
               while(rs.next())
            {
                i+=1;
            }  
            return i;
            
	}///
     
         
         
    }
     






        
       
