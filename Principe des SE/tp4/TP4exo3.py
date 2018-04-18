import os

import sys

import stat




fichierArg=sys.argv[1]

fichierCopie=""+fichierArg+"~"


#SUPPRIMER FC
#

try:
	
	#os.unlink(fichierCopie)

#except OSError as e:
	
	#pass



#Copie

os.link(fichierArg,fichierCopie)

print("Copie cree")



#Recuperer les droits de f

droit=os.stat(fichierArg).st_mode



#Supprimer f

os.unlink(fichierArg)



#Ouvrir f en ecriture, creation avec droit

fa=os.open(fichierArg,os.O_CREAT|os.O_WRONLY)

os.chmod(fichierArg,droit)



#Ouvir f~ en lecture

fc=os.open(fichierCopie,os.O_RDONLY)



#parcour de f~

size=1

nb=" "
recopiage=True

retourLigne=False
while len(nb)>0:
	nb=os.read(fc,size)
	nb.decode(encoding='UTF-8',errors='strict')
	if nb==" " and retourLigne==True:
		recopiage=False
	elif nb==" " and recopiage==True:
		os.write(fa,nb)
	elif nb=="\n":
		os.write(fa,nb)
		retourLigne==True
	else:
		os.write(fa,nb)
		retourLigne=False

os.close(fa)
os.close(fc)
