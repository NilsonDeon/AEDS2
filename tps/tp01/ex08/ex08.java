import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;

class ex08 {
 
    public static String getHtml(String endereco){
        String retorno = "", linha;
        URL url;
        InputStream is = null;
        BufferedReader br;
    
        try {
            url = new URL(endereco); 

            is = url.openStream();

            // adiciona html
            br = new BufferedReader(new InputStreamReader(is)); 
    
            while ((linha = br.readLine()) != null) {
                retorno += linha + "\n";
            }

        } catch (MalformedURLException mue) {
            mue.printStackTrace();

        } catch (IOException ioe) {
            ioe.printStackTrace();
        } 
    
        try {
            is.close();
        } catch (IOException ioe){
    
        }
    
        return retorno;
    }

    public static String printLetra(String s){

        //transformando string em byte
        byte[] b = s.getBytes();
        String palavra = new String(b, StandardCharsets.ISO_8859_1);
        
        return palavra;
    }


    public static int Tag(String html, String tag) {
        int retorno = 0;
        if (tag == "<table>"){ 

            // lendo página
            for (int i = 0; i < html.length(); i++){  

                // verificando se e tabela
                if (html.charAt(i) == '<'){
                    if (html.charAt(i + 1) == 't' && html.charAt(i + 2) == 'a' && html.charAt(i + 3) == 'b'
                    && html.charAt(i + 4) == 'l' && html.charAt(i + 5) == 'e' && html.charAt(i + 6) == '>'){ 
                        retorno++;
                    }
                }
            }

        } else { 

            // lendo página
            for (int i = 0; i < html.length(); i++) {

                // verificando se e quebra de linha
                if (html.charAt(i) == '<') {
                    if (html.charAt(i + 1) == 'b' && html.charAt(i + 2) == 'r' && html.charAt(i + 3) == '>'){
                        retorno++;
                    }
                }
            }
        }
        return retorno;
    }

    public static void verificaExistencia(String s, String titulo){

        int[] quantidade = new int[25];

        // quantidade de quebras de linha e tabelas
        quantidade[23] = Tag(s, "<br>"); 
        quantidade[24] = Tag(s, "<table>"); 


        for(int i = 0; i < s.length(); i++){

            if (s.charAt(i) >= 97 && s.charAt(i) <= 122 && (s.charAt(i) != 97 && s.charAt(i) != 101
                    && s.charAt(i) != 105 && s.charAt(i) != 111 && s.charAt(i) != 117)) quantidade[22]++;

            else {
                switch (s.charAt(i)){
                    case 'a': quantidade[0]++; break;
                    case 'e': quantidade[1]++; break;
                    case 'i': quantidade[2]++; break;
                    case 'o': quantidade[3]++; break;
                    case 'u': quantidade[4]++; break;
                    case '\u00E1': quantidade[5]++; break;
                    case '\u00E9': quantidade[6]++; break;
                    case '\u00ED': quantidade[7]++; break;
                    case '\u00F3': quantidade[8]++; break;
                    case '\u00FA': quantidade[9]++; break;
                    case '\u00E0': quantidade[10]++; break;
                    case '\u00E8': quantidade[11]++; break;
                    case '\u00EC': quantidade[12]++; break;
                    case '\u00F2': quantidade[13]++; break;
                    case '\u00F9': quantidade[14]++; break;
                    case '\u00E3': quantidade[15]++; break;
                    case '\u00F5': quantidade[16]++; break;
                    case '\u00E2': quantidade[17]++; break;
                    case '\u00EA': quantidade[18]++; break;
                    case '\u00EE': quantidade[19]++; break;
                    case '\u00F4': quantidade[20]++; break;
                    case '\u00FB': quantidade[21]++; break;
                }
            }
        }

        MyIO.println("a(" + (quantidade[0]) + ") e(" + (quantidade[1]) + ") i(" + quantidade[2] + ") o(" + quantidade[3] + ") u(" + quantidade[4]+ ") "+ printLetra("\u00E1") +"(" + quantidade[5] + ") "+ printLetra("\u00E9") +"(" + quantidade[6] + ") "+ printLetra("\u00ED") +"(" + quantidade[7] + ") "+ printLetra("\u00F3") +"(" + quantidade[8] + ") "+ printLetra("\u00FA") +"(" + quantidade[9] + ") "+ printLetra("\u00E0") +"(" + quantidade[10]+ ") "+ printLetra("\u00E8") +"(" + quantidade[11] + ") "+ printLetra("\u00EC") +"(" + quantidade[12] + ") "+ printLetra("\u00F2") +"(" + quantidade[13] + ") "+ printLetra("\u00F9") +"(" + quantidade[14] + ") "+ printLetra("\u00E3") +"(" + quantidade[15] + ") "+ printLetra("\u00F5") +"("+ quantidade[16] + ") "+ printLetra("\u00E2") +"(" + quantidade[17] + ") "+ printLetra("\u00EA") +"(" + quantidade[18] + ") "+ printLetra("\u00EE") +"(" + quantidade[19] + ") "+ printLetra("\u00F4") +"(" + quantidade[20] + ") "+ printLetra("\u00FB") +"(" + quantidade[21]+ ") consoante(" + quantidade[22] + ") <br>(" + quantidade[23] + ") <table>(" + quantidade[24] + ") " + titulo);
    }


    public static boolean isFim(String s){
        return (s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
    }

    public static void main(String[] args){

        String[] pagina = new String[1000];
        String[] endereco = new String[1000];
        String html;

        int count = 0;

        pagina[count] = MyIO.readLine();

        // verificando flag de parada
        while(isFim(pagina[count]) == false){

            endereco[count] = MyIO.readLine();

            count++;
            pagina[count] = MyIO.readLine();
            
        }
    
        // saida
        for(int i = 0; i < count; i++){
            html = getHtml(endereco[i]);
            verificaExistencia(html, pagina[i]);
        }
    }

}

