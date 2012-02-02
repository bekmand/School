package dao;
import java.util.ArrayList;
import model.Deltager;
import model.Konferrence;
import model.Hotel;

public class Dao {
	private static ArrayList<Konferrence> konferrence = new ArrayList<Konferrence>();
	private static ArrayList<Hotel> hotel = new ArrayList<Hotel>();
	private static ArrayList<Deltager> deltager = new ArrayList<Deltager>();
	
	public static ArrayList<Konferrence> getAllKonferrence(){
		return konferrence;
	}
	
	public static void storeKonferrence(Konferrence konf){
		konferrence.add(konf);
	}
	
	public static ArrayList<Hotel> getAllHotel(){
		return hotel;
	}
	
	public static void storeHotel(Hotel hoteller){
		hotel.add(hoteller);
	}
	
	public static ArrayList<Deltager> getAllDeltager(){
		return deltager;
	}
	
	public static void storeDeltager(Deltager deltagere){
		deltager.add(deltagere);
	}
	
	public static int getDeltagerSize(){
		return deltager.size();
	}

}
