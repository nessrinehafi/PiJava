/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Entities.Annonce;
import Services.AnnonceServices;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hamouda
 */
public class AnnonceMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        AnnonceServices as= new AnnonceServices();
        Annonce an = new Annonce();
        
        java.util.Date date_util = new java.util.Date();
        java.sql.Date date_sql = new java.sql.Date(date_util.getTime());
        
        an.setAnimal("ceeeeee");
        an.setCategorie("LostAndFound");
        an.setDatecreation(date_sql);
        an.setDescription("eeeeeeeeee");
        an.setUser_id(1);
        an.setPrix(100.2f);
        an.setImage("alooo");
        an.setEstvalide(false);
        an.setAnnonceFin(false);
        an.setRace("eeeeeeeee");
        
      // System.out.println(an.toString());
        
        as.Ajouter(an);
        
        
       // as.supprimer(8);
       
       
       
         /* 
       //Affichage
       
       List <Annonce> ls=new ArrayList<Annonce>();
        ls=as.afficheall();
       for(Annonce i:ls)
	{
	System.out.println(i.toString());
    } */
    /*
         //trouver
         Annonce an2 = new Annonce();
         an2=as.trouver(2);
         System.out.println(an2.toString()); */
    
         
        
       /*
    //UPDATE
    Annonce a2 = as.trouver(5);
        a2.setUser_id(1);
        a2.setCategorie("Adoption");
        
       
        as.modifier(a2); */
    }
}
