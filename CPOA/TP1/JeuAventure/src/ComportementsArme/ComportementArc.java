package ComportementsArme;

import Comportements.ComportementArme;

public class ComportementArc implements ComportementArme{
	private final static ComportementArc cpA=new ComportementArc();
	private ComportementArc() {}
	
	public static ComportementArc getInstance() {
		return cpA;
	}
	public void utiliserArme() {
		System.out.println("Attaque a l'arc");
	}
}
