import java.util.List;
import java.util.ArrayList;
import java.util.Collection;

import stone.Grinder;
import stone.Stone;

public class MyGrinder implements Grinder{

		public Collection<Stone> grind(Stone stone, int diameter) {
			//Creation d'une ArrayList de Stone, pour stocker les pierres cr�es successivement par les splits futurs.
			List<Stone> collec = new ArrayList<Stone>();
			//On ajoute la 1ere pierre a l'ArrayList.
			collec.add(stone);
			int i=0;
			//On fait boucler le split tant que l'indice de test de la taille de la pierre n'est pas � la fin de l'ArrayList
			while(i<collec.size()) {
				//On test que la pierre qui se trouve � l'indice i dans l'arrayList a un diam�tre sup�rieur � celui demand� en entr�e.
				if(collec.get(i).diameter()>diameter) {
					//Si oui, on split la pierre � l'indice i.
					collec.add(collec.get(i).split());
				}else{
					//Si le diam�tre est bien plus petit, on passe � la pierre suivant.
					i++;
				}
			}
			//On retourne l'arrayList finale
			return collec;
		}
}
	
	



