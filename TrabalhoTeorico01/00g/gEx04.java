class gEx04{
    public static void main(String[] args) {
        int time1 = MyIO.readInt();
        int time2 = MyIO.readInt();

        if(time1 > time2){
            MyIO.println("Vitoria do time 1!");
        }else if(time2 > time1){
            MyIO.println("Vitoria do time 2!");
        }else{
            MyIO.println("Empate!");
        }

    }

}