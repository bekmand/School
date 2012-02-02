package spiller;

import java.util.ArrayList;
import java.util.Iterator;

public class Soeg {
//	private ArrayList<Spiller> spillere = new ArrayList();
	
	public Spiller findScoreLineær(ArrayList<Spiller> spillere, int score){
		boolean found = false;
		int i = 0;
		Spiller spiller = null;
		
		while(!found && i < spillere.size()){
			spiller = spillere.get(i);
			if(spiller.getMaal() == score){
				found = true;
			}
			else
				i++;
		}
	return spiller;
	}
	
	public Spiller findScoreBineær(ArrayList<Spiller> spillere, int score){
		boolean found = false;
		int left = 0;
		int right = spillere.size()-1;
		int mid = 0;
		Spiller spillere1 = null;
		
		while(!found && left <= right){
			mid = (left + right)/2;
			spillere1 = spillere.get(mid);
			if(spillere.get(mid).getMaal() == score)
				found = true;
			else if (spillere.get(mid).getMaal() < score)
				left = mid+1;
			else if (spillere.get(mid).getMaal() > score)
				right = mid-1;
		}
		
		return spillere1;
	}
	
	public String findGodSpiller(ArrayList<Spiller> spillere){
		boolean found = false;
//		int i = 0;
		String sp = "";
		Spiller spillere2 = null;
		Iterator<Spiller> it = spillere.iterator();
		
		while(!found && it.hasNext()){
			spillere2 = it.next();
			
			if(spillere2.getHøjde() < 170 && spillere2.getMaal() > 50){
				found = true;
				sp = spillere2.getNavn();
			}
		}
		
//		while(!found && i < spillere.size()){
//			spillere2 = spillere.get(i);
//			if(spillere.get(i).getHøjde() < 170 && spillere.get(i).getMaal() > 50){
//				found = true;
//			}
//			else
//				i++;
//		}
		
		return sp;
	}
	

}
