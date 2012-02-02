package sK_5_6_Opgave3_TreeMap;

import java.util.HashMap;

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
		for (int i = 0; i < studiner.size(); i++) {
			for (int j = 0; j < studiner.get(i).getKarakterer().size(); j++) {
				karakterer += studiner.get(i).getKarakterer().get(j);
			}
			skoleKarakter += karakterer
					/ studiner.get(i).getKarakterer().size();
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
