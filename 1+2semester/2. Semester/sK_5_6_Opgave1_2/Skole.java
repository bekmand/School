package sK_5_6_Opgave1_2;

import java.util.ArrayList;

public class Skole {

	private String navn;
	private ArrayList<Studerende> studiner = new ArrayList<Studerende>();

	public Skole(String navn) {
		this.navn = navn;
	}

	public String getNavn() {
		return this.navn;
	}

	public void addStuderende(Studerende studerende) {
		studiner.add(studerende);
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
		boolean found = false;
		int i = 0;
		while (!found && i < studiner.size()) {
			s = studiner.get(i);
			if (s.getStudieNr() == studieNr) {
				found = true;
				s = studiner.get(i);
			} else {
				i++;
			}
		}
		return s;
	}

	public String toString() {
		return "Skole " + this.navn + studiner;
	}

}
