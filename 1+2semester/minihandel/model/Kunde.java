package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="Kunder")
public class Kunde {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String navn;

	@Temporal(TemporalType.DATE)
	private Date foedt;

	@OneToMany(cascade={CascadeType.PERSIST, CascadeType.REMOVE})
	@JoinColumn
	private List<Ordre> ordrer;

	public Kunde() {
		ordrer = new ArrayList<Ordre>();
	}
	
	public Kunde(String navn, Date foedt) {
		this.navn = navn;
		this.foedt = foedt;
		ordrer = new ArrayList<Ordre>();
	}

	public String getNavn() {
		return navn;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}

	public Date getFoedt() {
		return foedt;
	}

	public void addOrdre(Ordre ordre) {
		ordrer.add(ordre);
	}

	public void removeOrdre(Ordre ordre) {
		ordrer.remove(ordre);
	}
	
	public Iterator<Ordre> getOrdrer(){
		return ordrer.iterator();
	}
	
	@Override
	public String toString(){
		return navn;
	}

}
