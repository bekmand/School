package fletteSorteringHul;

import java.util.*;

public class FletteSorteringHul {
	// den liste der skal sorteres skal være global for de rekursive kald
	private List<Integer> list;

	// den metode der sætter fletningen i gang
	public void fletteSort(List<Integer> list) {
		this.list = list;
		mergesort(0, list.size() - 1);
	}

	// den rekursive metode der implementere del-løs og kombiner skabelonen
	private void mergesort(int l, int h) {
		if (l < h) {
			int m = (l + h) / 2;
			mergesort(l, m);
			mergesort(m + 1, h);
			merge(l, m, h);
		}
	}

	// kombiner er realiseret ved fletteskabelonen
	private void merge(int low, int middle, int high) {
		List<Integer> temp = new ArrayList<Integer>();
		
		temp.add(list.get(low));
		temp.add(list.get(middle));
		temp.add(list.get(high));
		
		System.out.println(temp);
		
		
//		int i = low;
//		int m = middle;
//
//		while (i < middle || m < high) {
//
//			if (list.get(i) < list.get(m)) {
//				temp.add(list.get(low));
//				i++;
//			}
//			if (list.get(i) > list.get(m)) {
//				temp.add(list.get(middle + 1));
//				m++;
//			}
//			if (i > middle) {
//				temp.add(m);
//				m++;
//			}
//			if (m > high) {
//				temp.add(i);
//				i++;
//			}
//		}
//		System.out.println(temp);
//		list.addAll(temp);
	}

}
