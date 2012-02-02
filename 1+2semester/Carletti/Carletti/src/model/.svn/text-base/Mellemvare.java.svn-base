package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.UniqueConstraint;

@Entity
public class Mellemvare {
	@Id
	private int batchID;
	private String navn;
	private int antal;
	@ManyToOne
	@JoinColumn
	private Behandling behandling;
	@OneToMany (cascade={CascadeType.PERSIST, CascadeType.REMOVE})
	private List<tørring> tørretider = new ArrayList<tørring>();
	@ManyToOne (cascade={CascadeType.PERSIST, CascadeType.REMOVE})
	@JoinColumn
	private Baand baand;
	
	public Mellemvare(String navn, int antal, int batchID){
		this.setNavn(navn);
		this.setAntal(antal);
		this.setBatchID(batchID);
	}
	
	public Mellemvare() {
		
	}
	
	public Behandling getBehandling(Behandling behandling){
		return behandling;
	}
	
	public void addTørretid(tørring tørre){
		this.addTørretidUD(tørre);
		tørre.setMellemvareUD(this);
	}
	
	public void addTørretidUD(tørring tørre){
		tørretider.add(tørre);
	}
	
	public List<tørring> getToerretider(){
		return new ArrayList<tørring>(tørretider);
	}

	
	//Directions
	
	public void setBaandUD(Baand baand) {
		this.baand = baand;
	}
	
	public void setBaand(Baand baand) {
		if(baand != null){
			this.setBaandUD(baand);
			baand.addVare(this);
		}
		else{
			this.getBaand().removeVare(this);
			this.setBaandUD(null);
		}
	}
	
	
	//Getter and setters
	public String getNavn() {
		return navn;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}

	public int getAntal() {
		return antal;
	}

	public void setAntal(int antal) {
		this.antal = antal;
	}

	public int getBatchID() {
		return batchID;
	}

	public void setBatchID(int batchID) {
		this.batchID = batchID;
	}

	public Behandling getBehandling() {
		return behandling;
	}

	public void setBehandling(Behandling behandling) {
		this.behandling = behandling;
	}

	public Baand getBaand() {
		return baand;
	}
	
	public String toString(){
		return batchID + ", " + navn;
	}

	

}
