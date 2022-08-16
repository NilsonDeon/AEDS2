class gEx07{
    
    public static void main(String[] args) {
        int maior = 0, menor = 0, auxiliar = 0;

        for(int i = 0; i < 10; i++){
            if(i == 0){
                maior = MyIO.readInt();
                menor = MyIO.readInt();

            }else{
                auxiliar = MyIO.readInt();
                if(auxiliar > maior){
                    maior = auxiliar;
                }else if(auxiliar < menor){
                    menor = auxiliar;
                }
            }

        }
        
        MyIO.println(maior);
        MyIO.println(menor);
    }
    
}