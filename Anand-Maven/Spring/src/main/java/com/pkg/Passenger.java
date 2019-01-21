package com.pkg;

public class Passenger {
	private int passengerId;
	private String passengerName;
	private String phoneNo;
	private String email;
	private String location;
	
	public Passenger() {
		
	}
	
	public Passenger(int passengerId, String passengerName, String phoneNo, String email, String location) {
		super();
		this.passengerId = passengerId;
		this.passengerName = passengerName;
		this.phoneNo = phoneNo;
		this.email = email;
		this.location = location;
	}

	public int getPassengerId() {
		return passengerId;
	}

	public void setPassengerId(int passengerId) {
		this.passengerId = passengerId;
	}

	public String getPassengerName() {
		return passengerName;
	}

	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
	
	
	
}
