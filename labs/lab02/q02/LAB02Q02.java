import java.util.Scanner;

class LAB02Q02{


	public static void sequenciaEspelho(int numero1, int numero2){
		
		String sequencia = "", espelho = "";

		for(int i = numero1; i <= numero2; i++){

			sequencia += i;
		}

		for(int i = ( sequencia.length() - 1 ); i >= 0; i--){

			espelho += sequencia.charAt(i);
		}


		// saida
		System.out.println(sequencia + espelho);

	}

	public static void main(String[] args){
	
		int numero1, numero2;
		Scanner sc = new Scanner(System.in);

		while(sc.hasNext()){
			// entradas
			numero1 = sc.nextInt();
			numero2 = sc.nextInt();

			sequenciaEspelho(numero1, numero2);
		}

		sc.close(); //Encerra o programa

	}
}
