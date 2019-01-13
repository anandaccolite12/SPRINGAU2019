package com.pkg.employee;


//inherited
public class Manager extends Employee {

	private Project teamManagerOf;
	
	public Manager(String name, int age, double salary, String location, Project teamManagerOf) {
		super(name, age, salary, location);
		this.teamManagerOf = teamManagerOf;
		// TODO Auto-generated constructor stub
	}

	public void createPlan() {
		System.out.println("Plan Created");
	}
	public void assignTask() {
		System.out.println("Task Assigned");
	}
	public void conductAppraisalMeeting() {
		System.out.println("Get details of the employee");
	}

	@Override
	public String toString() {
		return super.toString()+" Manager [teamManagerOf=" + teamManagerOf.getName() + "]";
	}

	@Override
	public void raiseSalary() {
		// TODO Auto-generated method stub
		this.setSalary(this.getSalary()*0.50);
	}

	@Override
	public void getDesgnation() {
		// TODO Auto-generated method stub
		System.out.println("*****Manager*****");
	} 
	
	
	
}
