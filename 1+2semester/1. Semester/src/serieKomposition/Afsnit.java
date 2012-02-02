package serieKomposition;

public class Afsnit {
	private int nr;
	private int length;
	private String guestActor;
	
	public Afsnit (int nr, int length, String guestActor){
		this.nr = nr;
		this.length = length;
		this.guestActor = guestActor;
	}
	
	public int getNr(){
		return nr;
	}
	
	public int getLength(){
		return length;
	}
	
	public String getGuestActor(){
		return guestActor;
	}
	
	public void setGuestActor(String guestActor){
		this.guestActor = guestActor;
	}

}
