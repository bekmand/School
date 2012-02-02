package model_comparable;

import java.util.ArrayList;
import java.util.Collections;

public class MainSoeg {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
			//Kunderne
		Kunde k3 = new Kunde("Jan", "Jensen", 42);
		Kunde k1 = new Kunde("Anne", "Jupiter", 24);
		Kunde k4 = new Kunde("Ole", "Hansen", 12);
		Kunde k2 = new Kunde("Casper", "Bekmand", 20);
		Kunde k5 = new Kunde("Charles", "Guppy", 32);

		ArrayList<Kunde> list = new ArrayList<Kunde>(); // Danner ArrayList
		list.add(k1);
		list.add(k2);
		list.add(k3);
		list.add(k4);
		list.add(k5);
		System.out.println(list);
		Collections.sort(list); // Kald til sort
		System.out.println(list);
		
		SoegPaaComparable spc = new SoegPaaComparable();

		Kunde[] kunder = {k1,k2,k3,k4,null,null,null};
		
		
		
		Insertion.inserKundeArray(kunder, k5);
		
		spc.udskrivSortering(kunder);
		
		

		
//		ArrayList<Comparable> s1 = new ArrayList<Comparable>();
//
//		s1.add("Erna");
//		s1.add("Elly");
//		s1.add("Laurits");
//		s1.add("Bertha");
//		s1.add("Christian");
//		s1.add("August");
//		s1.add("Marius");
//		s1.add("John");
//		s1.add("Tove");
//		s1.add("Poul");
//		s1.add("Flemming");
//
//		String[] s = { "Erna", "Elly", "Laurits", "Bertha", "Christian",
//				"August", "Marius", "John", "Tove", "Poul", "Flemming" };
//		int[] ints = { 45, 23, 66, 30, 88, 27, 2, 34, 48 };
//		
//		
//
//		long tid1 = System.nanoTime();
//		spc.bubbleSort(s);
//		long tid2 = System.nanoTime();
//		System.out.println(tid2 - tid1);
//
//		long tid3 = System.nanoTime();
//		spc.selectionSortArray(s);
//		long tid4 = System.nanoTime();
//		System.out.println(tid4 - tid3);
//
//		// spc.selectionSortArrayList(s1);
//
//		long tid5 = System.nanoTime();
//		spc.insertionSort(s);
//		long tid6 = System.nanoTime();
//		System.out.println(tid6 - tid5);

		// spc.insertionSortArrayList(s1);

		// Udskrivnings Metoder

		// spc.udskrivSortering(s);
		// spc.udskrivSorteringArrayList(s1);
	}

}
