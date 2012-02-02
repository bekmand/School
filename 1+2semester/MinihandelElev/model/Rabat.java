package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Rabat {
	@Id
	@GeneratedValue
	private int ID;
	
	
	public Rabat(){
		
	}
	public double rabatBeloeb(double beloebUdenRabat){

		return beloebUdenRabat;
	}



}
