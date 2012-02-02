package Svommer2.copy;
import java.util.ArrayList;

public class AnvendSvømmer {

	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//ArrayList<Svømmer> svømmer = new ArrayList<Svømmer>();
		TraeningsPlan tp1 = new TraeningsPlan('A',20,40);
		TraeningsPlan tp2 = new TraeningsPlan('B',10,30);
		ArrayList<Double> tider = new ArrayList<Double>();
		
		//svømmer = new ArrayList<Svømmer>();
		Svømmer p1 = new Svømmer("Jan",1990,tider,"HSK");
		Svømmer p2 = new Svømmer("Bo",1989,tider,"HSK");
		Svømmer p3 = new Svømmer("Jesper",1992,tider,"HSK");
		
		
		tp1.addSvømmer(p1);
		tp1.addSvømmer(p2);
		tp2.addSvømmer(p3);
		
		ArrayList<Svømmer> result = tp1.getSvømmere();
		for(Svømmer s : result){
			System.out.println(s.getNavn());
		}
	}

}
