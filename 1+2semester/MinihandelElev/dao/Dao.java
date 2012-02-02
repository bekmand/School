package dao;

import java.util.List;

import model.Kunde;
import model.Vare;

public interface Dao {
	public List<Kunde> getAllKunder();
	public void store(Kunde kunde);
	public void remove(Kunde kunde);
	public Kunde findKunde(String navn);
	public void close();
	public List<Vare> getAllVare();
	public Vare FindKoebtVare(String navn);
}