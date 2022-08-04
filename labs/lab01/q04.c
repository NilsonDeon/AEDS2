#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define MAX 100

int isMaiuscula(char s[], int index){
    if (index < strlen(s)) {

            if (s[index] >= 'A' && s[index] <='Z') { 
                return 1 + isMaiuscula(s, index+1);
            }

            if (s[index] < 'A' || s[index] > 'Z'){ 
                return 0 + isMaiuscula(s, index+1);
            }
        }

        return 0;
}

int main(){

    char frase[MAX];
    int resp[MAX], cont = 0;

    while (1){

        gets(frase);

        if (strcmp(frase, "FIM")){
            resp[cont++] = isMaiuscula(frase, 0);
        }
        else{ break; }
    }
    
    for (int i = 0; i < cont; i++){

        if (i == cont -1){
            printf("%i", resp[i]);
        }
        else{
            printf("%i\n", resp[i]);
        }
        
    }
    
    
    return 0;
}
