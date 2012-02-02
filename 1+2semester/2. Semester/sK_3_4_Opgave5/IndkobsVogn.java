package sK_3_4_Opgave5;

import java.util.ArrayList;

public class IndkobsVogn {

	private ArrayList<Vare> varer = new ArrayList();

	public IndkobsVogn() {

	}

	public ArrayList<Vare> addVare(Vare vare) {
		varer.add(vare);

		return varer;
	}
	
	public double getSamletPris(){
		double pris = 0;
		for(Vare v: varer){
			pris += v.getBruttoPris();
		}
		return pris;
	}

	public void udskrivBon() {
		System.out.println("Tak fordi du handlede hos Tide-Shoppen");
		System.out.println();
		System.out.println(varer.toString());
		System.out.println();
		System.out.println("Du blev betjent af Lars");
		System.out.println();
		System.out.println();
		System.out.println("Beløb: " + getSamletPris());
		System.out.println("Dette er din bon og på gensyn");
	}

}
