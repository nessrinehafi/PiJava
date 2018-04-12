/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IServices;

import Entities.Evenement;

/**
 *
 * @author user
 */
public interface IEvenement 
{
    public void ajouterEvenement(Evenement e);
    public void supprimerEvenement(Evenement e);
    public void modifierEvenement(Evenement e);



}
