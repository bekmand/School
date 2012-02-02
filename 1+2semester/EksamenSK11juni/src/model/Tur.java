package model;

import java.util.ArrayList;

public class Tur {
	private String startSted;
	private String slutSted;
	private int antalPassagerer;
	private int km;
	private ArrayList<Bus> busser = new ArrayList<Bus>();
	
	
	public Tur(String startSted, String slutSted, int antalPassagerer, int km){
		this.startSted = startSted;
		this.slutSted = slutSted;
		this.antalPassagerer = antalPassagerer;
		this.km = km;
	}
	
	public double getTurPris(){
		int sum = 0;
		for(int i = 0; i<busser.size(); i++){
			int tempSum = 0;
			sum += busser.get(i).getBusKategori().get(i).getBasisPris();
			tempSum = busser.get(i).getBusKategori().get(i).getKmPris();
			tempSum = tempSum * getKm();
			sum += tempSum;
		}
		
		return sum;
	}
	
	//Associationer ----------------------
	
	public ArrayList<Bus> getBusser(){
		return new ArrayList<Bus>(busser);
	}
	
	void addBusserUD(Bus bus){
		busser.add(bus);
	}
	
	void removeBusserUD(Bus bus){
		busser.remove(bus);
	}
	
	public void addBus(Bus bus){
		this.addBusserUD(bus);
		bus.addTurUD(this);
	}
	
	public void removeBus(Bus bus){
		bus.removeTurUD(this);
		this.removeBusserUD(bus);
	}
	
	//Getter & setters ****
	
	public String getStartSted(){
		return startSted;
	}
	
	public String getSlutSted(){
		return slutSted;
	}
	
	public int getAntalPassagerer(){
		return antalPassagerer;
	}
	
	public int getKm(){
		return km;
	}
	
	public void setStartSted(String startSted){
		this.startSted = startSted;
	}
	
	public void setSlutSted(String slutSted){
		this.slutSted = slutSted;
	}
	
	public void setAntalPassagerer(int antalPassagerer){ 
		this.antalPassagerer = antalPassagerer;
	}

	public void setKm(int km){
		this.km = km;
	}
}
