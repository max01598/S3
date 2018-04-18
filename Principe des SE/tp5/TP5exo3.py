import os

import sys

import random




r,w=os.pipe() #permet de créer un tube de communication permettant de communiquer des données entre processus. Seul les processus créés par un fork() peuvent l'utiliser



pid=os.fork() #permet de créer un processus fils, il pourra utiliser le tube de communication



if(pid>0):#Si le pid>0, alors c'est le processus père
	os.close(r)
 #le père doit écrire dans le processus de communication, on ferme donc le descripteur du tube côté lecture	
	n=random.randint(0,1000)
 #permet de choisir un nombre entre 0 et 1000 de façon aléatoire	
	print(n)
 #permet d'afficher ce nombre pour connaitre sa valeur et la comparer à celle transmise	
	res=n.to_bytes(4,sys.byteorder)
	#permet de convertir le nombre en bytes
	os.write(w,res)
	#permet d'écrire ce nombre dans le descripteur du tube côté écriture
	os.wait()
 #permet au processus père d'attendre son fils, empêche la création d'un processus zombie	
	os.close(w)
 #permet de fermer le descripteur du tube côté écriture	

else:
	
	os.close(w)
 #le fils doit lire dans le processus de communication, on ferme donc le descripteur du tube côté écriture	
	chaine=os.read(r,4)
 #permet de lire et récupérer le contenu du descripteur du tube côté lecture, normalement c'est le nombre généré en bytes	
	b=int.from_bytes(chaine,sys.byteorder)
 #permet de convertir des bytes en int
	print(b)
 #permet d'afficher le contenu de la lecture pour vérifier que le processus fils reçoivent le nombre généré par le père	
	os.close(r)

 #ferme le descripteur du tube côté lecture	
		
	
