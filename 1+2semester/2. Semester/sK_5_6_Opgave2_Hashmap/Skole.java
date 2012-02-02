package sK_5_6_Opgave2_Hashmap;

import java.util.HashMap;
import java.util.Iterator;

public class Skole {

	private String navn;
	private HashMap<Integer, Studerende> studiner = new HashMap<Integer, Studerende>();
	public Skole(String navn) {
		this.navn = navn;
	}
	public String getNavn() {
		return this.navn;
	}

	public void addStuderende(int studieNr, Studerende studerende) {
		studiner.put(studieNr, studerende);
	}

	public void removeStuderende(Studerende studerende) {
		studiner.remove(studerende);
	}

	public double gennemsnit() {
		double karakterer = 0;
		double skoleKarakter = 0;
		Iterator<Studerende> it = studiner.values().iterator();
		while(it.hasNext()) {
			Studerende s = it.next();
			for (int j = 0; j < s.getKarakterer().size()-1; j++) {
				karakterer += s.getKarakterer().get(j);
			}
			skoleKarakter += karakterer
					/ s.getKarakterer().size();
		}
		return skoleKarakter / studiner.size();
	}

	public Studerende findStuderende(int studieNr) {
		Studerende s = null;
		
		if(studiner.containsKey(studieNr)){
			s = studiner.get(studieNr);
		}
		
		return s;
	}

	public String toString() {
		return "Skole " + this.navn + studiner;
	}

}
