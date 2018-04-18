package appli;

public class PizzeriaBrest extends Pizzeria{
	@Override
	public Pizza creerPizza(String type) {
		Pizza pizza = null;
		if(type.equals("fromage")) {
			pizza = new PizzaFromageStyleBrest();
		}
		return pizza;
	}


}
