import os

import sys

import tempfile

import traceback

fich= tempfile.TemporaryFile() #permet d'ouvrir un fichier temporaire et retourne un objet de type io.BufferedRandom

desc=fich.fileno() #permet cette fois de r�cuperer le descripteur de bas niveau du fichier temporaire



saveStderr=os.dup(2) #permet de cr�er une sauvegarde de l'ancien descripteur de la sortie d'erreurs

os.dup2(desc,2) #substitue le descripteur du fichier temporaire au descripteur de la sortie d'erreurs, son effet est identique � celui de l'exo1

traceback.print_stack() #ecrit dans la sortie d'erreurs, mais ici c'est le fichier temporaire

fich.os.seek(0,0) #permet, avant de r�cuperer un contenu, de placer le curseur de lecture o� on le souhaite, ici on le veut au d�but du fichier temporaire

ligne=str(fich.readline())
 #permet de r�cup�rer le contenu de fich (fichier temporaire) sous type string gr�ce au str()

print(ligne) #affiche le contenu pour confirmer que le fichier temporaire cr�� joue le role de sortie d'erreur


os.dup2(saveStderr,desc)



 #permet de r�affecter l'ancien descripteur de la sortie d'erreurs � l'actuel sortie d'erreur

