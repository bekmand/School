package model;

import java.util.ArrayList;
import java.util.List;

public class Lager {

	public static Lager instance;
	
	public static Lager getInstance(){
		if(instance == null){
			instance = new Lager();
		}
		return instance;
	}
	
	private String navn;
	private int kapacitet;
	private List<Baand> lagerBaand;
	
	private Lager(){}

	private Lager(String navn, int kapacitet){
		this.addLagerBaand(new ArrayList<Baand>());
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
	
	public void addLagerBaand(List<Baand> lagerBaand) {
		this.lagerBaand = lagerBaand;
	}

	public List<Baand> getLagerBaand() {
		return lagerBaand;
	}
	
	public void removeLagerBaand(Baand baand){
		lagerBaand.remove(baand);
	}
	
}
