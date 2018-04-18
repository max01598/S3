import sys
import os

r,w=os.pipe() #creation du processus

pid=os.fork() #creation du processus fils

if(pid>0):#Si c'est le pere alors le processus va creer un nouveau fils
	
	pid2=os.fork() #creation du second processus fils
	if(pid2==0):#Le fils numero 2 ..
		os.close(w)#.. va fermer le cote écriture du tube de communication ..
		os.dup2(r,0)#.. puis va redirectionner le cote lecture vers l'entree standard ..
		os.execl("/bin/grep","grep","\\.py")#.. et enfin executer la commande grep \\.py
	else:
		os.close(w) #Le pere va fermer les deux cotes du tube et attendre ses fils  
		os.close(r)
		os.wait()
		os.wait()
		
else:
	os.close(r)#Le fils numéro 1 va fermer le cote lecture du tube
	os.dup2(w,1)# .. va redirectionner le cote ecriture vers la sortie standard ..
	os.execl("/bin/ls","ls","-l")#.. et executer la commande ls -l
