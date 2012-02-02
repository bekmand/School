package model;
import java.util.ArrayList;

public class Ledsager {
	private String navn;
	private String partnerNavn;
	private int partnerNr;
	private ArrayList<Aktiviteter> aktivitet = new ArrayList();
	
	
	public Ledsager(String navn, String partnerNavn, int partnerNr){
		this.navn = navn;
		this.partnerNavn = partnerNavn;
		this.partnerNr = partnerNr;
	}
	
	public int aktivitetsPriser(){
		int tempSum = 0;
		for(int i = 0; i < aktivitet.size(); i++){
			tempSum += aktivitet.get(i).getPris();
		}
		return tempSum;
	}
	
	//----------------------------------------------------------------
	
	public void addAktivitetUD(Aktiviteter aktivi){
		aktivitet.add(aktivi);
	}
	
	public void removeAktivitetUD(Aktiviteter aktivi){
		aktivitet.remove(aktivi);
	}
	
	public void addAktivitet(Aktiviteter aktivi){
		this.addAktivitetUD(aktivi);
		aktivi.addLedsagerUD(this);
	}
	
	public void removeAktivitet(Aktiviteter aktivi){
		aktivi.removeLedsagerUD(null);
		this.removeAktivitetUD(aktivi);
	}
}
