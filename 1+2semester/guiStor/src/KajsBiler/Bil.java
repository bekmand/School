
package KajsBiler;


public class Bil {
	 
	private String m�rke;
	private int regnr;
	
	/**
	 * @param regnr
	 * @param m�rke
	 */
	public Bil(  int regnr, String m�rke ) {
		 
		this.regnr = regnr;
		this.m�rke = m�rke;
		 
	}
	 
	/**
	 * @return  
	 */
	public String getM�rke() {
		return m�rke;
	}
	/**
	 * @param navn 
	 */
	public void setM�rke(String m�rke) {
		this.m�rke = m�rke;
	}
	 
	/**
	 * @return  
	 */
	public int getRegnr() {
		return regnr;
	}
	/**
	 * @param  
	 */
	public void setRegnr(int regnr) {
		this.regnr = regnr;
	}
	 
	
	public String toString(){
		return regnr+" " +m�rke;
	}
}
