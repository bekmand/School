package persondao;

import java.util.List;

public interface DAO {
	public List<Person> getAllPersons();
	public void store(Person person);
	public void remove(Person person);
	public Person findPerson(String navn);
	public void close();
}