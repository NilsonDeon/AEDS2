import java.io.*;
import java.util.*;
import java.text.*;

class Games{

    private int app_id;
    private String name;
    private Date release_date;
    private String owners;
    private int age;
    private float price;
    private int dlcs;
    private String[] languages;
    private String website;
    private boolean windows;
    private boolean mac;
    private boolean linux;
    private float upvotes;
    private int avg_pt;
    private String developers;
    private String[] genres;

    //  construtores

    public Games(){}
   
    public Games(int app_id, String name, Date release_date, String owners, int age, float price, int dlcs, String[] languages, String website, boolean windows, boolean mac, boolean linux, float upvotes, int avg_pt, String developers, String[] genres){
        this.app_id = app_id;
        this.name = name;
        this.release_date = release_date;
        this.owners = owners;
        this.age = age;
        this.price = price;
        this.dlcs = dlcs;
        this.languages = languages;
        this.website = website;
        this.windows = windows;
        this.mac = mac;
        this.linux = linux;
        this.upvotes = upvotes;
        this.avg_pt = avg_pt;
        this.developers = developers;
        this.genres = genres;
    }

// -------------------------- setters ------------------------------------- //

    public void setApp_id(int app_id){
        this.app_id = app_id;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setRelease_date(Date release_date){
        this.release_date = release_date;
    }

    public void setOwners(String owners){
        this.owners = owners;
        }

    public void setAge(int age){
        this.age = age;
    }

    public void setPrice(float price){
        this.price = price;
    }

    public void setDlcs(int dlcs){
        this.dlcs = dlcs;
    }

    public void setLanguages(String[] languages){
        this.languages = languages;
        }

    public void setWebsite(String website){
        this.website = website;
    }

    public void setWindows(Boolean windows){
        this.windows = windows;
    }

    public void setMac(Boolean mac){
        this.mac = mac;
    }

    public void setLinux(Boolean linux){
        this.linux = linux;
    }

    public void setUpvotes(float upvotes){
        this.upvotes = upvotes;
    }

    public void setAvg_pt(int avg_pt){
        this.avg_pt = avg_pt;
    }

    public void setDevelopers(String developers){
        this.developers = developers;
    }

    public void setGenres(String[] genres){
        this.genres = genres;
    }

   // -------------------------- getters ------------------------------------- //

    public int getApp_id(){
        return app_id;
    }

    public String getName(){
        return name;
    }

    public Date getRelease_date(){
        return release_date;
    }

    public String getOwners(){
        return owners;
    }

    public int getAge(){
        return age;
    }

    public float getPrice(){
        return price;
    }

    public int getDlcs(){
        return dlcs;
    }

    public String[] getLanguages(){
        return languages;
    }

    public String getWebsite(){
        return website;
    }

    public boolean getWindows(){
        return windows;
    }

    public boolean getMac(){
        return mac;
    }

    public boolean getLinux(){
        return linux;
    }

    public float getUpvotes(){
        return upvotes;
    }

    public int getAvg_pt(){
        return avg_pt;
    }

    public String getDevelopers(){
        return developers;
    }

    public String[] getGenres(){
        return genres;
    }

    public Games clone(){
        Games game = new Games();

        game.app_id = this.app_id;
        game.name = this.name;
        game.release_date = this.release_date;
        game.owners = this.owners;
        game.age = this.age;
        game.price = this.price;
        game.dlcs = this.dlcs;
        game.languages = this.languages;
        game.website = this.website;
        game.windows = this.windows;
        game.mac = this.mac;
        game.linux = this.linux;
        game.upvotes = this.upvotes;
        game.avg_pt = this.avg_pt;
        game.developers = this.developers;
        game.genres = this.genres;

        return game;
    }
    
    public void imprimir(){
        String mostrar = app_id + " " + name + " " + trataData(release_date) + " " + owners + " " + age + " " + trataPrice(price) + " " + dlcs + trataArr(languages) + " " + website + " " + windows + " " + mac + " " + linux + " " + trataUpVote(upvotes) + " " + trataPlayTime(avg_pt) + " " + developers + trataArr(genres);

        MyIO.println (mostrar);
    }

    // chamada de leitura e atribuição de valores
    public Games ler(String valores) throws ParseException{
        Games game =  new Games();
        Index index = new Index();

        game.app_id = lerInt(valores, index, 1);
        game.name = lerString1(valores, index, 2);
        game.release_date = lerDate(valores, index, 0);
        game.owners = lerString2(valores, index, 1);
        game.age = lerInt(valores, index, 1);
        game.price = lerFloat(valores, index, 1);
        game.dlcs = lerInt(valores, index, 3);
        game.languages = lerArray(valores, index, 1);
        game.website = lerString2(valores, index, 1);
        game.windows = lerBoolean(valores, index, 0);
        game.mac = lerBoolean(valores, index, 0);
        game.linux = lerBoolean(valores, index, 0);
        game.upvotes = lerPorcentagem(valores, index, 0);
        game.avg_pt = lerInt(valores, index, 1);
        game.developers = lerString2(valores, index, 1);
        game.genres = lerArrayString(valores, index, 0);

        return game;        
    }

    public Games encontraId(Games[] games, int quant, int id){
        Games game = new Games();

        for(int i = 0; i < quant; i++){
            if (id == games[i].app_id){
                game = games[i].clone();
                i = quant;
            }
        }

        return game;
    }

    // tratando alguns dados
    public String trataData(Date date){
        DateFormat dateFormat = new SimpleDateFormat("MMM/yyyy", Locale.US);
        String data = dateFormat.format(date);
            
        return data;
    }

    public String trataPrice(float preco){
        String precoTratado = "";

        if(price == 0.0f ){
            precoTratado = "0.00";

        }else{
            precoTratado += preco;
        }

        return precoTratado;
    }

    public String trataArr(String[] arr){
        String str = "";
        int leng = 0, i;

        for(String valor : arr){
            if(valor != null){
                leng++;
            }
        }

        str += " [";

        for (i = 0; i < (leng-1); i++){
            str += arr[i] + ", ";
        }
        
        str += arr[i] + "]";

        return str;
    }

    public String trataUpVote(float upvote){
        String up = "";

        int aux = (int)(upvote * 100);

        if (((upvote * 100) - aux ) > 0.5){
            aux++;
        }

        up = aux + "%";

        return up;
    }

    public String trataPlayTime(int tempo){

        String playtime = "";
        int h = 0, m = 0;

        while(tempo >= 60){
            tempo -= 60;
            h++;
        }

        m = tempo;

        if (h > 0 && m > 0){

            playtime += (h + "h " + m + "m");

        }else if(h > 0 && m < 0){ 

            playtime += (h + "h");

        }else if(h < 0 && m > 0){

            playtime += (m + "m");

        } else {

            playtime = null;
        }

        return playtime;
    }


    // leitura dos dados
    public int lerInt(String valores, Index index, int add)throws ParseException{
        String aux = "";
        int intLido, i = index.getIndex();
        char c = valores.charAt(i);

        while (c != ','){
            aux += c;
            i++;
            c = valores.charAt(i);
        }

        intLido = Integer.parseInt(aux);
        index.setIndex(i+add);

        return intLido;
    }

    public String lerString1(String valores, Index index, int add){
        String stringLida = "";
        int i = index.getIndex();
        char c = valores.charAt(i);

        if (c == '"'){
            i++;
            c = valores.charAt(i);
            while (c != '"'){
                stringLida += c;
                i++;
                c = valores.charAt(i);
            }
            i++;
        } else {
            while (c != ','){
                stringLida += c;
                i++;
                c = valores.charAt(i);
                if (c == ',' && valores.charAt(i+1) == ','){
                stringLida += c + valores.charAt(i+1);
                i++;
                }
            }
        }

        if (stringLida == ""){
            stringLida = null;
        }
        index.setIndex(i+add);

        return stringLida;
    }

    public String lerString2(String valores, Index index, int add){
        String stringLida = "";
        int i = index.getIndex();
        char c = valores.charAt(i);

        if (c == '"'){
            i++;
            c = valores.charAt(i);
            while (c != '"'){
                stringLida += c;
                i++;
                c = valores.charAt(i);
            }
            i++;
        } else {
            while (c != ','){
                stringLida += c;
                i++;
                c = valores.charAt(i);
            }
        }

        if (i == valores.length()-1){
            i-=2;
        }
            
        if (stringLida == ""){
            stringLida = null;
        }
        index.setIndex(i+add);

        return stringLida;
    }

    public Date lerDate(String valores, Index index, int add) throws ParseException{
        Date dateLida = null;
        String aux = "";
        int i = index.getIndex();

        if (valores.charAt(i+12) == '"'){
            aux = valores.substring(i,   i+3) + " " + 
                valores.substring(i+4, i+6) + " " + 
                valores.substring(i+8, i+12);
            SimpleDateFormat date = new SimpleDateFormat("MMM dd yyyy", Locale.US);
            dateLida = date.parse(aux);
            i+=14;
        } else if (valores.charAt(i+11) == '"') {
            aux = valores.substring(i,   i+3) + " " + 
                valores.substring(i+4, i+5) + " " +  
                valores.substring(i+7, i+11);
            SimpleDateFormat date = new SimpleDateFormat("MMM dd yyyy", Locale.US);
            dateLida = date.parse(aux);
            i+=13;
        } else {
            aux = valores.substring(i-1, i+2) + " " + 
                valores.substring(i+3, i+7);
            SimpleDateFormat date = new SimpleDateFormat("MMM yyyy", Locale.US);
            dateLida = date.parse(aux);
            i+=10;     
        }
        index.setIndex(i+add);

        return dateLida;
    }

    public float lerFloat(String valores, Index index, int add)throws ParseException{
        String aux = "";
        float floatLido;

        int i = index.getIndex();
        char c = valores.charAt(i);

        while (c != ','){
            aux += c;
            i++;
            c = valores.charAt(i);
        }
        floatLido = Float.parseFloat(aux);
        index.setIndex(i+add);

        return floatLido;
    }

    public String[] lerArray(String valores, Index index, int add){

        String[] arrayLido = new String[50];
        int i = index.getIndex(), k = 0;
        char c = valores.charAt(i);

        if (c == ','){
            while (c != 'T' && c != 'V'){
                i++;
                c = valores.charAt(i);
            }
            i-=2;
        } else if ((int)c != 39){
            c = valores.charAt(i);
            arrayLido[k] = "";
            while ((int)c != 39){
                arrayLido[k] += c;
                i++;
                c = valores.charAt(i);            
            }
            i+=2;
        } else {
            while (valores.charAt(i-1) != '"'){
                i++;
                c = valores.charAt(i);
                arrayLido[k] = "";
                while((int)c != 39){
                    arrayLido[k] += c;
                    i++;
                    c = valores.charAt(i);
                }
                i+=3; k++;
            }
        }
        index.setIndex(i+add);

        return arrayLido;
    }
   
    public String[] lerArrayString(String valores, Index index, int add){
        String[] arrayLido = new String[50];
        int i = index.getIndex(), k = 0; i++;
        char c = valores.charAt(i);
            
        if (i != valores.length()-1){
            if (valores.charAt(i-1) == '"'){
                while (c != '"'){
                c = valores.charAt(i);
                arrayLido[k] = "";
                while (c != ',' && c != '"'){
                    arrayLido[k] += c;
                    i++;
                    c = valores.charAt(i);
                }
                i++; k++;
                }
            } else {
                i--;
                int tamanho = valores.length();
                arrayLido[0] = "";
                while (i < tamanho){
                arrayLido[0] += valores.charAt(i);
                i++;
                }
            }
        }
        index.setIndex(i+add);
    
        return arrayLido;
    }

    public boolean lerBoolean(String valores, Index index, int add){
        boolean booleanLido;
        int i = index.getIndex();
        char c = valores.charAt(i);

        while (c == ','){
            i++;
            c = valores.charAt(i);
        }

        if (c == 'T'){
            booleanLido = true;
            i+=5;
        } else {
            booleanLido = false;
            i+=6;
        }
        index.setIndex(i+add);

        return booleanLido;
    }

    public float lerPorcentagem(String valores, Index index, int add)throws ParseException{
        String aux = "";
        float floatLido;
        int i = index.getIndex();
        char c = valores.charAt(i);

        while (c != ','){
            aux += c;
            i++;
            c = valores.charAt(i);
        }
        float positivos = Float.parseFloat(aux);
        i++; aux = "";

        c = valores.charAt(i);
        while (c != ','){
            aux += c;
            i++;
            c = valores.charAt(i);
        }
        float negativos = Float.parseFloat(aux);
        i++; aux = "";

        int porcento = (int)(10000*(positivos / (positivos+negativos)));
        floatLido = (1.0f*porcento)/10000;
        index.setIndex(i+add);

        return floatLido;
    }

}

class Index{

    private int index;

    Index(){ this.index = 0; }

    Index (int index){ this.index = index; }

    public int getIndex(){ return (this.index); }
  
    public void setIndex(int index){ this.index = index; }

}

class Q01{

    public static boolean isFim(String s){
        return !((s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' 
        && s.charAt(2) == 'M'));
    }

    public static void main(String args[]) throws Exception, ParseException {

        Games[] games = new Games[5000];

        Games aux = new Games();

        int[] id = new int[60];
        String valores = "", str = "";
        int i = 0, j = 0, k = 0;

        InputStreamReader isr = new InputStreamReader(new FileInputStream ("/tmp/games.csv"));
        BufferedReader entrada = new BufferedReader(isr);

        MyIO.setCharset("UTF-8");

        // le arquivo enquanto tem jogo
        while ((valores = entrada.readLine()) != null){
            games[i] = new Games();
            games[i] = games[i].ler(valores);
            i++;
        }
        entrada.close();

        // entrada do usuario
        str = MyIO.readLine();
        do{
            id[k] = Integer.parseInt(str);
            k++;
            str = MyIO.readLine();
        } while (isFim(str));

        for(j = 0; j < k; j++){
            aux = games[j].encontraId(games, i, id[j]);
            // saida
            aux.imprimir();
        }
    }
}
 