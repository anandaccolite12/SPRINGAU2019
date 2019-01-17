package org.accolite.java.EmployeeManagement.service;

import java.util.*;

import org.accolite.java.EmployeeManagement.dto.EmployeeDTO;

public class EmployeeService {

	static List<EmployeeDTO> employeeList = new ArrayList<EmployeeDTO>();
	
	public EmployeeService() {
		employeeList.add(new EmployeeDTO("xxx","1","cbe"));
		employeeList.add(new EmployeeDTO("yyy","2","blore"));
		employeeList.add(new EmployeeDTO("zzz","3","hyb"));
	}
	
	
	public EmployeeDTO getEmployee(String id) {
		System.out.println("***Outside****"+id+"********");
		for(EmployeeDTO emp:employeeList) {
			System.out.println("*******"+emp.getEmployeeId()+"********");
			if(emp.getEmployeeId().equals(id)) {
				System.out.println("***Inside****"+id+"********");
				return emp;
			}
		}
		return null;
	}
	
	public List<EmployeeDTO> getAllEmployee() {
		return employeeList;
	}
	
	public String addEmployee(EmployeeDTO emp) {
		employeeList.add(emp);
		return "Added - " + emp.getEmployeeId();
	}
	
	public String deleteEmployee(String id) {
		for(EmployeeDTO emp:employeeList) {
			System.out.println("***OutsideDelete****"+id+"********");
			if(emp.getEmployeeId().equals(id)) {
				System.out.println("***InsideDelete****"+id+"********");
				employeeList.remove(new EmployeeDTO(emp.getEmployeeName(), emp.getEmployeeId(), emp.getEmployeeAge()));
				return "Deleted" + emp.getEmployeeId();
			}
		}
		return "ID not found, not deleted";
	}
	
	public String updateEmployee(EmployeeDTO emp) {
		for(EmployeeDTO employee:employeeList) {
			if(employee.getEmployeeId().equals(emp.getEmployeeId())) {
				employee.setEmployeeName("Updated" + emp.getEmployeeName());
				employee.setEmployeeAge("Updated" + emp.getEmployeeAge());
				return "Updated - "+emp.getEmployeeId();
			}
		}
		return "ID not found, not updated";
	}
	
}
