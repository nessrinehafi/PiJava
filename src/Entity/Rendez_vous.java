/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.sql.Date;
import javafx.scene.control.DatePicker;

/**
 *
 * @author haythem
 */
public class Rendez_vous {
    
    
    private int Id;
    private String message;
    private String date;
    private String heure;
    private Date createDt;
    private Date updateDt;
    private int demandeur_id;
    private boolean valide;
    private int accepteur_id;
    private boolean remove;
    private String service;

    public Rendez_vous() {
    }

    public Rendez_vous(String message, String date, String heure, Date createDt, Date updateDt, int demandeur_id, boolean valide, int accepteur_id, boolean remove, String service) {
        this.message = message;
        this.date = date;
        this.heure = heure;
        this.createDt = createDt;
        this.updateDt = updateDt;
        this.demandeur_id = demandeur_id;
        this.valide = valide;
        this.accepteur_id = accepteur_id;
        this.remove = remove;
        this.service = service;
    }
    
    public Rendez_vous(String date, String heure) {
       
        this.date = date;
        this.heure = heure;
        
    }
    
    public Rendez_vous(boolean valide) {
       
        this.valide = valide;
        
        
    }


    
    @Override
    public String toString() {
        return "rendez_vous{" + "message=" + message + ", date=" + date + ", heure=" + heure + ", createDt=" + createDt + ", updateDt=" + updateDt + ", demandeur_id=" + demandeur_id + ", valide=" + valide + ", accepteur_id=" + accepteur_id + ", remove=" + remove + ", service=" + service + '}';
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHeure() {
        return heure;
    }

    public void setHeure(String heure) {
        this.heure = heure;
    }

    public Date getCreateDt() {
        return createDt;
    }

    public void setCreateDt(Date createDt) {
        this.createDt = createDt;
    }

    public Date getUpdateDt() {
        return updateDt;
    }

    public void setUpdateDt(Date updateDt) {
        this.updateDt = updateDt;
    }

    public int getDemandeur_id() {
        return demandeur_id;
    }

    public void setDemandeur_id(int demandeur_id) {
        this.demandeur_id = demandeur_id;
    }

    public boolean isValide() {
        return valide;
    }

    public void setValide(boolean valide) {
        this.valide = valide;
    }

    public int getAccepteur_id() {
        return accepteur_id;
    }

    public void setAccepteur_id(int accepteur_id) {
        this.accepteur_id = accepteur_id;
    }

    public boolean isRemove() {
        return remove;
    }

    public void setRemove(boolean remove) {
        this.remove = remove;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    
    
}
