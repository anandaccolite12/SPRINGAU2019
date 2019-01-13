package com.pkg.employee;

abstract public class Employee {
	
	private static  int employeeCount = 0;  //static variable 
	private final int minWorkHours = 8;		//final Variable	
	
	private int id;
	private String name;
	private int age;
	private double salary;
	private String location;
	private int noOfExperiance;
	
	
	//instance initializer block
	{
		System.out.println("Employee count incremented");
		employeeCount++;   
	}
	
	
	public Employee(String name, int age, double salary, String location) {
		super();
		this.name = name;
		this.age = age;
		this.salary = salary;
		this.location = location;
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public void fillTimeSheet () {
		System.out.println("TimeSheet Filled !!!!");
	}

	public void applyLeave() {
		System.out.println("Request Leave");
	}
	
	//abstract function
	abstract public void raiseSalary();
	abstract public void getDesgnation();
	
	
	@Override
	public String toString() {
		return "Employee [name=" + name + ", age=" + age + ", salary=" + salary + ", location=" + location + "]";
	}
	
	
	
}

