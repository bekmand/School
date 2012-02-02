package dao;

import java.util.ArrayList;
import model.*;

public class Dao {
	static ArrayList<Tur> ture = new ArrayList<Tur>();
	static ArrayList<Bus> busser = new ArrayList<Bus>();
	static ArrayList<BusKategori> buskategorier = new ArrayList<BusKategori>();
	
	//Getter & setters
	
	public static void setTure(ArrayList<Tur> list){
		ture = list;
	}
	
	public static void addTure(Tur obj){
		ture.add(obj);
	}
	
	public static ArrayList<Tur> getTure(){
		return new ArrayList<Tur>(ture);
	}
	
	public static void setBusser(ArrayList<Bus> list){
		busser = list;
	}
	
	public static void addBusser(Bus obj){
		busser.add(obj);
	}
	
	public static ArrayList<Bus> getBusser(){
		return new ArrayList<Bus>(busser);
	}
	
	public static void setBusKategori(ArrayList<BusKategori> list){
		buskategorier = list;
	}
	
	public static void addBusKategori(BusKategori obj){
		buskategorier.add(obj);
	}
	
	public static ArrayList<BusKategori> getBusKategorier(){
		return new ArrayList<BusKategori>(buskategorier);
	}

}
