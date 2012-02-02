package Singleton;

import java.util.ArrayList;

public class personAdministrator {
	private static personAdministrator instance = new personAdministrator();
	private ArrayList<person> personer = new ArrayList<person>();
	
	
	public static personAdministrator getInstance(){
		
		if(instance == null)
				instance = new personAdministrator();	
		return instance;
		
	}
	
	
	public void add(person person){
		personer.add(person);
	}
	
	public void remove(person person){
		personer.remove(person);
	}
	
	public ArrayList<person> getPersoner(){
		return personer;
	}

}
