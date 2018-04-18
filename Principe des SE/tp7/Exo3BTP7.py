import os
import sys
import posix_ipc
import mmap

shm=posix_ipc.SharedMemory("/memoireP")
filenoShm=shm.fd
sema=posix_ipc.Semaphore("/sema")
sema.acquire()#De son cote ce programme va attendre que le semaphore est un jeton de libre pour s'executer, il devrait etre creer par le processus qui permet d'entrer les valeurs
tab=mmap.mmap(filenoShm,os.sysconf("SC_PAGE_SIZE"),mmap.ACCESS_READ)
taille=tab[0]+1
for index in range(1,taille):
    print(tab[index])

tab.close()
