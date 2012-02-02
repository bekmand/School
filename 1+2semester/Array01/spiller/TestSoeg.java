package spiller;

import java.util.ArrayList;

public class TestSoeg {
	public static void main(String[] args) {

		ArrayList<Spiller> spillere = new ArrayList<Spiller>();
		
		Soeg se1 = new Soeg();
		
		Spiller s1 = new Spiller("jango", 188, 83, 2);
		Spiller s2 = new Spiller("hango", 189, 89, 3);
		Spiller s3 = new Spiller("kango", 196, 79, 4);
		Spiller s4 = new Spiller("pango", 166, 76, 55);
		Spiller s5 = new Spiller("rango", 169, 80, 55);
		spillere.add(s1);
		spillere.add(s2);
		spillere.add(s3);
		spillere.add(s4);
		spillere.add(s5);
		
		System.out.println(se1.findScoreLineær(spillere, 4));
		System.out.println(se1.findScoreBineær(spillere, 4));
		System.out.println(se1.findGodSpiller(spillere));

	}

}
