package unidir_01to01;

public class Group {
	
	private String name;

	//link to Person class (--> 0..1)
	private Person person = null;

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
		return name + " (p: " + (person != null ? person.getName() : "null") + ")";
	}

	//-----------------------------------------------------------------------------------

	/**
	 * Returns the person of this group.
	 */
	public Person getPerson() {
		return person;
	}

	/**
	 * Sets or unsets the person of this group.
	 * Requires: 
	 * If person is not null: The group is not linked to any person, 
	 * and the person is not linked to any group
	 * If person is null: this group is linked to a person
	 * Note: null is an allowed value of person
	 */
	public void setPerson(Person person) {
		this.person = person;
	}

	

}
