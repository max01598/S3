import math
#Xn+1=(a.Xn+c)mod m
#X0=graine
def suite(liste,nbE,a,c,m,Xn):
    i=0
    while(i<=nbE):
        Xn=(a*Xn+c)%m
        liste.append(Xn)
        i=i+1

def DivisionListe(listeDep,listeFin,m):#on va diviser chaque valeur par 256 
     for index in range(0,len(listeDep)):#pour chaque valeur ...
         listeFin[index]=listeDep[index]/m
         #.... on divise la valeur par 256 de la liste de départ pour ensuite l'ajouter dans la seconde liste
         
def trouverPeriode(liste):
    valeurInit=liste[0]
    valeurInit2=liste[1]
    for index in range(1,len(liste)):
        if liste[index]==valeurInit:
            if liste[index+1]==valeurInit2:
                print(index)
                exit()
        
a=25
c=16
m=256

X0=50
liste=[]
liste.append(X0)
suite(liste,10000,a,c,m,X0)
print(liste)
trouverPeriode(liste)
Liste2=DivisionListe(liste,m)
#Pour la suite, on crée une fonction rangerListe() avec la liste à trier en paramètre ainsi qu'une liste à deux dimensions
#On regarde chaque valeur puis on l'attribue à la liste[i][] correspondante.
#Par conjecture : le résultat sera le même que dans l'exo 1 entant donnée que ce sont les mêmes paramètres de départ.   
#b)Les résultats sont identiques