package service;

import java.util.List;

import model.Kunde;
import dao.JpaDAO;

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
		JpaDAO.getInstance().store(k);
	}
	
	public void removeKunde(Kunde k) {
		JpaDAO.getInstance().remove(k);
	}
	
	public Kunde findKunde(String navn) {
		return JpaDAO.getInstance().findKunde(navn);
	}
	
	public List<Kunde> getAllKunder() {
		return JpaDAO.getInstance().getAllKunder();
	}
}
