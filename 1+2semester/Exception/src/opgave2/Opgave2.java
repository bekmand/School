package opgave2;

import java.util.*;

public class Opgave2 {

public static void init(ArrayList a) {
	a.add(23);
	a.add(40);
	a.add("Oops");
	a.add(8);
	a.add(14);
	a.add(33);
	a.add("Uha");
	a.add(55);
}

public static void ud(ArrayList<Integer> a) {
	for (int i=0; i<a.size(); i++) {
		try{
		int value=a.get(i);
		System.out.println(i+": "+value);
		}
		
		catch(ClassCastException e){
			System.out.println(i+": " + "Indeholder ikke et heltal");
		}
		
	}
}

public static void main(java.lang.String[] args) {
	ArrayList<Integer> a = new ArrayList<Integer>();

	init(a);

	ud(a);

	System.out.println("------------");
}

}
