
package comparableOpg;


public class Kunde implements Comparable<Kunde> {
	private String efternavn;
	private String fornavn;
	private int alder;
	
	public Kunde(String efternavn, String fornavn, int alder) {
		super();
		this.efternavn = efternavn;
		this.fornavn = fornavn;
		this.alder = alder;
	}
	public int compareTo(Kunde kunde) {
		if (efternavn.equals(kunde.getEfternavn()))
			return fornavn.compareTo(kunde.getFornavn());
		else 
			return efternavn.compareTo(kunde.getEfternavn());
	}

	public int getAlder() {
		return alder;
	}

	public String getEfternavn() {
		return efternavn;
	}
	
	public String getFornavn() {
		return fornavn;
	}
	public String toString(){
		return efternavn + " " + fornavn + " " + alder;
	}
}
