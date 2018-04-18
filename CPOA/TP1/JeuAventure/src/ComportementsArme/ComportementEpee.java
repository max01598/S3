package ComportementsArme;

import Comportements.ComportementArme;

public class ComportementEpee implements ComportementArme{
	private final static ComportementEpee cpE=new ComportementEpee();
	private ComportementEpee() {}
	public static ComportementEpee getInstance() {
		return cpE;
	}
	public void utiliserArme() {
		System.out.println("Attaque a l'epee");
	}
}
