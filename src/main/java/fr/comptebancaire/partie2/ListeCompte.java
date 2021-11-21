package fr.comptebancaire.partie2;

import java.io.Serializable;
import java.util.*;

public class ListeCompte implements Serializable {

    private HashMap<String, Compte> listeDeCompte;

    public ListeCompte() {
        listeDeCompte = new HashMap<String, Compte>();
    }

    public void ajouteUnCompte(String t) {
        Compte nouveauCompte = new Compte("");
        if (t.equalsIgnoreCase("E")) nouveauCompte = new CompteEpargne();
        else nouveauCompte = new Compte();
        String cle = nouveauCompte.getNumeroCompte();
        if (listeDeCompte.get(cle) == null) listeDeCompte.put(cle, nouveauCompte);
        else System.out.println("Ce compte existe déjà !");
    }

    public void ajouteUneLigne(String n) {
        Compte nCompte = (Compte) listeDeCompte.get(n);
        if (nCompte != null) nCompte.creerLigne();
        else System.out.println("Le compte " + n + " n'existe pas !");
    }

    public void rechercheUnCompte(String n) {
        Compte nCompte = (Compte) listeDeCompte.get(n);
        if (nCompte != null) nCompte.afficherCpte();
        else System.out.println("Le compte " + n + " n'existe pas !");
    }

    public void supprimeUnCompte(String n) {
        Compte nCompte = (Compte) listeDeCompte.get(n);
        if (nCompte != null) {
            listeDeCompte.remove(n);
            System.out.println("Le compte " + n + " a été supprimé !");
        }
        else System.out.println("Le compte " + n + " n'existe pas !");
    }

    public void afficheLesComptes() {
        if (listeDeCompte.size() != 0) {
            Collection<Compte> cCompte = listeDeCompte.values();
            for (Compte c : cCompte) c.afficherCpte();
        }
        else System.out.println("La liste de comptes est vide !");
    }

    public Compte getCompte(String n) {
        Compte nCompte = (Compte) listeDeCompte.get(n);
        if (nCompte == null) System.out.println("Le compte " + n + " n'existe pas !");
        return nCompte;
    }
}
