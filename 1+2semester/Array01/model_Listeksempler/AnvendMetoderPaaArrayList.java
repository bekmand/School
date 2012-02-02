package model_Listeksempler;

import java.util.ArrayList;

public class AnvendMetoderPaaArrayList {

	
	public static void main(String[] args) {
		ArrayList<Integer> talListe = new ArrayList<Integer>();
		
		talListe.add(5);
		talListe.add(3);
		talListe.add(11);
		talListe.add(9);
		
		MetoderPaaArrayList metoder = new MetoderPaaArrayList();
		/*metoder.udskrivHeltalsListe(talListe);
		System.out.println();
		System.out.println("Summen er " + metoder.sumListe(talListe));
		System.out.println();
		System.out.println("Indeks for maksimum " + metoder.indeksForMaksimum(talListe));
		*/
		
		metoder.ombyt(talListe);
		
	}

}
