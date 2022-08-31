#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main() {

    char string1[100], string2[100];

    // entrada + verificacao de final de arquivo
    while( scanf("%s%s", string1, string2) != EOF ){

        int length1 = strlen(string1);
        int length2 = strlen(string2);
        int length3 = length1 + length2;

        char* string3 = (char*)malloc( length3 * sizeof(char) );
        int count1 = 0, count2 = 0;

        for(int i = 0; i < length3; i++){

            if(i % 2 == 0){

                if(count1 < length1){
                    string3[i] = string1[count1];
                    count1++;

                } else{
                    string3[i] = string2[count2];
                    count2++;
                }

            } else{

                if(count2 < length2){
                    string3[i] = string2[count2];
                    count2++;

                } else{
                    string3[i] = string1[count1];
                    count1++;
                }
            }
        }

        // saida
        for(int i = 0; i < length3; i++){
            printf("%c", string3[i]);
        }
        printf("\n");
    }

    return 0;
}