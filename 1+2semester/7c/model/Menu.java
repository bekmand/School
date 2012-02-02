package model;

import gui.InputKeysPanel;
import gui.MainFrame;

import java.util.ArrayList;

import model.EMenu.*;

public class Menu {

	private ArrayList<Menu> list = new ArrayList<Menu>();

	private String navn;
	private menuStates ms;
	private phoneState ps;
	
	private Menu parent;
	
	// private InputMode inputMode;

	public Menu(String navn, phoneState ps, menuStates ms) {
		this.setNavn(navn);
		this.ps = ps;
		this.ms = ms;
		// this.inputMode = inputMode;
	}

	public menuStates getMenuState(){
		return ms;
	}
	
	public phoneState getPhoneState(){
		return ps;
	}
	
	public void setNavn(String navn) {
		this.navn = navn;
	}

	public String getNavn() {
		return navn;
	}

	public void addMenu(Menu obj) {
		obj.setParent(this);
		list.add(obj);
	}

	public String toString() {
		return navn;
	}

	public ArrayList<Menu> getNext() {
		ArrayList tmpA = null;
		
		if (list.size() != 0) {
			tmpA = new ArrayList<Menu>(list);
			//MainFrame.setMenuState(setState);
		}
		else{
			
		}
		return tmpA;
	}

	public void setParent(Menu parent) {
		this.parent = parent;
	}
	
	public ArrayList<Menu> getList(){
		return list;
	}

	public Menu getParent() {
		return parent;
	}
}