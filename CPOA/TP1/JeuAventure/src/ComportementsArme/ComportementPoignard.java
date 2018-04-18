package ComportementsArme;

import Comportements.ComportementArme;

public class ComportementPoignard implements ComportementArme{
	private final static ComportementPoignard cpP=new ComportementPoignard();
	private ComportementPoignard() {}
	public static ComportementPoignard getInstance() {
		return cpP;
	}
	public void utiliserArme() {
		System.out.println("Attaque au le poignard");
	}

}
