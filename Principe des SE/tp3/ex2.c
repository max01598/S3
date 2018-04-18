#include <stdio.h>
#include <stdlib.h>
#include <signal.h>
int i=0;

void sighandler(){
	//Affichage d'un compteur 
	printf("Compteur : %d\n",i);
	//Signal toutes les 2s
	alarm(2);
}



int main (){
	//Detection du signal d'alarme
	signal(SIGALRM, sighandler);
	//Signal au bout de 2s
	alarm(2);
	//Boucle pour permettre au programme de ne pas s'arreter 
	while(1){
		usleep(1);
		i++;
	}
}




