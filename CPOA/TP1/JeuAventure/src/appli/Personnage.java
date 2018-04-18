package appli;

import Comportements.ComportementArme;

abstract public class Personnage {
	
	protected ComportementArme arme;
	
	public Personnage(ComportementArme parme)
	{
		this.arme=parme;
	}
	
	public final void Combattre() {
		this.arme.utiliserArme();
	}
	
	public void setArme(ComportementArme a)
	{
		this.arme=a;
	}
	
	
}
