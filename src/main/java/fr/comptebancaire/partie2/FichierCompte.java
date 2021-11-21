package fr.comptebancaire.partie2;

import java.io.*;

public class FichierCompte {
    private ObjectOutputStream ofW;
    private ObjectInputStream ofR;
    private String nomDuFichier = "Compte.dat";
    private char mode;

    public boolean ouvrir(String s) {
        try {
            mode = s.toUpperCase().charAt(0);
            if (mode == 'R' || mode =='L') 
                ofR = new ObjectInputStream(new FileInputStream(nomDuFichier));
            else if (mode == 'W' || mode == 'E')
                ofW = new ObjectOutputStream(new FileOutputStream(nomDuFichier));
            return true;
        }
        catch (IOException e) {
            return false;
        }
    }

    public void ecrire(ListeCompte tmp) {
        try {
            if (tmp != null) ofW.writeObject(tmp);
        }
        catch (IOException e) {
            System.out.println(nomDuFichier + " : Erreur lors de l'écriture ");
        }
    }

    public ListeCompte lire() {
        try {
            ListeCompte tmp = (ListeCompte) ofR.readObject();
            return tmp;
        }
        catch (IOException e) {
            System.out.println(nomDuFichier + " : Erreur de lecture ");
        }
        catch (ClassNotFoundException e) {
            System.out.println(nomDuFichier + " : n'est pas du bon format ");
        }
        return null;
    }

    public void fermer() {
        try {
            if (mode == 'R' || mode == 'L') ofR.close();
            else if (mode == 'W' || mode == 'E') ofW.close();
        }
        catch (IOException e) {
            System.out.println(nomDuFichier + " : Erreur à la fermeture ");
        }
    }
}
