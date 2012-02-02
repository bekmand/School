package sK_7_8_OpgaverRekursiv;

public class Opgave5 {
	// Skriv en rekursiv metode der implementerer i Euclids algoritme der finder
	// st�rste f�lles division af de to positive heltal. Den st�rste f�lles
	// division af to tal er det st�rste heltal der g�r op i begge tal. Euclids
	// algoritme St�rste F�lles Divisor sfd(a,b) er defineret ved

//	Termineringsregel b hvis b <=a og b g�r op i a
//	Rekurrensregel sfd(b,a) hvis a < b
//				   sfd(b, a%b) 	ellers
	
	public static int storsteDivisor(int a, int b){
		int result = 0;
		if(b <= a && a%b == 0){
			result = b;
		}
		else if(a < b){
			result = storsteDivisor(b, a);
		}
		else{
			result = storsteDivisor(b, a%b);
		}
		return result;
	}
	
	public static void main(String[] args) {

		System.out.println(storsteDivisor(10,20));

	}
}
