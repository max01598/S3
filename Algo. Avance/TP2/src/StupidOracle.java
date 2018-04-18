import game.Card;
import game.Deck;
import game.Oracle;

/**
 * Implementation minimaliste de l'interface Oracle.
 * 
 * @see Oracle
 */
public class StupidOracle implements Oracle {

	/**
	 * Memorise une carte du paquet.
	 */
	protected Card myCard;

	@Override
	public void showDeck(Deck d) {
		myCard = d.takeOnTop();
		// On memorise la carte du dessus du paquet
	}

	@Override
	public Card guessFirst() {
		return myCard;
	}

	@Override
	public Card guessNext(Card prev) {
		return myCard;
	}
}
