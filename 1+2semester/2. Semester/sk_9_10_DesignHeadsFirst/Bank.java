package sk_9_10_DesignHeadsFirst;

import java.util.ArrayList;

public class Bank{
	
	private ArrayList<Kunde> kunde = new ArrayList<Kunde>();
	private ArrayList<Konto> konto = new ArrayList<Konto>();
	
	private RenteInterface renteInterface;
	
	
	public void bank(ArrayList<Kunde> kunde, ArrayList<Konto> konto){
		this.kunde = kunde;
		this.konto = konto;
	}

}