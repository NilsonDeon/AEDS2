#include <stdio.h>
#include <string.h>
#include <stdbool.h>

#define MAX 1000

bool isPalindromoRecursivo(char* palavra, int i) {

    int length = strlen(palavra);
    int retorno = false;

    if(length/2 == i){
      retorno = true;

    }else if (palavra[i] == palavra[length - i - 1]){
        retorno = isPalindromoRecursivo(palavra, i+1);
    }
    
    return retorno;
}

int isFim(char* palavra) {
    int length = strlen(palavra);
    return ( length == 3 && palavra[0] == 'F' && palavra[1] == 'I' && palavra[2] == 'M');
}

int main() {
    char palavra[MAX];
    char texto[MAX][MAX];
    int count = 0;
	
    while(1){

        // entrada padrao
        scanf(" %[^\n]", palavra);

        if(strcmp(palavra, "FIM") == 0){
            break;
        }

        strcpy(texto[count], palavra);

        count++;
    }

    // saida
    for (int i = 0; i < count; i++) {

        if (isPalindromoRecursivo(texto[i], 0)){
            printf("SIM\n");

        } else{
            printf("NAO\n");
        }
        
    }
}