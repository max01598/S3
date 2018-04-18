import os
import sys


r,w=os.pipe() #lance le premier pipe
r2,w2=os.pipe()#lance le second pipe
pid=os.fork() #lance deux processus

#Le processus P1=pere
if(pid>0):
	#Envoi du contenu de ff.txt à P2 
	os.close(r)#Premierement : P1 va fermer le cote lecture du tube
	fichiertxt=os.open("ff.txt",os.O_RDONLY)# ouvrir le fichier ff.txt en lecture
	#lecture du fichier
	size=16
	nb=" "
	while len(nb)>0:# ensuite recuperer le contenu de ce fichier
		nb=os.read(fichiertxt,size)
		os.write(w,nb)#pour l'ecrire dans le tube de commonication cote ecriture
	os.close(fichiertxt)#fermer le fichier
	os.close(w)# et le cote ecriture du tube
	
	#lecture de P2
	os.close(w2)#Deuxiement : P1 va fermer le cote ecriture du second tube
	nb2=" "
	while len(nb2)>0:
		nb2=os.read(r2,size)# lire le contenu du cote ecriture du second tube
		os.write(1,nb2)# et l'ecrit sur la sortie standard
	os.close(r2)#ferme le cote lecture du second tube 
	os.wait()#attend son fils

else:
	#lecture de P1, on suit le meme principe que la lecture de P2 par P1
	os.close(w)
	size=16
	nb=" "
	while len(nb)>0:
		nb=os.read(r,size)
		os.write(2,nb)
	os.close(r)

	#Envoi du contenu de gg.txt à P1, on suit le meme principe que l'envoi de P1 vers P2
	os.close(r2)
	fichiertxt=os.open("gg.txt",os.O_RDONLY)
	nb2=" "
	while len(nb2)>0:
		nb2=os.read(fichiertxt,size)
		os.write(w2,nb2)
	os.close(fichiertxt)
	os.close(w2)
	
		
		
