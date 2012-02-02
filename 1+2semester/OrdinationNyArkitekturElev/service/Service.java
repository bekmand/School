package service;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import dao.Dao;

import ordination.DagligFast;
import ordination.DagligSk�v;
import ordination.L�gemiddel;
import ordination.PN;
import ordination.Patient;



public class Service {
	
	/**
	 * Opretter PN Ordination
	 * @return opretter og returnerer en PN ordination
	 */
	public static PN opretPNOrdination(GregorianCalendar startDen, GregorianCalendar slutDen, Patient patient, L�gemiddel l�gemiddel,double antal){
		//TODO
		return null;
	}
	
	/**
	 * 
	 * Opretter DagligFast ordination
	 * @return opretter og returnerer en DagligFast ordination
	 * Bem�rk: negativ antal betyder ingen dosis p� dette tidspunkt
	 */
	public static DagligFast opretDagligFastOrdination(GregorianCalendar startDen, GregorianCalendar slutDen, Patient patient, L�gemiddel l�gemiddel,double morgenAntal, double middagAntal, double aftenAntal, double natAntal){
		//TODO
		return null;
	}
	/**
	 * Opretter daglig sk�v ordination
	 * Krav: antalEnheder og klokkeSl�t har samme l�ngde. klokkeSl�t indeholder tidspunkter p� dagen p� formen 15:30
	 * @return opretter og returnerer en DagligSk�v ordination
	 */
	public static DagligSk�v opretDagligSk�vOrdination(GregorianCalendar startDen, GregorianCalendar slutDen, Patient patient, L�gemiddel l�gemiddel,String[] klokkeSl�t, double[] antalEnheder)
	{
		//TODO 
		return null;
	}
	
	/**
	 * Registrerer at PN ordinationen er anvendt p� dagen dato
	 * @param ordination
	 * @param dato
	 * En dato for hvorn�r ordinationen anvendes tilf�jes ordinationen.
	 * Hvis datoen ikke er indenfor ordinationens gyldighedsperiode kastes en RuntimeException 
	 */public static void ordinationPNAnvendt(PN ordination, GregorianCalendar dato){
		 //TODO
	}
	
	/**
	 * 
	 * @param patient
	 * @param l�gemiddel
	 * @return den anbefalede dosis for den p�g�ldende patient(der skal tages hensyn til patientens v�gt)
	 * Det er en forskellig enheds faktor der skal anvendes, den er afh�ngig af patinetens v�gt 
	 */
	
	public static double anbefaletDosisPrD�gn(Patient patient, L�gemiddel l�gemiddel){
		double result = 0;
		if (patient.getV�gt()<25)
			result = patient.getV�gt()*l�gemiddel.getEnhePrKgPrD�gnLet();
		else if (patient.getV�gt()>120)
			result = patient.getV�gt()*l�gemiddel.getEnhePrKgPrD�gnTung();
		else 
			result = patient.getV�gt()*l�gemiddel.getEnhePrKgPrD�gnNormal();
		return result;
	}
	
	public static List<Patient> getAllPatienter(){
		return Dao.getAllPatienter();
	}
	
	public static List<L�gemiddel> getAllL�gemidler(){
		return Dao.getAllL�gemidler();
	}
	
	public static void createSomeObjects(){
		
		
		Dao.gemPatient(new Patient("Jane Jensen", "121256-0512", 63.4));
		Dao.gemPatient(new Patient("Finn Madsen", "070985-1153", 83.2));
		
		Dao.gemL�gemiddel(new L�gemiddel("Pinex", 0.1,0.15,0.16, "Styk"));
		Dao.gemL�gemiddel(new L�gemiddel("Paracetamol", 1,1.5,2, "Ml"));
		Dao.gemL�gemiddel(new L�gemiddel("Fucidin", 0.025, 0.025, 0.025, "Styk"));
		Dao.gemL�gemiddel(new L�gemiddel("ABC", 0.01,0.015,0.02, "Styk"));
	
		
//		opretPNOrdination(new GregorianCalendar(2007, 3,1), new GregorianCalendar(2007, 3,12), Dao.getAllPatienter().get(0), Dao.getAllL�gemidler().get(1), 123);
//		opretPNOrdination(new GregorianCalendar(2007, 4,12), new GregorianCalendar(2007, 3,12), Dao.getAllPatienter().get(0), Dao.getAllL�gemidler().get(0), 3);
//		
//		opretDagligFastOrdination(new GregorianCalendar(2007, 1,10), new GregorianCalendar(2007, 1,12), Dao.getAllPatienter().get(1), Dao.getAllL�gemidler().get(1),2,-1,1,-1);
//		String[] kl = {"12:00", "12:40","16:00","18:45"};
//		double[] an = {0.5, 1, 2.5, 3};
//		opretDagligSk�vOrdination(new GregorianCalendar(2007, 1,23), new GregorianCalendar(2007, 1,24), Dao.getAllPatienter().get(1), Dao.getAllL�gemidler().get(2), kl, an);
	
	}


}
