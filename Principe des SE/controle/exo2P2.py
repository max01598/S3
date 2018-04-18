import os
import sys
import signal

while(1):
    choix=input("Entrer choix")
    desc=os.open("tmp",os.O_RDONLY)
    pid=os.read(desc,4)
    res=int.from_bytes(pid,sys.byteorder)
    if(choix=="info"):
        print(res)
    elif(choix=="stop"):
        os.kill(res,signal.SIGKILL)
        os.close(desc)
        sys.exit(0)
    else :
        choix=input("Entrer choix")

    
    
    
