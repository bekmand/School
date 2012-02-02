package mobiltelefon;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MobilTest {
	public static void main(String[] args) {
		
		MobilTlf mobil = new MobilTlf("nokia", "310i", 40553577, Design.SEJ);
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Mobiles");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(mobil);
		em.getTransaction().commit();
		
		 System.out.println(em.createQuery("SELECT m FROM MobilTlf m",MobilTlf.class).getResultList());
	        
	        em.close();
	        emf.close();
	}
}
