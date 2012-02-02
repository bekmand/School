package service;

import java.util.ArrayList;
import java.util.Random;

import dao.Dao;

import model.EMenu.InputMode;
import model.EMenu.menuStates;
import model.EMenu.phoneState;
import model.Kontakt;
import model.Menu;
import model.Opkald;
import model.SMS;

public class Service {

	private static Opkald op1;
	
	public static void Start(){
		Menu tmpMenu = null;
		
		tmpMenu = new Menu("Kontakt", phoneState.KONTAKT ,null);
		tmpMenu.addMenu(new Menu("Opret", null, menuStates.OPRET));
		tmpMenu.addMenu(new Menu("Oversigt", null, menuStates.LAES));
		tmpMenu.addMenu(new Menu("Rediger", null, menuStates.REDIGER));
		Dao.addMenu(tmpMenu);
		
		tmpMenu = new Menu("Besked", phoneState.SMS, null);
		tmpMenu.addMenu(new Menu("Opret", null, menuStates.OPRET));
		tmpMenu.addMenu(new Menu("Oversigt", null, menuStates.LAES));
		tmpMenu.addMenu(new Menu("Slet", null, menuStates.REDIGER));
		Dao.addMenu(tmpMenu);
		
		tmpMenu = new Menu("Opkald", phoneState.OPKALD, null);
		Dao.addMenu(tmpMenu);
	}
	
	public static ArrayList<Kontakt> getKontakter() {
		return new ArrayList<Kontakt>(dao.Dao.getKontakter());
	}
	
	public static void addKontakter(String efternavn, String fornavn, int nummer){
		Kontakt k1 = new Kontakt(fornavn, efternavn, nummer);
		Dao.addKontakter(k1);
	}
	
	public static ArrayList<SMS> getSmser(){
		return new ArrayList<SMS>(dao.Dao.getSmser());	
	}
	
	public static void addSmser(int nummer, String text, boolean incommingSms){
		SMS s1 = new SMS(text, nummer, incommingSms);
		dao.Dao.addSmser(s1);
	}
	
	public static ArrayList<Opkald> getOpkald(){
		return new ArrayList<Opkald>(dao.Dao.getOpkald());
	}
	
	public static void addOpkald(boolean incommingCall, boolean callAccpeted, int nummer){
		Opkald o1 = new Opkald(incommingCall, callAccpeted, nummer);
		op1 = o1;
	}
	
	public static ArrayList<Menu> getMenus(){
		return new ArrayList<Menu>(dao.Dao.getMenuer());
	}
	
	public static void addMenu(Menu menu){
		dao.Dao.addMenu(menu);
	}
	
	public static Opkald getLastCall(){
		return dao.Dao.getOpkald().get(dao.Dao.getOpkald().size()-1);
	}
	
	public static boolean ringOp(int nummer){
		Random rnd = new Random();
		boolean OpkaldAccepteret = rnd.nextBoolean();
		addOpkald(false, false, nummer);
		return OpkaldAccepteret;
	}
	
	public static void laegPaa(){
		op1.setCallLenght();
		Dao.addOpkald(op1);
	}
	
	public static Kontakt findKontakt(int nr){
		boolean found = false;
		int i = 0;
		ArrayList<Kontakt> list = Dao.getKontakter();
		Kontakt kontakt = null;
		while(!found && i<list.size()){
			kontakt = list.get(i);
			if (kontakt.getNummer()== nr)
				found = true;
			else
				i++;		
		}
		if (found)
			return kontakt;
		else
			return null;
	}
	
}
