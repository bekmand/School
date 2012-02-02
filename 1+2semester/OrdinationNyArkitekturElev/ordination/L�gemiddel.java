package ordination;

public class L�gemiddel {
	private String navn;
	private double enhedPrKgPrD�gnLet;   // faktor der anvendes hvis patient vejer < 25 kg
	private double enhedPrKgPrD�gnNormal;// faktor der anvendes hvis 25 kg <= patient v�gt <= 120 kg
	private double enhedPrKgPrD�gnTung;  // faktor der anvendes hvis patient v�gt > 120 kg 
	private String enhed;
	
	/**
	 * Opretter et l�gemiddel.
	 * Krav: navn er ikke tom, enhedPrKgPrD�gnLet >= 0, enhedPrKgPrD�gnNormal >=0, 
	 *           enhedPrKgPrD�gnTung >=0, enhed er ["stk", "pust", "mL", "dr�ber"].
	 */
	
	public L�gemiddel(String navn, double enhedPrKgPrD�gnLet, double enhedPrKgPrD�gnNormal , double enhedPrKgPrD�gnTung, String enhed) {
		super();
		this.navn = navn;
		this.enhedPrKgPrD�gnLet = enhedPrKgPrD�gnLet;
		this.enhedPrKgPrD�gnNormal = enhedPrKgPrD�gnNormal;
		this.enhedPrKgPrD�gnTung = enhedPrKgPrD�gnTung;
		this.enhed = enhed;
	}

	public String getEnhed() {
		return enhed;
	}

	public String getNavn() {
		return navn;
	}

	public double getEnhePrKgPrD�gnLet() {
		return enhedPrKgPrD�gnLet;
	}
	public double getEnhePrKgPrD�gnNormal() {
		return enhedPrKgPrD�gnNormal;
	}
	public double getEnhePrKgPrD�gnTung() {
		return enhedPrKgPrD�gnTung;
	}
	public String toString(){
		return navn;
	}
}
