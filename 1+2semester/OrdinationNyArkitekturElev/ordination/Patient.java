package ordination;



public class Patient {
	private String cprnr;
	private String navn;
	private double v�gt;

	// TODO: Link til Ordination
	
	public Patient(String cprnr, String navn, double v�gt) {
		super();
		this.cprnr = cprnr;
		this.navn = navn;
		this.v�gt = v�gt;
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
		public double getV�gt(){
		return v�gt;
	}
	public void setV�gt(double v�gt){
		this.v�gt = v�gt;
	}
		public String toString(){
		return navn + "  " + cprnr;
	}
 //TODO: Metoder (med specifikation) til at vedligeholde link til Ordination
	
}
