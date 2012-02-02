package model_comparable;
import java.util.ArrayList;
import java.util.Collections;

public class TotalFletning {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
			//Kunderne
		Kunde k1 = new Kunde("Anne", "Jupiter", 24);
		Kunde k2 = new Kunde("Casper", "Bekmand", 20);
		Kunde k3 = new Kunde("Charles", "Guppy", 32);
		Kunde k4 = new Kunde("Jan", "Jensen", 42);
		Kunde k5 = new Kunde("Jannik", "Jensen", 12);
		Kunde k6 = new Kunde("Hrebub", "Habub", 12);
		Kunde k7 = new Kunde("Kurt", "Nielsen", 12);
		Kunde k8 = new Kunde("Nick", "Bøvlsen", 12);
		Kunde k9 = new Kunde("Dublin", "Charlse", 12);
		
		ArrayList<Kunde> l1 = new ArrayList();
		ArrayList<Kunde> l2 = new ArrayList();
		
		
		l1.add(k1);
		l1.add(k2);
		l1.add(k3);
		l1.add(k5);
		l1.add(k7);
		
		l2.add(k3);
		l2.add(k4);
		l2.add(k5);
		l2.add(k1);
		
		Collections.sort(l2);
		Collections.sort(l1);
		
		int[] list1 = {2,4,6,8,10,12,14};
		int[] list2 = {1,2,4,5,6,9,12,17};
		
		Merge.udskrivSortering(Merge.fællesTal(list1, list2));

	}

}
