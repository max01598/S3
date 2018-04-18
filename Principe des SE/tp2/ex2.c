#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>


int main (){
	pid_t rc = fork();
 	if(rc==0){
		execlp("xterm",NULL);
	}
}



