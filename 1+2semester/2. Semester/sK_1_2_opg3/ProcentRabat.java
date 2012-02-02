package sK_1_2_opg3;

public class ProcentRabat extends Rabat{
	
	private double rabatProcent;
	
	public ProcentRabat(double rabatProcent){
		this.rabatProcent = rabatProcent / 100;
	}
	
	@Override
	public double rabatBeloeb(double beloebUdenRabat){
		return beloebUdenRabat -= beloebUdenRabat * rabatProcent;
		
	}
}
