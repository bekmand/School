package model_comparable;
import java.util.ArrayList;

public class SoegPaaComparable {
	
	public static void bubbleSort (Comparable[] data){
		int position, scan;
		
		for(position = data.length -1; position >= 0; position--){
			for(scan = 0; scan <= position - 1; scan++){
				if(data[scan].compareTo(data[scan+1]) > 0)
					swap(data, scan, scan+1);
			}
		}
	}
	
	public static void selectionSortArray(Comparable[] data){
		int min;
		
		for(int index = 0; index < data.length-1; index++){
			min = index;
			for(int scan = index+1; scan < data.length; scan++)
				if(data[scan].compareTo(data[min]) < 0)
					min = scan;
				
			swap (data, min, index);	
			
		}
	}
	
	public static void selectionSortArrayList(ArrayList<Comparable> data){
		int min;
		
		for(int index = 0; index < data.size()-1; index++){
			min = index;
			for(int scan = index+1; scan < data.size(); scan++)
				if(data.get(scan).compareTo(data.get(min)) < 0)
					min = scan;
				
			swap2 (data, min, index);
		}
	}
	
	public static void insertionSort(Comparable[] data){
		for(int index = 1; index < data.length; index++){
			Comparable key = data[index];
			int position = index;
			
			while(position > 0 && data[position-1].compareTo(key) > 0){
				data[position] = data[position-1];
				position--;
			}
			
			data[position] = key;
		}
	}
	
	public static void insertionSortArrayList(ArrayList<Comparable> data){
		for(int index = 1; index < data.size(); index++){
			Comparable key = data.get(index);
			int position = index;
			
			while(position > 0 && data.get(position-1).compareTo(key) > 0){
				data.set(position, data.get(position-1));
				position--;
			}
			
			data.set(position, key);
		}
	}
	
	public static void swap(Comparable[] data, int index1, int index2){
		Comparable tmp = data[index1];
		data[index1] = data[index2];
		data[index2] = tmp;
	}
	
	public static void swap2(ArrayList <Comparable> data, int index1, int index2){
		Comparable tmp = data.get(index1);
		data.set(index1, data.get(index2));
		data.set(index2, tmp);
	}
	
	public void udskrivSortering(Comparable[] data) {
		for (int i = 0; i < data.length; i++) {
				System.out.print(data[i] + " ");
		}
		System.out.println();
	}
	
	public void udskrivSorteringArrayList(ArrayList<Comparable> data) {
		for (int i = 0; i < data.size(); i++) {
				System.out.print(data.get(i) + " ");
		}
		System.out.println();
	}
}
