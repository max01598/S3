import os
import sys
import random
import numpy
import threading
import time
import logging

def collectTemp(index,x):#fonction qui va collecter les températures
    colonne=0
    while(True):#on remplit la matrice
    	lock.acquire()
        nbA=random.randint(0,32)
        x[index][colonne%10]=nbA#ici le modulo permet de revenir à la ligne
        lock.release()
        time.sleep(1)#on attend 1 seconde
        colonne=colonne+1
    pass


def creatCapt(pnbCapteur,pmatrice):#fonction qui va créer les différents threads qui joueront le rôle des capteurs
    for i in range(pnbCapteur):#on crée un thread par capteur demandé
        th = threading.Thread(target=collectTemp, kwargs={'index' : i,'x' : pmatrice})#on définit le thread qui exécute la fonction de collectTemp 
        th.start()#on lance le thread


#def waitCpt():#fonction qui va permettre d'attendre l'execution de tous les threads
   # main_thread = threading.currentThread()
    #for t in threading.enumerate():
        #if t is main_thread:
            #continue
        #t.join()


def findMax(pmatrice):#fonction qui va trouver le maximum des températures
    tempMax = 0
    tempMax=max(pmatrice)#on récupère le max de la matrice
    print("maximum")
    print (tempMax)#on affiche le max directement dans le fichier grâce au dup2

def genererCollect(nbArg, pmatrice):#fonction qui va lancer la collecte de températures
	for i in range(nbArg):
		lock.acquire()
		matrice2 = numpy.copy(pmatrice[i,:])
		lock.release()
		tr = threading.Thread(target=findMax, kwargs={'pmatrice':matrice2})#on lance le thread qui lance findMax
		tr.start()



lock = threading.Lock()#création du lock pour gérer la protection sur l'action des threads
nbCapteur= 5#nombre de capteur
matrice = numpy.zeros((nbCapteur,10),int)#on crée une matrice de 5*10 remplis de zéros
fich=os.open("stats_globales.txt",os.O_CREAT|os.O_TRUNC|os.O_RDWR)#on ouvre le fichier demandé en lecture et écriture, on le crée si il n'existe pas, on le vide si il existe déja.
os.dup2(fich,1);#on échange la sortie standard avec le fichier, cela permettra d'écrire dans le fichier 
creatCapt(nbCapteur,matrice)#on lance la création des capteurs pour relever des températures
while(True):#on entre dans une boucle infinie
    time.sleep(10)#on attend dix secondes
    genererCollect(nbCapteur,matrice)#on commence la collecte 
