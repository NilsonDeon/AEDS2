#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>


char toUpper(char caractere){
    return (caractere >= 'a' && caractere <= 'z') ? ((char)((int)caractere - 32)) : caractere;
}


bool isVogal(char str[]){

    char caractere = '\0';

    for (int i = 0; i < strlen(str) - 2; i++){

        caractere = toUpper(str[i]);

        if ((caractere != 'A') && (caractere != 'E') && (caractere != 'I') && (caractere != 'O') && (caractere != 'U')){
            return false;
        }
    }
    return true;

}


bool isVogalChar(char caractere){

    caractere = toUpper(caractere);

    if ((caractere != 'A') && (caractere != 'E') && (caractere != 'I') && (caractere != 'O') && (caractere != 'U')){

        return true;
    }

    return false;
}


bool isConsoante(char str[]){

    char caractere = '\0';

    for (int i = 0; i < strlen(str) - 2; i++){
        caractere = toUpper(str[i]);

        if ((caractere < 'A' || caractere > 'Z') || (isVogalChar(caractere) == false)){
            return false;
        }
    }

    return true;
}


bool isInt(char str[]){

    char caractere = '\0';

    for (int i = 0; i < strlen(str) - 2; i++){
        caractere = str[i];

        if ((caractere < '0') || (caractere > '9')){
            return false;
        }
    }

    return true;
}

bool isReal(char str[]){

    char caractere = '\0';
    int count = 0;

    for (int i = 0; i < strlen(str) - 2; i++){
        caractere = str[i];

        if (caractere == ',' || caractere == '.'){
            count++;
        }

        if ((count > 1) || ((caractere != ',' && caractere != '.') && (caractere < '0') || (caractere > '9'))){

            return false;
            
        }
    }

    return true;
}

bool isFim(char str[]){
    return ((str[0] == 'F') && (str[1] == 'I') && (str[2] == 'M'));
}

int main(void){

    char str[200];
    
    while(true){

        fflush(stdin);
        fgets(str, 200, stdin);

        if(isFim(str)){
            break;
        }

        if(isVogal(str)){
            printf("SIM ");
            
        }else{
            printf("NAO ");
        }

        if(isConsoante(str)){
            printf("SIM ");

        }else{
            printf("NAO ");
        }

        if(isInt(str)){
            printf("SIM ");

        }else{
            printf("NAO ");
        }

        if(isReal(str)){
            printf("SIM\n");

        }else{
            printf("NAO\n");
        }
        
    }

    return 0;
}