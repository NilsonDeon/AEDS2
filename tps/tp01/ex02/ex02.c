#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <string.h>

#define MAX 700

bool palindromo(char palavra[]){

    int length = strlen(palavra);
    

    for (int i = 0; i < length/2 ; i++){
        // verificacao de duas letras por iteracao
        if ( palavra[i] != palavra[ ( ( length - 2) - i ) ] ) {

            return false;
        }

        return true;
    }
    
}

bool isFim(char palavra[]){
    return ((strlen(palavra)-1) == 3 && palavra[0] == 'F' && palavra[1] == 'I' && palavra[2] == 'M');
}

int main(){

    char resposta[MAX];
    char* palavra = malloc(MAX);
    int count = 0;

    while (true){

        fgets(palavra, MAX, stdin);
        if (isFim(palavra)){
            break;

        }else if(palindromo(palavra)){
            resposta[count++] = 's';

        }else{
            resposta[count++] = 'n';
        }
        
    }
    
    for (int i = 0; i < count; i++){
        if (resposta[i] == 's'){
            printf("SIM\n");

        }else{
            printf("NAO\n");
        }
    }
    

    free(palavra);
    return 0;
}
