package bilUdlej;
import java.util.ArrayList;

public class Udlejning {
	private int nr;
	private int antalDage;
	private String dato;
	private ArrayList<Bil> bil;
	
	public Udlejning(int nr, String dato, int antalDage){
		this.nr = nr;
		this.dato = dato;
		this.antalDage = antalDage;
	}

}