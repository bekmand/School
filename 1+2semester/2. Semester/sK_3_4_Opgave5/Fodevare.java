package sK_3_4_Opgave5;

public class Fodevare extends Vare {

	private double moms;

	public Fodevare(double nettoPris, String navn) {
		super(nettoPris, navn);
		this.navn = navn;
		this.nettoPris = nettoPris;
		this.moms = 1.05;

	}

	public String getNavn() {
		return this.navn;
	}

	// Der er 5% moms på fødevare
	public double getBruttoPris() {
		return nettoPris * moms;
	}

}
