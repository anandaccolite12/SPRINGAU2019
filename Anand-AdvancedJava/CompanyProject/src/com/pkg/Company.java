package com.pkg;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Company {
	private String name;
	private Set<Employee> employees;
	private Address address;
	
	public Company(String name, Set<Employee> employees, Address address) {
		super();
		this.name = name;
		this.employees = employees;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	public void listEmployeesBasedOnAge(int age) {
		System.out.println("\n==> Using Advance For Loop ");
		for (Employee employee : employees) {
			if(employee.getAge() < age) {
				System.out.println(employee);
			}
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.getCityName().hashCode());
		System.out.println(address.getCityName() + result);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Company other = (Company) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (employees == null) {
			if (other.employees != null)
				return false;
		} else if (!employees.equals(other.employees))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	
	@Override
	public String toString() {
		return "Company [name=" + name + ", employees=\n" + employees + ", address=" + address + "]\n\n";
	}
	
	
	
	
}
