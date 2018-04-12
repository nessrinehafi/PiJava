/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Entities.Signalement;
import Services.SignalementServices;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hamouda
 */
public class SignalementMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        SignalementServices sign = new SignalementServices();
           Signalement s = new Signalement();
        
      
        s.setUser_id(1);
        
        s.setAnnonce_id(5);
        s.setType(4);
       // System.out.println(s.toString());
        
       //sign.Ajouter(s);
       
      // sign.supprimer(8);
      
   /*  
      //Affichage
      List<Signalement> lis = new ArrayList<Signalement>();
      
      lis=sign.afficheall();
      
      for ( Signalement i : lis)
      {
          System.out.println(i.toString());
      }
      */
   
   /* 
   //Modif

      s=sign.trouver(9);
   
   s.setType(3);
    
   sign.modifier(s); */
   
   
         
      
        
         
        
     
    }
    
}
