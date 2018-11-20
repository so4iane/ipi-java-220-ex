package com.ipiecoles.java.java220;

import com.ipiecoles.java.java220.exceptions.TechnicienException;
import org.joda.time.LocalDate;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Manager extends Employe {
    public Double getPrimeAnnuelle () {
        return Entreprise.primeAnnuelleBase()+Entreprise.PRIME_MANAGER_PAR_TECHNICIEN* equipe.size();
    }

    private HashSet<Technicien> equipe = new HashSet <>();

    public void ajoutTechnicienEquipe(Technicien tec){
        equipe.add(tec);
    }

    public void augmenterSalaire(Double pourcentage) {
        super.augmenterSalaire(pourcentage);
        augmenterSalaireEquipe(pourcentage);
    }

    private void augmenterSalaireEquipe(Double pourcentage) {
        for (Technicien technicien : equipe) {
            technicien.augmenterSalaire(pourcentage);
        }
    }
    public void ajoutTechnicienEquipe(String nom, String prenom, String matricule, LocalDate dateEmbauche, Double salaire, Integer grade) {
        this.ajoutTechnicienEquipe(new Technicien(nom, prenom, matricule, dateEmbauche, salaire, grade));
    }

    public List<Technicien> equipeParGrade(){
        return equipe.stream().sorted().collect(Collectors.toList());//permet de trier la liste
    }

    public Double salaireEquipeGrade1(){
        return equipe.stream()
                .filter(technicien-> technicien.getGrade().equals(1))//filtre pour grade =1
                .mapToDouble(t->t.getSalaire())//transforme en double pour faire la somme
                .sum();//on fait la somme
    }

    @Override
    public void setSalaire(Double salaire) {
        super.setSalaire(salaire* Entreprise.INDICE_MANAGER + (salaire*(double)equipe.size()*0.1));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Manager)) return false;
        if (!super.equals(o)) return false;
        Manager manager = (Manager) o;
        return Objects.equals(equipe, manager.equipe);
    }



    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), equipe);
    }

    public HashSet<Technicien> getEquipe() {
        return equipe;
    }

    public void setEquipe(HashSet<Technicien> equipe) {
        this.equipe = equipe;
    }
}
