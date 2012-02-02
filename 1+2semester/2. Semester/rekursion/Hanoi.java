/*
 * Created on 2005-03-03
 */
package rekursion;

/**
 * @author mad
 */
public class Hanoi {
	public static int counter;
	
	public static void counter(){
		counter += 1;
	}
	
	public static void flyt(int n, int fra, int til){
		if (n==1){
			System.out.println("Flyt fra " +fra +" til " + til);	
			counter();
		}
		else {
			flyt(n-1,fra,6-fra-til);
			System.out.println("Flyt fra " + fra +" til " + til);
			flyt(n-1,6-fra-til,til);
			counter();
		}
		
	}
	public static void main(String[] args) {
			flyt(25,1,3);
			System.out.println("Antal flyt: " + counter);
	}
}
