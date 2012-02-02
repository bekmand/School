package dao;
import java.util.ArrayList;

import model.*;

public class Dao {

	static ArrayList<Kunde> kunder = new ArrayList<Kunde>();
	static ArrayList<Kasse> kasser = new ArrayList<Kasse>();
	
	public static void setKunde(ArrayList<Kunde> list){
		kunder = list;
	}
	
	public static void addKunde(Kunde obj){
		kunder.add(obj);
	}
	
	public static ArrayList<Kunde> getKunder(){
		return new ArrayList<Kunde>(kunder);
	}
	
	public static void removeKunde(int index){
		kunder.remove(index);
	}
	
	public static void setKasse(ArrayList<Kasse> list){
		kasser = list;
	}
	
	public static void addKasse(Kasse obj){
		kasser.add(obj);
	}
	
	public static ArrayList<Kasse> getKasser(){
		return new ArrayList<Kasse>(kasser);
	}
	
	public static void removeKasse(int index){
		kasser.remove(index);
	}
}
