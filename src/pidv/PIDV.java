/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidv;

import Entity.Rendez_vous;
import Services.CRUD;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author haythem
 */
public class PIDV {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        CRUD c = new CRUD();
        
        
        
//Ajout        
       /* Rendez_vous rdv=new Rendez_vous();
        java.util.Date date_util = new java.util.Date();
        java.sql.Date date_sql = new java.sql.Date(date_util.getTime());
        

            rdv.setMessage("aaa");
            rdv.setDate("24/02/2018");
            rdv.setHeure("14h");
            rdv.setCreateDt(date_sql);
            rdv.setUpdateDt(date_sql);
            rdv.setDemandeur_id(33);
            rdv.setValide(true);
            rdv.setAccepteur_id(33);
            rdv.setRemove(false);
            rdv.setService("Dressage");
        
            c.ajouter(rdv);*/

//Affichage 
        /*List <Rendez_vous> list=new ArrayList<Rendez_vous>();
          list=c.afficheall();
       for(Rendez_vous i:list)
	{
	System.out.println(i.toString());
                   
    }*/
//Delete
        /*c.supprimer(63);*/
//Update

        Rendez_vous rdv=new Rendez_vous();
        
        
        
            rdv.setId(rdv.getId());
            rdv.setMessage(rdv.getMessage());
            rdv.setDate(rdv.getDate());
            rdv.setHeure(rdv.getHeure());
            rdv.setCreateDt(rdv.getCreateDt());
            rdv.setUpdateDt(rdv.getUpdateDt());
            rdv.setDemandeur_id(rdv.getDemandeur_id());
            rdv.setValide(rdv.isValide());
            rdv.setAccepteur_id(rdv.getAccepteur_id());
            rdv.setRemove(rdv.isRemove());
            rdv.setService(rdv.getService());
            
            
            rdv.setMessage("bb");
            rdv.setDate("27/02/2018");
            rdv.setHeure("9h");
            
        
      
            c.modifier(rdv,60);
        
        // TODO code application logic here
    }
    
}
