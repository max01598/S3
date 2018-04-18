package application.action;

import java.util.Locale;
import java.util.Scanner;

import banque.AgenceBancaire;
import banque.Compte;

public class ActionVoirCompteNumero implements Action{
	
	private String message;
	public  ActionVoirCompteNumero() {
		message ="Compte demande:";
	}
	@Override
	public String actionMessage() {
		// TODO Auto-generated method stub
		return message;
	}

	@Override
	public void execute(AgenceBancaire ag) throws Exception {
		System.out.println("Entrer le numero :");
		Scanner lect;
		lect = new Scanner ( System.in );
		lect.useLocale(Locale.US);
		String numero = lect.next();
		Compte c = ag.getCompte(numero);
		if (c==null) {
			System.out.println("Compte inexistant ...");
		} else {
			c.afficher();
		}
		
	}

}
