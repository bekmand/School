package sK_3_4_Opgave5;

public class Spiritus extends Vare {

	private double moms;

	public Spiritus(double nettoPris, String navn) {
		super(nettoPris, navn);
		this.nettoPris = nettoPris;
		this.navn = navn;

	}

	// Der er 80% moms på spiritus, dog 120% moms hvis nettoprisen er over 150
	// kr.
	public double getBruttoPris() {

		double bruttoPris = 0;
		if (nettoPris > 150) {
			bruttoPris = nettoPris * 2.2;
		} else {
			bruttoPris = nettoPris * 1.8;
		}
		return bruttoPris;
	}

}
