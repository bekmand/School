package model;

public class ArrayMetoder {
	
	
	
	public int sum(int[] t){
	
	int sum = 0;
	
	for(int i = 0; i < t.length; i++){
		sum += t[i];
	}
	return sum;
	}
	
	public double dSum(double[] tt){
		double sum1 = 0.0;
		
		for(int i = 0; i < tt.length; i++){
			sum1 += tt[i];
		}
	
		return sum1;
	}
	
	public int[] danSum(int[] a, int[] b){
		int l = 0;
		int[] c = new int [5];
		
		if(a.length <= b.length){
			l = a.length;
		}
		else l = b.length;
		
		for(int i = 0; i < l; i++){
			c[i] = a[i] + b[i]; 	
		}
		return c;
	}
	public boolean harUlige(int[] t){
		boolean ulige = false;
		for(int i = 0; i < t.length; i++){
			if(t[i] % 2 != 0){
				ulige = true;
			}
			else{
				ulige = false;
			}
		}
		return ulige;
	}
	
	
}
