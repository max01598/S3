import java.util.ArrayList;
import java.util.List;

import game.*;

public class Ex1 {

	public static void main(String[] args) {
		//Cr�e un paquet de carte contenant 8 cartes dans chaque famille
		Deck deckdep = new Deck(8);
		//Affiche le nombre de cartes contenues dans le paquet
		System.out.println(deckdep.count());
		//Affiche le paquet
		System.out.println(deckdep.toString());
		//M�lange le paquet
		deckdep.shuffle();
		//Affiche � nouveau le paquet
		System.out.println(deckdep.toString());
		//Cr�e une liste contenant les cartes du paquet
		ArrayList<Card> CollecCard=new ArrayList<Card>( deckdep.elements());
		//Afficher la liste
		System.out.println(CollecCard.toString());
		//Trier la liste
		CollecCard.sort(null);
		//Affiche � nouveau la liste
		System.out.println(CollecCard.toString());
		
	}

}
