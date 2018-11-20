package com.ipiecoles.java.java220;


import org.joda.time.LocalDate;

public class Entreprise {
    public static Double SALAIRE_BASE  = 1480.27;
    public static Integer NB_CONGES_BASE = 25;
    public static Double INDICE_MANAGER = 1.3;
    public static Double PRIME_MANAGER_PAR_TECHNICIEN = 250d;
    //on met un d pour preciser que c'est un double (sinon 250 est un entier)
    public static Double PRIME_ANCIENNETE = 100.0;
    //on met .0 pour preciser que c'est un double (pareil que si on avait mis un d)
    public static Double primeAnnuelleBase() {
        return LocalDate.now().getYear() / 2d;//localDate.now pour la date d'aujourd'hui, puis /2 pour les 50%
    }
}
