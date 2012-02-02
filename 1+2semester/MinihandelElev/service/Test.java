package service;

import java.sql.Date;
import java.util.Iterator;

import model.Kunde;
import model.Ordre;
import model.OrdreLinje;
import model.Vare;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Kunde k = new Kunde("Lars", new Date(1989, 12, 29));
		

		Vare v = new Vare(1, "PS3", 2400);
		
		
		Ordre o = new Ordre(1, k);
		o.createOrdreLinie(1, 10, v);
	
		k.addOrdre(o);
		
		Service.getInstance().storeKunde(k);
		
		
		
//		
//		System.out.println(Service.getInstance().getAllKunder()+"");


//		Opgave 1
		System.out.println(Service.getInstance().getAllVare()+"");
		
//		Opgave 2
//		Iterator<Ordre> i = Service.getInstance().findKunde("Lars").getOrdrer();
//		while(i.hasNext()){
//			Iterator<OrdreLinje> it = i.next().getOrdreLinjer();
//			while(it.hasNext()){
//				System.out.println(it.next().getVare());
//			}
//		}
//		
//		
//		Opgave 3
//		k.setNavn("Casper");
//		v.setNavn("Xbox360");
//		
//		Ordre o2 = new Ordre(1,k);
//		
//		o2.createOrdreLinie(4, 1, v);
//		
//		k.addOrdre(o2);
		
//		Opgave 4
		k.removeOrdre(o);
		
	}

}