class ExemploArq01Escrita
{
  public static void main(String[] args)
  {
     //Abrir o arquivo texto
     Arq.openWrite("javaArq.txt");


     //Escrever no arquivo texto
     Arq.println(5);
     Arq.println(10.333);
     Arq.println('P');
     Arq.println(false);
     Arq.println("Arquivos");


     //Fechar o arquivo texto
     Arq.close();

  } // Fim main()
} // Fim class
