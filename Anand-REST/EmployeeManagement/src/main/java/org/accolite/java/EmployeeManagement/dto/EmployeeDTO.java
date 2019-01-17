package org.accolite.java.EmployeeManagement.dto;

public class EmployeeDTO {
	private String employeeName;
	private String employeeId;
	private String employeeAge;
	
	
	public EmployeeDTO() {
		
	}
	
	public EmployeeDTO(String employeeName, String employeeId, String employeeAge) {
		super();
		this.employeeName = employeeName;
		this.employeeId = employeeId;
		this.employeeAge = employeeAge;
	}

	public String getEmployeeName() {
		return employeeName;
	}
	
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	
	public String getEmployeeId() {
		return employeeId;
	}
	
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	
	public String getEmployeeAge() {
		return employeeAge;
	}
	
	public void setEmployeeAge(String employeeAge) {
		this.employeeAge = employeeAge;
	}
	
}
