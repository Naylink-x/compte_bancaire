package fr.comptebancaire.partie2;

import java.awt.*;
import java.awt.event.*;

public class Saisie implements ActionListener {
    ListeCompte lc;
    TextField reponse;

    public Saisie(ListeCompte tmp_lc) {
        lc = tmp_lc;

        Frame F = new Frame("Saisie du n° de compte ");
        F.setSize(300, 50);
        F.setBackground(Color.white);
        F.setLayout(new BorderLayout());
        F.add(new Label("Numéro du compte : "), "West");
        reponse = new TextField(10);
        F.add(reponse, "East");
        reponse.addActionListener(this);
        F.setVisible(true);
    }

    public void actionPerformed(ActionEvent evt) {
        String numero = reponse.getText();
        Compte cpte = new Compte("");
        cpte = lc.getCompte(numero);

        if (cpte != null) {
            Stat s = new Stat(cpte);
            new Fenetre(s);
        }
    }
}
