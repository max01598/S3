import os
import sys
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>

print('Entrer le contenu')
fichierD=sys.argv[1]
fileT=os.open(fichierD,os.O_CREAT|os.O_TRUNC|os.O_WRONLY)
size=5
nb=" "
while len(nb)>0:
	nb=os.read(sys.stdin.fileno(),size)
	os.write(fileT,nb)

os.close(fileT)

