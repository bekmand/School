package service;

import java.util.ArrayList;
import dao.Dao;
import model.*;

public class Service {

	public static ArrayList<Bus> findBusserTilTur(Tur tur, BusKategori kategori) {
		ArrayList<Bus> ledigeBusser = new ArrayList<Bus>();

		for (int i = 0; i < Dao.getBusser().size(); i++) {
			Bus tmpBus = Dao.getBusser().get(i);

			for (int j = 0; j < Dao.getTure().size(); j++)
				if (tmpBus.getTurer().get(j).equals(tur)
						&& tmpBus.getBusKategori().get(j).equals(kategori)
						&& tmpBus.getAntalPassagerer() > Dao.getTure().get(j).getAntalPassagerer()) {

					ledigeBusser.add(tmpBus);
				}
		}
		return ledigeBusser;
	}

	public static int antalBusser(int minimumKilometer){
		int antal = 0;
		for(int i = 0; i<Dao.getBusser().size();i++){
			Bus tmpBus = Dao.getBusser().get(i);
			int sum = 0;
			for(int j = 0; j < Dao.getTure().size(); j++){
				sum += tmpBus.getTurer().get(i).getKm();
			}
			if(sum > minimumKilometer){
				antal++;
			}
		}
		return antal;
	}

	public static Tur findTur(ArrayList<Tur> ture, String startSted){
		boolean found = false;
		int i = 0;
		Tur tFound = null;
		
		while(!found && i < ture.size()){
			if(ture.get(i).getStartSted().equals(startSted)){
				found = true;
				tFound = ture.get(i);
			}
			else
				i++;
		}
		return tFound;
	}
	
	public static void CreateSomeObjects() {
		Bus tmpBus = null;

		Tur t1 = new Tur("a", "b", 80, 100);
		Tur t2 = new Tur("c", "d", 60, 250);
		Tur t3 = new Tur("e", "f", 120, 80);

		tmpBus = new Bus(100, 2000);
		tmpBus.addTur(t1);
		tmpBus.addTur(t2);
		Dao.addBusser(tmpBus);

		tmpBus = new Bus(140, 2002);
		tmpBus.addTur(t2);
		tmpBus.addTur(t3);
		Dao.addBusser(tmpBus);

		tmpBus = new Bus(80, 2007);
		Dao.addBusser(tmpBus);

		BusKategori tmpKategori = null;

		tmpKategori = new BusKategori("Luksus", 200, 10);
		Dao.addBusKategori(tmpKategori);

		tmpKategori = new BusKategori("Standard", 50, 5);
		Dao.addBusKategori(tmpKategori);

		tmpKategori = new BusKategori("Turist", 100, 7);
		Dao.addBusKategori(tmpKategori);
	}

	public static ArrayList<Tur> getTure() {
		return new ArrayList<Tur>(Dao.getTure());
	}

	public static void addTur(String startSted, String slutSted,
			int antalPassagerer, int km) {
		Tur t = new Tur(startSted, slutSted, antalPassagerer, km);
		Dao.addTure(t);
	}

	public static ArrayList<Bus> getBusser() {
		return new ArrayList<Bus>(Dao.getBusser());
	}

	public static void addBus(int antalPassagerer, int indregistreringsår) {
		Bus b = new Bus(antalPassagerer, indregistreringsår);
		Dao.addBusser(b);
	}

	public static ArrayList<BusKategori> getBusKategori() {
		return new ArrayList<BusKategori>(Dao.getBusKategorier());
	}

	public static void addBusKategori(String kategori, int basisPris, int kmPris) {
		BusKategori bk = new BusKategori(kategori, basisPris, kmPris);
		Dao.addBusKategori(bk);
	}
}
