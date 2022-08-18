public class ex01 {

    public static boolean palindromo(String palavra){

       
        for (int i = 0; i < palavra.length()/2; i++) {

            // verificacao de duas letras por iteracao
            if ( palavra.charAt(i) != palavra.charAt(  (palavra.length() - 1) - i) ) {

                return false;
            }
        }

        return true;   
    }

    public static boolean isFim(String s){

	    return(s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');

	}

    public static void main(String[] args) {

        String[] palavras = new String[1000];
        int count = 0;

        while(true){

            // entrada
            palavras[count] = MyIO.readLine();

            if(isFim(palavras[count])){
                break;
            
            // verificacao de palindromo e saida com SIM ou NAO
            }else if (palindromo(palavras[count++])) {
                MyIO.println("SIM");
                
            } else {
                MyIO.println("NAO");
            }
        }
    }

}
