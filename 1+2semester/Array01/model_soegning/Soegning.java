package model_soegning;

public class Soegning {
	
	public boolean soeg(int[] tal){
		boolean found = false;
		int i = 0;
		
		while(!found && i < tal.length){
			if(tal[i] % 2 != 0){
				found = true;
			}
			else
				i++;
		}
		return found;
	}
	
	public int soeg1(int[] tal){
		boolean found = false;
		int i = 0;
		int resultat = -1;
		
		while(!found && i < tal.length){
			if(tal[i] > 9 && tal[i] < 16){
				resultat = tal[i];
				found = true;
			}
			else
				i++;
		}
		return resultat;
	}
	
	public boolean soeg2(int[] tal){
		boolean found = false;
		int i = 1;
		
		while(!found && i < tal.length){
			if(tal[i-1] == tal[i]){
				found = true;
			}
			else
				i++;
		}
		return found;
	}
	
	public boolean lineærSøgning1(int[] arr, int mål){
		boolean found = false;
		int left = 0;
		int right = arr.length-1;
		int mid = 0;
		
		while(!found && left <= right){
			if(arr[mid] == mål)
				found = true;
			else if(arr[mid] < mål)
				left = mid+1;
			else if(arr[mid] > mål)
				right = mid-1;
		}
		return found;
	}
}
