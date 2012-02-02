package model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class OrdreLinje {
	
	@Id
	private int linieNr;

	private int antalStk;
	
	@OneToOne(cascade={CascadeType.PERSIST, CascadeType.REMOVE})
	private Vare vare;
	
	OrdreLinje(){}

	OrdreLinje(int linieNr, int antalStk, Vare vare) {
		this.linieNr = linieNr;
		this.antalStk = antalStk;
		this.vare = vare;

	}

	public int getLinieNr() {
		return linieNr;
	}

	public int getAntalStk() {
		return antalStk;
	}
	public Vare getVare(){
		return vare;
	}
	public double pris(){
		return antalStk * vare.getStkPris();
	}

}
