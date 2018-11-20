package com.ipiecoles.java.java220;

import org.joda.time.LocalDate;

import java.util.Objects;

public class Commercial extends Employe {
    private Double caAnnuel= 0d;
    private Integer performence;

    public Double getPrimeAnnuelle () {

        if (this.getCaAnnuel() != null) {
            return Math.max(Math.ceil(this.getCaAnnuel()*0.05),500);
            //On vérifie que caAnnuel n'est pas nul puis on prends 500 si la prime Annuelle +(% est inférieur à 500 est en dessous.
        }
        return 500d;
    }

    public Boolean performenceEgale(Integer performence){
        return Objects.equals(this.performence, performence);//Object.equals gère le null
    }

    public Note equivalenceNote(){
        switch (this.performence){
            case 0:
            case 50:
                return Note.INSUFFISANT;
            case 100:
                return Note.PASSABLE;
            case 150:
                return Note.BIEN;
            case 200:
                return Note.TRES_BIEN;
                default:
                    return null;
        }
    }

    public Commercial() {
        super();
    }

    public Commercial(String nom, String prenom, String matricule, LocalDate dateEmbauche, Double salaire, Double caAnnuel) {
        super(nom, prenom, matricule, dateEmbauche, salaire);
        this.caAnnuel = caAnnuel;
    }

    public Commercial(Double caAnnuel, Integer performence) {
        this.caAnnuel = caAnnuel;
        this.performence = performence;
    }

    public Commercial(String nom, String prenom, String matricule, LocalDate dateEmbauche, Double salaire, Double caAnnuel, Integer performence) {
        this(nom, prenom, matricule, dateEmbauche, salaire, caAnnuel);
        this.performence = performence;
    }

    public Double getCaAnnuel() {
        return caAnnuel;
    }

    public void setCaAnnuelle(Double caAnnuel) {
        this.caAnnuel = caAnnuel;
    }
}
