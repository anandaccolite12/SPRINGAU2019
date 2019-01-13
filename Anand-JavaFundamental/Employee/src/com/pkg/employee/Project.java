package com.pkg.employee;


//both manager and developer has project 
//composition

public class Project {
	private String name;
	private int noOfMembersCount;
	private String clientName;
	private String projectStartDate;
	
	public Project(String name, int noOfMembersCount, String clientName, String projectStartDate) {
		super();
		this.name = name;
		this.noOfMembersCount = noOfMembersCount;
		this.clientName = clientName;
		this.projectStartDate = projectStartDate;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getNoOfMembersCount() {
		return noOfMembersCount;
	}
	
	public void setNoOfMembersCount(int noOfMembersCount) {
		this.noOfMembersCount = noOfMembersCount;
	}
	
	public String getClientName() {
		return clientName;
	}
	
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	
}
