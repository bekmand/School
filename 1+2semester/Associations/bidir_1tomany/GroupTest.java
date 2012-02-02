package bidir_1tomany;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class GroupTest {
	private Group group;
	private Person person;
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testAddPersonUD() {
		group = new Group("Min Gruppe");
		person = new Person("Mig");
		group.addPerson(person);
		
		assertTrue(group.getPersons().contains(person));
		assertSame(person.getGroup(), group);
	}

	@Test
	public void testRemovePersonUD() {
//		fail("Not yet implemented");
	}

}
