/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.sql.Date;

/**
 *
 * @author nouha
 */
public class Service {
    private int id;
    private String title;
    private String description;
    private Date createDt;
    private String adresseS;
    private int numtel;
    private int catservice;
    public String userservice;
    private String image;
    private String categorie;
    private Boolean favori;
    private double altitude;
    private double longitude;

    public Service() {
    }

    
    public Service(String title,String description,String adresseS,int numtel,String image,String categorie) {
       
        this.title=title;
        this.description=description;
        this.adresseS=adresseS;
        this.numtel=numtel;
        this.image=image;
        this.categorie=categorie;
        
  
    }
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreateDt() {
        return createDt;
    }

    public void setCreateDt(Date createDt) {
        this.createDt = createDt;
    }

    public String getAdresseS() {
        return adresseS;
    }

    public void setAdresseS(String adresseS) {
        this.adresseS = adresseS;
    }

    public int getNumtel() {
        return numtel;
    }

    public void setNumtel(int numtel) {
        this.numtel = numtel;
    }

    public int getCatservice() {
        return catservice;
    }

    public void setCatservice(int catservice) {
        this.catservice = catservice;
    }

    public String getUserservice() {
        return userservice;
    }

    public void setUserservice(String userservice) {
        this.userservice = userservice;
    }

    

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public Boolean getFavori() {
        return favori;
    }

    public void setFavori(Boolean favori) {
        this.favori = favori;
    }

    @Override
    public String toString() {
        return "Service{" + "id=" + id + ", title=" + title + ", description=" + description + ", createDt=" + createDt + ", adresseS=" + adresseS + ", numtel=" + numtel + ", catservice=" + catservice + ", userservice=" + userservice + ", image=" + image + ", categorie=" + categorie + '}';
    }

    public double getAltitude() {
        return altitude;
    }

    public void setAltitude(double altitude) {
        this.altitude = altitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
    
    
    



    
}
