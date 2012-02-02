package sK_7_8_OpgaverRekursiv;

public class Opgave3 {
	// Skriv en rekursiv metode der beregner a*b
	// hvor a g b er hele tal større end eller lig med nul
	// metoden skal anvende definitionen og må ikke benytte Javas indbyggede
	// gange operation
	// Antag derefter at din maskine kun kan fordoble og halvere hele tal samt
	// lægge dem sammen.

	// Termineringsregel 1 * b = b
	// Termineringsregel 0 * b = 0

	// Rekurrensregel n! = n*(n-))! (n>0)
	
	/**
	 * Opgave 3.1 product
	 */
	public static int product(int a, int b) {
		
		int result = 0;
		if(a == 1){
			result = b;
		}
		else if(a == 0){
			result = 0;
		}
		else if(a > 1){
			result = product(a-1, b) +b;
		}
		System.out.println("111111111");
		return result;
		
	}
	
	public static int productRus(int a, int b){
		int result = 0;
		if(a == 0){
			result = 0;
		}
		else if(a >= 1 && a % 2 != 0){
			result = productRus(a-1, b) +b;
		}
		// et tal modulus 2 == 0  er lige, et tal modulus 2 != 0 er ulige
		else if(a > 1 && a % 2 == 0){
			result = productRus(a / 2, 2 * b);
		}
		System.out.println("22222222");
		return result;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println(product(19, 3));

		System.out.println(productRus(19, 3));

	}
}
