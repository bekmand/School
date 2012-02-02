package bidir_1to01;

public class Person
{
    private String name;

    //link to group class (--> 1)
    private Group group = null;

    /**
     * Creates a new person.<br />
     * Requires: name not empty.<br />
     * Note: This constructor does not establish the to-1-group multiplicity of the new person.
     */
    public Person(String name)
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
     * Sets the name.
     * Requires: name not empty.
     */
    public void setName(String name)
    {
        this.name = name;
    }

    @Override
    public String toString()
    {
        return name + " (g: " + group.getName() + ")";
    }

    //-----------------------------------------------------------------------------------

    /**
     * Returns the group of this person.
     */
    public Group getGroup()
    {
        return group;
    }

    /**
     * Sets or unsets the group of this person.<br />
     * Requires:<br /> 
     * If <i>group</i> is not null: This person is not linked to any group, 
     * and the group is not linked to any person.<br />
     * If <i>group</i> is null: This person is linked to a group.<br />
     * Note: null is an allowed value of <i>group</i>.<br />
     * Note: This method breaks the to-1-group multiplicity of this person,
     *       if <i>group</i> is null.
     */
    void setGroupUD(Group group)
    {
        //One-way link from Person to Group.
        this.group = group;
    }

    /**
     * Sets or unsets the group of this person.<br />
     * Requires:<br /> 
     * If <i>group</i> is not null: This person is not linked to any group, 
     * and the group is not linked to any person.<br />
     * If <i>group</i> is null: This person is linked to a group.<br />
     * Note: null is an allowed value of <i>group</i>.<br />
     * Note: This method breaks the to-1-group multiplicity of this person,
     *       if <i>group</i> is null.
     */
    public void setGroup(Group group)
    {
        //Two-way link between Person and Group.
        if (group != null) {
            this.setGroupUD(group);
            group.setPersonUD(this);
        }
        else { //group == null
            this.getGroup().setPersonUD(null);
            this.setGroupUD(null);
        }
    }
}
