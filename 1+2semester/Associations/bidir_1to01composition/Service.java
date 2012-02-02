package bidir_1to01composition;

public class Service
{

    public static void main(String[] args)
    {
        Service service = new Service();

        Group g1 = new Group("G1");
        Group g2 = new Group("G2");

        Person p1 = service.createPerson("P1", g1);
        Person p2 = service.createPerson("P2", g2);
        System.out.println("Person: " + p1);
        System.out.println("Person: " + p2);
        System.out.println("Group: " + g1);
        System.out.println("Group: " + g2);
        System.out.println();

        service.deletePerson(g2);
        System.out.println("Person: " + p1);
        System.out.println("Group: " + g1);
        System.out.println("Group: " + g2);
        System.out.println();
    }

    /**
     * Creates a person linked to the group.
     */
    public Person createPerson(String name, Group group)
    {
        Person person = group.createPerson(name);
        return person;
    }

    /**
     * Deletes the person of the group.
     * Requires: The group is linked to a person.
     */
    public void deletePerson(Group group)
    {
        group.removePerson();
    }

}
