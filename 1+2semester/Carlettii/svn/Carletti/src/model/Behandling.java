package model;

import java.util.ArrayList;
import java.util.List;

public class Behandling {
	private int batchID;
	private int counter = 0;
	private String navn;
	private int maxAntalDelbehandlinger;
	private List<Delbehandling> delbehandlinger = new ArrayList<Delbehandling>();
	
	
	public Behandling(int batchID, String navn){
		this.setBatchID(batchID);
		this.setNavn(navn);
	}


	
	
	
	//Getters and setters
	public int getBatchID() {
		return batchID;
	}


	public void setBatchID(int batchID) {
		this.batchID = batchID;
	}
	
	public int getCounter(){
		return counter;
	}


	public String getNavn() {
		return navn;
	}


	public void setNavn(String navn) {
		this.navn = navn;
	}

	public void addDelbehandling(Delbehandling delbehandling){
		delbehandlinger.add(delbehandling);
	}
	
	public void removeDelbehandling(Delbehandling delbehandling){
		delbehandlinger.remove(delbehandling);
	}
	
	public List<Delbehandling> getDelbehandlinger(){
		return new ArrayList<Delbehandling>(delbehandlinger);
	}
	
	public void setMaxAntalDelbehandlinger(){
		this.maxAntalDelbehandlinger = delbehandlinger.size();
	}
	
	public int getMaxAntalDelbehandlinger(){
		return maxAntalDelbehandlinger;
	}
	
	public String toString(){
		return batchID + ", " + navn;
	}
}
