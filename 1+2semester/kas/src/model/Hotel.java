package model;

public class Hotel {
	private String navn;
	private double prisEnkelt;
	private double prisDoublet;
	private double tillæg;
	
	public Hotel (String navn, double prisEnkelt, double prisDoublet, double tillæg){
		this.navn = navn;
		this.prisEnkelt = prisEnkelt;
		this.prisDoublet = prisDoublet;
		this.tillæg = tillæg;
	}
	
	public double getPrisDouble(){
		return prisDoublet;
	}
	
	public double getPrisEnkel(){
		return prisEnkelt;
	}
	
	public double getTillæg(){
		return tillæg;
	}
	
	public String toString(){
		return this.navn+" "+this.prisEnkelt+" "+this.prisDoublet+" "+this.tillæg;
	}

}
