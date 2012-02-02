package model;

public class Abonnement {
	private boolean ugentlig;
	private Størrelse størrelse;
	private Kasse kasse;
	
	Abonnement(boolean ugentlig, Størrelse størrelse){
		this.ugentlig = ugentlig;
		this.størrelse = størrelse;
	}
	
	public double getKassePris(){
		double pris = 0.0;
		if(størrelse == Størrelse.SINGLE){
			pris = getKasse().getPris();
		}
		if(størrelse == Størrelse.DOUBLE){
			pris = getKasse().getPris() * 1.75;
		}
		if(størrelse == Størrelse.FAMILY){
			pris = getKasse().getPris() * 2.5;
		}
		
		return pris;
	}
	
	public boolean getUgentlig(){
		return ugentlig;
	}
	
	public Størrelse getStørrelse(){
		return størrelse;
	}
	
	public Kasse getKasse(){
		return kasse;
	}
	
	public void setKasse(Kasse kasse){
		this.kasse = kasse;
	}
	
	public void setUgentlig(boolean ugentlig){
		this.ugentlig = ugentlig;
	}
	
	public void setStørrelse(Størrelse størrelse){
		this.størrelse = størrelse;
	}

}
