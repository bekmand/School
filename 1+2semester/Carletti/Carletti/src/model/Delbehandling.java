package model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Delbehandling {
	@Id
	private int batchID;
	private int minimumsT�rretid;
	private int idealT�rretid;
	private int maximalT�rretid;
	private String navn;
	
	
	public Delbehandling(int mins, int ideal, int max, String navn, int batchID){
		this.setMinimumsT�rretid(mins);
		this.setIdealT�rretid(ideal);
		this.setMaximalT�rretid(max);
		this.setNavn(navn);
		this.setBatchID(batchID);
	}
	
	public Delbehandling(){
		
	}
	
	
	//Getters and Setters

	public int getMinimumsT�rretid() {
		return minimumsT�rretid;
	}

	public void setMinimumsT�rretid(int minimumsT�rretid) {
		this.minimumsT�rretid = minimumsT�rretid;
	}

	public int getIdealT�rretid() {
		return idealT�rretid;
	}

	public void setIdealT�rretid(int idealT�rretid) {
		this.idealT�rretid = idealT�rretid;
	}

	public int getMaximalT�rretid() {
		return maximalT�rretid;
	}

	public void setMaximalT�rretid(int maximalT�rretid) {
		this.maximalT�rretid = maximalT�rretid;
	}

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
	
	public String toString(){
		return batchID + ", " + navn;
	}

}
