package KajsBiler;

import java.util.ArrayList;


public class Dao {
	private static ArrayList<Kunde> kunder = new ArrayList<Kunde>(); 
	private static ArrayList<Bil> biler= new ArrayList<Bil>();
	/**
	 * Gemmer kunden
	 * Requires:  kunden er ikke gemt
	 */
	public static void storeKunde(Kunde kunde) {
		kunder.add(kunde);
	}

	/**
	 * Fjerner den gemte kunde
	 * Requires: kunden er gemt
	 */
	public static void deleteKunde(Kunde kunde) {
		kunder.remove(kunde);
	}

	/**
	 * Returner en liste af kunder
	 */
	public static ArrayList<Kunde> getAlleKunder() {
		return kunder;
	}
	
	
	/**
	 * Gemmer bilen
	 * Requires:  bilen er ikke gemt
	 */
	public static void storeBil(Bil bil) {
		biler.add(bil);
	}

	/**
	 * Fjerner den gemte bil
	 * Requires: bilen er gemt
	 */
	public static void deleteBil(Bil bil) {
		biler.remove(bil);
	}

	/**
	 * Returner en liste af biler
	 */
	public static ArrayList<Bil> getAlleBiler() {
		return biler;
	}
	 }
