import os
import sys
import posix_ipc
import mmap
import time

shm=posix_ipc.SharedMemory("/memoireP",posix_ipc.O_CREAT,size=os.sysconf("SC_PAGE_SIZE"))#on cree un espace memoire partagee
filenoShm=shm.fd


tab=mmap.mmap(filenoShm,os.sysconf("SC_PAGE_SIZE"),mmap.ACCESS_READ)#on mappe cette zone memoire

taille=input("Entrer la taille du tableau :")#on demande à l'utilisateur le nombre d'entiers qu'il veut saisir

tab[0]=int(taille)#on stocke ce nombre

for index in range(1,int(taille)+1):#on le fais saisir ...
    nb=input("Entrer un entier : (valeur entre 0 et 255)")
    tab[index]=int(nb)#.. et on stocke l'entier entré
    print(tab[index])

time.sleep(30)#on dors pendant 30 secondes pour que le second processus ait le temps d'agir
tab.close()#on ferme la mmap
shm.unlink()#on 'supprime' l'espace memoire partagee

