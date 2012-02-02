package bidir_1to01composition;

public class Group
{
    private String name;

    //link to Person class (--> 0..1)
    private Person person = null;

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
        return name + " (p: " + (person != null ? person.getName() : "null") + ")";
    }

    //-----------------------------------------------------------------------------------

    /**
     * Returns the person of this group.
     */
    public Person getPerson()
    {
        return person;
    }

    /**
     * Creates a person linked to this group.<br />
     * Requires: This group is not linked to any person.
     */
    Person createPersonUD(String name)
    {
        //One-way link from Group to Person.
        Person person = new Person(name);
        this.person = person;
        return person;
    }

    /**
     * Removes the person from this group.<br />
     * Requires: This group is linked to a person.<br />
     * Note: This method breaks the to-1-group multiplicity of the Person class.
     */
    void removePersonUD()
    {
        //One-way link from Group to Person.
        this.person = null;
    }

    /**
     * Creates a person linked to this group.<br />
     * Requires: This group is not linked to any person.
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
     * Requires: This group is linked to a person.<br />
     * Note: This method breaks the to-1-group multiplicity of the Person class.
     */
    public void removePerson()
    {
        //Two-way link between Group and Person.
        this.getPerson().setGroupUD(null);
        this.removePersonUD();
    }
}
