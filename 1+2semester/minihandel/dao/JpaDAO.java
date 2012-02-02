package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Kunde;

public class JpaDAO implements DAO {
	private static JpaDAO daoInstance;
	
	private EntityManagerFactory emf;
	private EntityManager em;
	
	private JpaDAO() {
		emf = Persistence.createEntityManagerFactory("minihandel");
		em = emf.createEntityManager();
	}
	
	public static JpaDAO getInstance() {
		if(daoInstance == null) {
			daoInstance = new JpaDAO();
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
		Query q = em.createQuery("SELECT k Kunde K WHERE k.navn = :navn", Kunde.class);
		q.setParameter("navn", navn);
		return (Kunde)q.getResultList().get(0);
	}

	@Override
	public void close() {
		em.close();
		emf.close();
	}
	
	
}
