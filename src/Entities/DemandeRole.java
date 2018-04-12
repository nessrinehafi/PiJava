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
public class DemandeRole {
    private int id;
    private String nvrole;
    private boolean estvalide;
    private String demandeur;
    private Date dateDemande;
    private String demande;
    private String document;

    

    public DemandeRole() {
    }
    
    

    public DemandeRole(String demande,String document,String nvrole) {
        this.demande=demande;
        this.document=document;
        this.nvrole=nvrole;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNvrole() {
        return nvrole;
    }

    public void setNvrole(String nvrole) {
        this.nvrole = nvrole;
    }

    public boolean getEstvalide() {
        return estvalide;
    }

    public void setEstvalide(boolean estvalide) {
        this.estvalide = estvalide;
    }
    

    public String getDemandeur() {
        return demandeur;
    }

    public void setDemandeur(String demandeur) {
        this.demandeur = demandeur;
    }

    public Date getDateDemande() {
        return dateDemande;
    }

    public void setDateDemande(Date dateDemande) {
        this.dateDemande = dateDemande;
    }

    public String getDemande() {
        return demande;
    }

    public void setDemande(String demande) {
        this.demande = demande;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

   
    
    
    
    
   
    
    }
