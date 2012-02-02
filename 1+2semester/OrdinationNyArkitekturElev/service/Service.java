package service;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import dao.Dao;

import ordination.DagligFast;
import ordination.DagligSkæv;
import ordination.Lægemiddel;
import ordination.PN;
import ordination.Patient;



public class Service {
	
	/**
	 * Opretter PN Ordination
	 * @return opretter og returnerer en PN ordination
	 */
	public static PN opretPNOrdination(GregorianCalendar startDen, GregorianCalendar slutDen, Patient patient, Lægemiddel lægemiddel,double antal){
		//TODO
		return null;
	}
	
	/**
	 * 
	 * Opretter DagligFast ordination
	 * @return opretter og returnerer en DagligFast ordination
	 * Bemærk: negativ antal betyder ingen dosis på dette tidspunkt
	 */
	public static DagligFast opretDagligFastOrdination(GregorianCalendar startDen, GregorianCalendar slutDen, Patient patient, Lægemiddel lægemiddel,double morgenAntal, double middagAntal, double aftenAntal, double natAntal){
		//TODO
		return null;
	}
	/**
	 * Opretter daglig skæv ordination
	 * Krav: antalEnheder og klokkeSlæt har samme længde. klokkeSlæt indeholder tidspunkter på dagen på formen 15:30
	 * @return opretter og returnerer en DagligSkæv ordination
	 */
	public static DagligSkæv opretDagligSkævOrdination(GregorianCalendar startDen, GregorianCalendar slutDen, Patient patient, Lægemiddel lægemiddel,String[] klokkeSlæt, double[] antalEnheder)
	{
		//TODO 
		return null;
	}
	
	/**
	 * Registrerer at PN ordinationen er anvendt på dagen dato
	 * @param ordination
	 * @param dato
	 * En dato for hvornår ordinationen anvendes tilføjes ordinationen.
	 * Hvis datoen ikke er indenfor ordinationens gyldighedsperiode kastes en RuntimeException 
	 */public static void ordinationPNAnvendt(PN ordination, GregorianCalendar dato){
		 //TODO
	}
	
	/**
	 * 
	 * @param patient
	 * @param lægemiddel
	 * @return den anbefalede dosis for den pågældende patient(der skal tages hensyn til patientens vægt)
	 * Det er en forskellig enheds faktor der skal anvendes, den er afhængig af patinetens vægt 
	 */
	
	public static double anbefaletDosisPrDøgn(Patient patient, Lægemiddel lægemiddel){
		double result = 0;
		if (patient.getVægt()<25)
			result = patient.getVægt()*lægemiddel.getEnhePrKgPrDøgnLet();
		else if (patient.getVægt()>120)
			result = patient.getVægt()*lægemiddel.getEnhePrKgPrDøgnTung();
		else 
			result = patient.getVægt()*lægemiddel.getEnhePrKgPrDøgnNormal();
		return result;
	}
	
	public static List<Patient> getAllPatienter(){
		return Dao.getAllPatienter();
	}
	
	public static List<Lægemiddel> getAllLægemidler(){
		return Dao.getAllLægemidler();
	}
	
	public static void createSomeObjects(){
		
		
		Dao.gemPatient(new Patient("Jane Jensen", "121256-0512", 63.4));
		Dao.gemPatient(new Patient("Finn Madsen", "070985-1153", 83.2));
		
		Dao.gemLægemiddel(new Lægemiddel("Pinex", 0.1,0.15,0.16, "Styk"));
		Dao.gemLægemiddel(new Lægemiddel("Paracetamol", 1,1.5,2, "Ml"));
		Dao.gemLægemiddel(new Lægemiddel("Fucidin", 0.025, 0.025, 0.025, "Styk"));
		Dao.gemLægemiddel(new Lægemiddel("ABC", 0.01,0.015,0.02, "Styk"));
	
		
//		opretPNOrdination(new GregorianCalendar(2007, 3,1), new GregorianCalendar(2007, 3,12), Dao.getAllPatienter().get(0), Dao.getAllLægemidler().get(1), 123);
//		opretPNOrdination(new GregorianCalendar(2007, 4,12), new GregorianCalendar(2007, 3,12), Dao.getAllPatienter().get(0), Dao.getAllLægemidler().get(0), 3);
//		
//		opretDagligFastOrdination(new GregorianCalendar(2007, 1,10), new GregorianCalendar(2007, 1,12), Dao.getAllPatienter().get(1), Dao.getAllLægemidler().get(1),2,-1,1,-1);
//		String[] kl = {"12:00", "12:40","16:00","18:45"};
//		double[] an = {0.5, 1, 2.5, 3};
//		opretDagligSkævOrdination(new GregorianCalendar(2007, 1,23), new GregorianCalendar(2007, 1,24), Dao.getAllPatienter().get(1), Dao.getAllLægemidler().get(2), kl, an);
	
	}


}
