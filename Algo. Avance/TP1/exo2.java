import stone.Stone;

public class exo2 {

	
	//Main pour réduire une BigStone jusqu'a ce que son diamètre soit inférieur ou égal a 5.
	public static void main(String[] args) {
		
		//Creation de la BigStone
		Stone BigStone = Stone.makeBigStone();
		System.out.println("SmallStone : "+BigStone.toString());
		int i=0;
		
		//Boucle while, si le diamètre est supérieur a 5.
		while(BigStone.diameter()>5) {
			//Split de la pierre + remplacement du 'gros morceau' apres split mais le petit (celui extrait de la méthode split()).
			BigStone=BigStone.split();
			//Affichage du nombre de split
			System.out.println("Split "+i);
			i++;
		}
		
		System.out.println("SmallStone : "+BigStone.toString());

	}

}
