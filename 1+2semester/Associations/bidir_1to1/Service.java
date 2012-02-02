package bidir_1to1;

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

        p1.setGroup(null);
        g2.setPerson(null);
        g1.setPerson(p2);
        g2.setPerson(p1);
        System.out.println("Person: " + p1);
        System.out.println("Person: " + p2);
        System.out.println("Group: " + g1);
        System.out.println("Group: " + g2);
        System.out.println();
    }

    /**
     * Creates a person linked to the group.
     */
    public Person createPerson(String name, Group group)
    {
        Person p = new Person(name);
        group.setPerson(p);
        return p;
    }
}
