import numpy
import sys
import os
import threading as thr



def threadExec(matriceA,matriceB,x,y,matriceMul):#cette fonction va calculer une valeur de la nouvelle matrice  
    valeur=0
    for i in range(len(matriceA)):
        valeur=valeur + matriceA[x][i]*matriceB[i][y]#on calcule la valeur d'un element de la matrice 
    matriceMul[x][y]=valeur#on l'ajoute
    bar.wait()#on attend les threads

    
def creatThread(pNb,matriceA,matriceB,matriceD):#Cette fonction permet de creer les threads pour calculer la matrice 
    for i in range(pNb):
        for j in range(pNb):
            th = thr.Thread(target=threadExec, kwargs={'matriceA' : matriceA, 'matriceB' : matriceB, 'x' : i,'y' : j, 'matriceMul' : matriceD})
            th.start()

    
matriceA=numpy.array([[1,2],[1,2]])#on initialise la matrice A
matriceB=numpy.array([[4,4],[1,4]])#on intialise la matrice B
matriceFin=numpy.array([[0,0],[0,0]])#on initialise la matrice Fin qui sera le resultat de la multiplication
print(matriceA)#on affiche les deux matrices
print(matriceB)
bar = thr.Barrier(5)#on cree la barriere qui devra attendre 5 threads avant de s'ouvrir
creatThread(2,matriceA,matriceB,matriceFin)#on lance la creation des threads
bar.wait()#on attend les 5 threads pour afficher la matrice Fin
print(matriceFin)
bar.reset()#on reset le nombre de thread a attendre sinon la barriere reste ouverte, comme si on a referme la barriere
matriceFinCarre=numpy.array([[0,0],[0,0]])#on initialise la derniere matrice Fin au carre
creatThread(2,matriceFin,matriceFin,matriceFinCarre)#on lance le calcul
bar.wait()#on attend la fin des 5 threads
print(matriceFinCarre)#on affiche la matrice finale



