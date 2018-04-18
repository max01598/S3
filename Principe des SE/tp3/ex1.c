#include <stdio.h>
#include <stdlib.h>
#include <signal.h>
int i=1;

void sighandler(){
	//3 Premiers CTRL+C
	if(i<4){
		printf("interuption numéro %d\n",i);
		fflush(stdout);
	//Sortie du programme
	}else if(i==6){
		exit(0);
		
	}
	i++;
	
}

int main (){
	//Detection du signal
	signal(SIGINT, sighandler);
	//Boucle pour permettre au programme de ne pas s'arreter avant que l'on fasse le signal 
	while(1){
		sleep(1);
	}
}



