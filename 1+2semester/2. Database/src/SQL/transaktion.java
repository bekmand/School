package SQL;

public class transaktion {
	private int regNr;
	private int ktoNr;
	private String dato;
	private String tekst;
	private double beloeb;
	
	
	public transaktion(int regNr, int ktoNr, String dato, String tekst, double beloeb){
		this.regNr = regNr;
		this.ktoNr = ktoNr;
		this.dato = dato;
		this.tekst = tekst;
		this.beloeb = beloeb;
	}

}
