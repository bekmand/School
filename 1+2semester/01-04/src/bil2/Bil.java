package bil2;
import java.util.ArrayList;

public class Bil {
	private String nr;
	private int prisPrDag;
	private int anskafÅr;
	private ArrayList<Udlejning> udlejninger = new ArrayList<Udlejning>();

	
	public Bil (String nr, int anskafÅr){
		this.nr = nr;
		this.anskafÅr = anskafÅr;
	}
	
	public void setPris(int pris){
		this.prisPrDag = pris;
	}
	public int getPris(){
		return prisPrDag;
	}
	public String getNr(){
		return nr;
	}
	public int getÅr(){
		return anskafÅr;
	}
	
	/**
	 * En vejs link mellem Udlejning og bil
	 * @param udlejning
	 */
	
	public void addUdlejningUD(Udlejning udlejning){
		udlejninger.add(udlejning);
	}
	public void removeUdlejningUD(Udlejning udlejning){
		udlejninger.remove(udlejning);
	}
	
	/**
	 * To vejs link mellem Udlejning og bil
	 * @param udlejning
	 */
	
	public void addUdlejning(Udlejning udlejning){
		this.addUdlejningUD(udlejning);
		udlejning.addBilUD(this);
	}
	public void removeUdlejning(Udlejning udlejning){
		udlejning.removeBilUD(this);
		this.removeUdlejningUD(udlejning);
		
	}
	
	/**
	 * Metode til at finde max antal dage en bil har været udlejet
	 */
	
	public void maxUdlejetBil(){
		int i = 0;
		for(Udlejning u : udlejninger){
			if(i < u.getAntalDage()){
				i = u.getAntalDage();
			}
		}
		System.out.println(i);
	}
}
