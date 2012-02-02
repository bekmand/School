package model;

import java.util.ArrayList;
import java.util.List;

public class Baand {
	private String navn;
	private int batchID;
	private int kapacitet;
	private List<Mellemvare> mellemvareListe;
	
	
	public Baand(String navn, int batchID, int kapacitet){
		this.setNavn(navn);
		this.setBatchID(batchID);
		this.setKapacitet(kapacitet);
	}
	
	
	//Directions
	
	public void addVare(Mellemvare mellemvare){
		mellemvareListe.add(mellemvare);
	}
	
	public void removeVare(Mellemvare mellemvare){
		mellemvareListe.remove(mellemvare);
	}
	
	public List<Mellemvare> getMellemvarer(){
		return new ArrayList<Mellemvare>(mellemvareListe);
	}
	
	
	//Getters and Setters
	public String getNavn() {
		return navn;
	}


	public void setNavn(String navn) {
		this.navn = navn;
	}


	public int getBatchID() {
		return batchID;
	}


	public void setBatchID(int batchID) {
		this.batchID = batchID;
	}


	public int getKapacitet() {
		return kapacitet;
	}


	public void setKapacitet(int kapacitet) {
		this.kapacitet = kapacitet;
	}
	
	public String toString(){
		return batchID + ", " + navn;
	}
	
	

}
