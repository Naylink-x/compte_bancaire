package fr.comptebancaire.partie2;

import java.util.*;

public class CompteEpargne extends Compte {
    static Scanner in = new Scanner(System.in);

    private double taux;

    public CompteEpargne() {
        super("Epargne");
		taux = controlTaux();
    }

    private double controlTaux() {
        double tmpt;

        do {
            System.out.println("Taux de placement : ");
            tmpt = in.nextDouble();
        } while (tmpt < 0);
        return tmpt;
    }

    public void afficherCpte(){
        super.afficherCpte();
        System.out.println("Taux d'épargne du compte : " + taux);
    }

    public double getTaux() {
        return taux;
    }
}
