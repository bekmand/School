package Singleton;

public class person {
	private String navn;
	
	public person(String navn){
		this.setNavn(navn);
	}

	public String getNavn() {
		return navn;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}
	
	public String toString(){
		return navn;
	}
}
