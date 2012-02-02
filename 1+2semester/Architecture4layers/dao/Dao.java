package dao;

import java.util.ArrayList;

import model.Company;
import model.Employee;

/**
 * @author mlch
 */
public class Dao {
	private static Dao instance = new Dao();
	private static ArrayList<Company> companies = new ArrayList<Company>();
	private static ArrayList<Employee> employees = new ArrayList<Employee>();
	
	private Dao(){}
	
	public static Dao getInstance(){
		if(instance == null){
			instance = new Dao();
		}
		return instance;
	}

	/**
	 * Returns a list of all stored companies.
	 */
	public ArrayList<Company> getAllCompanies() {
		return companies;
	}

	/**
	 * Stores the company.<br />
	 * Requires: The company is not stored.
	 */
	public void storeCompany(Company company) {
		companies.add(company);
	}

	/**
	 * Deletes the stored company.<br />
	 * Requires: The company is stored.
	 */
	public void removeCompany(Company company) {
		companies.remove(company);
	}

	/**
	 * Returns a list of all employees in the store.
	 */
	public ArrayList<Employee> getAllEmployees() {
		return employees;
	}

	/**
	 * Stores the employee.<br />
	 * Requires: The employee is not stored.
	 */
	public void storeEmployee(Employee employee) {
		employees.add(employee);
	}

	/**
	 * Removes the stored employee.<br />
	 * Requires: The employee is stored.
	 */
	public void removeEmployee(Employee employee) {
		employees.remove(employee);
	}

}
