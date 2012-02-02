package unidir_01tomany;

import java.util.ArrayList;

public class Group {

	private String name;

	//link to Person class (--> 0..*)
	private ArrayList<Person> persons = new ArrayList<Person>();

	/**
	 * Creates a new group.<br />
	 * Requires: name not empty.
	 */
	public Group(String name) {
		this.name = name;
	}

	/**
	 * Returns the name.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.<br />
	 * Requires: name not empty.
	 */
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name + " (p: " + persons + ")";
	}

	//-----------------------------------------------------------------------------------

	/**
	 * Returns a list of persons in this group.
	 */
	public ArrayList<Person> getPersons() {
		return persons;
	}

	/**
	 * Adds the person to this group.<br />
	 * Requires: No group is linked to the person.<br />
	 */
	public void addPerson(Person person) {
		persons.add(person);
	}

	/**
	 * Removes the person from this group.<br />
	 * Requires: This group is linked to the person.<br />
	 */
	public void removePerson(Person person) {
		persons.remove(person);
	}

}
