/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import static Controller.LoginController.LoggedUser;
import java.util.Date;

/**
 *
 * @author nessrine
 */
public class Forum {

    private int id;
    private int auteurid;
    
    private String Titre;
    private String rating;
    private String Auteur;
    private String Blog;

    public Forum(int id, String Titre, String rating, String Auteur, String Blog, String Image, String Tags, Date Cree, Date Modifiee, Boolean Fenabled) {
        this.id = id;
        this.Titre = Titre;
        this.rating = rating;
        this.Auteur = Auteur;
        this.Blog = Blog;
        this.Image = Image;
        this.Tags = Tags;
        this.Cree = Cree;
        this.Modifiee = Modifiee;
        this.Fenabled = Fenabled;
    }

    public Forum(String Titre, String Blog, Date Cree, String Tags, String Image, String Auteur) {

        this.Titre = Titre;

        this.Blog = Blog;
        this.Cree = Cree;
        this.Image = Image;
        this.Tags = Tags;
        this.Auteur = Auteur;
    }

    public Forum(int id, String Titre, String Blog, String Tags, String Auteur) {
        this.id = id;

        this.Titre = Titre;

        this.Blog = Blog;

        this.Tags = Tags;
        this.Auteur = Auteur;
    }
    
    public Forum(int id, String Titre, String Blog, String Tags, String Auteur,int auteurid) {
        this.id = id;

        this.Titre = Titre;

        this.Blog = Blog;

        this.Tags = Tags;
        this.Auteur = Auteur;
        this.auteurid=auteurid;
    }
    
    public Forum(String Titre, String Blog, Date Cree, String Tags, String Image, String Auteur,int auteurid , int Signe) {

        this.Titre = Titre;

        this.Blog = Blog;
        this.Cree = Cree;
        this.Image = Image;
        this.Tags = Tags;
        this.Auteur = Auteur;
        this.auteurid=auteurid;
        this.Signe = Signe;
    }    

    public int getAuteurid() {
        return auteurid;
    }

    public void setAuteurid(int auteurid) {
        this.auteurid = auteurid;
    }
    public Forum(int id, String Titre, String Blog, String Tags, String Auteur,Date Cree,int Signe) {
        this.id = id;

        this.Titre = Titre;

        this.Blog = Blog;

        this.Tags = Tags;
        this.Auteur = Auteur;
        this.Cree = Cree;
        this.Signe = Signe;
    }
    public Forum() {
    }

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return Titre;
    }

    public void setTitre(String Titre) {
        this.Titre = Titre;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getAuteur() {
        return Auteur;
    }

    public void setAuteur(String Auteur) {
        this.Auteur = Auteur;
    }

    public String getBlog() {
        return Blog;
    }

    public void setBlog(String Blog) {
        this.Blog = Blog;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String Image) {
        this.Image = Image;
    }

    public String getTags() {
        return Tags;
    }

    public void setTags(String Tags) {
        this.Tags = Tags;
    }

    public Date getCree() {
        return Cree;
    }

    public void setCree(Date Cree) {
        this.Cree = Cree;
    }

    public Date getModifiee() {
        return Modifiee;
    }

    public void setModifiee(Date Modifiee) {
        this.Modifiee = Modifiee;
    }

    public int getSigne() {
        return Signe;
    }

    public void setSigne(int Signe) {
        this.Signe = Signe;
    }

    public Boolean getFenabled() {
        return Fenabled;
    }

    public void setFenabled(Boolean Fenabled) {
        this.Fenabled = Fenabled;
    }
    private String Image;
    private String Tags;
    private Date Cree;
    private Date Modifiee;
    private int Signe = 0;
    private Boolean Fenabled;

}
