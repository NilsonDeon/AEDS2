import java.io.RandomAccessFile;

class ex09{

    public static int criaArquivo(int quantidadeNum) throws Exception{

        // abrindo em modo leitura e escrita
        RandomAccessFile arquivo = new RandomAccessFile("arquivo.txt", "rw");

        for (int i = 0; i < quantidadeNum; i++) {
            
            double valor = MyIO.readDouble();  

            arquivo.writeDouble(valor); 
        }

        int ponteiro = (int) arquivo.getFilePointer(); 

        arquivo.close();

        return ponteiro;
    }

    public static void leArquivo(int ponteiro) throws Exception{

        // abrindo em modo leitura
        RandomAccessFile arquivo = new RandomAccessFile("arquivo.txt", "r"); 
 
        // lendo dubles | duble == 8 bytes
        for (int i = 8; i <= ponteiro; i += 8) { 
            arquivo.seek(ponteiro - i); 
        
            double auxiliar = arquivo.readDouble();

            if (auxiliar % 1 == 0) {
                MyIO.println((int) auxiliar); 

            } else{
                MyIO.println(auxiliar);
            }
                
        }

        arquivo.close();
    }

    public static void main(String[] args) throws Exception{

        int quantidadeNum = MyIO.readInt();

        int ponteiro = criaArquivo(quantidadeNum);

        leArquivo(ponteiro);
        
    }

}