/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.sql.Date;

/**
 *
 * @author haythem
 */
public class User {

    
    private int Id;
    private String username;
    private String username_canonical;
    private String email;
    private String email_canonical;
    private boolean enabled;
    private String salt;
    private String password;
    private Date last_login;
    private String confirmation_token;
    private String password_requested_at;
    private String roles;
    private String nom;
    private String prenom;
    private int numtel;
    private String adresse;
    private String role;
    private String longitude;
    private String latitude;
    private int fenable=1;
    
    

    public User() {
    }

    public User(int Id, String username, String username_canonical, String email, String email_canonical, boolean enabled, String salt, String password, Date last_login, String confirmation_token, String password_requested_at, String roles, String nom, String prenom, String habitation, String longitude, String latitude, int numtel) {
        this.Id = Id;
        this.username = username;
        this.username_canonical = username_canonical;
        this.email = email;
        this.email_canonical = email_canonical;
        this.enabled = enabled;
        this.salt = salt;
        this.password = password;
        this.last_login = last_login;
        this.confirmation_token = confirmation_token;
        this.password_requested_at = password_requested_at;
        this.roles = roles;
        this.nom = nom;
        this.prenom = prenom;
        this.numtel = numtel;
        this.adresse = adresse;
        this.role = role;
        this.longitude = longitude;
        this.latitude = latitude;
        this.fenable = fenable;
        
        
    }

    @Override
    public String toString() {
        return "User{" + "Id=" + Id + ", username=" + username + ", username_canonical=" + username_canonical + ", email=" + email + ", email_canonical=" + email_canonical + ", enabled=" + enabled + ", salt=" + salt + ", password=" + password + ", last_login=" + last_login + ", confirmation_token=" + confirmation_token + ", password_requested_at=" + password_requested_at + ", roles=" + roles + ", nom=" + nom + ", prenom=" + prenom + ", adresse=" + adresse + ", longitude=" + longitude + ", latitude=" + latitude + ", numtel=" + numtel + ", role=" + role + '}';
    }

    

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername_canonical() {
        return username_canonical;
    }

    public void setUsername_canonical(String username_canonical) {
        this.username_canonical = username_canonical;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail_canonical() {
        return email_canonical;
    }

    public void setEmail_canonical(String email_canonical) {
        this.email_canonical = email_canonical;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
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

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public int getNumtel() {
        return numtel;
    }

    public void setNumtel(int numtel) {
        this.numtel = numtel;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getFenable() {
        return fenable;
    }

    public void setFenable(int fenable) {
        this.fenable = fenable;
    }
    
    

    

}
