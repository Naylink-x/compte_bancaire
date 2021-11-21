package fr.comptebancaire.partie2;

import java.awt.event.*;

public class GestionQuitter extends WindowAdapter implements ActionListener {
    
    public void actionPerformed(ActionEvent e) {
        System.exit(0);
    }

    public void windowClosing(WindowEvent e) {
        System.exit(0);
    }
}
