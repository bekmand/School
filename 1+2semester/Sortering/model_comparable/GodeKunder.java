package model_comparable;

import java.util.ArrayList;
import java.util.Collections;

public class GodeKunder {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Kunde k1 = new Kunde("Anne", "Jupiter", 24);
		Kunde k2 = new Kunde("Casper", "Bekmand", 20);
		Kunde k3 = new Kunde("Charles", "Guppy", 32);
		Kunde k4 = new Kunde("Jan", "Jensen", 42);
		Kunde k5 = new Kunde("Jannik", "Jensen", 12);
		Kunde k6 = new Kunde("Hrebub", "Habub", 12);
		Kunde k7 = new Kunde("Kurt", "Nielsen", 12);
		Kunde k8 = new Kunde("Nick", "Bøvlsen", 12);
		Kunde k9 = new Kunde("Dublin", "Charlse", 12);
		
		ArrayList<Kunde> list1 = new ArrayList<Kunde>();
				
		list1.add(k1);
		list1.add(k2);
		list1.add(k3);
		list1.add(k4);
		list1.add(k5);
		list1.add(k6);
		list1.add(k7);
		list1.add(k8);
		list1.add(k9);
				
		Collections.sort(list1);
		
		Kunde[] kunder = {k2,k9,k6};
		
		System.out.println(Merge.godeKunder(list1, kunder));

	}

}
