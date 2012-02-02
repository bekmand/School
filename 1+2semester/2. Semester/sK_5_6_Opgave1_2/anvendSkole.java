package sK_5_6_Opgave1_2;

public class anvendSkole {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Skole s = new Skole("DatamatikerSkolen");

		Studerende st = new Studerende("Bekmand", 2);
		Studerende st2 = new Studerende("Cederdoff", 5);
		Studerende st3 = new Studerende("Rita", 1);
		Studerende st4 = new Studerende("Tidemand", 7);
		Studerende st5 = new Studerende("Lars", 6);
		Studerende st6 = new Studerende("Stendorf", 3);
		Studerende st7 = new Studerende("Carsten", 4);
		
		st.addKarakter(5);
		st2.addKarakter(2);
		st3.addKarakter(6);
		st4.addKarakter(9);
		st5.addKarakter(10);
		st6.addKarakter(13);
		st7.addKarakter(4);

		s.addStuderende(st);
		s.addStuderende(st2);
		s.addStuderende(st3);
		s.addStuderende(st4);
		s.addStuderende(st5);
		s.addStuderende(st6);
		s.addStuderende(st7);
		
		System.out.println(s.findStuderende(3));
		System.out.println();
		System.out.println(s);
		System.out.println();
		System.out.println(s.gennemsnit());
		

	}

}
