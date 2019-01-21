package com.pkg;

public class Driver {
	private int driverId;
	private String driverName;
	private String phoneNo;
	private String vehicleRegNo;
	
	public Driver() {
		
	}
	
	public Driver(int driverId, String driverName, String phoneNo, String vehicleRegNo) {
		super();
		this.driverId = driverId;
		this.driverName = driverName;
		this.phoneNo = phoneNo;
		this.vehicleRegNo = vehicleRegNo;
	}

	public int getDriverId() {
		return driverId;
	}

	public void setDriverId(int driverId) {
		this.driverId = driverId;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getVehicleRegNo() {
		return vehicleRegNo;
	}

	public void setVehicleRegNo(String vehicleRegNo) {
		this.vehicleRegNo = vehicleRegNo;
	}
	
	
	
}
