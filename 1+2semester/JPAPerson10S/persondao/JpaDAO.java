package persondao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class JpaDAO implements DAO {
	private static JpaDAO dao;
	
	public static JpaDAO getDAO() {
		if (dao == null)
			dao = new JpaDAO();
		return dao;
	}
	
	private EntityManagerFactory emf = 
		Persistence.createEntityManagerFactory("JpaDAO test");
	private EntityManager em = emf.createEntityManager();
	private EntityTransaction tx = em.getTransaction();
	
	private JpaDAO () {
		// singleton
	}
	
	@Override
	public Person findPerson(String navn) {
		Person p = null;
		String jplQuery = "SELECT p FROM Person p WHERE p.navn = :navn";
		Query query = em.createQuery(jplQuery);
		query.setParameter("navn", navn);
		List<Person> list = query.getResultList();
		if (list.size()>0)
			p = list.get(0);
		return p;
	}

	@Override
	public List<Person> getAllPersons() {
		return em.createQuery("SELECT p FROM Person p",Person.class).getResultList();
	}
	
	@Override
	public void store(Person person) {
		tx.begin();
		em.persist(person);
		tx.commit();
		
	}

	@Override
	public void remove(Person person) {
		tx.begin();
		em.remove(person);
		tx.commit();
		
	}

	@Override
	public void close() {
		em.clear();
		
	}
}
