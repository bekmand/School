package Singleton;

public class personAdministratorTest {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		personAdministrator pa = personAdministrator.getInstance();

		person p1 = new person("Casper");
		person p2 = new person("Lars");
		
		pa.add(p1);
		pa.add(p2);
		
		System.out.println(pa.getPersoner());
		
	}

}
