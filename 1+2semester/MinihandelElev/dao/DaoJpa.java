package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.*;

public class DaoJpa implements Dao {
	private static DaoJpa daoInstance;
	
	private EntityManagerFactory emf;
	private EntityManager em;
	
	private DaoJpa() {
		emf = Persistence.createEntityManagerFactory("MinihandelElev");
		em = emf.createEntityManager();
	}
	
	public static DaoJpa getInstance() {
		if(daoInstance == null) {
			daoInstance = new DaoJpa();
		}
		
		return daoInstance;
	}

	@Override
	public List<Kunde> getAllKunder() {
		return em.createQuery("SELECT k FROM Kunde k", Kunde.class).getResultList();
	}

	@Override
	public void store(Kunde kunde) {
		em.getTransaction().begin();
		em.persist(kunde);
		em.getTransaction().commit();
	}

	@Override
	public void remove(Kunde kunde) {
		em.getTransaction().begin();
		em.remove(kunde);
		em.getTransaction().commit();
	}

	@Override
	public Kunde findKunde(String navn) {
		Query q = em.createQuery("SELECT k FROM Kunde K WHERE k.navn = :navn", Kunde.class);
		q.setParameter("navn", navn);
		return (Kunde)q.getResultList().get(0);
	}

	@Override
	public void close() {
		em.close();
		emf.close();
	}
	
	@Override
	public List<Vare> getAllVare(){
		return em.createQuery("SELECT v FROM Vare v", Vare.class).getResultList();
	}
	
	public Vare FindKoebtVare(String navn){
		Query q = em.createQuery("SELECT v FROM VARE where Kunde k = :navn");
		q.setParameter("navn", navn);
		return(Vare)q.getResultList();
	}
	
	
}
