package spiller;

public class Spiller {
	private String navn;
	private int hojde;
	private int vaegt;
	private int antalMaal;
		// Opretter et Spiller objekt med navn, højde, vægt og
    // antal mål
		public Spiller(String navn, int hoejde, int vaegt, int
                   antalmaal){
		this.hojde = hoejde;
		this.navn = navn;
		this.vaegt = vaegt;
		this.antalMaal = antalmaal;
	}

		
	public String toString(){
		return (this.getNavn() + " " + this.getHøjde() + " " + this.getVægt() + " " + this.getMaal());
	}
	// returnerer spillerens navn
	public String getNavn() {return navn;}
	 
	// returnerer spillerens højde i cm
	public int getHøjde() {return hojde;}
	
	// returnerer spillerens vægt i kg
	public int getVægt() {return vaegt;}
	  
	// returnerer antal mål spilleren har scoret i
  // indeværende sæson
	public int getMaal() {return antalMaal;}
}
