package persondao;

import java.util.List;

public class Service {
	private static Service service;

	public static Service getService() {
		if (service == null)
			service = new Service();
		return service;
	}

//	private DAO dao = JpaDAO.getDAO();
	private DAO dao = ListDAO.getDAO();

	private Service() {
		// singleton
	}

	public Person newPerson() {
		return new Person();
	}

	public Person findPerson(String navn) {
		return dao.findPerson(navn);
	}

	public List<Person> getPersoner() {
		return dao.getAllPersons();
	}
	
	public void store(Person person) {
		dao.store(person);
	}
	
	public void close(){
		dao.close();
	}
	
	
}
