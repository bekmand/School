package bilUdlej;

public class Bil {
	private String nr;
	private int prisPrDag;
	private int anskafÅr;
	
	/**
	 * Initialiser en ny bil, med nr pris pr dag og anskaffelses år.
	 * 
	 * @param nr
	 * @param prisPrDag
	 * @param anskafÅr
	 */
	
	
	public Bil(String nr, int prisPrDag, int anskafÅr){
		this.nr = nr;
		this.prisPrDag = prisPrDag;
		this.anskafÅr = anskafÅr;
	}

	public void addBil(){
		
	}
	
	public String getNr(){
		return nr;
	}

	public int getPrisPrDag(){
		return prisPrDag;
	}
	
	public int getAnskafÅr(){
		return anskafÅr;
	}

	public void setPrisPrDag(int prisPrDag){
		this.prisPrDag = prisPrDag;
	}
}
