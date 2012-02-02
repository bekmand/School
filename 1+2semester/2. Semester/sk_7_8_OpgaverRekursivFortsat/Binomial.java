package sk_7_8_OpgaverRekursivFortsat;

public class Binomial {
	
	public int binomial(int m, int n){
		
		int result = 0;
		
		if(m == 0 && n == 0) result = 1;
		
		else if(0<=m && m<=n){
			result = binomial(m, n-1) + binomial(m-1, n-1);
		}
		return 1;
	}

}
