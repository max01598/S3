package appli;

public class PizzaTestDrive {
		  public static void main(String[] args) {
		    Pizzeria boutiqueBrest = new PizzeriaBrest();
		    Pizzeria boutiqueStrasbourg = new PizzeriaStrasbourg();

		    Pizza pizza = boutiqueBrest.commanderPizza("fromage");
		    System.out.println("JMB a command� une " + pizza.getNom() + "\n");

		    pizza = boutiqueStrasbourg.commanderPizza("fromage");
		    System.out.println("JMI a command� une " + pizza.getNom() + "\n");
		  }
		}

