package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Lager {

	public static Lager instance;
	
	public static Lager getInstance(){
		if(instance == null){
			instance = new Lager();
		}
		return instance;
	}
	@Id
	@GeneratedValue
	private int id;
	private String navn;
	private int kapacitet;
	@OneToMany (cascade={CascadeType.PERSIST, CascadeType.REMOVE})
	private List<Baand> lagerBaand = new ArrayList<Baand>();
	
	private Lager(){}

	private Lager(String navn, int kapacitet){
		this.setNavn(navn);
		this.setKapacitet(kapacitet);
	}
	
	
	//Getters and setters

	public void setKapacitet(int kapacitet) {
		this.kapacitet = kapacitet;
	}

	public int getKapacitet() {
		return kapacitet;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}

	public String getNavn() {
		return navn;
	}

	
	//Directions
	
	public void addLagerBaand(Baand baand) {
		lagerBaand.add(baand);
	}

	public List<Baand> getLagerBaand() {
		return lagerBaand;
	}
	
	public void removeLagerBaand(Baand baand){
		lagerBaand.remove(baand);
	}
	
}
