package SK_1_2;

public class Synsmand extends Mekaniker {

	private int synPrUge;
	private int svendeBrev�r;

	public Synsmand(String navn, String adresse, int svendeBrev�r,
			int UdV�rkf�rer, int synPrUge) {
		super(navn, adresse, svendeBrev�r, 0);

		this.synPrUge = synPrUge;
	}

	@Override
	public double beregnL�n() {
		double ugeL�n = synPrUge * 290;
		return ugeL�n;
	}
}
