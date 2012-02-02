package opgave3;

import java.util.ArrayList;
import java.util.Scanner;

public class Opgave34 {

	public static int udskrivVærdi(int i, ArrayList<Integer> 
                                                              a){
		int tal = 0;
		try{
		tal = a.get(i);
		}
		catch(ClassCastException e){
			throw new RuntimeException("Torks");
		}
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
		int n = scan.nextInt();
		try{
		System.out.println("Tal nr. " + n + " er " 
				+ udskrivVærdi(n,a) + "\n");
		}
		catch(RuntimeException e){
			System.out.println(e.getMessage());
		}
		System.out.println("Udskrift færdig");

	}
}

