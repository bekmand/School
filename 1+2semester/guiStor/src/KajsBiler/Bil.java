
package KajsBiler;


public class Bil {
	 
	private String mærke;
	private int regnr;
	
	/**
	 * @param regnr
	 * @param mærke
	 */
	public Bil(  int regnr, String mærke ) {
		 
		this.regnr = regnr;
		this.mærke = mærke;
		 
	}
	 
	/**
	 * @return  
	 */
	public String getMærke() {
		return mærke;
	}
	/**
	 * @param navn 
	 */
	public void setMærke(String mærke) {
		this.mærke = mærke;
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
		return regnr+" " +mærke;
	}
}
