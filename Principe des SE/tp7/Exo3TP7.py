import os
import sys
import posix_ipc
import mmap
import time

shm=posix_ipc.SharedMemory("/memoireP",posix_ipc.O_CREAT,size=os.sysconf("SC_PAGE_SIZE"))
filenoShm=shm.fd
sema=posix_ipc.Semaphore("/sema",posix_ipc.O_CREAT)#Cette fois ci on cree un semaphore avec zero 'jeton'
tab=mmap.mmap(filenoShm,os.sysconf("SC_PAGE_SIZE"),mmap.ACCESS_READ)

taille=input("Entrer la taille du tableau :")

tab[0]=int(taille)

for index in range(1,int(taille)+1):
    nb=input("Entrer un entier : (valeur entre 0 et 255)")
    tab[index]=int(nb)
    print(tab[index])

sema.release()#on rajoute un jeton dans le semaphore pour permettre à un autre programme de s'executer
tab.close()

