import os
import sys
import time

tube=os.open("tmp",os.O_WRONLY)
pid=os.getpid()
print(pid)
res=pid.to_bytes(4,sys.byteorder)
os.write(tube,res)
while(1):
    os.system("who")
    time.sleep(1)

os.close(tube)
    
