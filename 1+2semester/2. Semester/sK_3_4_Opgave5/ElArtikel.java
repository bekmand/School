package sK_3_4_Opgave5;

public class ElArtikel extends Vare {

	private double moms;

	public ElArtikel(double nettoPris, String navn) {
		super(nettoPris, navn);
		this.moms = 1.30;
		this.nettoPris = nettoPris;
		this.navn = navn;
	}

	// der er 30% moms på ElArtikler dog minds 3 kr.
	public double getBruttoPris() {
		double bruttoPris = 0;
		if (nettoPris < 10) {
			bruttoPris = nettoPris + 3;
		} else {
			bruttoPris = nettoPris * moms;
		}
		return bruttoPris;
	}

}
