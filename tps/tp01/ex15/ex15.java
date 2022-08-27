public class ex15 {

    public static char toUpper(char c) {
        return (c >= 'a' && c <= 'z') ? ((char) ((int) c - 32)) : c;
    }

    public static boolean isVogal(String str, int i) {
        boolean retorno;

        if (i == str.length()) {
            retorno = true;

        }else if  ((toUpper(str.charAt(i)) != 'A') && (toUpper(str.charAt(i)) != 'E') && (toUpper(str.charAt(i)) != 'I') && (toUpper(str.charAt(i)) != 'O') && (toUpper(str.charAt(i)) != 'U')) {
            retorno = false;

        }else {
            retorno = isVogal(str, ++i);
        }

        return retorno;
    }

    public static boolean isVogalChar(char c) {
        boolean retorno = true;

        c = toUpper(c);

        if ((c != 'A') && (c != 'E') && (c != 'I') && (c != 'O') && (c != 'U')) {
            retorno = false;
        }

        return retorno;
    }

    public static boolean isConsonant(String palavra, int i) {
        boolean retorno;

        if (i == palavra.length()) {
            retorno = true;

        }else if ((toUpper(palavra.charAt(i)) < 'A' || toUpper(palavra.charAt(i)) > 'Z') || (isVogalChar(palavra.charAt(i)) == true)) {
            retorno = false;

        }else {
            retorno = isConsonant(palavra, ++i);
        }
        return retorno;
    }

    public static boolean isInt(String palavra, int i) {
        boolean retorno;

        if (i == palavra.length()) {
            retorno = true;

        }else if ((palavra.charAt(i) < '0') || (palavra.charAt(i) > '9')) {
            retorno = false;

        }else {
            retorno = isInt(palavra, ++i);
        }

        return retorno;
    }

    public static boolean isReal(String palavra, int i, int count) {
        boolean retorno;
        
        if (i == palavra.length()) {
            retorno = true;

        }else if ((count > 1) || ((palavra.charAt(i) != ',' && palavra.charAt(i) != '.') && (palavra.charAt(i) < '0') || (palavra.charAt(i) > '9'))) {
            retorno = false;

        }else {

            if (palavra.charAt(i) == ',' || palavra.charAt(i) == '.') {
                count++;
            }

            retorno = isReal(palavra, ++i, count);
        }

        return retorno;
    }

    public static boolean isFim(String palavra){
        return !(palavra.length() == 3 && palavra.charAt(0) == 'F' && palavra.charAt(1) == 'I' && palavra.charAt(2) == 'M');
    }

    public static void main(String[] args) {

        String palavra = MyIO.readLine();

        while (isFim(palavra)) {

            if(isVogal(palavra, 0)){
                MyIO.print("SIM ");
            }else{
                MyIO.print("NAO ");
            }

            if(isConsonant(palavra, 0)){
                MyIO.print("SIM ");
            }else{
                MyIO.print("NAO ");
            }

            if(isInt(palavra, 0)){
                MyIO.print("SIM ");
            }else{
                MyIO.print("NAO ");
            }

            if(isReal(palavra, 0, 0)){
                MyIO.print("SIM\n");
            }else{
                MyIO.print("NAO\n");
            }
            
            palavra = MyIO.readLine();
        }

    }
}