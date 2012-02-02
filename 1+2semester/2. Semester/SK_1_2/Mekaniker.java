package SK_1_2;

public class Mekaniker extends Ansat{
	private int svendeBrevÅr;
	private double timeLøn;

	public Mekaniker(String navn, String adresse, int svendeBrevÅr,
			double timeLøn) {
		super(navn, adresse, timeLøn);
//		this.svendeBrevÅr = SvendeBrevÅr;
//		this.timeLøn = TimeLøn;
	}
	public double beregnLøn(int antalTimer){
		double mekanikerLøn = timeLøn*antalTimer;
		return mekanikerLøn;
	}
	public int getSvendeBrevÅr(){
		return this.svendeBrevÅr;
	}
	public double getTimeLøn(){
		return this.timeLøn;
	}
	public void updateSvendeBrevÅr(int SvendeBrevÅr){
		this.svendeBrevÅr = SvendeBrevÅr;
	}
	public void updateTimeLøn(int TimeLøn){
		this.timeLøn = TimeLøn;
	}
}
