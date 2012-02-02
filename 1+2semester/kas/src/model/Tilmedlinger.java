package model;
import java.util.ArrayList;

public class Tilmedlinger {
	private double ankomstDato;
	private double afrejseDato;
	private Ledsager ledsagere;
	private boolean fordragsHolder;
	private boolean ledsager;
	private Konferrence konf;
	private Deltager deltagere;
	private Hotel hotel;
	private boolean hotelReservation;
	private boolean hotelTillæg;
	
	public Tilmedlinger(double ankomstDato, double afrejseDato, boolean fordragsholder){
		this.afrejseDato = afrejseDato;
		this.ankomstDato = ankomstDato;
		this.fordragsHolder = false;
	}
	
	public void addDeltager(Deltager deltager){
		this.deltagere = deltager;
	}
	
	public void addLedsager(Ledsager ledsagere){
		this.ledsagere = ledsagere;
	}
	
	public void setLedsager(boolean aktiv){
		this.ledsager = aktiv;		
	}
	
	public boolean getLedsager(){
		return ledsager;
	}
	
	public void setHotelReservation(boolean hotelAktiv){
		this.hotelReservation = hotelAktiv;
	}
	
	public void setFordragsHolder(boolean fordragAktiv){
		this.fordragsHolder = fordragAktiv;
	}
	
	public double getSum(){
		int tempPris = 0;
		if(ledsager == true){
			tempPris += ledsagere.aktivitetsPriser();
			if(hotelReservation == true){
				
				tempPris += hotel.getPrisDouble();
				
				if(hotelTillæg == true){
					tempPris += hotel.getTillæg();
				}
			}
		}
		if(hotelReservation == true && ledsager == false){
			tempPris += hotel.getPrisEnkel();
			if(hotelTillæg == true){
				tempPris += hotel.getTillæg();
			}
		}
		tempPris += konf.getKonfPris();
		
		return tempPris;
	}

}
