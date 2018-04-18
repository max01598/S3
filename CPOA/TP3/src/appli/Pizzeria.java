package appli;

public abstract class Pizzeria {
	public Pizza commanderPizza(String typ)
	{
		Pizza pizza = null;
		pizza=creerPizza(typ);
		pizza.preparer(); 
		pizza.cuire(); 
		pizza.couper(); 
		pizza.emballer();
		return pizza;
		
	}
	public abstract Pizza creerPizza(String ptyp);

}
