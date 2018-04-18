import stone.Stone;

public class exo2 {

	
	//Main pour r�duire une BigStone jusqu'a ce que son diam�tre soit inf�rieur ou �gal a 5.
	public static void main(String[] args) {
		
		//Creation de la BigStone
		Stone BigStone = Stone.makeBigStone();
		System.out.println("SmallStone : "+BigStone.toString());
		int i=0;
		
		//Boucle while, si le diam�tre est sup�rieur a 5.
		while(BigStone.diameter()>5) {
			//Split de la pierre + remplacement du 'gros morceau' apres split mais le petit (celui extrait de la m�thode split()).
			BigStone=BigStone.split();
			//Affichage du nombre de split
			System.out.println("Split "+i);
			i++;
		}
		
		System.out.println("SmallStone : "+BigStone.toString());

	}

}
