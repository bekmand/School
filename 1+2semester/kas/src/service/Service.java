package service;

import java.util.ArrayList;

import model.Aktiviteter;
import model.Deltager;
import model.Konferrence;
import model.Hotel;
import model.Ledsager;
import model.Tilmedlinger;
import dao.Dao;

public class Service {
	
	private static Konferrence k1;

	public static void startUp(){
		createSomeObjects();
	}
	
	public static void closeDown(){
		//nothing happening atm.
	}
	
	public static ArrayList<Konferrence> getAllKonferrence(){
		return Dao.getAllKonferrence();
	}
	
	public static ArrayList<Aktiviteter> getAllUdflugter(){
		ArrayList<Aktiviteter> alleAktiviteter = new ArrayList<Aktiviteter>();
		for(int i = 0; i < Dao.getAllKonferrence().size(); i++){	
			alleAktiviteter.addAll(Dao.getAllKonferrence().get(i).getAllaktiviteter());
		}
		return alleAktiviteter;
	}
	
	public static Konferrence opretKonferrence(String navn, String location, double datoStart, double datoSlut, double konferrencePris){
		Konferrence konf = new Konferrence(navn, location, datoStart, datoSlut, konferrencePris);
		Dao.storeKonferrence(konf);
		return konf;
	}
	
	public static ArrayList<Hotel> getAllHotel(){
		return Dao.getAllHotel();
	}
	
	public static Hotel opretHotel(String navn, double prisEnkelt, double prisDoublet, double tillæg){
		Hotel hoteller = new Hotel(navn, prisEnkelt, prisDoublet, tillæg);
		Dao.storeHotel(hoteller);
		return hoteller;
	}
	
	public static ArrayList<Deltager> getAllDeltager(){
		return Dao.getAllDeltager();
	}
	
//	public static double getTotalPris(){
//		int sum;
//		
//		}
	
	public static int getDeltagerNr(){
		return Dao.getDeltagerSize();
	}
	
	public static Deltager opretDeltager(String navn, int nr, String adresse, String by, String land, 
										int tlf, double ankomstDato, double afrejseDato, boolean fordragsholder ){
 		Deltager deltagere = new Deltager(navn, nr, adresse, by, land, tlf);
		Tilmedlinger tilmelding = new Tilmedlinger(ankomstDato, afrejseDato, fordragsholder);
 		tilmelding.addDeltager(deltagere);
		k1.addTilmeldning(tilmelding);
 		return deltagere;
	}
	
	public static Ledsager opretLedsager(String navn, String partnerNavn, int partnerNr){
		Ledsager ledsagere = new Ledsager(navn, partnerNavn, partnerNr);
		return ledsagere;
	}
	
	
	//------------------------------------------------------------------------------
	
	private static void createSomeObjects() {
		k1 = opretKonferrence("IT", "Herning", 25.03, 30.03, 200);

		Hotel h1 = opretHotel("luksus", 100.0, 150.0, 50.0);		
	}
}
