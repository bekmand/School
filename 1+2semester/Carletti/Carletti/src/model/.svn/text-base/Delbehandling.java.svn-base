package model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Delbehandling {
	@Id
	private int batchID;
	private int minimumsTørretid;
	private int idealTørretid;
	private int maximalTørretid;
	private String navn;
	
	
	public Delbehandling(int mins, int ideal, int max, String navn, int batchID){
		this.setMinimumsTørretid(mins);
		this.setIdealTørretid(ideal);
		this.setMaximalTørretid(max);
		this.setNavn(navn);
		this.setBatchID(batchID);
	}
	
	public Delbehandling(){
		
	}
	
	
	//Getters and Setters

	public int getMinimumsTørretid() {
		return minimumsTørretid;
	}

	public void setMinimumsTørretid(int minimumsTørretid) {
		this.minimumsTørretid = minimumsTørretid;
	}

	public int getIdealTørretid() {
		return idealTørretid;
	}

	public void setIdealTørretid(int idealTørretid) {
		this.idealTørretid = idealTørretid;
	}

	public int getMaximalTørretid() {
		return maximalTørretid;
	}

	public void setMaximalTørretid(int maximalTørretid) {
		this.maximalTørretid = maximalTørretid;
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
