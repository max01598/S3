import os
import sys
import time

fr=os.open("tmp",os.O_RDONLY)# on recupere le descripteur du tube nommé "tmp" ouvert en lecture
while(1):
	chaine=os.read(fr,1)# on va lire le contenu dans tmp, c'est le nombre aleatoire qui est actuellement en byte
	nb=int.from_bytes(chaine,sys.byteorder)# le convertir en entier pour verifier
	cha=chaine.decode(encoding='UTF-8',errors='strict')# puis en ASCII
	print(nb)
	print(cha)
	
