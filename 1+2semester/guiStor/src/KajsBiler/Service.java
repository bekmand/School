/*
 * Created on 2005-05-13
 */
package KajsBiler;

 

import java.util.ArrayList;


public class Service {
	
	
	public static void startOp(){
		skaberNogleObjekter();
	}
	
	/**
	 * Returner liste af alle kunder.
	 */
	public static ArrayList<Kunde> getAlleKunder() {
		return Dao.getAlleKunder();
	}

	/**
	 * Opretter en kunde. 
	 * Krav: navn ej tom, cpr >= 0.
	 */
	public static Kunde opretKunde(String navn, int cpr) {
		Kunde kunde = new Kunde(navn, cpr);
		Dao.storeKunde(kunde);
		return kunde;
	}
	
	/**
	 * Returner en liste af biler.
	 */
	public static ArrayList<Bil> getAlleBiler() {
		return Dao.getAlleBiler();
	}

	/**
	 * Opretter en bil.
	 * Krav:  
	 */
	public static Bil opretBil(int regnr,String mærke) {
		Bil bil = new Bil(regnr, mærke);
		Dao.storeBil(bil);
		return bil;
	}
	 
	
	 
	
	// evt. flere metoder der arbejder på listerne med objekterne

	public static void skaberNogleObjekter(){
		// opret afprøvningsdata  
		
		opretKunde("Peter Sørensen", 1);
		 
		opretBil(1,"Honda");
		opretBil(2, "Pegeuot");
		
	}
}
 