package opgave4;

import java.util.ArrayList;
import java.util.Scanner;

public class Opgave10_1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int max = 10;
		int resultat = 0;
		ArrayList<Integer> list = new ArrayList<Integer>();

		for (int i = 0; i < max; i++) {
			Scanner scan = new Scanner(System.in);
			System.out.print("Indtast et nummer: ");
			String n = scan.nextLine();
			try {
				list.add(Integer.parseInt(n));
			} catch (NumberFormatException e) {
				Scanner scan1 = new Scanner(System.in);
				System.out.println("Indtast et nyt nummer: ");
				String n1 = scan1.nextLine();
				list.add(Integer.parseInt(n1));
			}
		}
		for (int j = 0; j < list.size(); j++) {
			resultat += (int) list.get(j);
		}
		System.out.println(resultat/list.size());
	}
}
