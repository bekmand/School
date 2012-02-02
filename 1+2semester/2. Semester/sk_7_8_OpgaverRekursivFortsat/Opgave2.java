package sk_7_8_OpgaverRekursivFortsat;

import java.util.ArrayList;

public class Opgave2 {

	// Opgave 2.2

	public int tal(int n) {
		int result = 0;

		if (n == 0)
			result = 2;
		else if (n == 1)
			result = 1;
		else if (n == 2)
			result = 5;

		else if (n > 2 && n % 2 == 0) {
			result = 2 * tal(n - 3) - tal(n - 1);
		} else if (n > 2 && n % 2 != 0) {
			result = tal(n - 1) + tal(n - 2) + 3 * tal(n - 3);
		}
		return result;
	}

	// Opgave 2.3
	public int talN(int n) {
		int result = 0;
		ArrayList<Integer> tal = new ArrayList<Integer>();
		tal.add(2);
		tal.add(1);
		tal.add(5);
		while (n > 0) {
			if (n > 2 && n % 2 != 0) {
				tal.add(tal.get(n-1) + tal.get(n-2) + (3*(tal.get(n-3))));
			} else if (n > 2 && n % 2 == 0) {
				tal.add(2*(tal.get(n-3)) - tal.get(n-1));
			}

		}
		return result;
	}
}
