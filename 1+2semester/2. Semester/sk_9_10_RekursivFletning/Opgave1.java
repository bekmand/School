package sk_9_10_RekursivFletning;

import java.util.ArrayList;
import java.util.List;

public class Opgave1 {

	private ArrayList<Integer> list = new ArrayList<Integer>();
	private static int sum = 0;
	
	public static int summereRekursiv(List<Integer> list){
		
		int e1 = list.size()/2;
		
		if(list.size() == 1){
			sum += list.get(0);
		}
		else if(list.size()>1){
			summereRekursiv(list.subList(0, e1));
			summereRekursiv(list.subList(e1, list.size()));
		}
		return sum;
	}
	
	public static int antalNullerRekursiv(List<Integer> list){
		int e1 = list.size()/2;
		
		if(list.size() == 1 && list.get(0) == 0){
			sum += 1;
		}
		else if(list.size()>1){
			antalNullerRekursiv(list.subList(0, e1));
			antalNullerRekursiv(list.subList(e1, list.size()));
		}
		return sum;
	}
	
	
	public static void main(String[] args) {
	
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		list.add(2);
		list.add(2);
		list.add(0);
		list.add(2);
		//Opgave 1
//		System.out.println(summereRekursiv(list));
		//Opgave 2
//		System.out.println(antalNullerRekursiv(list));
		//Opgave 3
		
	}

}
