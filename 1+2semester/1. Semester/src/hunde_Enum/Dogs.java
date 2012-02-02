package hunde_Enum;

public class Dogs {
	private String name;
	private boolean stamTavle;
	private int pris;
	private DogRace race;

	public Dogs(String name, boolean stamTavle, int pris, DogRace race){
		this.name = name;
		this.stamTavle = stamTavle;
		this.pris = pris;
		this.race = race;
	}
	
	public int getPris(){
		return this.pris;
	}
	
	public DogRace getRace(){
		return race;
	}
}
