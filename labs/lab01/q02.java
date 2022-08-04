import java.text.Normalizer;
import java.util.Scanner;


class q02 {

    public static int isMaiuscula(String s, int index){

        if (index < s.length()) {

            if (s.charAt(index) >= 'A' && s.charAt(index) <='Z') { return 1 + isMaiuscula(s, index+1);}

            if (s.charAt(index) >= 'a' && s.charAt(index) <='z' || s.charAt(index) >= ' ' && s.charAt(index) <= '@') { 
                return 0 + isMaiuscula(s, index+1);
            }
        }

        return 0;
    }

    public static void main(String[] args){

        String palavras[] = new String[1000];
        int cont = 0;

        try (Scanner input = new Scanner(System.in)) {
            while (true){
                
                String string = input.nextLine();

                string = Normalizer.normalize(string, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", ""); // remove carcteres especiais

                if ( (string.length() == 3 && string.charAt(0) == 'F' && string.charAt(1) == 'I' && string.charAt(2) == 'M') == false) { // para loop quando esquever FIM

                    palavras[cont] = string;

                    cont++;
                }
                else{ break; }

            };
        }

        for (String palavra : palavras) {
            int retorno = isMaiuscula(palavra, 0);
            System.out.println(retorno);
        }
 
    }

}

