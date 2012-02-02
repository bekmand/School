package dSBforenkelt;
import java.util.ArrayList;

public class Tog {
	private String rute;
	private int nr;
	private int antalPladser;
	private ArrayList<Plads> pladser = new ArrayList<Plads>();
	
	public Tog(String rute, int nr, int antalPladser){
		this.rute = rute;
		this.nr = nr;
		this.antalPladser = antalPladser;
		create();
	}
	
	public String getRute(){
		return this.rute;
	}
	
	public int getNr(){
		return this.nr;
	}
	
	public void createPlads(){
		antalPladser++;
		Plads p = new Plads(antalPladser);
		pladser.add(p);
		
	}
	
	public void setReserveret(int nr, boolean reserveret){
		if(pladser.get(nr).isReserveret() == true){
			System.out.println("Pladsen er Reserveret");
		}
		else{
			pladser.get(nr).setReserveret();
		}
	}
	
	public boolean isReserveret(int nr){
		return pladser.get(nr).isReserveret();
	}
	
	public int isNotReserveret(){
		int r = 0;
		for(int i = 0; i < pladser.size(); i++){
			if(isReserveret(r) == false){
				r++;
			}
		}
		return r;
	}
	
	public void create(){ 
	int i = 1;
	while(i <= antalPladser){
		Plads p = new Plads(i);
		pladser.add(p);
		i++;
	}
	}

}
