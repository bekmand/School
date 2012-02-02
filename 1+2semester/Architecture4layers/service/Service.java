package service;

import java.util.ArrayList;

import dao.Dao;


import model.Company;
import model.Employee;

/**
 * @author mlch
 */
public class Service {
	private static Service instance = new Service();
	
	private Service(){}
	
	public static Service getInstance(){
		if(instance == null){
			instance = new Service();
		}
		return instance;
	}
	
	/**
	 * Does any initialising needed when the application starts up.
	 */
	public void startUp() {
		createSomeObjects();
	}

	/**
	 * Does any housekeeping needed when the application closes down.
	 */
	public void closeDown() {
		//nothing needed
	}

	/**
	 * Returns a list of all companies.
	 */
	public ArrayList<Company> getAllCompanies() {
		return Dao.getInstance().getAllCompanies();
	}

	/**
	 * Creates a company.<br />
	 * Requires: name not empty, hours >= 0.
	 */
	public Company createCompany(String name, int hours) {
		Company company = new Company(name, hours);
		Dao.getInstance().storeCompany (company);
		return company;
	}

	/**
	 * Deletes the company.<br />
	 * Requires: The company has no employees. 
	 */
	public void deleteCompany(Company company) {
		Dao.getInstance().removeCompany(company);
	}

	/**
	 * Updates the company.<br />
	 * Requires: name not empty, hours >= 0, and the name or the hours has changed.
	 */
	public void updateCompany(Company company, String name, int hours) {
		company.setName(name);
		company.setHours(hours);
	}
	
	/**
	 * Returns a list of all employees.
	 */
	public ArrayList<Employee> getAllEmployees() {
		return Dao.getInstance().getAllEmployees();
	}

	/**
	 * Creates an employee.<br />
	 * Requires: name not empty, wage >= 0.
	 */
	public Employee createEmployee(String name, int wage) {
		Employee employee = new Employee(name, wage);
		Dao.getInstance().storeEmployee(employee);
		return employee;
	}

    /**
     * Deletes the employee.
     */
    public void deleteEmployee(Employee employee)
    {
        if (employee.getCompany() != null)
            employee.setCompany(null);
        Dao.getInstance().removeEmployee(employee);
    }


	/**
	 * Updates the employee.<br />
	 * Requires: name not empty, wage >= 0, and the name or the wage has changed.<br />
	 */
	public void updateEmployee(Employee employee, String name, int wage) {
		employee.setName(name);
		employee.setWage(wage);
	}

    /**
     * Updates the company of the employee.<br />
     * Requires: The company of the employee has changed.<br />
     * Note: null is an allowed value of company.
     */
    public void updateCompanyOfEmployee(Employee employee, Company company)
    {
        employee.setCompany(company);
    }
	

	//-----------------------------------------------------------------------------------

	//This method is used to initialise the store with some objects.
	private void createSomeObjects() {
		Company c1 = createCompany("IBM", 37);
		createCompany("AMD", 40);
		Company c3 = createCompany("SLED", 45);
		createCompany("Vector", 32);

		createEmployee("Bob Dole", 210);
		Employee e2 = createEmployee("Alice Schmidt", 250);
		updateCompanyOfEmployee(e2, c1);
		createEmployee("George Down", 150);
		Employee e4 = createEmployee("Rita Uphill", 300);
		updateCompanyOfEmployee(e4, c3);
	}

}
