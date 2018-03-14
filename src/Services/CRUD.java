/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entity.Rendez_vous;
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

    public class CRUD {
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
    String query="DELETE FROM rendez_vous WHERE id = " + id + ";";
    
        try {
            ps=c.prepareStatement(query);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Rendez_vous.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    public void modifier(Rendez_vous r, int id){
        
    String query="UPDATE rendez_vous SET message='"+r.getMessage()+"',date='"+r.getDate()+"',heure='"+r.getHeure()+"' where id = "+ id +";";
	
        try {
            ps=c.prepareStatement(query);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Rendez_vous.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public List<Rendez_vous> afficheall(){
        
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
    
}
