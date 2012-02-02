package model;

/**
 * Models an employee.
 * @author mlch
 */
public class Employee
{
    private String name;
    private int wage; //hourly wage

    //link to company class (0..* --> 0..1)
    private Company company = null;

    /**
     * Creates a new employee.<br />
     * Requires: name not empty, wage >= 0.
     */
    public Employee(String name, int wage)
    {
        this.name = name;
        this.wage = wage;
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
     * Returns the wage. 
     */
    public int getWage()
    {
        return wage;
    }

    /**
     * Sets the wage.<br />
     * Requires: wage >= 0.
     */
    public void setWage(int wage)
    {
        this.wage = wage;
    }

    /**
     * Returns a string describing this employee.
     */
    @Override
    public String toString()
    {
        String s = name + " (wage: " + wage + ")";
        if (company != null)
            s = name + " (wage: " + wage + ", company: " + company.getName() + ")";
        return s;
    }

    // -----------------------------------------------------------------------------

    /**
     * Returns the company of this employee.
     */
    public Company getCompany()
    {
        return company;
    }

    /**
     * Sets or unsets the company of this employee.<br />
     * Requires: 
     * If <i>company</i> is not null: This employee is not linked to the company.
     * If <i>company</i> is null: This employee is linked to the company.
     */
    void setCompanyUD(Company company)
    {
        this.company = company;
    }

    /**
     * Sets or unsets the company of this employee.<br />
     * Requires:<br /> 
     * If <i>company</i> is not null: This employee is not linked to the company.<br />
     * If <i>company</i> is null: This employee is linked to the company.<br />
     * Note: null is an allowed value of <i>company</i>.
     */
    public void setCompany(Company company)
    {
        if (company != null) {
            this.setCompanyUD(company);
            company.addEmployeeUD(this);
        }
        else { //company == null;
            this.getCompany().removeEmployeeUD(this);
            this.setCompanyUD(null);
        }
    }

    // -----------------------------------------------------------------------------

    /**
     * Calculates the weekly salary.<br />
     * Requires: This employee has a company. 
     */
    public double calcWeeklySalary()
    {
        return wage * company.getHours();
    }

}
