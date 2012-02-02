package ordination;

public class Lægemiddel {
	private String navn;
	private double enhedPrKgPrDøgnLet;   // faktor der anvendes hvis patient vejer < 25 kg
	private double enhedPrKgPrDøgnNormal;// faktor der anvendes hvis 25 kg <= patient vægt <= 120 kg
	private double enhedPrKgPrDøgnTung;  // faktor der anvendes hvis patient vægt > 120 kg 
	private String enhed;
	
	/**
	 * Opretter et lægemiddel.
	 * Krav: navn er ikke tom, enhedPrKgPrDøgnLet >= 0, enhedPrKgPrDøgnNormal >=0, 
	 *           enhedPrKgPrDøgnTung >=0, enhed er ["stk", "pust", "mL", "dråber"].
	 */
	
	public Lægemiddel(String navn, double enhedPrKgPrDøgnLet, double enhedPrKgPrDøgnNormal , double enhedPrKgPrDøgnTung, String enhed) {
		super();
		this.navn = navn;
		this.enhedPrKgPrDøgnLet = enhedPrKgPrDøgnLet;
		this.enhedPrKgPrDøgnNormal = enhedPrKgPrDøgnNormal;
		this.enhedPrKgPrDøgnTung = enhedPrKgPrDøgnTung;
		this.enhed = enhed;
	}

	public String getEnhed() {
		return enhed;
	}

	public String getNavn() {
		return navn;
	}

	public double getEnhePrKgPrDøgnLet() {
		return enhedPrKgPrDøgnLet;
	}
	public double getEnhePrKgPrDøgnNormal() {
		return enhedPrKgPrDøgnNormal;
	}
	public double getEnhePrKgPrDøgnTung() {
		return enhedPrKgPrDøgnTung;
	}
	public String toString(){
		return navn;
	}
}
