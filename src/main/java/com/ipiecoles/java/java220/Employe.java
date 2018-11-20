package com.ipiecoles.java.java220;

import org.joda.time.LocalDate;

import java.util.Objects;

/**
 * Created by pjvilloud on 21/09/17.
 */
public abstract class Employe {
    //on met les attributs en prive
    private String nom;
    private String prenom;
    private String matricule;
    private LocalDate dateEmbauche; //on utilise tjs le LocalDate(org.joda.time)
    private Double salaire;
    public Employe(){ }

    public Employe(String nom, String prenom, String matricule, LocalDate dateEmbauche, Double salaire) {
        this.nom = nom;
        this.prenom = prenom;
        this.matricule = matricule;
        this.dateEmbauche = dateEmbauche;
        this.salaire = salaire;
    }
    //pour créer un constructeur on peut le générer avec un clic droit
    public final Integer getNombreAnneeAnciennete(){//final car la valeur peut changer
        return  LocalDate.now().getYear()- this.dateEmbauche.getYear();
    }

    public Integer getNbConges(){
        return Entreprise.NB_CONGES_BASE;
    }


    //On utiliste clic droit puis generate pour faire un toString
    public String toString() {
        return "Employe{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", matricule='" + matricule + '\'' +
                ", dateEmbauche=" + dateEmbauche +
                ", salaire=" + salaire +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;//si la classe qu'on compare est egale à l'objet o
        if (o == null) return false;//si l'objet o est null (vide)
        if (!(o instanceof Employe)) return false; //on peut aussi faire getclass()!=o.getclass() On compare les classe
        Employe employe = (Employe) o;
        return Objects.equals(nom, employe.nom) &&
                Objects.equals(prenom, employe.prenom) &&
                Objects.equals(matricule, employe.matricule) &&
                Objects.equals(dateEmbauche, employe.dateEmbauche) &&
                Objects.equals(salaire, employe.salaire);
    }

    @Override
    public int hashCode() {

        return Objects.hash(nom, prenom, matricule, dateEmbauche, salaire);
    }

    public void augmenterSalaire(Double pourcentage){
        this.salaire = salaire*(1+pourcentage);//*= peut remplacer =salaire
    }

    public abstract Double getPrimeAnnuelle();

    //On utilise le clic droit generate pour les getter/setter, et on met tjs les g/s à la fin du code
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

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public LocalDate getDateEmbauche() {
        return dateEmbauche;
    }

    public void setDateEmbauche(LocalDate dateEmbauche) throws Exception {
        if (dateEmbauche != null && dateEmbauche.isAfter(LocalDate.now())) {//on utilise le isAfter
            throw new Exception("La date d'embauche ne peut être postérieure à la date courante");
        } else {
            this.dateEmbauche = dateEmbauche;
        }
    }

    public Double getSalaire() {
        return salaire;
    }

    public void setSalaire(Double salaire) {
        this.salaire = salaire;
    }
}

