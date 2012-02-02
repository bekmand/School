package bidir_01tomany;

public class Person
{
    private String name;

    //link to group class (--> 0..1)
    private Group group = null;

    /**
     * Creates a new person.<br />
     * Requires: name not empty.
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
        return name + " (g: " + (group != null ? group.getName() : "null") + ")";
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
     * If <i>group</i> is not null: This person is not linked to any group.<br />
     * If <i>group</i> is null: This person is linked to a group.<br />
     * Note: null is an allowed value of <i>group</i>.
     */
    void setGroupUD(Group group)
    {
        //One-way link from Person to Group.
        this.group = group;
    }

    /**
     * Sets or unsets the group of this person.<br />
     * Requires:<br /> 
     * If <i>group</i> is not null: This person is not linked to any group.<br />
     * If <i>group</i> is null: This person is linked to a group.<br />
     * Note: null is an allowed value of <i>group</i>.
     */
    public void setGroup(Group group)
    {
        //Two-way link between Person and Group.
        if (group != null) {
            this.setGroupUD(group);
            group.addPersonUD(this);
        }
        else { //group == null
            this.getGroup().removePersonUD(this);
            this.setGroupUD(null);
        }
    }
}
