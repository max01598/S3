import os
import sys
import time
import random

fw=os.open("tmp",os.O_WRONLY)# on recupere le descripteur du tube nommé "tmp" ouvert en ecriture 
while(1):
	n=random.randint(32,99)# on genere un nombre aleatoire entre 32 et 99
	print(n)# et on l'affiche
	res=n.to_bytes(1,sys.byteorder)# et on le convertie en byte pour pouvoir le communiquer
	os.write(fw,res)# puis on l'ecrit vers le descripteur du tube nommé "tmp"
	time.sleep(1)# et on attend 1 seconde


