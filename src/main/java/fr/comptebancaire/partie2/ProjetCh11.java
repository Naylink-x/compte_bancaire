package fr.comptebancaire.partie2;

import java.util.*;

public class ProjetCh11 {
    
    /* public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        byte option = 0;
        String numeroLu = "";

        ListeCompte liste = new ListeCompte();
        FichierCompte F = new FichierCompte();

        if (F.ouvrir("R")) {
            liste = F.lire();
            F.fermer();
        }

        System.out.println("Affichage des statistiques");
        System.out.print("Quel compte souhaitez-vous afficher ? : ");
        numeroLu = in.next();
        Compte cpte = new Compte("");
        cpte = liste.getCompte(numeroLu);
        if (cpte != null) {
            Stat s = new Stat(cpte);
            s.statParMotif();
        }
    } */

    public static void main (String [] argument)	{
        ListeCompte liste = new ListeCompte();
        FichierCompte F = new FichierCompte();
        if (F.ouvrir("L")) {
            liste = F.lire();
            F.fermer();
        }
        if (liste != null) 	new Saisie(liste);
    }	
}
