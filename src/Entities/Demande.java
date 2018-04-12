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
public class Demande {
    private int id ;
    private int user_id;
    private int annonce_id;
    private String categorie ;
    private Float Prix_Secondaire ;
    private String num_tel ;
    private boolean valide ;
    private String q1;
    private String q2;
    private String q3;
    private String q4;
    private String q5;
    private String q6;
    private String q7;
    private String q8;
    private String animal ;

    public Demande() {
    }

    public Demande(int user_id, int annonce_id,String categorie, Float Prix_Secondaire, String num_tel, String q7, String q8,String animal) {
        this.user_id = user_id;
        this.annonce_id = annonce_id;
        this.categorie = categorie;
        this.Prix_Secondaire = Prix_Secondaire;
        this.num_tel = num_tel;
        this.q7 = q7;
        this.q8 = q8;
        this.animal=animal;
    }
      public Demande(int user_id, int annonce_id,String categorie,float Prix_Secondaire, String q4, String q5, String q6,String num_tel,String animal) {
        this.user_id = user_id;
        this.annonce_id = annonce_id;
        this.categorie = categorie;
        this.Prix_Secondaire = Prix_Secondaire;
        this.q4 = q4;
        this.q5 = q5;
        this.q6 = q6;
        this.num_tel = num_tel;
        this.animal=animal;

        
    }
      public Demande(int user_id, int annonce_id,String categorie,float Prix_Secondaire, String q1, String q2, String q3,String q4,String num_tel,String animal) {
        this.user_id = user_id;
        this.annonce_id = annonce_id;
        this.categorie = categorie;
        this.Prix_Secondaire = Prix_Secondaire;
        this.q1 = q1;
        this.q2 = q2;
        this.q3 = q3;
        this.q4=q4;
        this.num_tel = num_tel;
        this.animal=animal;

        
    }

   

    @Override
    public String toString() {
        return "Demande{" + "id=" + id + ", user_id=" + user_id + ", annonce_id=" + annonce_id + ", categorie=" + categorie + ", Prix_Secondaire=" + Prix_Secondaire + ", num_tel=" + num_tel + ", valide=" + valide + ", q1=" + q1 + ", q2=" + q2 + ", q3=" + q3 + ", q4=" + q4 + ", q5=" + q5 + ", q6=" + q6 + ", q7=" + q7 + ", q8=" + q8 + '}';
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

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public Float getPrix_Secondaire() {
        return Prix_Secondaire;
    }

    public void setPrix_Secondaire(Float Prix_Secondaire) {
        this.Prix_Secondaire = Prix_Secondaire;
    }

    public String getNum_tel() {
        return num_tel;
    }

    public void setNum_tel(String num_tel) {
        this.num_tel = num_tel;
    }

    public boolean isValide() {
        return valide;
    }

    public void setValide(boolean valide) {
        this.valide = valide;
    }

    public String getQ1() {
        return q1;
    }

    public void setQ1(String q1) {
        this.q1 = q1;
    }

    public String getQ2() {
        return q2;
    }

    public void setQ2(String q2) {
        this.q2 = q2;
    }

    public String getQ3() {
        return q3;
    }

    public void setQ3(String q3) {
        this.q3 = q3;
    }

    public String getQ4() {
        return q4;
    }

    public void setQ4(String q4) {
        this.q4 = q4;
    }

    public String getQ5() {
        return q5;
    }

    public void setQ5(String q5) {
        this.q5 = q5;
    }

    public String getQ6() {
        return q6;
    }

    public void setQ6(String q6) {
        this.q6 = q6;
    }

    public String getQ7() {
        return q7;
    }

    public void setQ7(String q7) {
        this.q7 = q7;
    }

    public String getQ8() {
        return q8;
    }

    public void setQ8(String q8) {
        this.q8 = q8;
    }

    public String getAnimal() {
        return animal;
    }

    public void setAnimal(String animal) {
        this.animal = animal;
    }
    
    
    
    
    
}
