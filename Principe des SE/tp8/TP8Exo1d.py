# -*- coding: utf-8 -*-
import os
import sys
import threading
import random
import time

#Ce code correspond au précédent sauf que cette fois ci on va s'assurer qu'il ne peut plus y avoir d'erreur grace au threading.lock
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
			lock.acquire()#le thread va attendre de pouvoir prendre un jeton pour réaliser cette partie du code
			if list[i] > list[i+1]:
				# permutation => temp != None
				temp = list[i+1]
				list[i+1] = list[i]
				list[i] = temp
			lock.release()#une fois réalisée, il va reposer le jeton pour que le thread suivant puisse executer cette partie	

def tri_bulle(list):
	if len(list) <= 1:
		return
	temp = 0
	while temp != None:
		temp = None
		for i in range(len(list)-2, -1, -1):
			lock.acquire()
			if list[i] > list[i+1]:
				# permutation => temp != None
				temp = list[i]
				list[i] = list[i+1]
				list[i+1] = temp
			lock.release()

lock = threading.Lock()#création du lock, il contient un jeton et permettra déviter des erreurs
# création liste non-ordonnée pour les tests
N = 1000
liste = []
for i in range(N):
    liste.insert(random.randint(0, i), i)
print(liste)

t = threading.Thread(target=threadExecSable, kwargs={'x' : liste})
t2 = threading.Thread(target=threadExecBulle, kwargs={'x' : liste})
t.start()
t2.start()
t.join()
t2.join()

for i in range(0,1000):
    if(i!=liste[i]):
        print("erreur")
        print(liste[i])
        print(i)
        break
        
