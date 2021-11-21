package fr.comptebancaire.partie2;

import java.awt.*;

public class Fenetre extends Frame {
    public final static int HT = 300;
    public final static int LG = 300;

    public Fenetre(Stat s) {
        setTitle("Les statistiques du compte ");
        setSize(LG, HT);
        setBackground(Color.darkGray);
        addWindowListener(new GestionQuitter());

        Dessin page = new Dessin(s);
        add(page, "Center");

        Button bQuitter = new Button("Quitter");
        bQuitter.addActionListener(new GestionQuitter());
        add(bQuitter, "South");
        setVisible(true);
    }
}
