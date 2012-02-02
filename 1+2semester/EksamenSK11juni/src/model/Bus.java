package model;

import java.util.ArrayList;

public class Bus {
	private int antalPassagerer;
	private int indregistreringsår;
	private ArrayList<Tur> turer = new ArrayList<Tur>();
	private ArrayList<BusKategori> busKategorier = new ArrayList<BusKategori>();
	
	public Bus(int antalPassagerer, int indregistreringsår){
		this.antalPassagerer = antalPassagerer;
		this.indregistreringsår = indregistreringsår;
	}
	
	public int getAntalTurer(String startSted, String slutSted){
		int count = 0;
		for(int i = 0; i < turer.size(); i++){
			if(turer.get(i).getStartSted().equals(startSted) && turer.get(i).getSlutSted().equals(slutSted))
				count++;
		}
		return count;
	}
	
	//Associationer -----------------------------
	//Bus til Tur
	
	public ArrayList<Tur> getTurer(){
		return new ArrayList<Tur>(turer);
	}
	
	void addTurUD(Tur tur){
		turer.add(tur);
	}
	
	void removeTurUD(Tur tur){
		turer.remove(tur);
	}
	
	public void addTur(Tur tur){
		this.addTurUD(tur);
		tur.addBusserUD(this);
	}
	
	public void removeTur(Tur tur){
		tur.removeBusserUD(this);
		this.removeTurUD(tur);
	}
	
	//Bus til BusKategori 
	
	public ArrayList<BusKategori> getBusKategori(){
		return new ArrayList<BusKategori>(busKategorier);
	}
	
	public void addBusKategori(BusKategori busKategori){
		busKategorier.add(busKategori);
	}
	
	public void removeBusKategori(BusKategori busKategori){
		busKategorier.remove(busKategori);
	}
	
	// Getter & Setters ******
	
	public int getAntalPassagerer(){
		return antalPassagerer;
	}
	
	public int getIndregistreringsår(){
		return indregistreringsår;
	}
	
	public void setAntalPassagerer(int antalPassagerer){
		this.antalPassagerer = antalPassagerer;
	}
	
	public void setIndregistreringsår(int indRegistreringsår){
		this.indregistreringsår = indRegistreringsår;
	}
}
