package Svommer2.copy;

import java.util.ArrayList;

/**
 * Modellerer en sv�mmer
 */
public class Svømmer {
	private String navn;
	private String klub;
	private int årgang;
	private ArrayList<Double> tider;

	/**
	 * Initialiserer en ny svømmer med navn, årgang, klub og tider. Krav: årgang
	 * > 1900.
	 */
	public Svømmer(String navn, int årgang, ArrayList<Double> tider, String klub) {
		super();
		this.navn = navn;
		this.årgang = årgang;
		this.tider = tider;
		this.klub = klub;
	}

	/**
	 * Returnerer sv�mmerens navn.
	 */
	public String getNavn() {
		return navn;
	}

	/**
	 * Returnerer sv�mmerens �rgang.
	 */
	public int getÅrgang() {
		return årgang;
	}

	/**
	 * Returnerer sv�mmerens klub.
	 */
	public String getKlub() {
		return klub;
	}

	/**
	 * Registrerer sv�mmerens klub
	 * 
	 * @param klub
	 */
	public void setKlub(String klub) {
		this.klub = klub;
	}

	/**
	 * Returnerer den hurtigste tid sv�mmeren har opn�et
	 */
	public double bedsteTid() {
		double bedst = tider.get(0);
		for (int i = 1; i < tider.size(); i++) {
			if (tider.get(i) < bedst)
				bedst = tider.get(i);
		}
		return bedst;
	}

	/**
	 * Returnerer gennemsnittet af de tider sv�mmeren har opn�et
	 */
	public double gennemsnitAfTid() {
		if (tider.size() > 0) {
			double sum = 0;
			for (int i = 0; i < tider.size(); i++) {
				sum = sum + tider.get(i);
			}
			return sum / tider.size();
		} else
			return -1;

	}

	/**
	 * Returnerer gennemsnittet af de tider sv�mmeren har opn�et idet den
	 * langsomste tid ikke er medregnet
	 */
	public double snitUdenDårligste() {
		
		if (tider.size() > 1) {
			double langsom = tider.get(0);
			double sum = 0;
			for (int i = 0; i < tider.size(); i++) {
				sum = sum + tider.get(i);
				if (langsom < tider.get(i))
					langsom = tider.get(i);
			}
			return (sum-langsom) / (tider.size()-1);
		} else
			return -1;
	}
}
