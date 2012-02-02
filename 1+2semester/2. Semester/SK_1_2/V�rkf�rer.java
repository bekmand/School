package SK_1_2;

public class V�rkf�rer extends Ansat {

	private int udV�rkf�rer;
	private double ugeTill�g;

	public V�rkf�rer(String navn, String adresse, int svendeBrev�r,
			double timeL�n, int UdV�rkf�rer, double UgeTill�g) {
		super(navn, adresse, timeL�n);
		this.udV�rkf�rer = UdV�rkf�rer;
		this.ugeTill�g = UgeTill�g;
	}

	@Override
	public double beregnL�n(int antalTimer) {
		double v�rkF�rerL�n = super.beregnL�n(antalTimer) + this.ugeTill�g;
		return v�rkF�rerL�n;

	}
}
