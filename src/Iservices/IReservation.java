/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IServices;

import Entities.Reservation;

/**
 *
 * @author Asus
 */
public interface IReservation {
    public void reserver(Reservation r);
    public void annulerReservation(Reservation r);
    public boolean VerfierReservation(Reservation r);
    
}
