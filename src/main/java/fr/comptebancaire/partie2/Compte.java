package fr.comptebancaire.partie2;

import java.io.Serializable;
import java.util.*;

public class Compte implements Serializable {
	static Scanner in = new Scanner(System.in);
	
	private String numeroCompte;
	private String typeCompte;
	protected double valeurCourante = 0.0;
	private LigneComptable [] ligne;
	public static final int NBLigne = 10;
	private int nbLigneReel;
	
	public Compte() {
		typeCompte = controlType();
		System.out.println("Numéro du compte : ");
		numeroCompte = in.next();
		valeurCourante = controlValInit();
		ligne = new LigneComptable[NBLigne];
		nbLigneReel = -1;
	}
	
	public Compte(String type) {
		if (type.equalsIgnoreCase("Epargne")) {
			typeCompte = type;
			System.out.println("Numéro du compte : ");
			numeroCompte = in.next();
			valeurCourante = controlValInit();
			ligne = new LigneComptable[NBLigne];
			nbLigneReel = -1;
		}
	}
	
	public void afficherCpte() {
		System.out.print("Le compte n° : " + numeroCompte);
		System.out.println(" est un compte " + typeCompte);
		if (nbLigneReel >= 0)
			for (int iLigne = 0; iLigne <= nbLigneReel; iLigne ++) {
				ligne[iLigne].afficherLigne();
			}
		System.out.println("Valeur courante : " + valeurCourante);
		if (valeurCourante < 0) {
			System.out.println("Attention compte débiteur ... !");
		}
	}
	
	public void creerLigne() {
		nbLigneReel++;
		if (nbLigneReel < NBLigne) {
			ligne[nbLigneReel] = new LigneComptable();
		}
		else {
			nbLigneReel--;
			decalerLignes();
			ligne[NBLigne - 1] = new LigneComptable();
		}
		valeurCourante += ligne[nbLigneReel].getValeurTransac();
	}

	private void decalerLignes() {
		for (int iLigne = 1; iLigne < NBLigne; iLigne++) {
			ligne[iLigne - 1] = ligne[iLigne]; 
		}
	}
	
	private String controlType() {
		char tmpc;
		String tmpS = "Courant";
		
		do {
			System.out.println("Type du compte [Types possibles : ");
			System.out.println("C(ourant), J(oint)] : ");
			tmpc = in.next().charAt(0);
		} while (tmpc != 'C' && tmpc != 'J');
		switch (tmpc) {
		case 'C' :
			tmpS = "Courant";
			break;
		case 'J' :
			tmpS = "Joint";
			break;
		}
		return tmpS;
	}
	
	private double controlValInit() {
		double tmpV;
		
		do {
			System.out.println("Première valeur créditée : ");
			tmpV = in.nextDouble();
		} while (tmpV <= 0);
		
		return tmpV;
	}
	
	public String getNumeroCompte() {
		return numeroCompte;
	}
	
	public String getTypeCompte() {
		return typeCompte;
	}
	
	public double getValeurCourante() {
		return valeurCourante;
	}

	public int getNbLigne() {
		return nbLigneReel;
	}

	public LigneComptable getLigne(int n) {
		return ligne[n];
	}
}