import os

import sys

import random




r,w=os.pipe() #permet de cr�er un tube de communication permettant de communiquer des donn�es entre processus. Seul les processus cr��s par un fork() peuvent l'utiliser



pid=os.fork() #permet de cr�er un processus fils, il pourra utiliser le tube de communication



if(pid>0):#Si le pid>0, alors c'est le processus p�re
	os.close(r)
 #le p�re doit �crire dans le processus de communication, on ferme donc le descripteur du tube c�t� lecture	
	n=random.randint(0,1000)
 #permet de choisir un nombre entre 0 et 1000 de fa�on al�atoire	
	print(n)
 #permet d'afficher ce nombre pour connaitre sa valeur et la comparer � celle transmise	
	res=n.to_bytes(4,sys.byteorder)
	#permet de convertir le nombre en bytes
	os.write(w,res)
	#permet d'�crire ce nombre dans le descripteur du tube c�t� �criture
	os.wait()
 #permet au processus p�re d'attendre son fils, emp�che la cr�ation d'un processus zombie	
	os.close(w)
 #permet de fermer le descripteur du tube c�t� �criture	

else:
	
	os.close(w)
 #le fils doit lire dans le processus de communication, on ferme donc le descripteur du tube c�t� �criture	
	chaine=os.read(r,4)
 #permet de lire et r�cup�rer le contenu du descripteur du tube c�t� lecture, normalement c'est le nombre g�n�r� en bytes	
	b=int.from_bytes(chaine,sys.byteorder)
 #permet de convertir des bytes en int
	print(b)
 #permet d'afficher le contenu de la lecture pour v�rifier que le processus fils re�oivent le nombre g�n�r� par le p�re	
	os.close(r)

 #ferme le descripteur du tube c�t� lecture	
		
	
