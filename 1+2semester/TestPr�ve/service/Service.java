package service;

import model.*;
import java.util.ArrayList;
import dao.Dao;;

public class Service {
	
	public static void createKunde(int id, String navn){
		Dao.addKunde(new Kunde(id, navn));
	}
	
	public static ArrayList<Kunde> getKunder(){
		return Dao.getKunder();
	}
	
	public static void createKasse(String kategori, double pris){
		Dao.addKasse(new Kasse(kategori, pris));
	}
	
	public static ArrayList<Kasse> getKasser(){
		return Dao.getKasser();
	}
	
	public static ArrayList<Kunde> returnSortedKunde(){
		ArrayList<Kunde> k = new ArrayList<Kunde>();
		for(int i = 0; i < Dao.getKunder().size(); i++){
			Kunde kunde = k.get(i);
			int position = i;
			while(position > 0 && k.get(i-1).compareTo(kunde) > 0){
				position--;
			}
			k.remove(i);
			k.add(position, kunde);
		}
		
		return k;
	}
	
	public static ArrayList<Kunde> findKunderMedAbonnement(String kategori, boolean ugentlig){
		ArrayList<Kunde> list = new ArrayList<Kunde>();
		
		for(Kunde k : getKunder()){
			for(Abonnement a : k.getAbonnement()){
				if(a.getUgentlig() == ugentlig && a.getKasse().getKategori().equals(kategori))
					list.add(k);
			}
		}
		
		return list;
	}
	
	public static void createSomeObject(){
		Kunde tmpKunde = null;
		tmpKunde = new Kunde(1,"Casper");
		tmpKunde.createAbonnement(false, Størrelse.SINGLE);
		tmpKunde.createAbonnement(true, Størrelse.FAMILY);
		Dao.addKunde(tmpKunde);
		
		tmpKunde = new Kunde(2,"Brian");
		tmpKunde.createAbonnement(true, Størrelse.SINGLE);
		tmpKunde.createAbonnement(true, Størrelse.DOUBLE);
		Dao.addKunde(tmpKunde);
		
		Kasse tmpKasse = null;
		tmpKasse = new Kasse("Fisk", 100);
		Dao.addKasse(tmpKasse);
		tmpKasse = new Kasse("Computer", 180);
		Dao.addKasse(tmpKasse);
		tmpKasse = new Kasse("Teacher", 80);
		Dao.addKasse(tmpKasse);
	}

}