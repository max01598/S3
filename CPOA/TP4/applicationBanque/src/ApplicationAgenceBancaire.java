

import java.util.Locale;
import java.util.Scanner;

import application.AccesAgenceBancaire;
import banque.AgenceBancaire;
import banque.Compte;
import banque.exception.CompteException;

public class ApplicationAgenceBancaire {
	
	/**
	 * Affichage du menu de l'application
	 * @param ag	AgenceBancaire pour r�cup�rer le nom et la localisation
	 */
	public static void afficherMenu(AgenceBancaire ag) {
		System.out.println("Menu de " + ag.getNomAgence() + " (" + ag.getLocAgence() + ")");
		System.out.println("l - Liste des comptes de l'agence");
		System.out.println("v - Voir un compte (par son num�ro)");
		System.out.println("p - voir les comptes d'un Propri�taire (par son nom)");
		System.out.println("d - D�poser de l'argent sur un compte");
		System.out.println("r - Retirer de l'argent sur un compte");
		System.out.println("q - Quitter");
		System.out.print("Choix -> ");
	}
	
	/**
	 * Temporisation : Affiche un message et attend la frappe de n'importe quel caract�re.
	 */
	public static void tempo () {
		Scanner lect ;
		
		lect = new Scanner (System.in );
		
		System.out.print("Tapper un car + return pour continuer ... ");
		lect.next(); // Inutile � stocker mais ... 
	}

	public static void main(String argv[]) {
		
		String choix;

		boolean continuer ;
		Scanner lect;
		AgenceBancaire monAg ;
		
		String nom, numero;		
		Compte c;
		double montant;
		
		lect = new Scanner ( System.in );
		lect.useLocale(Locale.US);
		
		monAg = AccesAgenceBancaire.getAgenceBancaire();
		
		continuer = true;
		while (continuer) {
			ApplicationAgenceBancaire.afficherMenu(monAg);
			choix = lect.next();
			choix = choix.toLowerCase();
			switch (choix) {
				case "q" :
					System.out.println("ByeBye");
					ApplicationAgenceBancaire.tempo();
					continuer = false;
					break;
				case "l" :
					monAg.afficher();
					ApplicationAgenceBancaire.tempo();
					break;	
				case "v" :
					System.out.print("Num compte -> ");
					numero = lect.next();
					c = monAg.getCompte(numero);
					if (c==null) {
						System.out.println("Compte inexistant ...");
					} else {
						c.afficher();
					}
					ApplicationAgenceBancaire.tempo();
					break;
				case "p" :
					System.out.print("Propri�taire -> ");
					nom = lect.next();
					ApplicationAgenceBancaire.comptesDUnPropretaire (monAg, nom);
					ApplicationAgenceBancaire.tempo();
					break;		
				case "d" :
					System.out.print("Num compte -> ");
					numero = lect.next();
					System.out.print("Montant � d�poser -> ");
					montant = lect.nextDouble();
					ApplicationAgenceBancaire.deposerSurUnCompte(monAg, numero, montant);
					ApplicationAgenceBancaire.tempo();
					break;
				case "r" :
					System.out.print("Num compte -> ");
					numero = lect.next();
					System.out.print("Montant � retirer -> ");
					montant = lect.nextDouble();
					ApplicationAgenceBancaire.retirerSurUnCompte(monAg, numero, montant);
					ApplicationAgenceBancaire.tempo();
					break;
				default :
					System.out.println("Erreur de saisie ...");
					ApplicationAgenceBancaire.tempo();
					break;
			}
		}
		
	}
	
	public static void comptesDUnPropretaire (AgenceBancaire ag, String nomProprietaire) {
		Compte []  t; 
		
		t = ag.getComptesDe(nomProprietaire);
		if (t.length == 0) {
			System.out.println("pas de compte � ce nom ...");
		} else {
			System.out.println("  " + t.length + " comptes pour " + nomProprietaire);
			for (int i=0; i<t.length; i++)
				t[i].afficher();
		}
	}

	public static void deposerSurUnCompte (AgenceBancaire ag, String numeroCompte, double montant) {
		Compte c;
		
		c = ag.getCompte(numeroCompte);
		if (c==null) {
			System.out.println("Compte inexistant ...");
		} else {
			System.out.println("Solde avant d�p�t: "+c.soldeCompte());
			try {
				c.deposer(montant);
				System.out.println("Montant d�pos�, solde : "+c.soldeCompte());
			} catch (CompteException e) {
				System.out.println("Erreur de d�pot, solde inchang� : " + c.soldeCompte());
				System.out.println(e.getMessage());
			}
		}
	}
	
	public static void retirerSurUnCompte (AgenceBancaire ag, String numeroCompte, double montant) {
		Compte c;
		
		c = ag.getCompte(numeroCompte);
		if (c==null) {
			System.out.println("Compte inexistant ...");
		} else {
			System.out.println("Solde avant retrait : " + c.soldeCompte());
			try {
				c.retirer(montant);
				System.out.println("Montant retir�, solde : "+c.soldeCompte());
			} catch (CompteException e) {
				System.out.println("Erreur de d�pot, solde inchang� : " + c.soldeCompte());
				System.out.println(e.getMessage());
			}
		}

	}
}
