import java.util.Random;

class ex04{

    public static String aleatorizador(char letra1, char letra2, String palavra){
        String retorno = "";

        for(int i = 0; i < palavra.length(); i++){

            // substituindo letras
            if(palavra.charAt(i) == letra1){
                retorno += letra2;

            }else{ 
                retorno += palavra.charAt(i);
            } 

        }

        return retorno;
    }

    public static boolean isFim(String s){
        return (s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
    }

    public static void main(String[] args) {

        String[] entrada = new String[1000];
        
        Random gerador = new Random();
        gerador.setSeed(4);
        char letra1, letra2;

        int count = 0;

        // entrada padrao
        do {
            entrada[count] = MyIO.readLine();

        } while(isFim(entrada[count++]) == false);

        // desconsiderando linha com flag de parada
        count--; 

        // saida
        for(int i = 0; i < count; i++){

            //sorteando letras
            letra1 = (char)( 'a' + ( Math.abs(gerador.nextInt())%26 ));
            letra2 = (char)( 'a' + ( Math.abs(gerador.nextInt())%26 ));

            MyIO.println( aleatorizador(letra1, letra2, entrada[i]) );
        }
    }
}