package gui;

import java.util.GregorianCalendar;

public class Validering {
	static String[] makeKlokkeSlæt(Object[] model) {
		String[] resultat = new String[model.length];
		try {
			for (int i = 0; i < model.length; i++) {
				resultat[i] = ((String) model[i]).substring(0, 6);
			}
		} catch (RuntimeException e) {
			throw new RuntimeException("Klokkeslet er ikke korrekt");
		}
		return resultat;
	}

	static double[] makeAntal(Object[] model) {
		double[] resultat = new double[model.length];
		try {
			for (int i = 0; i < model.length; i++) {
				resultat[i] = Double.parseDouble(((String) model[i])
						.substring(6));
			}
		} catch (RuntimeException e) {
			throw new RuntimeException("Der er ikke givet korrekt antal");
		}
		return resultat;
	}

	static GregorianCalendar makeDate(String s) {

		GregorianCalendar g = null;
		try {
			if (s.length() != 10) {
				throw new RuntimeException();
			}
			int d = Integer.parseInt(s.substring(0, 2));
			int m = Integer.parseInt(s.substring(3, 5));
			int y = Integer.parseInt(s.substring(6, 10));
			g = new GregorianCalendar(y, m - 1, d);
		} catch (RuntimeException e) {
			throw new RuntimeException("Datoen er ikke korrekt format");
		}
		return g;

	}
}
