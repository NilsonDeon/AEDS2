class gEx09{
    
    public static void main(String[] args) {
        int n = MyIO.readInt();

        for(int i = 0; i < n; i++){
            if(i%2 != 0){
                MyIO.println(i);
            }
        }
    }
}