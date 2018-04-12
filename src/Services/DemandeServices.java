/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Annonce;
import Entities.Demande;
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
public class DemandeServices {
    Connection c=Connexion.getInstance().getConnexion();
        PreparedStatement st;
            Statement st2;
            
             public DemandeServices() {
        try {
                st2=c.createStatement();
            } catch (SQLException ex) {
                Logger.getLogger(DemandeServices.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
             public void Ajouter(Demande a){
        String query="insert into demande values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        
         try {
             st=c.prepareStatement(query);
              st.setInt(1, a.getId());
               st.setInt(2, a.getUser_id());
               st.setInt(3, a.getAnnonce_id());
                st.setString(4, a.getCategorie());
                st.setString(5, a.getQ1());
                st.setString(6, a.getQ2());
                st.setString(7, a.getQ3());
                st.setString(8, a.getQ4());
                st.setString(9, a.getQ5());
                st.setString(10, a.getQ6());
                st.setFloat(11, a.getPrix_Secondaire());
                st.setString(12, a.getQ7());
                st.setString(13, a.getQ8());
                st.setString(14, a.getNum_tel());
                st.setBoolean(15, a.isValide());
                 st.setString(16, a.getAnimal());
                
   
                st.executeUpdate();
   
             
         } catch (SQLException ex) {
             Logger.getLogger(DemandeServices.class.getName()).log(Level.SEVERE, null, ex);
         }

         
    }
             
              public void supprimer(int id){
    String query="DELETE FROM demande WHERE id = " + id + ";";
    
        try {
            st=c.prepareStatement(query);
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DemandeServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
     public List<Demande> afficheall(){
    List<Demande> ls=new ArrayList<Demande>();
    String query="select * from Demande";
        try {
            ResultSet rs=st2.executeQuery(query);
            while(rs.next()){
            Demande an=new Demande();
            an.setId(rs.getInt(1));
            an.setUser_id(rs.getInt(2));
            an.setAnnonce_id(rs.getInt(3));
            an.setCategorie(rs.getString(4));
            
            an.setQ1(rs.getString(5));
            an.setQ2(rs.getString(6));
            an.setQ3(rs.getString(7));
            an.setQ4(rs.getString(8));
            an.setQ5(rs.getString(9));
            an.setQ6(rs.getString(10));
            an.setPrix_Secondaire(rs.getFloat(11));
            
             an.setQ7(rs.getString(12));
            an.setQ8(rs.getString(13));
            an.setNum_tel(rs.getString(14));
            
            an.setValide(rs.getBoolean(15));
            an.setAnimal(rs.getString(16));
            
 
            ls.add(an);
                }
        } catch (SQLException ex) {
            Logger.getLogger(DemandeServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ls;
    }
     
      public Demande trouver(int id){
        
    String query="Select * from Demande where id = "+id+";";
    Demande an=new Demande();

             
            try {
                ResultSet rs = st2.executeQuery(query);
                while(rs.next()){
            an.setId(rs.getInt(1));
            an.setUser_id(rs.getInt(2));
            an.setAnnonce_id(rs.getInt(3));
            an.setCategorie(rs.getString(4));
            an.setQ1(rs.getString(5));
            an.setQ2(rs.getString(6));
            an.setQ3(rs.getString(7));
            an.setQ4(rs.getString(8));
            an.setQ5(rs.getString(9));
            an.setQ6(rs.getString(10));
            an.setPrix_Secondaire(rs.getFloat(11));
            
             an.setQ7(rs.getString(12));
            an.setQ8(rs.getString(13));
            an.setNum_tel(rs.getString(14));
            an.setValide(rs.getBoolean(15));
            
                }
            } catch (SQLException ex) {
                Logger.getLogger(DemandeServices.class.getName()).log(Level.SEVERE, null, ex);
            }
            return an;
        
    }
    
        public void modifier(Demande a){
        
    String query="UPDATE Demande SET user_id='"+a.getUser_id()+"',annonce_id='"+a.getAnnonce_id()+"',categorie='"+a.getCategorie()+"' where id = "+a.getId()+";";
	
        try {
            st=c.prepareStatement(query);
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AnnonceServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
         public List<Demande> afficheallV(String categorie){
    List<Demande> ls=new ArrayList<Demande>();
    String query="select * from Demande where categorie = '"+categorie+"'";
        try {
            ResultSet rs=st2.executeQuery(query);
            while(rs.next()){
            Demande an=new Demande();
            an.setId(rs.getInt(1));
            an.setUser_id(rs.getInt(2));
            an.setAnnonce_id(rs.getInt(3));
            an.setCategorie(rs.getString(4));
            
            an.setQ1(rs.getString(5));
            an.setQ2(rs.getString(6));
            an.setQ3(rs.getString(7));
            an.setQ4(rs.getString(8));
            an.setQ5(rs.getString(9));
            an.setQ6(rs.getString(10));
            an.setPrix_Secondaire(rs.getFloat(11));
            
             an.setQ7(rs.getString(12));
            an.setQ8(rs.getString(13));
            an.setNum_tel(rs.getString(14));
            
            an.setValide(rs.getBoolean(15));
            an.setAnimal(rs.getString(16));
            
 
            ls.add(an);
                }
        } catch (SQLException ex) {
            Logger.getLogger(DemandeServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ls;
    }
       
            
    
}
