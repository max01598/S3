import os
import sys
import mmap

fichierbinaire=os.open(sys.argv[1],os.O_RDWR)#on ouvre le fichier en mode lecture et ecriture

stat=os.stat(sys.argv[1])#cette fonction va permettre plus tard de recuperer la taille du fichier en parametre
taille=stat.st_size#on recupere la taille ici pour pouvoir mappe le fichier
tab=mmap.mmap(fichierbinaire,taille,mmap.ACCESS_READ)#on mappe le fichier mis en parametre

for index in range(0,taille,2):#on parcourt la mmap et toutes les deux valeurs on echange tab[i] avec tab[i+1]
	valeur=tab[index+1]
	tab[index+1]=tab[index]
	tab[index]=valeur
	print(hex(tab[index]))
	print(hex(tab[index+1]))
os.close(fichierbinaire)#on n'oublie pas de fermer le fichier

	

