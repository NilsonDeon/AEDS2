class gEx02{

    public static void main(String[] args) {
        int maior = 0, auxiliar = 0;

        for(int i = 0; i < 10; i++){
            if(i == 0){
                maior = MyIO.readInt();

            }else{
                auxiliar = MyIO.readInt();
                if(auxiliar > maior){
                    maior = auxiliar;
                }
            }

        }
        MyIO.println(maior);
    }

}