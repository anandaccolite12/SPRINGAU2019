package com.pkg;
import java.util.*;

public class EntryClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Address address1 = new Address(17, "Kaadubhesanalli", "Bangalore", "Karnataka", "India");

		Set<Employee> employees1 = new TreeSet<Employee>();
		
		employees1.add(new Employee("3", "anand", 24));
		employees1.add(new Employee("1", "raj", 26));
		employees1.add(new Employee("2", "venu", 22));
		
		Company company1 = new Company("Accolite", employees1, address1);
		
		//1st task
		//Based on the age value, list of employees will be displayed using Super For loop 
		company1.listEmployeesBasedOnAge(25);

	
		Address address2 = new Address(21, "marathalli", "Bangalore", "Karnataka", "India");

		Set<Employee> employees2 = new TreeSet<Employee>();
		
		employees2.add(new Employee("13", "xxxx", 34));
		employees2.add(new Employee("11", "yyyy", 25));
		employees2.add(new Employee("12", "zzzzz", 21));
		
		Company company2 = new Company("NewCompany", employees2, address2);
		
		company2.listEmployeesBasedOnAge(30);
		
		Address address3 = new Address(27, "koramangala", "Bangalore", "Karnataka", "India");
		Company company3 = new Company("OldCompany", employees1, address3);

		Address address4 = new Address(21, "Adyar", "Chennai", "Tamilnadu", "India");
		Company company4 = new Company("SuperCompany", employees1, address4);
		
		//2nd task
		//TreeSet - will give output in ascending order based on given comparable parameter for sorting in compareTo function 
		//compareTo function overridden (employee id as comparable parameter)
		System.out.println(company1.getEmployees());
		
		
		
		//3rd task
		//HashSet - City is the key for storing Companies
		//hashCode and equals has been overridden
		//the companies which in same city will have same key(hashcode)
		Set<Company> companySet = new HashSet<Company>();
		
		System.out.println("\nHascode for the companies : ");
		
		companySet.add(company1);
		companySet.add(company2);
		companySet.add(company3);
		companySet.add(company4);
		
		System.out.println(companySet.size());
		System.out.println("Company Set : \n\n"+companySet);
		
	}
	
}
