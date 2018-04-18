/**
 * @author bruel
 *
 */
public class Colvert extends Canard {
	
	public Colvert() {
		super(new volerAvecDesAiles(),new PeutCancaner());
	}

	@Override
	public void afficher() {
		System.out.println("Je suis un Colvert");
	}

}