/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.util.Date;

/**
 *
 * @author nouha
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
    private String nom;
    private String prenom;
    private int numtel;
    private String Datenaiss;
    private String adresse;
    private String image;
    private String role;
    
    
    public User(){
        
    }

    public User(String username, String email,String password,String nom, String prenom, int numtel,String Datenaiss,String adresse,String image) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.nom = nom;
        this.prenom = prenom;
        this.numtel=numtel;
        this.Datenaiss=Datenaiss;
        this.adresse=adresse;
        this.image=image;
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
