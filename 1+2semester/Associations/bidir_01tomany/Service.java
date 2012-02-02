package bidir_01tomany;

public class Service
{

    public static void main(String[] args)
    {
        Person p1 = new Person("P1");
        Person p2 = new Person("P2");
        Group g1 = new Group("G1");
        Group g2 = new Group("G2");
        System.out.println("Person: " + p1);
        System.out.println("Person: " + p2);
        System.out.println("Group: " + g1);
        System.out.println("Group: " + g2);
        System.out.println();

        Service service = new Service();

        service.linkGroupPerson(g1, p1);
        System.out.println("Person: " + p1);
        System.out.println("Person: " + p2);
        System.out.println("Group: " + g1);
        System.out.println("Group: " + g2);
        System.out.println();

        service.linkGroupPerson(g2, p1);
        service.linkGroupPerson(g2, p2);
        System.out.println("Person: " + p1);
        System.out.println("Person: " + p2);
        System.out.println("Group: " + g1);
        System.out.println("Group: " + g2);
    }

    /**
     * Links the group and the person.
     */
    public void linkGroupPerson(Group group, Person person)
    {
        if (person.getGroup() != null) {
            //remove the link between person and person.getGroup()
            person.setGroup(null);
        }
        //add the link between group and person
        group.addPerson(person);
    }

}
