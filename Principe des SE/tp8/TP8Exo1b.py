# -*- coding: utf-8 -*-
import os
import sys
import threading
import random
import time
#ce code est l'identique du précédent sauf que l'on réalise un tri à sable
def threadExec(x):
    tri_sable(x)
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

# création liste non-ordonnée pour les tests
N = 10
liste = []
for i in range(N):
    liste.insert(random.randint(0, i), i)
print(liste)

t = threading.Thread(target=threadExec, kwargs={'x' : liste})
t.start()
t.join()

