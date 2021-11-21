package fr.comptebancaire.partie1;

import java.util.*;

public class CompteBancaire {
	static Scanner in = new Scanner(System.in);
	
	static String numeroCompte, numeroLu;
	static String typeCompte;
	static double valeur = 0.0, taux = 0.0;

	public static void main(String[] args) {
		
		char tmp;
		//Date date;
		//String theme;
		//String moyenDePaiement;
		byte option;
		
		do {
			option = menuPrincipal();
			switch (option) {
				case 1 :
					do {
						System.out.println("Type du compte [Types possibles : ");
						System.out.println("C(ourant), J(oint), E(pargne)] : ");
						tmp = in.next().charAt(0);
					} while (tmp != 'C' && tmp != 'J' && tmp != 'E');
					switch (tmp) {
						case 'C' : typeCompte = "Courant";
						break;
						case 'J' : typeCompte = "Joint";
						break;
						case 'E' : typeCompte = "Epargne";
						break;
					}
					System.out.println("Numéro du compte : ");
					numeroCompte = in.next();
					System.out.println("Première valeur créditée : ");
					valeur = in.nextDouble();
					if (typeCompte.equalsIgnoreCase("Epargne")) {
						System.out.println("Taux de placement : ");
						taux = in.nextDouble();
					}
				break;
				case 2 :
					afficherCpte();
				break;
				case 3 :
					System.out.println("Option non programmée");
				break;
				case 4 :
					sortir();
				break;
				case 5 :
					alAide();
				break;
				default :
					System.out.println("Cette option n'existe pas ");
			}
		} while (option != 4);
	}
	
	
	public static byte menuPrincipal() {
		byte tmp;
		
		System.out.println("1. Créer un compte");
		System.out.println("2. Afficher un compte");
		System.out.println("3. Créer une ligne comptable");
		System.out.println("4. Sortir");
		System.out.println("5. De l'aide");
		System.out.println();
		System.out.println("Votre choix :");
		tmp = in.nextByte();
		
		return tmp;
	}
	
	public static void sortir() {
		System.out.println("Au revoir !");
		System.exit(0);
	}
	
	public static void alAide() {
		System.out.println("Option 1. Pour créer un compte Courant entrer C ");
		System.out.println("          Pour créer un compte Joint entrer J ");
		System.out.println("          Pour créer un compte Epargne entrt E");
		System.out.print("          Puis entrer le numéro du compte, et");
		System.out.println(" sa première valeur créditée ");
		System.out.println("          Dans le cas d'un compte épargne, entrer le taux ");
		System.out.println("Option 2. Le système affiche les données du compte choisi ");
		System.out.println("Option 3. Ecrire une ligne comptable ");
		System.out.println("Option 4. Pour quitter le programme ");
		System.out.println("Option 5. Pour afficher l'aide ");
	}
	
	public static void afficherCpte() {
		// demande à l'utilisateur de saisir le numéro du compte à afficher
		System.out.println("Saisissez le numéro du compte à consulter : ");
		numeroLu = in.next();
		// vérifier si le compte existe
		if (numeroLu.equalsIgnoreCase(numeroCompte)) {
			// si oui, affiche le numéro de compte, le type, la valeur initiale
			System.out.print("Le compte n° : " + numeroCompte + " est un compte ");
			if (typeCompte.equalsIgnoreCase("Courant")) System.out.println("courant ");
			else if (typeCompte.equalsIgnoreCase("Joint")) System.out.println("joint ");
			// affiche son taux dans le cas d'un compte épargne
			else if (typeCompte.equalsIgnoreCase("Epargne")) System.out.println("épargne dont le taux est " + taux + "%");
			System.out.println("Première valeur créditée : " + valeur);
		}
		else {
			// sinon affiche un message indiquant numéro de compte invalide
			System.out.println("Le système ne connait pas le compte " + numeroLu);
		}
	}
}
