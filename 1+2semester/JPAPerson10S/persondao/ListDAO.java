package persondao;

import java.util.ArrayList;
import java.util.List;




public class ListDAO implements DAO {
	private static ListDAO dao = null;
	private  List<Person> personer;
	
	private ListDAO(){
		personer = new ArrayList<Person>();
	}
	
	public static DAO getDAO(){
		if (dao == null)
			dao = new ListDAO();
		return dao;
	}

	
	@Override
	public List<Person> getAllPersons() {
		// TODO Auto-generated method stub
		return new ArrayList<Person>(personer);
	}

	@Override
	public void store(Person person) {
		if (!personer.contains(person))
			personer.add(person);
		
	}

	@Override
	public void remove(Person person) {
		personer.remove(person);
		
	}

	@Override
	public Person findPerson(String navn) {
		boolean found = false;
		int i = 0;
		while (!found && i<personer.size()){
			if (personer.get(i).getNavn().equals(navn))
				found = true;
			else
				i++;
		}
		if (found)
			return personer.get(i);
		else 
			return null;
		
	}

	@Override
	public void close() {
		// do nothing
	}
	

}
