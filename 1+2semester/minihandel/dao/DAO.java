package dao;

import java.util.List;

import model.Kunde;

public interface DAO {
	public List<Kunde> getAllKunder();
	public void store(Kunde kunde);
	public void remove(Kunde kunde);
	public Kunde findKunde(String navn);
	public void close();
}
