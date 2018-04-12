/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.sql.Date;

/**
 *
 * @author hamouda
 */
public class Annonce {
    
    private  int id;
    private int user_id;
    private String categorie;
    private Date datecreation ;
    private boolean estvalide;
    private boolean annonceFin;
    private String animal ;
    private String description;
    private String race;
    private Float prix;
    private String image;
    private String lieu ;
    protected String Categoriestat;
    protected int Nbannonce;
    public  int SignalementCount ;

    public Annonce() {
    }

    public Annonce( int user_id, String categorie,Date datecreation, String animal, String description, String race, Float prix, String image) {
        
        this.user_id = user_id;
        this.categorie = categorie;
        this.datecreation=datecreation;
        
        
       
        this.animal = animal;
        this.description = description;
        this.race = race;
        this.prix = prix;
        this.image = image;
    }
     public Annonce( int user_id, String categorie,Date datecreation, String animal, String description, String race, Float prix) {
        
        this.user_id = user_id;
        this.categorie = categorie;
        this.datecreation=datecreation;
       
        
        
       
        this.animal = animal;
        this.description = description;
        this.race = race;
        this.prix = prix;
    
    }
    

    public Annonce(int id, int user_id, String categorie, Date datecreation, boolean estvalide, boolean annonceFin, String animal, String description, String race, Float prix, String image) {
        this.id = id;
        this.user_id = user_id;
        this.categorie = categorie;
        this.datecreation = datecreation;
        this.estvalide = estvalide;
        this.annonceFin = annonceFin;
        this.animal = animal;
        this.description = description;
        this.race = race;
        this.prix = prix;
        this.image = image;
    }

  
    

    @Override
    public String toString() {
        return "Annonce{" + "id=" + id + ", user_id=" + user_id + ", categorie=" + categorie + ", datecreation=" + datecreation + ", estvalide=" + estvalide + ", annonceFin=" + annonceFin + ", animal=" + animal + ", description=" + description + ", race=" + race + ", prix=" + prix + ", image=" + image + '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategoriestat() {
        return Categoriestat;
    }

    public void setCategoriestat(String Categoriestat) {
        this.Categoriestat = Categoriestat;
    }

    public int getNbannonce() {
        return Nbannonce;
    }

    public void setNbannonce(int Nbannonce) {
        this.Nbannonce = Nbannonce;
    }
    

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public Date getDatecreation() {
        return datecreation;
    }

    public void setDatecreation(Date datecreation) {
        this.datecreation = datecreation;
    }

    public boolean isEstvalide() {
        return estvalide;
    }

    public void setEstvalide(boolean estvalide) {
        this.estvalide = estvalide;
    }

    public boolean isAnnonceFin() {
        return annonceFin;
    }

    public void setAnnonceFin(boolean annonceFin) {
        this.annonceFin = annonceFin;
    }

    public String getAnimal() {
        return animal;
    }

    public void setAnimal(String animal) {
        this.animal = animal;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public Float getPrix() {
        return prix;
    }

    public void setPrix(Float prix) {
        this.prix = prix;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public int getSignalementCount() {
        return SignalementCount;
    }

    public void setSignalementCount(int SignalementCount) {
        this.SignalementCount = SignalementCount;
    }

   
    
    
    

}