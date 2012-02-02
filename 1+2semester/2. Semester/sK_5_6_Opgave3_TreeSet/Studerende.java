package sK_5_6_Opgave3_TreeSet;

import java.util.ArrayList;

public class Studerende implements Comparable<Studerende> {

	private int studieNr;
	private String navn;
	private ArrayList<Integer> karakterer = new ArrayList<Integer>();

	public Studerende(String navn, int studieNr) {
		this.navn = navn;
		this.studieNr = studieNr;

	}

	public int getStudieNr() {
		return this.studieNr;
	}

	public String getNavn() {
		return this.navn;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}

	public void addKarakter(int karakter) {
		karakterer.add(karakter);
	}

	public ArrayList<Integer> getKarakterer() {
		return karakterer;
	}

	public String toString() {
		return "Navn: " + this.navn + " - " + "StudieNr: " + this.studieNr
				+ "." + "\n";
	}

	public int compareTo(Studerende s) {
		if (s.getStudieNr() - this.studieNr > 0) {
			return 1;
		}
		if (s.getStudieNr() - this.studieNr < 0) {
			return -1;
		}
		if (s.getStudieNr() - this.studieNr == 0) {
			return 0;
		}
		return 0;
	}
}
