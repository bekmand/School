package cars;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CarTest {

	public static void main(String[] args) {
		Car car = new Car("XY 12345", "Toyota Avensis", 147);

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Cars");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(car);
		em.getTransaction().commit();
		
        System.out.println(em.createQuery("SELECT c FROM Car c",Car.class).getResultList());
        
        em.close();
        emf.close();
	}
}
