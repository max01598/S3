#include <stdio.h>
#include <stdlib.h>
#include <signal.h>

void sighandler(){
	//Lorsque le fils s'arrete, on lance cette partie du code
	int status=0;
	//Fonction waitpid qui permet au père de ne pas s'arreter (grace a WNOHANG et -1) 
	waitpid(-1,&status,WNOHANG);
	//Qui permet au père d'afficher que le fils s'est bien terminé, ainsi que son code de retour
	printf("Le fils s'est terminé , code de retour : %d 	\n",WEXITSTATUS(status));
	fflush(stdout);
}

int main (){
	int i=0;
	//Creéation du fils
	pid_t rc=fork();
	//Si echec de la création
	if(rc<0){
		printf("Erreur fork");
		fflush(stdout);
	//Si c'est le fils 
	//On fait un sleep pendant 20s puis on arrete le processus
	}else if(rc==0){
		sleep(20);
		exit(5);
	}else if(rc>0){
	//Si c'est le père
	//On attend le signal de fin du fils tout en affichant un compteur en même temps
		signal(SIGCHLD, sighandler);
		while(1){
			printf("Compteur : %d \n",i);
			fflush(stdout);
			i++;
			sleep(2);
		}
	}			
}





