package com.ipiecoles.java.java220.exceptions;

import com.ipiecoles.java.java220.Technicien;

public class TechnicienException extends Exception {
    public static final String GRADE = "Le grade doit être compris entre 1 et 5 : ";

    public TechnicienException(Technicien technicien, Integer gradeIncorrect) {
        super("Le grade doit être compris entre 1 et 5 : " + gradeIncorrect + ", technicien : Technicien{grade=2} " + technicien.toString());
        System.out.println(this.getMessage());
    }
}

