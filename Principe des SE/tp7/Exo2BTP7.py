import os
import sys
import posix_ipc
import mmap

shm=posix_ipc.SharedMemory("/memoireP")#on accede a la zone memoire partagee
filenoShm=shm.fd


tab=mmap.mmap(filenoShm,os.sysconf("SC_PAGE_SIZE"),mmap.ACCESS_READ)#on la mappe
taille=tab[0]+1#on recupere le nombre d'elements saisi
for index in range(1,taille):# on l'affiche comme pour un tableau
    print(tab[index])

tab.close()#puis on ferme la mmap

