/**
 * @author bruel
 *
 */
abstract public class Canard {

	protected ComportementVoler cptmV;
	protected ComportementCancaner cptmC;
	
	public Canard(ComportementVoler pcptmV,ComportementCancaner pcptmC)
	{
		this.cptmC=pcptmC;
		this.cptmV=pcptmV;
	}
	
	public final void cancaner() {
		cptmC.Cancaner();
	}
	public final void voler() {
		cptmV.Voler();
	}
	public void nager() {
		System.out.println("Je nage comme un Canard!");
	}

	
	abstract public void afficher();
	
}