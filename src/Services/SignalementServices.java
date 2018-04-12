/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;


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
public class SignalementServices {
    
    Connection c = Connexion.getInstance().getConnexion();
     PreparedStatement st;
            Statement st2;
            
       public SignalementServices() {
        try {
                st2=c.createStatement();
            } catch (SQLException ex) {
                Logger.getLogger(SignalementServices.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
       
       public void Ajouter(Signalement s){
        String query="insert into signalement values(?,?,?,?,?)";
        SignalementServices ss = new SignalementServices();
        
         try {
              
               
             st=c.prepareStatement(query);
              st.setInt(1, s.getId());
               st.setInt(2, s.getUser_id());
                st.setInt(3, s.getAnnonce_id());
                st.setInt(4, s.getType());
                st.setInt(5, s.getNbsignalement());
               
                
                st.executeUpdate();
   
             
         } catch (SQLException ex) {
             Logger.getLogger(SignalementServices.class.getName()).log(Level.SEVERE, null, ex);
         }
        
        
    
    }
       
        public void supprimer(int id){
    String query="DELETE FROM signalement WHERE id = " + id + ";";
    
        try {
            st=c.prepareStatement(query);
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(SignalementServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
        
         public List<Signalement> afficheall(){
    List<Signalement> ls=new ArrayList<Signalement>();
    String query="select * from Signalement";
        try {
            ResultSet rs=st2.executeQuery(query);
            while(rs.next()){
            Signalement sn=new Signalement();
            sn.setId(rs.getInt(1));
            sn.setUser_id(rs.getInt(2));
            
            sn.setAnnonce_id(rs.getInt(3));
            sn.setType(rs.getInt(4));
            sn.setNbsignalement(rs.getInt(5));
            
            
     
            ls.add(sn);
                }
        } catch (SQLException ex) {
            Logger.getLogger(SignalementServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ls;
    }
         
          public Signalement trouver(int id){
        
    String query="Select * from Signalement where id = "+id+";";
    Signalement sn=new Signalement();

             
            try {
                ResultSet rs = st2.executeQuery(query);
                while(rs.next()){
            sn.setId(rs.getInt(1));
            sn.setUser_id(rs.getInt(2));
            sn.setAnnonce_id(rs.getInt(3));
            sn.setType(rs.getInt(4));
            
            
                }
            } catch (SQLException ex) {
                Logger.getLogger(SignalementServices.class.getName()).log(Level.SEVERE, null, ex);
            }
            return sn;
        
    }
           public void modifier(Signalement s){
        
    String query="UPDATE signalement SET id='"+s.getId()+"',user_id='"+s.getUser_id()+"', annonce_id='"+s.getAnnonce_id()+"', type="+s.getType()+" where id = "+s.getId()+";";
	
        try {
            st=c.prepareStatement(query);
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(SignalementServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
           
            public ArrayList<Signalement> Statistique2(){
         ArrayList<Signalement> Signalements =new ArrayList<>(); 
         
    
         
        String query="SELECT type,COUNT(type) FROM `signalement` GROUP by type ";
    

             
            try {
                ResultSet rs = st2.executeQuery(query);
                
                while(rs.next()){
                    Signalement s = new Signalement();
                s.setTypestat(rs.getString(1));
                s.setNbsignalement(rs.getInt(2));
                Signalements.add(s);
            
            
                }
            } catch (SQLException ex) {
                Logger.getLogger(SignalementServices.class.getName()).log(Level.SEVERE, null, ex);
            }
            return Signalements;
        
    }
            
             public int CountSignalementByType(int id , int type){
                 int poki = 0;
                 String query="Select Count(*) from Signalement where annonce_id = "+id+" AND type="+type+";";
                try {
                ResultSet rs = st2.executeQuery(query);
                
                while(rs.next()){
                    poki=rs.getInt(1);
                
            
            
                }
            } catch (SQLException ex) {
                Logger.getLogger(SignalementServices.class.getName()).log(Level.SEVERE, null, ex);
            }
            return poki;
                 
                 
              
         
         
         
             }
        
        
       
    
}
