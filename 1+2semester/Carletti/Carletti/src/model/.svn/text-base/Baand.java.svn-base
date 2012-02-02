package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Baand {
	@Id
	@GeneratedValue
	private int batchID;
	private String navn;
	private int kapacitet;
	@OneToMany (cascade= {CascadeType.PERSIST, CascadeType.REMOVE})
	private List<Mellemvare> mellemvareListe = new ArrayList<Mellemvare>();
	
	
	public Baand(int batchID, String navn, int kapacitet){
		this.setBatchID(batchID);
		this.setNavn(navn);
		this.setKapacitet(kapacitet);
	}
	
	public Baand() {
		
	}
	
	//Directions
	
	public void addVareUD(Mellemvare mellemvare){
		mellemvareListe.add(mellemvare);
	}
	
	public void removeVareUD(Mellemvare mellemvare){
		mellemvareListe.remove(mellemvare);
	}
	
	public void addVare(Mellemvare mellemvare){
		this.addVareUD(mellemvare);
		mellemvare.setBaandUD(this);
	}
	
	public void removeVare(Mellemvare mellemvare){
		this.removeVareUD(mellemvare);
		mellemvare.setBaandUD(null);
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
