package sk_9_10_DesignHeadsFirst;

public class Konto{
	private Kunde kunde;
	private RenteInterface renteinterface; 
	
	public Konto(Kunde kunde){
		this.kunde = kunde;
	}
	
	public int beregnRente(){
		return renteinterface.beregnRente();
	}
	
	public void setRente(RenteInterface renteinterface){
		this.renteinterface = renteinterface;
	}
	

}
