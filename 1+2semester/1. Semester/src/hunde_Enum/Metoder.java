package hunde_Enum;
import java.util.ArrayList;

public class Metoder {
	
	public static int samletPris(ArrayList<Dogs> hunde, DogRace race){
		int sum = 0;
		for(int i = 0; i < hunde.size(); i++){
			if(race.compareTo(hunde.get(i).getRace()) == 0){
				sum += hunde.get(i).getPris();
			}
		}
		return sum;
	}

}
