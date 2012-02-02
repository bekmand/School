package gave;
import java.util.ArrayList;

public class Person {
	private String navn;
	private int alder;
	private ArrayList<Gave> gaver = new ArrayList<Gave>();
	
	public Person(String navn, int alder){
		this.navn = navn;
		this.alder = alder;
	}
	
	public void setAlder(int alder){
		this.alder = alder;
	}
	
	

}
