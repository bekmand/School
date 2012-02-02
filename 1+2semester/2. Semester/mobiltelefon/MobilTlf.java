package mobiltelefon;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class MobilTlf {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ID;
	private int nummer;
	private String fabrikant;
	private String model;
	private int pris;
	private Design designModel;
	

	public MobilTlf(){}
	
	public MobilTlf(String fabrikant, String model, int nummer, Design designModel){
		this.fabrikant = fabrikant;
		this.model = model;
		this.nummer = nummer;
		this.designModel = designModel;
	}
	
	public String toString(){
		return "Mobiltelefon: " + this.fabrikant + " Model: " + this.model + " tlf Nummer: " + this.nummer + " design: "
				+ this.designModel;
	}
}
