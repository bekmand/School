package sK_3_4_Opgave5;

public class Vare {

	protected double nettoPris;
	private double moms;
	protected String navn;

	public Vare(double nettoPris, String navn) {
		this.nettoPris = nettoPris;
		this.moms = 1.25;
		this.navn = navn;
	}
	
	// Der er 25% moms på vare
	public double getBruttoPris() {
		return nettoPris * moms;
	}
	
	public String getNavn(){
		return this.navn;
	}
	
	public String toString(){
		return "Vare: " + this.navn + " - " + "Pris: " + getBruttoPris() + "\n"; 		
	}
}
