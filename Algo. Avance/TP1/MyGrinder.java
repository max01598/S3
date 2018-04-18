import java.util.List;
import java.util.ArrayList;
import java.util.Collection;

import stone.Grinder;
import stone.Stone;

public class MyGrinder implements Grinder{

		public Collection<Stone> grind(Stone stone, int diameter) {
			//Creation d'une ArrayList de Stone, pour stocker les pierres crées successivement par les splits futurs.
			List<Stone> collec = new ArrayList<Stone>();
			//On ajoute la 1ere pierre a l'ArrayList.
			collec.add(stone);
			int i=0;
			//On fait boucler le split tant que l'indice de test de la taille de la pierre n'est pas à la fin de l'ArrayList
			while(i<collec.size()) {
				//On test que la pierre qui se trouve à l'indice i dans l'arrayList a un diamètre supérieur à celui demandé en entrée.
				if(collec.get(i).diameter()>diameter) {
					//Si oui, on split la pierre à l'indice i.
					collec.add(collec.get(i).split());
				}else{
					//Si le diamètre est bien plus petit, on passe à la pierre suivant.
					i++;
				}
			}
			//On retourne l'arrayList finale
			return collec;
		}
}
	
	



