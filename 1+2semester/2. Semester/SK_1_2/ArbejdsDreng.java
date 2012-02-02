package SK_1_2;

public class ArbejdsDreng extends Ansat{

	public ArbejdsDreng(String navn, String adresse, double timeLøn){
		super(navn, adresse, timeLøn);
		
	}
	
	public double beregnLøn(int antalTimer){
		return super.getTimeLøn() * antalTimer;
		}
}
