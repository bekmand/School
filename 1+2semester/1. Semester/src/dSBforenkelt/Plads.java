package dSBforenkelt;

public class Plads {
	private int nr;
	private boolean reserveret;
	
	public Plads(int nr){
		this.nr = nr;
	}
	
	public void setReserveret(){
		if(reserveret = true){
			reserveret = false;
		}
		reserveret = true;
	}
	
	public boolean isReserveret(){
		return reserveret;
	}
	
	public int getNr(){
		return nr;
	}
}
