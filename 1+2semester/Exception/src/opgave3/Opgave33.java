package opgave3;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Opgave33 {

	public static int udskrivVærdi(int i, ArrayList<Integer> 
                                                              a){
		int tal = 0;
		tal = a.get(i);
		return tal;
	}
	
	public static void main(String[] args) {
		ArrayList a = new ArrayList();
		a.add(23);
		a.add(40);
		a.add("Oops");
		a.add(8);
		a.add(14);
		a.add(33);
		a.add("Uha");
		a.add(55);

		Scanner scan = new Scanner(System.in);
		System.out.print
			("Hvilket nr. tal skal vises?: ");
		try{
		int n = scan.nextInt();
		System.out.println("Tal nr. " + n + " er " 
				+ udskrivVærdi(n,a) + "\n");
		}
		catch(InputMismatchException e){
			System.out.println("Vælg et heltal");
		}
		catch(IndexOutOfBoundsException e){
			System.out.println("Du røg ud af array'et længde");
		}
		catch(ClassCastException e){
		}
		System.out.println("Udskrift færdig");

	}
}

