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
public class tørring {
	
	@Id
	private int batchID;
	@Temporal(TemporalType.TIMESTAMP)
	private GregorianCalendar tørringPåbegyndt, tørringAfsluttet;
	@ManyToOne (cascade={CascadeType.PERSIST, CascadeType.REMOVE})
	@JoinColumn
	private Mellemvare mellemvare;
	@ManyToOne (cascade={CascadeType.PERSIST, CascadeType.REMOVE})
	@JoinColumn
	private Delbehandling delbehandling;
	@Enumerated(EnumType.STRING)
	private appState status;

	public tørring(int batchID, Mellemvare mellemvare,
			Delbehandling delbehandling) {
		tørringPåbegyndt = new GregorianCalendar();
		this.setBatchID(batchID);
		this.setMellemvare(mellemvare);
		this.setDelbehandling(delbehandling);
		this.setStatus(appState.FORKORT);
	}
	
	public tørring() {
		
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

	public void setStatus(appState state) {
		this.status = state;
	}

	public appState getStatus() {
		return status;
	}

}
