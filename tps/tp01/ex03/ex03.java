class ex03 {

    public static String cifrar(String frase) {
        String cifrado = "";

        for (int i = 0; i < frase.length(); i++){

            //deslocando caracteres 3 casas a direita
            cifrado += (char)(frase.charAt(i) + 3);
        }

        return cifrado;
    }

    public static boolean isFim(String s){
        return (s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
    }

    public static void main (String[] args){

        String[] entrada = new String[1000];
        int count = 0;
  
        
        do{
           // entrada padrao
           entrada[count] = MyIO.readLine();

        } while (isFim(entrada[count++]) == false);
        
        // desconsiderando linha com flag de parada
        count--; 
  
        // saida
        for(int i = 0; i < count; i++){
           MyIO.println(cifrar(entrada[i]));
        }
     }
}