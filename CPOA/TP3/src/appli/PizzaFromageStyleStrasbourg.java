package appli;

import java.util.ArrayList;

public class PizzaFromageStyleStrasbourg extends Pizza{
	public PizzaFromageStyleStrasbourg() {
		this.nom="Pizza sauce style Strasbourg au fromage";
		this.garnitures.add("Mozzarella en lamelles");
	}
	void couper() {
		System.out.println("Découpage en parts carrées");
	}
	void emballer() {
		// TODO Auto-generated method stub
		System.out.println("Emballage dans une boîte officielle");

	}
}
