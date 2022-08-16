class trab_00b{

	// EX 01
	public static boolean sequentialSearch(int[] array, int x){

		int length = array.length;

		for(int i = 0; i < length; i++){

			if(x == array[i]){ return true; }
		}

		return false;
	}
	
	// EX 02
	public static boolean binarySearch(int[] array, int x){
		
		int length = array.length;
		int start = 0, end = (length-1);

		for(int i = 0; i < length; i++){

			int mid = (start+end)/2;
			int auxiliar = array[mid];
			
			if(x == auxiliar){
				return true;

			}else if(x > auxiliar){
				start = mid + 1;

			}else{
				end = mid - 1;
			}
		}

		return false;
	}

	// EX 03
	public static void higherLower(int[] array){

		int length = array.length;
		int higher = array[0], lower = array[0];

		for(int i = 1; i < length; i++){
			if(array[i] > higher){
				higher = array[i];

			}else if(array[i] < lower){
				lower = array[i];
			}
		}
		
		MyIO.println(higher + "\n" + lower);
	}

	//EX 04
	public static void higherLower2(int[] array){
		
		int length = array.length;
		int higher = array[0], lower = array[0];

		for(int i = 0; i < length; i++){
			int auxiliar = array[i];
			
			if(auxiliar > higher){
				higher = auxiliar;
			}else if(auxiliar < lower){
				lower = auxiliar;
			}
		}

		MyIO.println(higher + "\n" + lower);
		
	}
}
