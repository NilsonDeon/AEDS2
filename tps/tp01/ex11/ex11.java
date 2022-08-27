class ex11{

	public static boolean isPalindromoRecursivo(String palavra){
		// chamada da funcao com indice
		return isPalindromoRecursivo(palavra, 0);
	}


	public static boolean isPalindromoRecursivo(String palavra, int i){
	
		boolean resposta = false;
		int length = palavra.length() ;

		// letra do meio == caso base
		if(length/2 == i){
			resposta = true;

		}else if(palavra.charAt(i) == palavra.charAt( length - i - 1)){
			resposta = isPalindromoRecursivo(palavra, i+1);
		}

		return resposta;
	}

	public static boolean isFim(String palavra){
		
		return (palavra.length() == 3 && palavra.charAt(0) == 'F' && palavra.charAt(1) == 'I' && palavra.charAt(2) == 'M');

	}

	public static void main(String[] args){
		
		String palavra = " ";
		
		while(true){

			// entrada padrao
			palavra = MyIO.readLine();

			if(isFim(palavra)){
				break;
			}

			// saida
			if(isPalindromoRecursivo(palavra)){
				MyIO.println("SIM");

			}else{
				MyIO.println("NAO");
			}

		}
	}
}
