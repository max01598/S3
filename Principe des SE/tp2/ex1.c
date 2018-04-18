#include <stdio.h>
#include <stdlib.h>
int main ()
{
  pid_t rc = fork();
  if(rc>0){
	pid_t rc2 = fork();
	if(rc2>0){
		pid_t rc3 = fork();
		if(rc3>0){
			printf("Je suis le père de %d et %d et %d : mon PID est %d\n", rc,rc2,rc3,getpid());
			int id; 
			int status;
			id=wait(&status);
			while(id!=-1){
				printf("\nFin du processus %d \n",id);
				id=wait(&status);
			}
			printf("Fin du pere %d\n", getpid());
			fflush(stdout);
  		}else{
		   	printf("Je suis le fils de %d : mon PID est %d\n", getppid(),getpid());
		   	printf("Fin du fils %d\n", getpid());
			sleep(3);
		    	fflush(stdout);
			exit(0);
	}}else{
	   	printf("Je suis le fils de %d : mon PID est %d\n", getppid(),getpid());
	   	printf("Fin du fils %d\n", getpid());
		sleep(2);
	    	fflush(stdout);
		exit(0);
  }}else{
	printf("Je suis le fils de %d : mon PID est %d\n", getppid(),getpid());
	printf("Fin du fils %d\n", getpid());
	sleep(1);
        fflush(stdout);
	exit(0);
  }
  return 0;
}
   

