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
		
		tmpMenu = new Menu("Opkald", phoneState.MENU, menuStates.LAES);
		Dao.addMenu(tmpMenu);

		dao.Dao.addKontakter(-1, new Kontakt("Daniel", "Christensen", 555));
		dao.Dao.addKontakter(-1 ,new Kontakt("morerenged", "lol", 45645));
		addKontakter("Something", "Anders", 1232132);
	}
	
	public static ArrayList<Kontakt> getKontakter() {
		return new ArrayList<Kontakt>(dao.Dao.getKontakter());
	}
	

	public static void addKontakter(String efternavn, String fornavn, int nummer){
			sort(new Kontakt(fornavn, efternavn, nummer));
		}
	
	public static ArrayList<SMS> getSmser(){
		return new ArrayList<SMS>(dao.Dao.getSmser());	
	}
	
	public static void addSmser(int nummer, String text, boolean incommingSms){
		dao.Dao.addSmser(new SMS(text, nummer, incommingSms));
	}
	
	public static ArrayList<Opkald> getOpkald(){
		return new ArrayList<Opkald>(dao.Dao.getOpkald());
	}
	
	public static void removeKontakt(Kontakt kontakt){
		System.out.println(Dao.getKontakter());
		dao.Dao.removeKontakter(kontakt);
		System.out.println(Dao.getKontakter());
	}
	
	public static void sort (Kontakt key){
		ArrayList<Kontakt> data = Dao.getKontakter();
		int position=0;
		for (int index = 0; index <data.size(); index++){
			position = index;
			while(position > 0 && data.get(position-1).getFornavn().compareTo(key.getFornavn())>0){
				data.set(position, data.get(position-1));
				position--;
			}
		}
		dao.Dao.addKontakter(position, key);
	}
	
	public static void addOpkald(boolean incommingCall, boolean callAccpeted, int nummer){
		Opkald o1 = new Opkald(incommingCall, callAccpeted, nummer);
		op1 = o1;
		Dao.addOpkald(op1);
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
		addOpkald(false, OpkaldAccepteret, nummer);
		return OpkaldAccepteret;
	}
	
	public static void laegPaa(){
		op1.setCallLenght();
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

