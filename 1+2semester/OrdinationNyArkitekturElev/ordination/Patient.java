package ordination;



public class Patient {
	private String cprnr;
	private String navn;
	private double vægt;

	// TODO: Link til Ordination
	
	public Patient(String cprnr, String navn, double vægt) {
		super();
		this.cprnr = cprnr;
		this.navn = navn;
		this.vægt = vægt;
	}
	public String getCprnr() {
		return cprnr;
	}
	public String getNavn() {
		return navn;
	}
	public void setNavn(String navn) {
		this.navn = navn;
	}
		public double getVægt(){
		return vægt;
	}
	public void setVægt(double vægt){
		this.vægt = vægt;
	}
		public String toString(){
		return navn + "  " + cprnr;
	}
 //TODO: Metoder (med specifikation) til at vedligeholde link til Ordination
	
}
