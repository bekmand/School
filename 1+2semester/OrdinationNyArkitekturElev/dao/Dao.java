package dao;


import java.util.ArrayList;
import java.util.List;


import ordination.Lægemiddel;

import ordination.Patient;

public class Dao {
	private static List<Patient> patienter = new ArrayList<Patient>();
	private static List<Lægemiddel> lægemidler = new ArrayList<Lægemiddel>();

		
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
	 *  Returner en liste med alle gemte lægemidler
	 */
	public static List<Lægemiddel> getAllLægemidler(){
		return lægemidler;
	}
	
	/**
	 * Gemmer lægemiddel
	 * Krav: lægemidlet er ikke gemt
	 */
	public static void gemLægemiddel(Lægemiddel  lægemiddel){
		lægemidler.add(lægemiddel);
	}

}
