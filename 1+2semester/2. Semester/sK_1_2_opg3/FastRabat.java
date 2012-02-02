package sK_1_2_opg3;

public class FastRabat extends Rabat{
	
	private double rabatBeloeb;
	private double nedreGraense;
	
	public FastRabat(double nedreGraense, double rabatBeloeb){
		
		this.nedreGraense = nedreGraense;
		this.rabatBeloeb = rabatBeloeb;
	}
	@Override
	public double rabatBeloeb(double beloebUdenRabat){
		
		if(beloebUdenRabat >= nedreGraense){
		beloebUdenRabat -= rabatBeloeb;	
		}
		return beloebUdenRabat;
	}
}
