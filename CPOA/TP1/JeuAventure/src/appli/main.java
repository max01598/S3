package appli;

import java.util.Scanner;

import Comportements.ComportementArme;
import ComportementsArme.ComportementArc;
import ComportementsArme.ComportementEpee;
import ComportementsArme.ComportementPoignard;

public class main {

	public static void main(String[] args) {
		
		//Choisir le type du personnage
		System.out.println("Type du personnage");
		System.out.println("1--Le roi");
		System.out.println("2--La reine");
		System.out.println("3--Le Troll");
		System.out.println("4--Le Chevalier");
		Scanner sc = new Scanner(System.in);
		int choix= sc.nextInt();
		Personnage perso;
		switch(choix) 
		{
			case 1:
				perso=new Roi();
				System.out.println("Vous prenez le roi");
				perso.Combattre();
				break;
			case 2:
				perso=new Reine();
				System.out.println("Vous prenez la reine");
				perso.Combattre();
				break;
			case 3:
				perso=new Troll();
				System.out.println("Vous prenez le troll");
				perso.Combattre();
				break;
			default:
				perso=new Chevalier();
				System.out.println("Vous prenez le chevalier");
				perso.Combattre();
				break;		
		}
		
		System.out.println("Choisir l'arme du personnage");
		System.out.println("1--Le Poignard");
		System.out.println("2--L'arc");
		System.out.println("3--L'epee");
		int choixArme= sc.nextInt();
		switch(choixArme) 
		{
			case 1:
				perso.setArme(ComportementPoignard.getInstance()); 
				perso.Combattre();
				break;
			case 2:
				perso.setArme(ComportementArc.getInstance()); 
				perso.Combattre();
				break;
			default:
				perso.setArme(ComportementEpee.getInstance()); 
				perso.Combattre();
				break;		
		}
		
		
		
		

	}

}
