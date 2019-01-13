package com.pkg.employee;

public class Developer extends Employee {

	private Project teamWorksIn;
	
	public Developer(String name, int age, double salary, String location, Project teamWorksIn) {
		super(name, age, salary, location);
		this.teamWorksIn = teamWorksIn;
		// TODO Auto-generated constructor stub
	}
	
	public void performAssignedTask() {
		System.out.println("Task assinged");
	}

	@Override
	public String toString() {
		return super.toString()+" Developer [teamWorksIn=" + teamWorksIn.getName() + "]";
	}

	@Override
	public void raiseSalary() {
		// TODO Auto-generated method stub
		this.setSalary(this.getSalary()*0.25);
	}
	
	@Override
	public void getDesgnation() {
		// TODO Auto-generated method stub
		System.out.println("*****Developer*****");
	} 
	
	
	
}
