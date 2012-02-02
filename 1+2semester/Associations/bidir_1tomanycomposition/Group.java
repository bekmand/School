package bidir_1tomanycomposition;

import java.util.ArrayList;

public class Group
{
    private String name;

    //link to Person class (--> 0..*)
    private ArrayList<Person> persons = new ArrayList<Person>();

    /**
     * Creates a new group.<br />
     * Requires: name not empty.
     */
    public Group(String name)
    {
        this.name = name;
    }

    /**
     * Returns the name.
     */
    public String getName()
    {
        return name;
    }

    /**
     * Sets the name.<br />
     * Requires: name not empty.
     */
    public void setName(String name)
    {
        this.name = name;
    }

    @Override
    public String toString()
    {
        return name + " (p: " + persons + ")";
    }

    //-----------------------------------------------------------------------------------

    /**
     * Returns a list of persons in this group.
     */
    public ArrayList<Person> getPersons()
    {
        return new ArrayList<Person>(persons);
    }

    /**
     * Creates a person linked to this group.
     */
    Person createPersonUD(String name)
    {
        //One-way link from Group to Person.
        Person person = new Person(name);
        persons.add(person);
        return person;
    }

    /**
     * Removes the person from this group.<br />
     * Requires: This group is linked to the person.<br />
     * Note: This method breaks the to-1-group multiplicity of the person.
     */
    void removePersonUD(Person person)
    {
        //One-way link from Group to Person.
        persons.remove(person);
    }

    /**
     * Creates a person linked to this group.
     */
    public Person createPerson(String name)
    {
        //Two-way link between Group and Person.
        Person person = this.createPersonUD(name);
        person.setGroupUD(this);
        return person;
    }

    /**
     * Removes the person from this group.<br />
     * Requires: This group is linked to the person.<br />
     * Note: This method breaks the to-1-group multiplicity of the person.
     */
    public void removePerson(Person person)
    {
        //Two-way link between Group and Person.
        person.setGroupUD(null);
        this.removePersonUD(person);
    }
}
