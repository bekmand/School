package model;

import java.util.GregorianCalendar;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import model.Enum.appState;

@Entity
public class t�rring {
	
	@Id
	private int batchID;
	@Temporal(TemporalType.TIMESTAMP)
	private GregorianCalendar t�rringP�begyndt, t�rringAfsluttet;
	@ManyToOne (cascade={CascadeType.PERSIST, CascadeType.REMOVE})
	@JoinColumn
	private Mellemvare mellemvare;
	@ManyToOne (cascade={CascadeType.PERSIST, CascadeType.REMOVE})
	@JoinColumn
	private Delbehandling delbehandling;
	@Enumerated(EnumType.STRING)
	private appState status;

	public t�rring(int batchID, Mellemvare mellemvare,
			Delbehandling delbehandling) {
		t�rringP�begyndt = new GregorianCalendar();
		this.setBatchID(batchID);
		this.setMellemvare(mellemvare);
		this.setDelbehandling(delbehandling);
		this.setStatus(appState.FORKORT);
	}
	
	public t�rring() {
		
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

	public void setStatus(appState state) {
		this.status = state;
	}

	public appState getStatus() {
		return status;
	}

}
