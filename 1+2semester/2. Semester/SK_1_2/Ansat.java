package SK_1_2;

import java.util.ArrayList;

public abstract class Ansat extends Person {
	
	private int svendeBrev�r;
	private double timeL�n;
	
	public Ansat(String navn, String adresse,
			double timeL�n){
		super(navn, adresse);
		this.timeL�n = timeL�n;

		
	}

	public abstract double beregnL�n(int antalTimer);
	
	public void setTimeL�n(double timeL�n){
		this.timeL�n = timeL�n;
	}
	public double getTimeL�n(){
		return this.timeL�n;
	}
}
