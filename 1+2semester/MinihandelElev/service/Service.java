package service;

import java.util.List;

import model.Kunde;
import model.Vare;
import dao.DaoJpa;

public class Service {
	private static Service serviceInstance;
	
	private Service() { }
	
	public static Service getInstance() {
		if(serviceInstance == null) {
			serviceInstance = new Service();
		}
		
		return serviceInstance;
	}
	
	public void storeKunde(Kunde k) {
		DaoJpa.getInstance().store(k);
	}
	
	public void removeKunde(Kunde k) {
		DaoJpa.getInstance().remove(k);
	}
	
	public Kunde findKunde(String navn) {
		return DaoJpa.getInstance().findKunde(navn);
	}
	
	public List<Kunde> getAllKunder() {
		return DaoJpa.getInstance().getAllKunder();
	}
	
	public List<Vare> getAllVare(){
		return DaoJpa.getInstance().getAllVare();
	}
}
