package appli;

public class PizzeriaStrasbourg extends Pizzeria{
	public PizzeriaStrasbourg() {
	}
	
	@Override
	public Pizza creerPizza(String type) {
		Pizza pizza = null;
		if(type=="fromage") {
			pizza = new PizzaFromageStyleStrasbourg();
		}else {
			return null;
		}
		return pizza;
	}
}
