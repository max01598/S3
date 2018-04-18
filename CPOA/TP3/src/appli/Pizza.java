package appli;

import java.util.ArrayList;


public abstract class Pizza {
	String nom;
	String pate;
	String sauce;
	ArrayList<String> garnitures = new ArrayList<String>();

	void preparer() {
		System.out.println("Préparation de " + nom);
		System.out.println("Étalage de la pâte...");
		System.out.println("Ajout de la sauce...");
		System.out.println("Ajout des garnitures: ");
			for (int i = 0; i < garnitures.size(); i++) {
		System.out.println(" " + garnitures.get(i)); }
	}
	void cuire() {
		System.out.println("Cuisson 25 minutes à 180°");
	}
	void couper() {
		System.out.println("Découpage en parts triangulaires");
	}
	void emballer() {
		// TODO Auto-generated method stub
		System.out.println("En on emballe!");

	}
	public String getNom() {
		// TODO Auto-generated method stub
		return nom;
	}
}