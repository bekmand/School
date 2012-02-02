package serieKomposition;
import java.util.ArrayList;

public class Serie {
	private String title;
	private ArrayList<String> skuespillere;
	private ArrayList<Afsnit> afsnit;
	
	public Serie (String title){
		this.title = title;
		this.skuespillere = new ArrayList<String>();
	}
	
	public String getTitle(){
		return title;
	}
	
	public void addActor(String actor){
		skuespillere.add(actor);
	}
	
	public ArrayList<String> getActor(){
		return skuespillere;
	}
	
	public void addAfsnit(Afsnit afsnit){
		this.afsnit.add(afsnit);
	}
	
	public ArrayList<Afsnit> getAfsnit(){
		return afsnit;
	}
	
	public int samletLength(){
		int m = 0;
		for(int i = 0; i < afsnit.size(); i++){
			m += afsnit.get(i).getLength();
		}
		return m;
	}
	
	
	
}
