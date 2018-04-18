import os

import sys


fichierArg=sys.argv[1]
 #permet de nommer le fichier à créer, on aurait pu écrire : fichierArg=f.txt

fa=os.open(fichierArg,os.O_CREAT|os.O_WRONLY) #crée le fichierArg en mode écriture et récupère son descripteur
  

os.dup2(fa,1)
 #Substitue le descripteur du fichierArg au descripteur de sortie standard, cad que tout ce qui devait s'afficher en sortie standard s'écrira sur le fichierArg
os.execl("/bin/ls","ls","-l")

 #permet de lancer la commande ls -l
