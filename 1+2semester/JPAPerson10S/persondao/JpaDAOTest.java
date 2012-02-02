package persondao;

public class JpaDAOTest {
	public static void main(String[] args) {
		Service service = Service.getService();
		Person p = service.newPerson();
		p.setNavn("Jane");
		service.store(p);
		p = service.newPerson();
		p.setNavn("Jack");
		service.store(p);
		System.out.println(service.getPersoner());
		p.setNavn("Jake");
		service.store(p);
		System.out.println(p = service.findPerson("Jane"));
		System.out.println(p = service.findPerson("Jack"));
		System.out.println(p = service.findPerson("Jake"));
		service.close();
	}
}
