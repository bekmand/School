package SK_1_2;

public class Synsmand extends Mekaniker {

	private int synPrUge;
	private int svendeBrevÅr;

	public Synsmand(String navn, String adresse, int svendeBrevÅr,
			int UdVærkfører, int synPrUge) {
		super(navn, adresse, svendeBrevÅr, 0);

		this.synPrUge = synPrUge;
	}

	@Override
	public double beregnLøn() {
		double ugeLøn = synPrUge * 290;
		return ugeLøn;
	}
}
