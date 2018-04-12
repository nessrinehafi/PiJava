package Entities;

import Utils.CategoryType;
import Utils.StatutType;
import java.sql.Date;
import java.util.Objects;

/**
 *
 * @author Mega pc
 */
public class Reclamation {

    private int id;
    private CategoryType categorie;
    private Date dateCreation;
    private String titre;
    private String description;
    private String reponse = "Pas de réponse";
    private StatutType statut = StatutType.Nouvelle;
    private User user;

    public Reclamation() {
    }

    public Reclamation(int id, CategoryType categorie, Date dateCreation, String titre, String description, String reponse, StatutType statut, User user) {
        this.id = id;
        this.categorie = categorie;
        this.dateCreation = dateCreation;
        this.titre = titre;
        this.description = description;
        this.reponse = reponse;
        this.statut = statut;
        this.user = user;
    }

    public Reclamation(CategoryType categorie, Date dateCreation, String titre, String description, User user) {
        this.categorie = categorie;
        this.dateCreation = dateCreation;
        this.titre = titre;
        this.description = description;
        this.user = user;
    }
    
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CategoryType getCategorie() {
        return categorie;
    }

    public void setCategorie(CategoryType categorie) {
        this.categorie = categorie;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getReponse() {
        return reponse;
    }

    public void setReponse(String reponse) {
        this.reponse = reponse;
    }

    public StatutType getStatut() {
        return statut;
    }

    public void setStatut(StatutType statut) {
        this.statut = statut;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Reclamation{" + "id=" + id + ", categorie=" + categorie + ", dateCreation=" + dateCreation + ", titre=" + titre + ", description=" + description + ", reponse=" + reponse + ", statut=" + statut + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + this.id;
        hash = 29 * hash + Objects.hashCode(this.categorie);
        hash = 29 * hash + Objects.hashCode(this.dateCreation);
        hash = 29 * hash + Objects.hashCode(this.titre);
        hash = 29 * hash + Objects.hashCode(this.description);
        hash = 29 * hash + Objects.hashCode(this.reponse);
        hash = 29 * hash + Objects.hashCode(this.statut);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Reclamation other = (Reclamation) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.categorie, other.categorie)) {
            return false;
        }
        if (!Objects.equals(this.titre, other.titre)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.reponse, other.reponse)) {
            return false;
        }
        if (!Objects.equals(this.statut, other.statut)) {
            return false;
        }
        if (!Objects.equals(this.dateCreation, other.dateCreation)) {
            return false;
        }
        return true;
    }

}
