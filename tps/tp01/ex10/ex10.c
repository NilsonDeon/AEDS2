#include <stdio.h>
#include <stdlib.h>

void criaArquivo(int quantidade){

    double numero = 0;

    // cria arquivo, modo de escrita
    FILE *arquivo = fopen("arquivo.txt", "w");
    
    for (int i = 0; i < quantidade; i++){
        // entrada padrao
        scanf("%lf", &numero);
        // inserindo numero no arquivo
        fwrite(&numero, sizeof(numero), 1, arquivo);
    }

    fclose(arquivo);
}

void inverso(int quantidade){

    double numero = 0;

    // abrindo em modo de leitura
    FILE *arquivo = fopen("arquivo.txt", "r");

    for (int i = 1; i <= quantidade; i++){

        fseek(arquivo, -i * 8, SEEK_END);
        fread(&numero, sizeof(double), 1, arquivo);

        // saida
        if (numero - (int)numero == 0){
            printf("%d\n", (int)numero);
        }
        else{
            printf("%g\n", numero);
        }
    }

    fclose(arquivo);
}


int main(void)
{
    int quantidade = 0;

    // entrada padrao
    scanf("%i", &quantidade);

    criaArquivo(quantidade);

    inverso(quantidade);

}