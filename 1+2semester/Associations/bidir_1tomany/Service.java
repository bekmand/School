package bidir_1tomany;

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

        service.linkGroupPerson(g2, p1);
        System.out.println("Person: " + p1);
        System.out.println("Person: " + p2);
        System.out.println("Group: " + g1);
        System.out.println("Group: " + g2);
        System.out.println();
    }

    /**
     * Links the group and the person.
     */
    public void linkGroupPerson(Group group, Person person)
    {
        //remove the link between person and person.getGroup()
        person.setGroup(null);
        //add the link between group and person
        group.addPerson(person);
    }

    /**
     * Creates a person linked to the group.
     */
    public Person createPerson(String name, Group group)
    {
        Person p = new Person(name);
        group.addPerson(p);
        return p;
    }

}
