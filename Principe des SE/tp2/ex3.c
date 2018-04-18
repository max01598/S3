#include <stdio.h>
int main(){
 printf("Attention : ce programme boucle indéfiniment !\n");
 fflush(stdout);
 while (1){
 printf(".");
 fflush(stdout);
 sleep(1) ;
 }
 return 0; /* jamais atteint */
}
