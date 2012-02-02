package model;
import java.util.ArrayList;

public class Kunde implements Comparable<Kunde>{
	private int id;
	private String navn;
	private ArrayList<Abonnement> abonnement = new ArrayList<Abonnement>();
	
	
	public Kunde(int id, String navn){
		this.id = id;
		this.navn = navn;
	}
	
	public int getId(){
		return id;
	}
	
	public String getNavn(){
		return navn;
	}
	
	public void setId(int id){
		this.id = id;
	}
	
	public void setNavn(String navn){
		this.navn = navn;
	}
	
	public ArrayList<Abonnement> getAbonnement(){
		return new ArrayList<Abonnement>(abonnement);
	}
	
	public void createAbonnement(boolean ugentlig, Størrelse størrelse){
		abonnement.add(new Abonnement(ugentlig, størrelse));
	}
	
	public double getMånedsPris(){
		double pris = 0.0;
		
		for(int i = 0; i < abonnement.size(); i++){
			if(abonnement.get(i).getUgentlig() == true)
				pris += abonnement.get(i).getKassePris() * 4;
			else
				pris += abonnement.get(i).getKassePris() * 2;
		}
		
		return pris;
	}
	
	public boolean harUgeAbonnement(String kategori){
		boolean found = false;
		for(int i = 0; i<abonnement.size(); i++){
			if(abonnement.get(i).getUgentlig() == true && abonnement.get(i).getKasse().getKategori().equalsIgnoreCase(kategori))
				found = true;
		}
		return found;
	}

	@Override
	public int compareTo(Kunde arg0) {
		int tal = 0;
		// TODO Auto-generated method stub
		tal = this.id - arg0.getId();
		
		return tal;
	}
	
	
}
