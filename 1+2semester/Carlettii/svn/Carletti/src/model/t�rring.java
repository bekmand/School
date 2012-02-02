package model;

import java.util.Date;
import java.util.GregorianCalendar;

public class t�rring {
	private GregorianCalendar t�rringP�begyndt, t�rringAfsluttet;
	private int batchID;
	private Mellemvare mellemvare;
	private Delbehandling delbehandling;

	public t�rring(int batchID, Mellemvare mellemvare,
			Delbehandling delbehandling) {
		t�rringP�begyndt = new GregorianCalendar();
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
		mellemvare.addT�rretidUD(this);
	}

	public Delbehandling getDelbehandling() {
		return delbehandling;
	}

	public void setDelbehandling(Delbehandling delbehandling) {
		this.delbehandling = delbehandling;
	}

	public GregorianCalendar getT�rringP�begyndt() {
		return t�rringP�begyndt;
	}

	public void setT�rringAfsluttet(GregorianCalendar t�rringAfsluttet) {
		this.t�rringAfsluttet = t�rringAfsluttet;
	}

	public GregorianCalendar getT�rringAfsluttet() {
		return t�rringAfsluttet;
	}
	
	public long getSekunderToerret(){
		long now = new GregorianCalendar().getTimeInMillis();
		long tidspunktPaabegyndt = this.getT�rringP�begyndt().getTimeInMillis();
		return (now - tidspunktPaabegyndt) / 1000;
	}

}
