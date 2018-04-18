
public class test {

	public static void main(String[] args) {
		BouilleurChocolat bc;
		BouilleurChocolat bc1;
		
		bc=BouilleurChocolat.getInstanceBouilleur();
		System.out.println(bc);
		bc1=BouilleurChocolat.getInstanceBouilleur();
		System.out.println(bc1);
		if(bc==bc1)
		{
			System.out.println("Meme objet");
		}
		else
		{
			System.out.println("Il existe deux objets");
		}
		bc1.remplir();
		if(bc.estVide()==true)
		{
			System.out.println("Il existe deux objets");
		}else {
			System.out.println("Meme objet");
		}
	}

}
