package sK_1_2_opg3;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

public class Kunde {
	private String navn;

	private Date foedt;

	private ArrayList<Ordre> ordrer;
	
	private Rabat rabat;

	public Kunde(String navn, Date foedt) {
		this.navn = navn;
		this.foedt = foedt;
		ordrer = new ArrayList<Ordre>();
	}

	public String getNavn() {
		return navn;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}

	public Date getFoedt() {
		return foedt;
	}

	public void addOrdre(Ordre ordre) {
		ordrer.add(ordre);
	}

	public void removeOrdre(Ordre ordre) {
		ordrer.remove(ordre);
	}

	public Iterator<Ordre> getOrdrer() {
		return ordrer.iterator();
	}

	public double samletKoeb() {
		double samletPris = 0;
		Iterator<Ordre> itr = getOrdrer();
		while (itr.hasNext()) {
			samletPris += itr.next().samletPris();
		}
		return samletPris;
	}
	
	public void setRabat(Rabat rabat){
		this.rabat = rabat;
	}
	public Rabat getRabat(){
		return this.rabat;
	}
	

}
