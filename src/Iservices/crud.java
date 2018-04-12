/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Iservices;

import Entity.Rendez_vous;
import Entity.User;
import java.util.List;

/**
 *
 * @author haythem
 */
public interface crud {
    
    public void ajouter(Rendez_vous r);
    public void supprimer(int id);
    public void modifier(Rendez_vous r, int id);
    public void valider(Rendez_vous r, int id);
    public List<Rendez_vous> afficheallrdv();
    public List<User> affichealluser();
    public User getMail(int id);
    
}
