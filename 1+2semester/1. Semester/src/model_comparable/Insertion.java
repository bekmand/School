package model_comparable;
import java.util.ArrayList;

public class Insertion {
	
	public static void insertKunde(ArrayList<Kunde> kunder, Kunde kunde){
		boolean found = false;
		int i = 0;
		
		while(!found && i < kunder.size()){
		
			if(kunder.get(i).compareTo(kunde) > 0){
				found = true;
			}
			else
				i++;
		}
		kunder.add(i, kunde);
	}
	public static void inserKundeArray(Kunde[] kunder, Kunde kunde){
		
		int position = kunder.length;
		while(position > 0 && kunder[position-1] == null)
			position--;
		
		while(position > 0 && kunder[position-1].compareTo(kunde) > 0){
			kunder[position] = kunder[position-1];
			position--;
		}
		kunder[position] = kunde;
	}
}

