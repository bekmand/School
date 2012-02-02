package model_studmedGUI;


/**
 * Write a description of class Studerende here.
 * 
 * @author (Margrethe Dybdahl) 
 * @version (20.09.2010)
 */
public class Studerende
{
  /*
	 * Attributter der beskriver den studerendes tilstand
	 */
	private String navn;
	private boolean aktiv;
	private int alder;
	
	/*
	 * Constructor, n�r den studerende oprettes, skal den have et navn.
	 * Ved oprettelse er den studerende ikke aktiv
	 */
	public Studerende(String navn){
		this.navn = navn;
		this.alder = -1;
		this.aktiv = false;
	}
	/*
	 * Constructor, n�r den studerende oprettes, skal den have et navn.
	 * Ved oprettelse er den studerende ikke aktiv
	 */
	public Studerende(String navn, int alder){
		this.navn = navn;
		this.alder = alder;
		this.aktiv = false;
	}
	/*
	 * Man kan f� oplyst den studerendes alder, ved at kalde metoden getAlder
	 */
	public int getAlder(){
		return alder;
	}
	/*
	 * Den studerendes alder kan �ndres ved kald af setAlder metoden
	 */
	public void setAlder(int alder){
		this.alder = alder;
	}
	/*
	 * Den studerendes navn kan �ndres ved kald af setNavn metoden
	 */
	public void setNavn(String navn){
		this.navn = navn;
	}
	
	/*
	 * Man kan f� oplyst den studerendes navn, ved at kalde metoden getNavn
	 */
	public String getNavn(){
		return navn;
	}
	
	/*
	 * Den studerendes kan f� �ndret aktivitets status ved at kalde metoden setStatus
	 */
	public void setAktiv(boolean aktiv){
		this.aktiv = aktiv;
	}
	
	/*
	 * Man kan f� oplyst den studerendes aktivitet, ved at kalde metoden isAktiv
	 */
	public boolean isAktiv(){
		return aktiv;
	}
	
	public void fødselsdag(){
		alder++;
	}

}
