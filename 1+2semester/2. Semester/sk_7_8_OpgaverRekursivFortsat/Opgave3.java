package sk_7_8_OpgaverRekursivFortsat;

public class Opgave3 {
	public int hanoi(int n){
		int result = 0;
		int var = 2;
		
		while(n > 3 && var <= n){
			result += var*2 + 1;
		}
		
		return result;
	}
}
