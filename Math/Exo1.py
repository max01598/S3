#Xn+1=(a.Xn+c)mod m
#X0=graine
def suite(liste,nbE,a,c,m,Xn):#on construit la suite
    i=0
    while(i<=nbE):#tant que i n'a pas atteint le nombre d'elements demandés...
        Xn=(a*Xn+c)%m#... chaque élement est saisi
        liste.append(Xn)#on l'ajoute
        i=i+1

def trouverPeriode(liste):#pour trouver une periode, on va prendre les deux premieres valeurs et parcourir la liste en essayant de les retrouver les mêmes configurations
    valeurInit=liste[0]#on prend la premiere valeur de la liste
    valeurInit2=liste[1]#on prend la seconde valeur de la liste
    for index in range(1,len(liste)):#on parcourt la liste à partir du second élement
        if liste[index]==valeurInit:#si on trouve une valeur identique à la premiere valeur...
            if liste[index+1]==valeurInit2:#... alors regardons si celle qui suit est la même que la seconde ...
                print(index)#... alors c'est qu'il existe une période, on prend l'index actuel pour connaitre sa période
                exit()#on sort de cette boucle
        
a=25#on initialise les paramètres de base.
c=16
m=256

X0=125
liste=[]
liste.append(X0)
suite(liste,1000,a,c,m,X0);
print(liste)
trouverPeriode(liste)

