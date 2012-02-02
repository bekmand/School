package adapter;

public class ElVare extends Vare {
	
	public ElVare(int pris, String navn){
		super(pris, navn);
	}
	
	public double beregnMoms(){
		double moms = 0;
		moms = getPris() * 0.30;
		
		if(moms < 3){
			return 3;
		}
		else
			return moms;
	}
}
