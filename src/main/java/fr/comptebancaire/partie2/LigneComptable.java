package fr.comptebancaire.partie2;

import java.io.*;
import java.text.*;
import java.util.*;

public class LigneComptable implements Serializable {
	static Scanner in = new Scanner(System.in);
	
	private double valeurTransac;
	private String date;
	private String motif;
	private String modePaiement;
	
	public LigneComptable() {
		System.out.println("Entrer la valeur à créditer (+) ou à débiter (-) : ");
		valeurTransac = in.nextDouble();
		date = controlDate();
		motif = controlMotif();
		modePaiement = controlModePaiement();
	}
	
	public void afficherLigne() {
		if (valeurTransac < 0)
			System.out.println("Débiter : " + valeurTransac);
		else
			System.out.println("Créditer : " + valeurTransac);
		System.out.println("Le : " + date + "; motif : " + motif + "; mode de paiement : " + modePaiement);
	}

	private String controlDate() {
		byte count = 0;
		Date tmpD = null;
		SimpleDateFormat formater = new SimpleDateFormat("dd/MM/yyyy");
		String sDate;

		while(tmpD == null) {
			try {
				System.out.println("Entrez la date de l'opération [jj/mm/aaaa] : ");
				tmpD = formater.parse(in.next());
			}
			catch (ParseException e) {
				count++;
				System.out.println("Le format de la date est incorrect !");
				if (count >= 3) tmpD = new Date();
			}
		}
		sDate = formater.format(tmpD);
		return sDate;
	}

	private String controlModePaiement() {
		char tmpc;
		String tmpS = "CB";
		
		do {
			System.out.println("Entrer le mode de paiement [C(B), N(° Chèque), V(irement) : ");
			tmpc = in.next().charAt(0);
		} while (tmpc != 'C' && tmpc != 'N' && tmpc != 'V');
		switch (tmpc) {
		case 'C' :
			tmpS = "CB";
			break;
		case 'N' :
			tmpS = "N°Chèque";
			break;
		case 'V' :
			tmpS = "Virement";
			break;
		}
		return tmpS;
	}
	
	private String controlMotif() {
		char tmpc;
		String tmpS = "Salaire";
		
		do {
			System.out.println("Entrer le motif [S(alaire), L(oyer), A(limentation), D(ivers)] : ");
			tmpc = in.next().charAt(0);
		} while (tmpc != 'S' && tmpc != 'L' && tmpc != 'A' && tmpc != 'D');
		switch (tmpc) {
		case 'S' :
			tmpS = "Salaire";
			break;
		case 'L' :
			tmpS = "Loyer";
			break;
		case 'A' :
			tmpS = "Alimentation";
			break;
		case 'D' :
			tmpS = "Divers";
			break;
		}
		return tmpS;
	}

	
	public double getValeurTransac() {
		return valeurTransac;
	}
	
	public String getDate() {
		return date;
	}
	
	public String getMotif() {
		return motif;
	}
	
	public String getModePaiement() {
		return modePaiement;
	}
}
