package model;

import java.util.ArrayList;

/**
 * Models a company.
 * @author mlch
 */
public class Company
{
    private String name;
    private int hours; //weekly work hours

    //link to Employee class (0..1 --> 0..*)
    private ArrayList<Employee> employees = new ArrayList<Employee>();

    /**
     * Creates a new company.<br />
     * Requires: name not empty, hours >= 0.
     */
    public Company(String name, int hours)
    {
        this.name = name;
        this.hours = hours;
    }

    /**
     * Returns the name.
     */
    public String getName()
    {
        return name;
    }

    /**
     * Sets the name.<br />
     * Requires: name not empty.
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * Returns the weekly work hours.
     */
    public int getHours()
    {
        return hours;
    }

    /**
     * Sets the weekly work hours.<br />
     * Requires: hours >= 0.
     */
    public void setHours(int hours)
    {
        this.hours = hours;
    }

    /**
     * Returns a string describing this company.
     */
    @Override
    public String toString()
    {
        return name + " (hours: " + hours + ")";
    }

    // -----------------------------------------------------------------------------

    /**
     * Returns a list of this company's employees.
     */
    public ArrayList<Employee> getEmployees()
    {
        return new ArrayList<Employee>(employees);
    }

    /**
     * Adds the employee to this company.<br />
     * Requires: This company is not linked with the employee.
     */
    void addEmployeeUD(Employee employee)
    {
        employees.add(employee);
    }

    /**
     * Removes the employee from this company.<br />
     * Requires: This company has a link to the employee.
     */
    void removeEmployeeUD(Employee employee)
    {
        employees.remove(employee);
    }

    /**
     * Adds the employee to this company.<br />
     * Requires: This company is not linked with the employee.
     */
    public void addEmployee(Employee employee)
    {
        this.addEmployeeUD(employee);
        employee.setCompanyUD(this);
    }

    /**
     * Removes the employee from this company.<br />
     * Requires: This company has a link to the employee.
     */
    public void removeEmployee(Employee employee)
    {
        employee.setCompanyUD(null);
        this.removeEmployeeUD(employee);
    }

    // -----------------------------------------------------------------------------

    /**
     * Returns the count of employees in this company.
     */
    public int getEmployeesCount()
    {
        return employees.size();
    }
}
