import os
import sys

fich=sys.argv[1]
desc=os.open(fich,os.O_RDONLY)

size=1
cont=" "
cpC=0
cpL=0
while(len(cont)!=0):
    cont=os.read(desc,size)
    carac=cont.decode(encoding='UTF-8',errors='strict')
    if(carac=='\n'):
        cpL=cpL+1
    cpC=cpC+1

print(cpL)
print(cpC)
os.close(desc)
#os.unlink(fich)

        
