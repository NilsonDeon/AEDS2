class gEx05{

    public static void main(String[] args) {
        double salario = MyIO.readDouble();
        double prestacao = MyIO.readDouble();
        double valMax = salario * 0.4;

        if(prestacao <= valMax){
            MyIO.println("Aprovado!");
            
        }else{
            MyIO.println("Reprovado!");
        }
    }
}