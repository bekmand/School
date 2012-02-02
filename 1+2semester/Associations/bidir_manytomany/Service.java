package bidir_manytomany;

public class Service
{

    public static void main(String[] args)
    {
        Person p1 = new Person("P1");
        Group g1 = new Group("G1");
        Group g2 = new Group("G2");
        System.out.println("Person: " + p1);
        System.out.println("Group: " + g1);
        System.out.println("Group: " + g2);
        System.out.println();

        g1.addPerson(p1);
        System.out.println("Person: " + p1);
        System.out.println("Group: " + g1);
        System.out.println("Group: " + g2);
        System.out.println();

        p1.addGroup(g2);
        System.out.println("Person: " + p1);
        System.out.println("Group: " + g1);
        System.out.println("Group: " + g2);
    }

}
