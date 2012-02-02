package model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="OrdreLinier")
public class OrdreLinie {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private int linieNr;

	private int antalStk;

	@OneToOne(cascade={CascadeType.PERSIST, CascadeType.REMOVE})
	private Vare vare;

	OrdreLinie() { }
	
	OrdreLinie(int linieNr, int antalStk, Vare vare) {
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

}
