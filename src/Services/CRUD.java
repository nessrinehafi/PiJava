/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entity.Rendez_vous;
import Entity.User;
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
 * @author haythem
 */

    public class CRUD implements Iservices.crud{
	Connection c=Connexion.getInstance().getConnexion();
        PreparedStatement ps;
        Statement s;            

    public CRUD() {
            try {
                s=c.createStatement();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    public void ajouter(Rendez_vous r){
    String query="insert into rendez_vous values(?,?,?,?,?,?,?,?,?,?,?)";
    
        try {
            ps=c.prepareStatement(query);
            ps.setInt(1, r.getId());
            ps.setString(2, r.getMessage());
            ps.setString(3, r.getDate());
            ps.setString(4, r.getHeure());
            ps.setDate(5, r.getCreateDt());
            ps.setDate(6, r.getUpdateDt());
            ps.setInt(7, r.getDemandeur_id());
            ps.setBoolean(8, r.isValide());
            ps.setInt(9, r.getAccepteur_id());
            ps.setBoolean(10, r.isRemove());
            ps.setString(11, r.getService());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Rendez_vous.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void supprimer(int id){
        
    String query="UPDATE rendez_vous SET remove='"+1+"' where id = "+ id +";";
	
       
        
        try {
            ps=c.prepareStatement(query);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Rendez_vous.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    public void modifier(Rendez_vous r, int id){
        
    String query="UPDATE rendez_vous SET date='"+r.getDate()+"',heure='"+r.getHeure()+"' where id = "+ id +";";
	
        try {
            ps=c.prepareStatement(query);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Rendez_vous.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void valider(Rendez_vous r, int id){
        
        String query="UPDATE rendez_vous SET valide='"+1+"' where id = "+ id +";";
	
       
        
        try {
            ps=c.prepareStatement(query);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Rendez_vous.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public List<Rendez_vous> afficheallrdv(){
        
    List<Rendez_vous> list=new ArrayList<Rendez_vous>();
    
    
    
    String query="select * from rendez_vous";
       
    try {
            ResultSet rs=s.executeQuery(query);
            while(rs.next()){
                
            Rendez_vous rdv=new Rendez_vous();
            
            rdv.setId(rs.getInt(1));
            rdv.setMessage(rs.getString(2));
            rdv.setDate(rs.getString(3));
            rdv.setHeure(rs.getString(4));
            rdv.setCreateDt(rs.getDate(5));
            rdv.setUpdateDt(rs.getDate(6));
            rdv.setDemandeur_id(rs.getInt(7));
            rdv.setValide(rs.getBoolean(8));
            rdv.setAccepteur_id(rs.getInt(9));
            rdv.setRemove(rs.getBoolean(10));
            rdv.setService(rs.getString(11));
            
            list.add(rdv);
            
                }
        } catch (SQLException ex) {
            Logger.getLogger(Rendez_vous.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
      public List<User> affichealluser(){
        
    List<User> list=new ArrayList<User>();
    
    
    
    String query="select * from User";
       
    try {
            ResultSet rs=s.executeQuery(query);
            while(rs.next()){
                
            User user=new User();
            
            user.setId(rs.getInt(1));
            user.setUsername(rs.getString(2));
            user.setUsername_canonical(rs.getString(3));
            user.setEmail(rs.getString(4));
            user.setEmail_canonical(rs.getString(5));
            user.setEnabled(rs.getBoolean(6));
            user.setSalt(rs.getString(7));
            user.setPassword(rs.getString(8));
            user.setLast_login(rs.getDate(9));
            user.setConfirmation_token(rs.getString(10));
            user.setPassword_requested_at(rs.getString(11));
            user.setRoles(rs.getString(12));
            user.setNom(rs.getString(13));
            user.setPrenom(rs.getString(14));
            user.setNumtel(rs.getInt(15));
            user.setAdresse(rs.getString(17));
            user.setRole(rs.getString(19));
            
            user.setLongitude(rs.getString(20));
            user.setLatitude(rs.getString(21));
            
            
            
            
            list.add(user);
            
                }
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
      
      
        
      public User getMail(int id){
        
     String query="select * from User where id = "+ id +";";
     
     User user = new User();
       
    try {
            ResultSet rs=s.executeQuery(query);
            while(rs.next()){
                
            
            
          
            user.setId(rs.getInt(1));
            user.setUsername(rs.getString(2));
            user.setUsername_canonical(rs.getString(3));
            user.setEmail(rs.getString(4));
            user.setEmail_canonical(rs.getString(5));
            user.setEnabled(rs.getBoolean(6));
            user.setSalt(rs.getString(7));
            user.setPassword(rs.getString(8));
            user.setLast_login(rs.getDate(9));
            user.setConfirmation_token(rs.getString(10));
            user.setPassword_requested_at(rs.getString(11));
            user.setRoles(rs.getString(12));
            user.setNom(rs.getString(13));
            user.setPrenom(rs.getString(14));
            user.setNumtel(rs.getInt(15));
            user.setAdresse(rs.getString(17));
            user.setRole(rs.getString(19));
            
            user.setLongitude(rs.getString(20));
            user.setLatitude(rs.getString(21));
            
            
            

                }
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user;    
       
        
    }
      
     
    
}
