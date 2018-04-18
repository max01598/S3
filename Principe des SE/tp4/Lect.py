import os
import sys
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>


fichier=sys.argv[1]
fileT=os.open(fichier,os.O_RDONLY)
size=16
nb=" "
while len(nb)>0:
	nb=os.read(fileT,size)
	os.write(sys.stdout.fileno(),nb)

os.close(fileT)



	
