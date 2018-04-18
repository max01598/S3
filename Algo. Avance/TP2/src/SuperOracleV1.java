import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import game.*;

public class SuperOracleV1 implements Oracle {
	
	private int nbCard;
	private List<Card> lBase;
	private Deque<Card> lTri;
	protected Card myCard;
	
	public Card guessFirst() {
		return myCard;
	}

	public Card guessNext(Card previous) {
		Card cd;
		lBase.remove(previous);
		lTri.addLast(previous);
		if(!lBase.isEmpty()) {
			cd=lBase.get(0);
		}else {
			cd = lTri.getFirst();
			lTri.removeFirst();
		}
		return cd;
	}

	public void showDeck(Deck deck) {
		lTri=new ArrayDeque<Card>();
		this.nbCard=deck.count();
		this.lBase=new LinkedList<Card>(deck.elements());
		myCard = deck.takeOnTop();
		
	}

}
