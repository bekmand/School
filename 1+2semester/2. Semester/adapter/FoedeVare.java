package adapter;

public class FoedeVare extends Vare{
	public FoedeVare(int pris, String navn){
		super(pris, navn);
	}
	
	public double beregnMoms(){
		return getPris() * 0.05;
	}

}
