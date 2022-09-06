class Ex01{

    public static void main(String[] args) {
        
    }

}

class Game{

    private int app_id;
    private String name;
    private Data release_date;
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


    // construtores
    public Game(){

    }

    public Game(int app_id, String name, Data release_date, String owners, int age, float price, int dlcs, String[] languages, String website, boolean windows, boolean mac, boolean linux, float upvotes, int avg_pt, String developers, String[] genres) {

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

    // setters 
    public setApp_id(int app_id){
        this.app_id = app_id;
    }

    public setName(String name){
        this.name = name;
    }

    public setRelease_date(Data release_date){
        this.release_date = release_date;
    }

    public setOwners(String owners){
        this.owners = owners;
    }

    public setAge(int age){
        this.age = age;
    }

    public setPrice(float price){
        this.price = price;
    }

    public setDlcs(int dlcs){
        this.dlcs = dlcs;
    }

    public setLanguages(String[] languages){
        this.languages = languages;
    }

    public setWebsite(String website){
        this.website = website;
    }

    public setWindows(boolean windows){
        this.windows = windows;
    }

    public setMac(boolean mac){
        this.mac = mac;
    }

    public setLinux(boolean linux){
        this.linux = linux;
    }

    public setUpvotes(float upvotes){
        this.upvotes = upvotes;
    }

    public setAvg_pt(int avg_pt){
        this.avg_pt = avg_pt;
    }

    public setDevelopers(String developers){
        this.developers = developers;
    }

    public setGenres(String[] genres){
        this.genres = genres;
    }

    // getters
    public getApp_id(){
        return app_id;
    }

    public getName(){
        return name;
    }

    public getRelease_date(){
        return release_date;
    }

    public getOwners(){
        return owners;
    }

    public getAge(){
        return age;
    }

    public getPrice(){
        return price;
    }

    public getDlcs(){
        return dlcs;
    }

    public getLanguages(){
        return languages;
    }

    public getWebsite(){
        return website;
    }

    public getWindows(){
        return windows;
    }

    public getMac(){
        return mac;
    }

    public getLinux(){
        return linux;
    }

    public getUpvotes(){
        return upvotes;
    }

    public getAvg_pt(){
        return avg_pt;
    }

    public getDevelopers(){
        return developers;
    }

    public getGenres(){
        return genres;
    }
}