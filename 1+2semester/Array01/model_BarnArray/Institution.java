package model_BarnArray;

public class Institution {
	private String navn;
	private String adresse;
	private Barn[] børn;
	private int childCount = 0;
	
	private static final int MAX_ANTAL_BØRN = 10;
	
	public Institution(String navn, String adresse){
		this.setNavn(navn);
		this.setAdresse(adresse);
		
		børn = new Barn[MAX_ANTAL_BØRN];
	}
	
	public void addBarn(Barn barn){
		børn[childCount] = barn;
		childCount += 1;
	}
	
	public int gennemsnitAlder(){
		int sum = 0;
		for(int i = 0; i < childCount; i++){
			sum += børn[i].getAlder();
		}
		return sum / childCount;
	}
	
	public int antalPiger(){
		int sum = 0;
		for(int i = 0; i < childCount; i++){
			if(børn[i].isKøn() == false){
			sum += 1;
			}			
		}
		return sum;
	}
	
	public int antalDrenge(){
		int sum = 0;
		for(int i = 0; i < childCount; i++){
			if(børn[i].isKøn() == true){
				sum += 1;
			}
		}
		return sum;
	}
	
	
	//Setter og Getter's

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}

	public String getNavn() {
		return navn;
	}

}
