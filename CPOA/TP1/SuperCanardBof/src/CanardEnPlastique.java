/**
 * @author bruel
 *
 */

public class CanardEnPlastique extends Canard {
	
	
	public CanardEnPlastique() {
		super(new PeutpasVoler(),new PeutCancaner());
	}

	@Override
	public void afficher() {
		System.out.println("Je suis un CanardEnPlastique!");
	}

}
