package tps.tp01;

public class ex01 {

    public static boolean palindromo(String palavra){

        int cont = 0;
        int length = palavra.length();

        for (int i = 0; i < length; i++) {
            if ( palavra.charAt(i) == palavra.charAt(  (length - 1) - i) ) {
                cont++;
            }
        }

        if(cont == length){
            return true;
        }


        return false;
    }

    public static void main(String[] args) {

        while (true) {

            String palavra = MyIO.readString();

            if (palavra == "FIM") {
                break;

            }else{

                if (palindromo(palavra)) {
                    MyIO.println("SIM");
                    
                } else {
                    MyIO.println("NÃO");
                }
            }

        }
    }

}
