package fletteSorteringHul;

import java.util.ArrayList;
import java.util.List;

public class TestFlettesortering {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		
		list.add(45);
		list.add(12);
		list.add(56);
		list.add(37);
		list.add(48);
		list.add(12);
		list.add(34);
		list.add(4);
		list.add(56);
		System.out.println(list);
		
		FletteSorteringHul sort = new FletteSorteringHul();
		sort.fletteSort(list);
		System.out.println();
		System.out.println(list);
	}

}
