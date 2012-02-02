package SK_1_2;

import java.util.ArrayList;

public abstract class Ansat extends Person {
	
	private int svendeBrevÅr;
	private double timeLøn;
	
	public Ansat(String navn, String adresse,
			double timeLøn){
		super(navn, adresse);
		this.timeLøn = timeLøn;

		
	}

	public abstract double beregnLøn(int antalTimer);
	
	public void setTimeLøn(double timeLøn){
		this.timeLøn = timeLøn;
	}
	public double getTimeLøn(){
		return this.timeLøn;
	}
}
