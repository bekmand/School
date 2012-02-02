package bidir_1to01;

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
     * Sets or unsets the person of this group.<br />
     * Requires:<br /> 
     * If <i>person</i> is not null: This group is not linked to any person, 
     * and the person is not linked to any group.<br />
     * If <i>person</i> is null: This group is linked to a person.<br />
     * Note: null is an allowed value of <i>person</i>.<br />
     * Note: This method breaks the to-1 group multiplicity of the Person class,
     *       if <i>person</i> is null.
     */
    void setPersonUD(Person person)
    {
        //One-way link from Group to Person.
        this.person = person;
    }

    /**
     * Sets or unsets the person of this group.<br />
     * Requires:<br /> 
     * If <i>person</i> is not null: This group is not linked to any person, 
     * and the person is not linked to any group.<br />
     * If <i>person</i> is null: This group is linked to a person.<br />
     * Note: null is an allowed value of <i>person</i>.<br />
     * Note: This method breaks the to-1 group multiplicity of the Person class,
     *       if <i>person</i> is null.
     */
    public void setPerson(Person person)
    {
        //Two-way link between Group and Person.
        if (person != null) {
            this.setPersonUD(person);
            person.setGroupUD(this);
        }
        else { //person == null
            this.getPerson().setGroupUD(null);
            this.setPersonUD(null);
        }
    }
}
