package dao;

import java.util.ArrayList;

import model.Kontakt;
import model.Menu;
import model.Opkald;
import model.SMS;

public class Dao {
	
	static ArrayList<Kontakt> kontakter = new ArrayList<Kontakt>();
	static ArrayList<SMS> smser = new ArrayList<SMS>();
	static ArrayList<Opkald> opkald = new ArrayList<Opkald>();
	static ArrayList<Menu> menuer = new ArrayList<Menu>();
	
	public static void setKontakter(ArrayList<Kontakt> list){
		kontakter = list;
	}
	
	public static void addKontakter(Kontakt obj){
		kontakter.add(obj);
	}
	
	public static ArrayList<Kontakt> getKontakter(){
		return new ArrayList<Kontakt>(kontakter);
	}
	
	public static void removeKontakter(int index){
		kontakter.remove(index);
	}
	
	public static void setSmser(ArrayList<SMS> list){
		smser = list;
	}
	
	public static void addSmser(SMS obj){
		smser.add(obj);
	}
	
	public static ArrayList<SMS> getSmser(){
		return new ArrayList<SMS>(smser);
	}
	
	public static void removeSmser(int index){
		smser.remove(index);
	}
	
	public static void setOpkald(ArrayList<Opkald> list){
		opkald = list;
	}
	
	public static void addOpkald(Opkald obj){
		opkald.add(obj);
	}
	
	public static ArrayList<Opkald> getOpkald(){
		return new ArrayList<Opkald>(opkald);
	}
	
	public static void removeOpkald(int index){
		opkald.remove(index);
	}
	
	public static void setMenu(ArrayList<Menu> list){
		menuer = list;
	}
	
	public static void addMenu(Menu obj){
		menuer.add(obj);
	}
	
	public static ArrayList<Menu> getMenuer(){
		return new ArrayList<Menu>(menuer);
	}
	
	public static void removeMenuer(int index){
		menuer.remove(index);
	}
}
