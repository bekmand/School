package model;

import java.util.Date;
import java.util.GregorianCalendar;

public class tørring {
	private GregorianCalendar tørringPåbegyndt, tørringAfsluttet;
	private int batchID;
	private Mellemvare mellemvare;
	private Delbehandling delbehandling;

	public tørring(int batchID, Mellemvare mellemvare,
			Delbehandling delbehandling) {
		tørringPåbegyndt = new GregorianCalendar();
		this.setBatchID(batchID);
		this.setMellemvare(mellemvare);
		this.setDelbehandling(delbehandling);
	}

	// Getters and setters

	public int getBatchID() {
		return batchID;
	}

	public void setBatchID(int batchID) {
		this.batchID = batchID;
	}

	public Mellemvare getMellemvare() {
		return mellemvare;
	}

	public void setMellemvareUD(Mellemvare mellemvare) {
		this.mellemvare = mellemvare;
	}

	public void setMellemvare(Mellemvare mellemvare) {
		this.setMellemvareUD(mellemvare);
		mellemvare.addTørretidUD(this);
	}

	public Delbehandling getDelbehandling() {
		return delbehandling;
	}

	public void setDelbehandling(Delbehandling delbehandling) {
		this.delbehandling = delbehandling;
	}

	public GregorianCalendar getTørringPåbegyndt() {
		return tørringPåbegyndt;
	}

	public void setTørringAfsluttet(GregorianCalendar tørringAfsluttet) {
		this.tørringAfsluttet = tørringAfsluttet;
	}

	public GregorianCalendar getTørringAfsluttet() {
		return tørringAfsluttet;
	}
	
	public long getSekunderToerret(){
		long now = new GregorianCalendar().getTimeInMillis();
		long tidspunktPaabegyndt = this.getTørringPåbegyndt().getTimeInMillis();
		return (now - tidspunktPaabegyndt) / 1000;
	}

}
