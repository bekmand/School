package model;
import java.util.ArrayList;

public class Konferrence {
	private String navn;
	private String location;
	private double datoStart;
	private double datoSlut;
	private double konferrencePris;
	private ArrayList<Tilmedlinger> tilmeldninger = new ArrayList();
	private ArrayList<Aktiviteter> aktiviteter = new ArrayList();
	
	public Konferrence(String navn, String location, double datoStart, double datoSlut, double konferrencePris){
		this.navn = navn;
		this.location = location;
		this.datoStart = datoStart;
		this.datoSlut = datoSlut;
		this.konferrencePris = konferrencePris;
	}
	
	public void addAktivitet(Aktiviteter aktivitet){
		;
	}
	
	public double getKonfPris(){
		return konferrencePris;
	}
	
	public ArrayList<Aktiviteter> getAllaktiviteter(){
		return aktiviteter;
	}
	
	public void addTilmeldning(Tilmedlinger tilmeldning){
		tilmeldninger.add(tilmeldning);
	}
	public String toString(){
		return this.navn+" "+this.location+" "+this.datoStart+" "+this.datoSlut+" "+this.konferrencePris;

}
}
