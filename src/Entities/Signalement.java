/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author hamouda
 */
public class Signalement {
    
    private int id ;
    private int user_id;
    private int annonce_id;
    private int type;
        protected String Typestat;
    protected int Nbsignalement;
    
    
    public  Signalement()
    {}

    public Signalement( int user_id, int annonce_id, int type,int Nbsignalement) {
        
        this.user_id = user_id;
        this.annonce_id = annonce_id;
        this.type = type;
        this.Nbsignalement=Nbsignalement;
    }

    public String getTypestat() {
        return Typestat;
    }

    public void setTypestat(String Typestat) {
        this.Typestat = Typestat;
    }

    public int getNbsignalement() {
        return Nbsignalement;
    }

    public void setNbsignalement(int Nbsignalement) {
        this.Nbsignalement = Nbsignalement;
    }
    
    
   

    @Override
    public String toString() {
        return "Signalement{" + "id=" + id + ", user_id=" + user_id + ", annonce_id=" + annonce_id + ", type=" + type + '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getAnnonce_id() {
        return annonce_id;
    }

    public void setAnnonce_id(int annonce_id) {
        this.annonce_id = annonce_id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
    
    
}
