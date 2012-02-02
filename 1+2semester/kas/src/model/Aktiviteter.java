package model;
import java.util.ArrayList;

public class Aktiviteter {
	private String navn;
	private String location;
	private double dato;
	private double pris;
	private ArrayList<Ledsager> ledsagere = new ArrayList();
	
	public Aktiviteter(String navn, String location, double dato, double pris){
		this.navn = navn;
		this.location = location;
		this.dato = dato;
		this.pris = pris;
	}

	public double getPris(){
		return pris;
	}
	public String toString(){
		return this.navn+" "+this.location+" "+this.dato+" "+this.pris;

}
	
	//----------------------------------------------------------------
	
	public void addLedsagerUD(Ledsager ledsag){
		ledsagere.add(ledsag);
	}
	
	public void removeLedsagerUD(Ledsager ledsag){
		ledsagere.remove(ledsag);
	}
	
	public void addLedsager(Ledsager ledsag){
		this.addLedsager(ledsag);
		ledsag.addAktivitetUD(this);
	}
	
	public void removeLedsager(Ledsager ledsag){
		ledsag.removeAktivitetUD(null);
		this.removeLedsagerUD(ledsag);
	}
}
