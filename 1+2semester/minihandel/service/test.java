package service;

import java.util.Date;

import model.Kunde;
import model.Ordre;
import model.Vare;

public class test {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Kunde k = new Kunde("Lars", new Date(1989, 12, 29));
		
		Vare v = new Vare(1, "PS3", 2400);
		
		Ordre o = new Ordre(1, k);
		o.createOrdreLinie(1, 10, v);
		
		k.addOrdre(o);
		
		Service.getInstance().storeKunde(k);
		
		System.out.println(Service.getInstance().getAllKunder());
	}

}
