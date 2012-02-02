package hunde_Enum;
import java.util.ArrayList;

public class TestMetoder {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<Dogs> hunde = new ArrayList<Dogs>();
		
		Dogs d1 = new Dogs("Charlie", false, 1000, DogRace.TERRIER);
		Dogs d2 = new Dogs("Freya", true, 10000, DogRace.PUDDEL);
		Dogs d3 = new Dogs("Tanya", true, 4000, DogRace.BOKSER);
		Dogs d4 = new Dogs("Ronya", true, 4500, DogRace.BOKSER);
		
		hunde.add(d1);
		hunde.add(d2);
		hunde.add(d3);
		hunde.add(d4);
		
		System.out.println(Metoder.samletPris(hunde, DogRace.BOKSER));

	}

}
