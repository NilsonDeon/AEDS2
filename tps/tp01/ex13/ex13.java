class ex13 {
  
    public static String cifraRecursivo(String palavra){
        return cifraRecursivo(palavra, 0);
    }

    public static String cifraRecursivo(String palavra, int i) {
        // caso base == fim de palavra
        String retorno = "";

        if (i != palavra.length()){
            retorno = (char)((int)palavra.charAt(i) + 3) + cifraRecursivo(palavra, i + 1);
        } 

        return retorno;
    }
    
    public static boolean isFim(String palavra){
        return !(palavra.length() == 3 && palavra.charAt(0) == 'F' && palavra.charAt(1) == 'I' && palavra.charAt(2) == 'M');
    }

    public static void main (String[] args){

        String[] palavra = new String[1000];
        int count = 0;

        do {
            // entrada padrao
            palavra[count] = MyIO.readLine();

        } while (isFim(palavra[count++]));

        // ignorando flag de parada
        count--; 

        // saida
        for(int i = 0; i < count; i++){
            MyIO.println(cifraRecursivo(palavra[i]));
        }

    }
}