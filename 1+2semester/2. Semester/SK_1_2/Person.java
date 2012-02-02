package SK_1_2;

public class Person {

	private String navn;
	private String adresse;

	public Person(String navn, String adresse) {
		this.navn = navn;
		this.adresse = adresse;

	}

	public String getNavn() {
		return this.navn;
	}

	public String getAdresse() {
		return this.adresse;
	}

	public void updateNavn(String navn) {
		this.navn = navn;
	}

	public void updateAdresse(String adresse) {
		this.adresse = adresse;
	}
}
