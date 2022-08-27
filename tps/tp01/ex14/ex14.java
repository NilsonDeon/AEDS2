

class ex14 {

    public static boolean strComp(String a, String b) {

        boolean retorno = true;

        if (a.length() != b.length()) {
            retorno = false;

        } else {

            for (int i = 0; i < a.length(); i++) {

                if (a.charAt(i) != b.charAt(i)) {
                    retorno = false;
                }
            }
        }

        return retorno;
    }

    public static String substituirString(String s) {

        // possibilidades com até 4 valores 
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

        //  retorno para cada possibilidade
        String[] possibilidadeRetorno = { 
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

            if (strComp(s, possibilidades[i])) {
                return possibilidadeRetorno[i];
            }
        }

        return s;
    }

    public static String parser(String s) {

        char entradas = s.charAt(0), A = s.charAt(2), B = s.charAt(4), C = s.charAt(6);
    
        int posicaoInicial = 6; 

        if (entradas == '3') {
            posicaoInicial = 8;
        }

        String str = "";
        
        for (int i = posicaoInicial; i < s.length(); i++) {

            // removendo espaços e substituindo os valores 
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

        return algebraBooleana(str);
    }

    public static String algebraBooleana(String str) {

        String retorno;

        if (str.length() == 1) {
            retorno = str;

        } else {

            String auxiliar = "";
            retorno = "";
            
            int pos1 = 0, pos2 = 0;

            for (int i = 0; i < str.length(); i++) {

                // encontra pos
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

            if (str.charAt(pos1 - 2) == 'o' && str.charAt(pos1 - 1) == 'r') {
                // or
                for (int i = pos1 - 2; i <= pos2; i++){
                    auxiliar += str.charAt(i);
                }

                // soma tudo antes de or
                for (int i = 0; i < pos1 - 2; i++){ 
                    retorno += str.charAt(i);
                }
                retorno += substituirString(auxiliar); 

                // soma tudo depois de or
                for(int i = pos2 + 1; i < str.length(); i++){ 
                    retorno += str.charAt(i);
                }

            } else {

                // not e and
                for (int i = pos1 - 3; i <= pos2; i++){
                    auxiliar += str.charAt(i);
                }

                // soma tudo antes
                for (int i = 0; i < pos1 - 3; i++){
                    retorno += str.charAt(i);
                }
                retorno += substituirString(auxiliar);

                // soma tudo depois
                for(int i = pos2 + 1; i < str.length(); i++){
                    retorno += str.charAt(i);
                }
            }

            retorno = algebraBooleana(retorno);
            
        }

        return retorno;
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

        } while (isFim(entrada[count++]) == false);

        // desconsiderando flag de parada
        count--;   

        // saida
        for(int i = 0; i < count; i++){
            MyIO.println(parser(entrada[i]));
        }
    }
}