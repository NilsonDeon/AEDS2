class gEx01{

    public static void main(String[] args) {
        
        int numero1 = MyIO.readInt();
        int numero2 = MyIO.readInt();
        int numero3 = MyIO.readInt();
        
        if(numero1 > numero2 && numero1 > numero3){

            MyIO.print(numero1);

            if(numero2 < numero3){
                MyIO.print(" " + numero2 + "\n");

            }else{
                MyIO.print(" " + numero3 + "\n");
            }
        } else if(numero2 > numero1 && numero2 > numero3){

            MyIO.print(numero2);

            if(numero1 < numero3){
                MyIO.print(" " + numero1 + "\n");

            }else{
                MyIO.print(" " + numero3 + "\n");
            }
        } else{
            MyIO.print(numero3);

            if(numero1 < numero2){
                MyIO.print(" " + numero1 + "\n");

            }else{
                MyIO.print(" " + numero2 + "\n");
            }
        }

    }

}