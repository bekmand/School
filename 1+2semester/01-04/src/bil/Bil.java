package bil;
import java.util.ArrayList;

public class Bil {
	private String nr;
	private int prisPrDag;
	private int anskafÅr;
	//private ArrayList<Udlejning> udlejninger = new ArrayList<Udlejning>();

	
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
	/*public void addUdlejning(Udlejning udlejning){
		udlejninger.add(udlejning);
	}
	public void removeUdlejning(Udlejning udlejning){
		udlejninger.remove(udlejning);
	}
	*/
	
	
}