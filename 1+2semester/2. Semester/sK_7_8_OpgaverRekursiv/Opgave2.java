package sK_7_8_OpgaverRekursiv;

public class Opgave2 {

	// Skriv en rekursiv metode der beregner nP (p >=0)
	// Terminerings regel: n0 = 1
	// Rekurrensregel: nP = nP-1*n, p > 0

	/**
	 * opgave 2.1
	 */

	public static int power(int n, int p) {

		int result = 0;
		if (p == 0) {
			result = 1;
		} else if (p >= 0) {
			result = power(n, p - 1) * n;
		}
		return result;
	}

	/**
	 * Opgave 2.2
	 */
	// Skriv en anden rekursiv metode
	public static int power2(int n, int p){
		int result = 0;
		
		if(p == 0) {
			result = 1;
		}
		else if (p == 2){
			result = n*n;
		}
		else if (p > 0 && p %2 != 0){
			result = power2(n, p-1) *n;
		}
//		man kunne erstatte power2(n, 2) med n*n og fjerne else if p==2
		else if (p > 0 && p %2 == 0){
			result = power2(power2(n , 2), p/2);
		}
		return result;
	}
	
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {

//		System.out.println(power(5, 8));
		System.out.println(power2(2,5));

	}
}
