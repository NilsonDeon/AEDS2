import java.util.*;

class ex05 {

    public static boolean compara(String a, String b) {

        if (a.length() != b.length()) {
            return false;

        } else {

            for (int i = 0; i < a.length(); i++) {

                if (a.charAt(i) != b.charAt(i)) {
                    return false;
                }
            }
        }

        return true;
    }

    public static String substitui(String s) {

        // ate 4 valores
        String[] possibilidades = { 
            "not(0)", "not(1)",
            "or(0,0)", "or(0,1)", "or(1,0)", "or(1,1)",
            "or(0,0,0)", "or(0,0,1)", "or(0,1,0)", "or(0,1,1)", "or(1,0,0)", "or(1,0,1)", "or(1,1,0)", "or(1,1,1)",
            "or(0,0,0,0)", "or(0,0,0,1)", "or(0,0,1,0)", "or(0,0,1,1)", "or(0,1,0,0)", "or(0,1,0,1)", "or(0,1,1,0)",
            "or(0,1,1,1)", "or(1,0,0,0)", "or(1,0,0,1)", "or(1,0,1,0)", "or(1,0,1,1)", "or(1,1,0,0)", "or(1,1,0,1)",
            "or(1,1,1,0)", "or(1,1,1,1)",
            "and(0,0)", "and(0,1)", "and(1,0)", "and(1,1)",
            "and(0,0,0)", "and(0,0,1)", "and(0,1,0)", "and(0,1,1)", "and(1,0,0)", "and(1,0,1)", "and(1,1,0)", "and(1,1,1)",
            "and(0,0,0,0)", "and(0,0,0,1)", "and(0,0,1,0)", "and(0,0,1,1)", "and(0,1,0,0)", "and(0,1,0,1)", "and(0,1,1,0)",
            "and(0,1,1,1)", "and(1,0,0,0)", "and(1,0,0,1)", "and(1,0,1,0)", "and(1,0,1,1)", "and(1,1,0,0)", "and(1,1,0,1)",
            "and(1,1,1,0)", "and(1,1,1,1)"      
        };

        // respostas
        String[] possibRespostas = { 
        "1", "0",
        "0", "1", "1", "1",
        "0", "1", "1", "1", "1", "1", "1", "1",
        "0", "1", "1", "1", "1", "1", "1",
        "1", "1", "1", "1", "1", "1", "1",
        "1", "1",
        "0", "0", "0", "1",
        "0", "0", "0", "0", "0", "0", "0", "1",
        "0", "0", "0", "0", "0", "0", "0",
        "0", "0", "0", "0", "0", "0", "0",
        "0", "1"
        };
    

        String retorno = "";

        for (int i = 0; i < possibilidades.length; i++) {

            if (compara(s, possibilidades[i])) {
                return possibRespostas[i];
            }
        }

        return s;
    }

    public static String algebraBool(String s) {

        char entradas = s.charAt(0), A = s.charAt(2), B = s.charAt(4), C = s.charAt(6);
    
        int inicio = 6; 
        if (entradas == '3'){
            inicio = 8;
        }

        String str = "";

        for (int i = inicio; i < s.length(); i++){

            // refatorando
            if (s.charAt(i) == 'A') {
                str += A;
            } else if (s.charAt(i) == 'B') {
                str += B;
            } else if (entradas == '3' && s.charAt(i) == 'C') {
                str += C;
            } else if (s.charAt(i) != ' ') {
                str += s.charAt(i);
            }
        }
        
        while (str.length() > 1) {

            String auxiliar = "";
            String resposta = "";

            int pos1 = 0, pos2 = 0;

            for (int i = 0; i < str.length(); i++) {

                // encontrando posicoes
                if (str.charAt(i) == ')') {

                    pos2 = i;
                    int j = i;

                    while (pos1 == 0) {

                        if (str.charAt(j) == '(') {
                            pos1 = j;
                        }

                        j--;
                    }
                    break;
                }
            }

            // or
            if (str.charAt(pos1 - 2) == 'o' && str.charAt(pos1 - 1) == 'r') {
                
                
                for (int i = pos1 - 2; i <= pos2; i++) {
                    auxiliar += str.charAt(i);
                }

                // soma anterior a or
                for (int i = 0; i < pos1 - 2; i++) { 
                    resposta += str.charAt(i);
                }
                
                resposta += substitui(auxiliar); 

                // soma posterior a or
                for(int i = pos2 + 1; i < str.length(); i++) { 
                    resposta += str.charAt(i);
                }

            // and e not 
            } else {

                for (int i = pos1 - 3; i <= pos2; i++) {
                    
                    auxiliar+= str.charAt(i);
                }

                for (int i = 0; i < pos1 - 3; i++) {
                    resposta += str.charAt(i);
                }

                resposta += substitui(auxiliar);

                for(int i = pos2 + 1; i < str.length(); i++) {
                    resposta += str.charAt(i);
                }
            }

            // fazendo loop
            str = resposta; 
        }

        return str;
    }

    public static boolean isFim(String s){
        return (s.charAt(0) == '0');
    }

    public static void main (String[] args){

        String[] entrada = new String[1000];
        int count = 0;

        // entrada padrao
        do {
            entrada[count] = MyIO.readLine();
            MyIO.println(count);
        } while ( isFim(entrada[count++]) );

        // desconsiderando linha com flag de parada
        count--;   

       

        // saida
        for(int i = 0; i < count; i++){
            MyIO.println(count);
        }
    }
}

// algebraBool(entrada[i])