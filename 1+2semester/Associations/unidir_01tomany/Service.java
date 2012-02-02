package unidir_01tomany;

public class Service {

    public static void main(String[] args) {
        Group g1 = new Group("G1");
        Person p1 = new Person("P1");
        g1.addPerson(p1);

        System.out.println("Group: " + g1);
        System.out.println("Person: " + p1);
        System.out.println();

        Group g2 = new Group("G2");
        g1.removePerson(p1);
        g2.addPerson(p1);

        System.out.println("Group: " + g1);
        System.out.println("Group: " + g2);
        System.out.println("Person: " + p1);
    }

}
