package adapter;

public abstract class Vare {
	private int pris;
	private String navn;
	
	public Vare(int pris, String navn){
		this.navn = navn;
		this.pris = pris;
	}
	
	public int getPris(){
		return pris;
	}
	
	public void setPris(int pris){
		this.pris = pris;
	}
	
	public String getNavn(){
		return navn;
	}
	
	public void setNavn(String navn){
		this.navn = navn;
	}
	
	public double beregnMoms(){
		return 0;
	}
}
