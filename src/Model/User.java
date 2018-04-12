/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Date;

/**
 *
 * @author nessrine
 */
public class User {
    public int id;
    public String username;
    private String username_canonical;
    private String email;
    private String email_canonical;
    private boolean enabled;
    private String password;
    private Date last_login;
    private String confirmation_token;
    private String password_requested_at;
    private String roles;
    public String nom;
    public String prenom;
    private int numtel;
    private String Datenaiss;
    private String adresse;
    private String image;
    public static String role;
    private int est_banni;
    public static int connected_id;
    public static String connected_login;
    protected Boolean connected;
    public int 	fenable;

    public int getFenable() {
        return fenable;
    }

    public void setFenable(int fenable) {
        this.fenable = fenable;
    }

    public static int getConnected_id() {
        return connected_id;
    }
    
   public boolean isConnected() {
        return connected;
    }
    public static void setConnected_id(int connected_id) {
        User.connected_id = connected_id;
    }

    public static String getConnected_login() {
        return connected_login;
    }

    public static void setConnected_login(String connected_login) {
        User.connected_login = connected_login;
    }

    public Boolean getConnected() {
        return connected;
    }

    public void setConnected(Boolean connected) {
        this.connected = connected;
    }



    public int getEst_banni() {
        return est_banni;
    }

    public void setEst_banni(int est_banni) {
        this.est_banni = est_banni;
    }
    public static String loginUser,userMdp;

    public static String getLoginUser() {
        return loginUser;
    }

    public static void setLoginUser(String loginUser) {
        User.loginUser = loginUser;
    }

    public User(int id) {
        this.id = id;
    }

    public static String getUserMdp() {
        return userMdp;
    }

    public static void setUserMdp(String userMdp) {
        User.userMdp = userMdp;
    }
    
    public User(){
        
    }

    public User(String username, String email,String password,String nom, String prenom, int numtel,String Datenaiss,String adresse) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.nom = nom;
        this.prenom = prenom;
        this.numtel=numtel;
        this.Datenaiss=Datenaiss;
        this.adresse=adresse;
    }
    
    	 public User(String nom, String prenom,String email, int numtel,String username, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.nom = nom;
        this.prenom = prenom;
        this.numtel=numtel;
       
 
    }	
          public User(int id,String nom, String prenom ,String username, int fenable) {
        this.username = username;
this.id=id;
      
        this.nom = nom;
        this.prenom = prenom;
        this.fenable=fenable;
       
 
    }	
	 public User(String nom, String prenom,String email, int numtel,String username, String password,String role) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.nom = nom;
        this.prenom = prenom;
        this.numtel=numtel;
        
 
    }
       
    public User(String string, String string0, String string1, String string2, String string3, String string4, int aInt, int aInt0, java.sql.Date date, String string5) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", username=" + username + ", email=" + email + ", enabled=" + enabled + ", password=" + password + ", last_login=" + last_login + ", roles=" + roles + ", nom=" + nom + ", prenom=" + prenom + ", numtel=" + numtel + '}';
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getLast_login() {
        return last_login;
    }

    public void setLast_login(Date last_login) {
        this.last_login = last_login;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    
    public int getNumtel() {
        return numtel;
    }

    public void setNumtel(int numtel) {
        this.numtel = numtel;
    }

    public String getUsername_canonical() {
        return username_canonical;
    }

    public void setUsername_canonical(String username_canonical) {
        this.username_canonical = username_canonical;
    }

    public String getEmail_canonical() {
        return email_canonical;
    }

    public void setEmail_canonical(String email_canonical) {
        this.email_canonical = email_canonical;
    }

    

    public String getConfirmation_token() {
        return confirmation_token;
    }

    public void setConfirmation_token(String confirmation_token) {
        this.confirmation_token = confirmation_token;
    }

    public String getPassword_requested_at() {
        return password_requested_at;
    }

    public void setPassword_requested_at(String password_requested_at) {
        this.password_requested_at = password_requested_at;
    }

    public String getDatenaiss() {
        return Datenaiss;
    }

    public void setDatenaiss(String Datenaiss) {
        this.Datenaiss = Datenaiss;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    
    
}
