package sK_7_8_OpgaverRekursiv;

public class Opgave1 {

	// Skriv en rekursiv metode der beregner n!, n >= 0.
	// Termineringsregel 0! = 1
	// Rekurrensregel n! = n*(n-))! (n>0)
	
	public static int factorial(int n) {
		int result;
		if(n == 0){
			result = 1;
		}
		else{
			result = n * factorial (n-1);		
		}
		return result;
}

		/**
		 * @param args
		 */
		public static void main(String[] args) {
		
			System.out.println(factorial(0));
			
		}
}
		
		
		
