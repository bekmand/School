package bil;
import java.util.ArrayList;

public class Udlejning {
	
	private int nr;
	
	private int antalDage;
	
	private String dato;
	
	private ArrayList<Bil> biler = new ArrayList<Bil>();
	
	public Udlejning(int nr, String dato, int antalDage){
		this.nr = nr;
		this.dato = dato;
		this.antalDage = antalDage;
	}
	
	public void setAntalDage(int antalDage){
		this.antalDage = antalDage;
	}
	
	public int getNr(){
		return nr;
	}
	
	public void setNr(int nr){
		this.nr = nr;
	}
	
	public int getAntalDage(){
		return antalDage;
	}
	
	public String getDato(){
		return dato;
	}
	
	public void setDato(String dato){
		this.dato = dato;
	}
	
	public void addBil(Bil bil){
		biler.add(bil);
	}
	
	public void removeBil(Bil bil){
		biler.remove(bil);
	}
	
	public void getPris(){
		int x = 0;
		for(Bil b : biler){
			x += b.getPris()*getAntalDage();
		}
		System.out.println(x);
	}
	
}

