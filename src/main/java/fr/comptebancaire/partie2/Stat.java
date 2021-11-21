package fr.comptebancaire.partie2;

import java.awt.*;

public class Stat {

    Compte cpte;
    private double prctLoy, prctAli, prctDiv;

    public Stat(Compte c) {
        cpte = c;
    }

    private double pourcentage(double nb, double t) {
        double prct = 0;

        if (t > 0) {
            prct = (double) nb / t * 100;
        }
        return prct;
    }

    public void statParMotif() {
        double totDebit = 0;
        double totLoy = 0, totAli = 0, totDiv = 0;

        for (int i = 0; i <= cpte.getNbLigne(); i++) {
            if (cpte.getLigne(i).getValeurTransac() < 0)
                totDebit += Math.abs(cpte.getLigne(i).getValeurTransac());
            if (cpte.getLigne(i).getMotif().equalsIgnoreCase("Loyer"))
                totLoy += Math.abs(cpte.getLigne(i).getValeurTransac());
            if (cpte.getLigne(i).getMotif().equalsIgnoreCase("Alimentation"))
                totAli = totAli + Math.abs(cpte.getLigne(i).getValeurTransac());
            if (cpte.getLigne(i).getMotif().equalsIgnoreCase("Divers"))
                totDiv += Math.abs(cpte.getLigne(i).getValeurTransac());
        }

        prctLoy = pourcentage(totLoy, totDebit);
        prctAli = pourcentage(totAli, totDebit);
        prctDiv = pourcentage(totDiv, totDebit);
        System.out.println("A : " + prctAli + " L : " + prctLoy + " D : " + prctDiv);
    }

    public void dessine(Graphics g) {
        statParMotif();
        g.setColor(Color.darkGray);
        g.drawString("Compte n0 : " + cpte.getNumeroCompte(), 100, 50);
        g.drawString("Crédit", 105, 220);
        g.drawString("Débit", 160, 220);
        g.setColor(Color.blue);
        g.fillRect(100, 100, 50, 100);
        
        int reste = (int) (100 - prctLoy - prctAli - prctDiv);

        g.setColor(Color.green.darker().darker());
        g.fillRect(150, 100 + reste, 50, (int) prctLoy);
        g.drawString("Loyer", 210, 95 + (int) prctLoy + reste);
        g.setColor(Color.magenta);
		g.fillRect(150, 100 + (int) prctLoy + reste, 50, (int) prctAli);
		g.drawString("Alimentation", 210, 95 + (int) (prctLoy + prctAli) + reste);
		g.setColor(Color.red);
		g.fillRect(150, 100 + (int) (prctLoy + prctAli) + reste, 50, (int) prctDiv);
		g.drawString("Divers", 210, 95 + (int) (prctLoy + prctAli + prctDiv) + reste);
    }
}
