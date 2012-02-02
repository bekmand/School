package model;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Ordre {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ID;
	private int nummer;
	@OneToMany(cascade={CascadeType.PERSIST, CascadeType.REMOVE})
	@JoinColumn
	private List<OrdreLinje> ordrelinjer;

	public Ordre(){}
	
	public Ordre(int nummer, Kunde kunde) {
		this.nummer = nummer;
		ordrelinjer = new ArrayList<OrdreLinje>();
		kunde.addOrdre(this);
	}

	public int getNummer() {
		return nummer;

	}

	public void createOrdreLinie(int linieNr, int antalStk, Vare vare) {
		OrdreLinje ol = new OrdreLinje(linieNr, antalStk, vare);
		ordrelinjer.add(ol);
	}

	public Iterator<OrdreLinje> getOrdreLinjer() {
		return ordrelinjer.iterator();
	}

	public double samletPris() {
		double pris = 0;
		Iterator<OrdreLinje> itr = getOrdreLinjer();

		while (itr.hasNext()) {
			pris += itr.next().pris();
		}
		return pris;
	}

}
