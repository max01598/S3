

import java.util.Locale;
import java.util.Scanner;

import application.AccesAgenceBancaire;
import banque.AgenceBancaire;
import banque.Compte;
import banque.exception.ABCompteDejaExistantException;
import banque.exception.ABCompteInexistantException;
import banque.exception.ABCompteNullException;
import banque.exception.CompteException;

public class ApplicationAgenceBancaire {
	
	/**
	 * Affichage du menu de l'application
	 * @param ag	AgenceBancaire pour récupérer le nom et la localisation
	 */
	public static void afficherMenu(AgenceBancaire ag) {
		System.out.println("--");
		System.out.println("	Agence " + ag.getNomAgence() + " de" + ag.getLocAgence());
		System.out.println("	Menu General");
		System.out.println("--");
		System.out.println("	Choisir : ");
		System.out.println("1 - Liste des comptes de l'agence");
		System.out.println("2 - Voir un compte (par son numéro)");
		System.out.println("3 - Menu opérations sur comptes");
		System.out.println("4 - Menu gestion des comptes");
		System.out.println(" ");
		System.out.println("0 - Quitter");
		System.out.print("Votre choix ? ");
	}
	
	public static void AfficherSousMenuOperationCompte(AgenceBancaire ag) {
		System.out.println("--");
		System.out.println("	Agence " + ag.getNomAgence() + " de" + ag.getLocAgence());
		System.out.println("	Menu operations sur comptes");
		System.out.println("--");
		System.out.println("	Choisir : ");
		System.out.println("1 - Déposer de l'argent sur un compte");
		System.out.println("2 - Retirer de l'argent sur un compte");
		System.out.println(" ");
		System.out.println("0 - Quitter");
		System.out.print("Votre choix ? ");
	}
	
	public static void AfficherSousMenuGestionCompte(AgenceBancaire ag) {
		System.out.println("--");
		System.out.println("	Agence " + ag.getNomAgence() + " de" + ag.getLocAgence());
		System.out.println("	Menu operations sur comptes");
		System.out.println("--");
		System.out.println("	Choisir : ");
		System.out.println("1 - Ajouter un compte");
		System.out.println("2 - Supprimer un compte");
		System.out.println(" ");
		System.out.println("0 - Quitter");
		System.out.print("Votre choix ? ");
	}
	
	/**
	 * Temporisation : Affiche un message et attend la frappe de n'importe quel caractère.
	 */
	public static void tempo () {
		Scanner lect ;
		
		lect = new Scanner (System.in );
		
		System.out.print("Tapper un car + return pour continuer ... ");
		lect.next(); // Inutile à stocker mais ... 
	}

	public static void main(String argv[]) throws ABCompteNullException, ABCompteDejaExistantException, ABCompteInexistantException {
		
		String choix;

		boolean continuer ;
		boolean SousMenucontinuer ;
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
				case "0" :
					ApplicationAgenceBancaire.tempo();
					continuer = false;
					break;
				case "1" :
					monAg.afficher();
					ApplicationAgenceBancaire.tempo();
					break;	
				case "2" :
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
				case "3" :
					SousMenucontinuer=true;
					while(SousMenucontinuer) {
						ApplicationAgenceBancaire.AfficherSousMenuOperationCompte(monAg);
						choix = lect.next();
						choix = choix.toLowerCase();
						switch(choix) {
						case "0" :
							ApplicationAgenceBancaire.tempo();
							SousMenucontinuer = false;
							break;
						case "1" :
							System.out.print("Num compte -> ");
							numero = lect.next();
							System.out.print("Montant à déposer -> ");
							montant = lect.nextDouble();
							ApplicationAgenceBancaire.deposerSurUnCompte(monAg, numero, montant);
							ApplicationAgenceBancaire.tempo();
							break;
						case "2" :
							System.out.print("Num compte -> ");
							numero = lect.next();
							System.out.print("Montant à retirer -> ");
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
					break;		
				case "4" :
					SousMenucontinuer=true;
					while(SousMenucontinuer) {
						ApplicationAgenceBancaire.AfficherSousMenuGestionCompte(monAg);
						choix = lect.next();
						choix = choix.toLowerCase();
						switch(choix) {
						case "0" :
							System.out.println("ByeBye");
							ApplicationAgenceBancaire.tempo();
							SousMenucontinuer = false;
							break;
						case "1" :
							Compte cpt = new Compte();
							ApplicationAgenceBancaire.ajouterCompte(monAg, cpt);;
							ApplicationAgenceBancaire.tempo();
							break;
						case "2" :
							System.out.println("Nom du proprio :");
							nom = lect.next();
							ApplicationAgenceBancaire.supprimerCompte(monAg,nom);
							ApplicationAgenceBancaire.tempo();
							break;
						default :
							System.out.println("Erreur de saisie ...");
							ApplicationAgenceBancaire.tempo();
							break;
						}
					}
					
					
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
			System.out.println("pas de compte à ce nom ...");
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
			System.out.println("Solde avant dépôt: "+c.soldeCompte());
			try {
				c.deposer(montant);
				System.out.println("Montant déposé, solde : "+c.soldeCompte());
			} catch (CompteException e) {
				System.out.println("Erreur de dépot, solde inchangé : " + c.soldeCompte());
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
				System.out.println("Montant retiré, solde : "+c.soldeCompte());
			} catch (CompteException e) {
				System.out.println("Erreur de dépot, solde inchangé : " + c.soldeCompte());
				System.out.println(e.getMessage());
			}
		}

	}
	
	public static void ajouterCompte(AgenceBancaire ag, Compte cpt) throws ABCompteNullException, ABCompteDejaExistantException {
		ag.addCompte(cpt);
	}
	
	public static void supprimerCompte(AgenceBancaire ag, String nom) throws ABCompteNullException, ABCompteDejaExistantException, ABCompteInexistantException {
		ag.removeCompte(nom);
	}
}
