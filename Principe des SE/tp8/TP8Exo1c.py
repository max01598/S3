# -*- coding: utf-8 -*-
import os
import sys
import threading
import random
import time

def threadExecSable(x):
    tri_sable(x)
    print(x)
    pass

def threadExecBulle(x):
    tri_bulle(x)
    print(x)
    pass

def tri_sable(list):
    if len(list) <= 1:
        return
    temp = 0
    while temp != None:
        temp = None
        for i in range(0, len(list)-1, 1):
            if list[i] > list[i+1]:
                # permutation => temp != None
                temp = list[i+1]
                list[i+1] = list[i]
                list[i] = temp

def tri_bulle(list):
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
N = 1000
liste = []
for i in range(N):
    liste.insert(random.randint(0, i), i)
print(liste)
#cette fois on crée deux threads qui vont exécuter le tri à bulle et le tri à sable 
t = threading.Thread(target=threadExecSable, kwargs={'x' : liste})
t2 = threading.Thread(target=threadExecBulle, kwargs={'x' : liste})
t.start()
t2.start()
t.join()
t2.join()
#On verifie si il y a des erreurs, cad si il y a des valeurs qui auraient disparu ou se seraient mal trié à cause de l'éxecution en parallèle des threads
for i in range(0,1000):
    if(i!=liste[i]):
        print("erreur")
        print(liste[i])
        print(i)
        break
        
