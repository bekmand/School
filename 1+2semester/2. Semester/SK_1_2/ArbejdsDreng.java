package SK_1_2;

public class ArbejdsDreng extends Ansat{

	public ArbejdsDreng(String navn, String adresse, double timeL�n){
		super(navn, adresse, timeL�n);
		
	}
	
	public double beregnL�n(int antalTimer){
		return super.getTimeL�n() * antalTimer;
		}
}
