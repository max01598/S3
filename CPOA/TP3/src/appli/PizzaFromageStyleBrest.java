package appli;

import java.util.ArrayList;

public class PizzaFromageStyleBrest extends Pizza{

	public PizzaFromageStyleBrest() {
		this.nom="Pizza sauce style Brest au fromage";
		this.garnitures.add("Parmigiano reggiano râpé");
	}
	void couper() {
		System.out.println("Découpage en parts triangulaires");
	}

}
