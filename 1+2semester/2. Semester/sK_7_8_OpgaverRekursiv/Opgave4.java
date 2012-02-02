package sK_7_8_OpgaverRekursiv;

public class Opgave4 {
	// Skriv en rekursiv metode der returnerer s med
	// karakterene i omvendt rækkefølge. For eksempel skal kaldet
	// reverse RANSLIRPA = APRILSNAR
	//
	// Beskriv først den rekursive definition for at vende en String.
	// Programmer dernæst den rekursive metode.

	public static String reverse(String s) {
		String ord = "";
		if (s.length() == 1) {
			ord += s;
		} else{
			ord = s.substring(s.length() - 1, s.length())
					+ reverse(s.substring(0, s.length() - 1));
		}
		return ord;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println(reverse("REMMEBOV"));

	}
}
