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
public class Commentaire {

    public static void se(String text) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private int id;
    private String User;
    private String Commentaire;
    private int blog;
    private Date Cree;

    public Commentaire( String Commentaire,Date Cree, String User, int blog) {
        
       
        this.Commentaire = Commentaire;
                this.Cree = Cree;

        this.User = User;
                this.blog = blog;

       
    }

    public Commentaire() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser() {
        return User;
    }

    public void setUser(String User) {
        this.User = User;
    }

    public String getCommentaire() {
        return Commentaire;
    }

    public void setCommentaire(String Commentaire) {
        this.Commentaire = Commentaire;
    }

    public int getBlog() {
        return blog;
    }

    public void setBlog(int blog) {
        this.blog = blog;
    }

    public Date getCree() {
        return Cree;
    }

    public void setCree(Date Cree) {
        this.Cree = Cree;
    }

    

}
