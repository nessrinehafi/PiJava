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
public class ServiceFavoris extends Service{
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
    private double altitude;
    private double longitude;
    
    public ServiceFavoris() {
    }

    public ServiceFavoris(String title, String description, String adresseS, int numtel, String image, String categorie) {
        super(title, description, adresseS, numtel, image, categorie);
    }
    
    
}
