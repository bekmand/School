package dao;


import java.util.ArrayList;
import java.util.List;


import ordination.L�gemiddel;

import ordination.Patient;

public class Dao {
	private static List<Patient> patienter = new ArrayList<Patient>();
	private static List<L�gemiddel> l�gemidler = new ArrayList<L�gemiddel>();

		
	/*
	 *  Returner en liste med alle gemte patienter
	 */
	public static List<Patient> getAllPatienter(){
		return patienter;
	}
	
	/**
	 * Gemmer patient
	 * Krav: patienten er ikke gemt
	 */
	public static void gemPatient(Patient patient){
		patienter.add(patient);
	}
	
	/*
	 *  Returner en liste med alle gemte l�gemidler
	 */
	public static List<L�gemiddel> getAllL�gemidler(){
		return l�gemidler;
	}
	
	/**
	 * Gemmer l�gemiddel
	 * Krav: l�gemidlet er ikke gemt
	 */
	public static void gemL�gemiddel(L�gemiddel  l�gemiddel){
		l�gemidler.add(l�gemiddel);
	}

}
