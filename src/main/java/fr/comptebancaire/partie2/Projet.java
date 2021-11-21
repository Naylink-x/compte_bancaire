package fr.comptebancaire.partie2;

import java.util.*;

public class Projet {

	static Scanner in = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		byte option;
		String numeroLu = "";
		
		ListeCompte C = new ListeCompte();
		FichierCompte F = new FichierCompte();
		if (F.ouvrir("R")) {
			C = F.lire();
			F.fermer();
		}

		
		do {
			option = menuPrincipal();
			switch (option) {
				case 1 :
					System.out.print("Compte Epargne (o/n) : ");
					if (in.next().charAt(0) == 'o')
						C.ajouteUnCompte("E");
					else
						C.ajouteUnCompte("A");
					break;
				case 2 :
					System.out.println("Saisissez le numéro du compte à consulter : ");
					numeroLu = in.next();
					C.rechercheUnCompte(numeroLu);
					break;
				case 3 :
					C.afficheLesComptes();
					break;
				case 4 :
					System.out.println("Sur quel compte souhaitez-vous enregistrer une opération ?");
					numeroLu = in.next();
					C.ajouteUneLigne(numeroLu);
					break;
				case 5 :
					System.out.println("Saisissez le numéro du compte à supprimer : ");
					numeroLu = in.next();
					C.supprimeUnCompte(numeroLu);
					break;
				case 6 :
					System.out.println("Sauvegarde des données dans le fichier Compte.dat");
					F.ouvrir("W");
					F.ecrire(C);
					F.fermer();
					sortir();
					break;
				case 7 :
					alAide();
					break;
				default :
					System.out.println("Cette option n'existe pas ");
			}
		} while (option != 6);
	}
	
	
	public static byte menuPrincipal() {
		byte tmp;
		
		System.out.println("1. Créer un compte");
		System.out.println("2. Afficher un compte");
		System.out.println("3. Afficher tous les comptes");
		System.out.println("4. Créer une ligne comptable");
		System.out.println("5. Supprimer un compte");
		System.out.println("6. Sortir");
		System.out.println("7. De l'aide");
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
		System.out.println("Option 3. Le système affiche les données de tous les comptes ");
		System.out.println("Option 4. Ecrire une ligne comptable ");
		System.out.println("Option 5. Le système supprime le compte choisi ");
		System.out.println("Option 6. Pour quitter le programme ");
		System.out.println("Option 7. Pour afficher l'aide ");
	}
}

