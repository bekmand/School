
package KajsBiler;


public class Kunde {
	private String navn;
	 
	private int cpr;
	 

	/**
	 * @param navn
	 * @param cpr
	 */
	public Kunde(String navn, int cpr) {
		this.navn = navn;
		this.cpr = cpr;
	}
	
	/**
	 * @return Returns the cpr.
	 */
	public int getCpr() {
		return cpr;
	}
	/**
	 * @param cpr  
	 */
	public void setCpr(int cpr) {
		this.cpr = cpr;
	}
	/**
	 * @return Returns the navn.
	 */
	public String getNavn() {
		return navn;
	}
	/**
	 * @param navn The navn to set.
	 */
	public void setNavn(String navn) {
		this.navn = navn;
	}
	 
	public String toString(){
		return navn +" " +cpr;
	}
}
