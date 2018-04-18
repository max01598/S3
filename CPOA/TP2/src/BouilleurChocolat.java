
public class BouilleurChocolat {
	private boolean vide;
	private boolean bouilli;
	private static BouilleurChocolat bc1;
	
	private BouilleurChocolat() {
		this.vide=true;
		this.bouilli=false;
	}
	
	
	public static synchronized BouilleurChocolat getInstanceBouilleur() {
		if(bc1==null) 
		{
			return bc1=new BouilleurChocolat();
		}else {
			return bc1;
		}	
	}

	public void remplir() {
		if (estVide()) {
			vide = false;
			bouilli = false;
			// remplir le bouilleur du mélange lait/chocolat
		}
	}

	public void vider() {
		if (!estVide() && estBouilli()) {
			// vider le mélange
			vide = true;
		}
	}

	public void bouillir() {
		if (!estVide() && !estBouilli()) {
			// porter le contenu à ébullition
			bouilli = true;
		}
	}

	public boolean estVide() { return vide;}

	public boolean estBouilli() { return bouilli;}


}
