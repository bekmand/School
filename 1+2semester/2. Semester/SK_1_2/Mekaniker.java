package SK_1_2;

public class Mekaniker extends Ansat{
	private int svendeBrev�r;
	private double timeL�n;

	public Mekaniker(String navn, String adresse, int svendeBrev�r,
			double timeL�n) {
		super(navn, adresse, timeL�n);
//		this.svendeBrev�r = SvendeBrev�r;
//		this.timeL�n = TimeL�n;
	}
	public double beregnL�n(int antalTimer){
		double mekanikerL�n = timeL�n*antalTimer;
		return mekanikerL�n;
	}
	public int getSvendeBrev�r(){
		return this.svendeBrev�r;
	}
	public double getTimeL�n(){
		return this.timeL�n;
	}
	public void updateSvendeBrev�r(int SvendeBrev�r){
		this.svendeBrev�r = SvendeBrev�r;
	}
	public void updateTimeL�n(int TimeL�n){
		this.timeL�n = TimeL�n;
	}
}
