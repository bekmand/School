package sK_5_6_Opgave1_2;

import java.util.HashSet;

public class AnvendMetoderPaaHashSet {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		HashSet<Integer> list = new HashSet<Integer>();
		
		list.add(34);
		list.add(12);
		list.add(23);
		list.add(45);
		list.add(67);
		list.add(34);
		list.add(98);
		
		System.out.println(list);
		
		list.add(23);
		
		System.out.println(list);
		
		list.remove(67);
		
		System.out.println(list);
		
		System.out.println(list.contains(23));
		
		System.out.println(list.size());
		
		
		

	}

}
