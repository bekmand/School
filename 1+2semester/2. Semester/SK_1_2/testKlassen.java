package SK_1_2;

import java.util.ArrayList;

public class testKlassen {

	public static void main(String[] args) {
		ArrayList<Ansat> list = new ArrayList<Ansat>();
		Mekaniker m1 = new Mekaniker("Lars", "Mekanikervej 2", 1932, 5);
		Mekaniker m2 = new Mekaniker("Lars", "Mekanikervej 2", 1932, 5);
		Mekaniker m3 = new Mekaniker("Lars", "Mekanikervej 2", 1932, 5);
		Mekaniker m4 = new Mekaniker("Lars", "Mekanikervej 2", 1932, 5);
		V�rkf�rer v1 = new V�rkf�rer("Jens", "V�rkf�rervej 2", 1934, 5, 1936, 5.0);
		Synsmand s1 = new Synsmand("Hans", "Synsmandvej 2", 1956, 1958, 5);
		ArbejdsDreng a1 = new ArbejdsDreng("Bille", "Billevej 2", 10);
		
		list.add(m1);
		list.add(m2);
		list.add(m3);
		list.add(m4);
		list.add(v1);
		list.add(s1);
		list.add(a1);

		System.out.println(list);
		System.out.println(samletL�n(list));

	}

	/**
	 * Beregner summen af ugel��nnen for alle mekanikere i listen Krav: list's
	 * elementer er af typen Mekaninker
	 */
	public static double samletL�n(ArrayList<Ansat> list) {
		double samletL�n = 0;
		for (Ansat a : list) {
			samletL�n += a.beregnL�n(1);
		}
		return samletL�n;
	}
}
