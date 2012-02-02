package model_comparable;
import java.util.ArrayList;

	//Done with help from Rita
public class Merge {
	
	public static ArrayList<Kunde> totalFletning(ArrayList<Kunde> data1, ArrayList<Kunde> data2){
		ArrayList<Kunde> result = new ArrayList<Kunde>();
		int i = 0, j = 0;
		
		while (i < data1.size() && j < data2.size()){
			Kunde k1 = data1.get(i);
			Kunde k2 = data2.get(j);
			
			if(k1.compareTo(k2) <= 0){
				result.add(k1);
				i++;
			}
			else{
				result.add(k2);
				j++;
			}
		}
		while(i < data1.size()){
			result.add(data1.get(i));
			i++;
		}
		while(j < data2.size()){
			result.add(data2.get(j));
			j++;
		}
		return result;
	}	
	
	public static int[] fællesTal(int[] l1, int[] l2){
		int i = 0, j = 0, check = 0;
		int[] result = new int[l1.length];
		
		while(i < l1.length && j < l2.length){
			
			if(l1[i] == l2[j]){
				result[check] = l1[i];
				check++;
				i++;
				j++;
			}
			else if(l1[i] > l2[j]){
				j++;
			}
			else
				i++;
		}
		return result;
	}
	
	public static ArrayList<Kunde> godeKunder(ArrayList<Kunde> l1, Kunde[] l2){
		ArrayList<Kunde> k1 = new ArrayList<Kunde>();
		int i = 0, j = 0;
		
		while(i < l1.size() && j < l2.length){
			if(l1.get(i).compareTo(l2[j]) == 0){
				i++;
				j++;
			}
			else if(l1.get(i).compareTo(l2[j]) < 0){
				k1.add(l1.get(i));
				i++;
			}
			else
				j++;
			
		}
		while(i < l1.size()){
			k1.add(l1.get(i));
			i++;
		}
		return k1;
	}
	
	public static void udskrivSortering(int[] data) {
		for (int i = 0; i < data.length; i++) {
				System.out.print(data[i] + " ");
		}
		System.out.println();
	}
}
