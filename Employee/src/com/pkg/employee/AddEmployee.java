package com.pkg.employee;

public class AddEmployee {

	public static void main(String[] args) {
	
		// TODO Auto-generated method stub
			Project project1 = new Project("ProjectNew", 10, "XYZ", "09-09-2017");
			
			Employee employee1 = new Manager("Anand", 23, 12300, "Bangalore", project1);
			
			Employee employee2 = new Developer("Raj", 21, 8000, "Bangalore", project1);
			
			System.out.println(employee1);
			System.out.println(employee2);
			
			employee1.getDesgnation();
			employee1.applyLeave();
			employee1.fillTimeSheet();
			employee1.raiseSalary();
			
	}

}
