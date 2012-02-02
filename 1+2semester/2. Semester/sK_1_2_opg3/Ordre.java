package sK_1_2_opg3;

import java.util.ArrayList;
import java.util.Iterator;

public class Ordre {
	private int nummer;

	private ArrayList<OrdreLinje> ordrelinjer;

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
