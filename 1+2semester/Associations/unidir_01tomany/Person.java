package unidir_01tomany;

public class Person {
	//Invariant: name not empty.
	private String name;

	/**
	 * Creates a new person.<br />
	 * Requires: name not empty.<br />
	 */
	public Person(String name) {
		this.name = name;
	}

	/**
	 * Returns the name.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 * Requires: name not empty.
	 */
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}

}
