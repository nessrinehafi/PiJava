/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.time.LocalDateTime;

/**
 *
 * @author Asus
 */
public class Evenement {
    private int id ;
    private String nom;
    private String description;
    private String type ;
    private LocalDateTime HeureDebut;
    private LocalDateTime HeureFin;
    private double latitute ;
    private double longitude ;
    private int nbrpalacedispo ;
    private String monImage;   
    private User user;

    public Evenement() {
        user = new User();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDateTime getHeureDebut() {
        return HeureDebut;
    }

    public void setHeureDebut(LocalDateTime HeureDebut) {
        this.HeureDebut = HeureDebut;
    }

    public LocalDateTime getHeureFin() {
        return HeureFin;
    }

    public void setHeureFin(LocalDateTime HeureFin) {
        this.HeureFin = HeureFin;
    }

    public double getLatitute() {
        return latitute;
    }

    public void setLatitute(double latitute) {
        this.latitute = latitute;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public int getNbrpalacedispo() {
        return nbrpalacedispo;
    }

    public void setNbrpalacedispo(int nbrpalacedispo) {
        this.nbrpalacedispo = nbrpalacedispo;
    }

    public String getMonImage() {
        return monImage;
    }

    public void setMonImage(String monImage) {
        this.monImage = monImage;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
    
    
    
}
