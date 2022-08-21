class ex06 {

    public static boolean apenasVogal(String s){

        String auxiliar = "AEIOUaeiou";
        
        for(int i = 0; i < s.length(); i++){

            if (auxiliar.indexOf(s.charAt(i)) == -1){
                return false;
            }
        }

        return true;
    }

    public static boolean apenasConsoante(String s){
        
        String auxiliar = "QWRTYPSDFGHJKLZXCVBNMqwrtypsdfghjklzxcvbnm";

        for(int i = 0; i < s.length(); i++){

            if (auxiliar.indexOf( s.charAt(i) ) == -1) {
                return false;
            }
        }

        return true;
    }
    
    public static boolean isInteiro(String s){

        String auxiliar = "0123456789";

        for(int i = 0; i < s.length(); i++){

            if (auxiliar.indexOf( s.charAt(i) ) == -1){
                return false;
            }
        }

        return true;
    }

    public static boolean isReal(String s){

        String auxiliar = ",.0123456789";
        int count = 0;
        boolean retorno = true;
        
        for(int i = 0; i < s.length(); i++){

            if(s.charAt(i) == ',' || s.charAt(i) == '.'){
                count++;
            }

            if (auxiliar.indexOf( s.charAt(i) ) == -1){
                retorno = false;
            }
        }

        // verificacao de quantiade de '.' e ','
        if (count > 1){ 
            retorno = false;
        }

        return retorno;
    }


    public static boolean isFim(String s){
        return (s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
    }

    public static void main(String[] args){

        String[] entrada = new String[1000];

        int count = 0;
  
        // entrada padrao
        do {
           entrada[count] = MyIO.readLine();

        } while (isFim(entrada[count++]) == false);

        count--; // desconsiderando flag de parada
  
        // saida
        for(int i = 0; i < count; i++){

            if( apenasVogal(entrada[i]) ){
                MyIO.print("SIM ");

            }else{ 
                MyIO.print("NAO ");
            }

            if( apenasConsoante(entrada[i]) ){
                 MyIO.print("SIM ");

            }else{
                MyIO.print("NAO ");
            }

            if( isInteiro(entrada[i]) ){ 
                MyIO.print("SIM ");

            }else{
                MyIO.print("NAO ");
            }

            if( isReal(entrada[i]) ){
                MyIO.print("SIM\n");

            }else{
                MyIO.print("NAO\n");
            }
        }
    }
}