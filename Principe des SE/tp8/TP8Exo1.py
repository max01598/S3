# -*- coding: utf-8 -*-
import os
import sys
import threading
import random
import time

def threadExec(x):#fonction qui sera exécuté par chaque thread, prend en paramétre la liste à trier
    tri_bulle(x)#fonction de tri suivant le tri à bulle
    print(x)#affichage de la liste après le tri
    pass

def tri_bulle(list):#fonction de tri à bulle, donnée dans la structure tp8
    if len(list) <= 1:
        return
    temp = 0
    while temp != None:
        temp = None
        for i in range(len(list)-2, -1, -1):
            if list[i] > list[i+1]:
                # permutation => temp != None
                temp = list[i]
                list[i] = list[i+1]
                list[i+1] = temp

# création liste non-ordonnée pour les tests
N = 10
liste = []
for i in range(N):#on remplit la liste
    liste.insert(random.randint(0, i), i)
print(liste)#on affiche la liste non trié

t = threading.Thread(target=threadExec, kwargs={'x' : liste})#création du thread qui devra exécuter la fonction threadExec avec la liste créé en paramètre 
t.start()#lancement du thread
t.join()#le thread attend la fin de son exécution


