package bidir_manytomany;

import java.util.ArrayList;

public class Person
{
    private String name;

    //link to group class (--> 0..*)
    private ArrayList<Group> groups = new ArrayList<Group>();

    /**
     * Creates a new person.
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
        String s = name + " [g: ";
        for (Group g : groups) {
            s += g.getName() + ",";
        }
        s += "]";
        return s;
    }

    //-----------------------------------------------------------------------------------

    /**
     * Returns a list of this person's groups.
     */
    public ArrayList<Group> getGroups()
    {
        return new ArrayList<Group>(groups);
    }

    /**
     * Adds the group to this person.<br />
     * Requires: This person is not linked to the group.
     */
    void addGroupUD(Group group)
    {
        //One-way link from Person to Group.
        groups.add(group);
    }

    /**
     * Removes the group from this person.<br />
     * Requires: This person is linked to the group. 
     */
    void removeGroupUD(Group group)
    {
        //One-way link from Person to Group.
        groups.remove(group);
    }

    /**
     * Adds the group to this person.<br />
     * Requires: This person is not linked to the group.
     */
    public void addGroup(Group group)
    {
        //Two-way link between Person and Group.
        this.addGroupUD(group);
        group.addPersonUD(this);
    }

    /**
     * Removes the group from this person.<br />
     * Requires: This person is linked to the group.
     */
    public void removeGroup(Group group)
    {
        //Two-way link between Person and Group.
        group.removePersonUD(this);
        this.removeGroupUD(group);
    }
}
