package ordination;

public class Dosis {
	private String tid;
	private double antal;
	/**
	 * Opretter en ny dosis.
	 * Krav: tid er et lovligt tidpunkt på dagen, antal >= -1.
	 */
	public Dosis(String tid, double antal) {
		super();
		this.tid = tid;
		this.antal = antal;
	}
	public double getAntal() {
		return antal;
	}
	public void setAntal(double antal) {
		this.antal = antal;
	}
	public String getTid() {
		return tid;
	}
	public void setTid(String tid) {
		this.tid = tid;
	}
	public String toString(){
		return "Kl: " + tid + "   antal:  " + antal;
	}

}
