#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <string.h>

#define MAX 1000

bool isPalindromo(char texto[]){

    int length = strlen(texto);

    for(int i = 0 ; i < length/2; i++){
        
        // comparando 2 letras por iteracao
        if(texto[i] != texto[ (length -1) -i]){
            return false;
        }

    }

    return true;
}

bool isFim(char palavra[]){
    return ((strlen(palavra)-1) == 3 && palavra[0] == 'F' && palavra[1] == 'I' && palavra[2] == 'M');
}

int main(){

    char palavra[MAX];
    char texto[MAX][MAX];
    
    int count = 0;

    while(true){
        // entrada padrao
        scanf(" %[^\n]", palavra);

        if(strcmp(palavra, "FIM") == 0){
            break;
        }

        strcpy(texto[count], palavra);

        count++;
    }
	
    for(int i = 0; i < count; i++){
        // saida
        if(isPalindromo(texto[i])){
            printf("SIM\n");

        }else{
            printf("NAO\n");
        }
    }
}
