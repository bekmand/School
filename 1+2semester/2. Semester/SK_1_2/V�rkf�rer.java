package SK_1_2;

public class Værkfører extends Ansat {

	private int udVærkfører;
	private double ugeTillæg;

	public Værkfører(String navn, String adresse, int svendeBrevÅr,
			double timeLøn, int UdVærkfører, double UgeTillæg) {
		super(navn, adresse, timeLøn);
		this.udVærkfører = UdVærkfører;
		this.ugeTillæg = UgeTillæg;
	}

	@Override
	public double beregnLøn(int antalTimer) {
		double værkFørerLøn = super.beregnLøn(antalTimer) + this.ugeTillæg;
		return værkFørerLøn;

	}
}
