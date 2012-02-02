package Svommer2.copy;
import java.util.ArrayList;

public class TraeningsPlan {
	private char niveau;
	private int ugentligVandTimer;
	private int ugentligStyrkeTimer;
	private ArrayList<Svømmer> svømmere;
	
	
	public TraeningsPlan(char niveau, int ugentligVandTimer, int ugentligStyrkeTimer) {
		svømmere = new ArrayList<Svømmer>();
		this.niveau = niveau;
		this.ugentligVandTimer = ugentligVandTimer;
		this.ugentligStyrkeTimer = ugentligStyrkeTimer;
	}
	public char getNiveau() {
		return niveau;
	}
	public void setNiveau(char niveau) {
		this.niveau = niveau;
	}
	public int getUgentligStyrkeTimer() {
		return ugentligStyrkeTimer;
	}
	public void setUgentligStyrkeTimer(int ugentligStyrkeTimer) {
		this.ugentligStyrkeTimer = ugentligStyrkeTimer;
	}
	public int getUgentligVandTimer() {
		return ugentligVandTimer;
	}
	public void setUgentligVandTimer(int ugentligVandTimer) {
		this.ugentligVandTimer = ugentligVandTimer;
	}
	public void addSvømmer(Svømmer svømmer){
		svømmere.add(svømmer);
	}
	public void removeSvømmer(Svømmer svømmer){
		svømmere.remove(svømmer);
	}
	public ArrayList<Svømmer> getSvømmere(){
		return new ArrayList<Svømmer> (svømmere);
	}
}
