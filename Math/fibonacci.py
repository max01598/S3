#Definition de Un

#u1=1%10
#u2=1%10
#liste = []
#liste.append(u1)
#liste.append(u2)
indiceP=0
indiceD=0

for i in range(2,100) :
	ui=(liste[i-1]+liste[i-2])%10
	liste.append(ui)
	if liste[i-1] == 1 and liste[i] == 1:
		indiceP = i-1
		break
	

print indiceP	


i=2
while indiceD==0 and i<100
	ui=(liste[i-1]+liste[i-2])%10
	liste.append(ui)
	if liste[i-1] == 5 and liste[i] == 8:
		indiceD = i-1
	


	