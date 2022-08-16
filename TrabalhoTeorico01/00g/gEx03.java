class gEx03{
    public static void main(String[] args) {
        int numero1 = MyIO.readInt();
        int numero2 = MyIO.readInt();
        int resposta = 0;

        if(numero1 > 45 || numero2 > 45){
            resposta = numero1 + numero2;
            MyIO.println(resposta);

        }else if(numero1 > 20 && numero2 > 20){
            if(numero1 > numero2){
                resposta = numero1 - numero2;
                MyIO.println(resposta);

            }else{
                resposta = numero2 - numero1;
                MyIO.println(resposta);

            }
        }else if( (numero1 > 10 && numero2 != 0) || (numero2 > 10 && numero1 != 0 )){
            resposta = numero1/numero2;
            MyIO.println(resposta);

        }else{
            MyIO.println("Nilson");
        }
    }
}