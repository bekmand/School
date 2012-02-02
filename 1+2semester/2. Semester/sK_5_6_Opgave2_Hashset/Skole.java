package sK_5_6_Opgave2_Hashset;

import java.util.HashSet;
import java.util.Iterator;

public class Skole {

	private String navn;
	private HashSet<Studerende> studiner = new HashSet<Studerende>();

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
		int index = 0;
		double karakterer = 0;
		double skoleKarakter = 0;
		Iterator it = studiner.iterator();
		while (it.hasNext()) {
			Studerende stud = (Studerende) it.next();
			while (!stud.getKarakterer().isEmpty() && index < stud.getKarakterer().size()) {
				karakterer += stud.getKarakterer().get(index);
				index++;
			}
			skoleKarakter += stud.getKarakterer().size();
		}
		return skoleKarakter / studiner.size();
	}

	public Studerende findStuderende(int studieNr) {
		Studerende s = null;
		Iterator<Studerende> itr = studiner.iterator();
		boolean found = false;
		while (!found && itr.hasNext()) {
			s = itr.next();
			if (s.getStudieNr() == studieNr) {
				found = true;
			}
		}
		if(found == false){
			s = null;
		}
		return s;
	}

	public String toString() {
		return "Skole " + this.navn + studiner;
	}

}
