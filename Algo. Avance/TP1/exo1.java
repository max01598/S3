import stone.Stone;

public class exo1 {

	
	//Main de test de la méthode de Stone makeSmallStone ainsi que split
	public static void main(String[] args) {
		
		Stone SmallStone = Stone.makeSmallStone();
		System.out.println("SmallStone : "+SmallStone.toString());
		System.out.println("Split");
		System.out.println("Splited SmallStone 1 : "+SmallStone.split().toString());
		System.out.println("Splited SmallStone 2 : "+SmallStone.toString());
		
	}
	
}
