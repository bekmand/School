package unidir_01to01;

public class Person {
  
    private String name;

    /**
     * Creates a new person.
     * Requires: name not empty.
     */
    public Person(String name) {

        this.name = name;
    }

    /**
     * Returns the name.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name.
     * Requires: name not empty.
     */
    public void setName(String name) {
    
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

}
