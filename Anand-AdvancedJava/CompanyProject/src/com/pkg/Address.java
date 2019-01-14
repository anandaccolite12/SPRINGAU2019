package com.pkg;

public class Address {
	private int number;
	private String streetName;
	private String cityName;
	private String stateName;
	private String countryName;
	
	public Address(int number, String streetName, String cityName, String stateName, String countryName) {
		super();
		this.number = number;
		this.streetName = streetName;
		this.cityName = cityName;
		this.stateName = stateName;
		this.countryName = countryName;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	@Override
	public String toString() {
		return "Address [number=" + number + ", streetName=" + streetName + ", cityName=" + cityName + ", stateName="
				+ stateName + ", countryName=" + countryName + "]";
	}
	
	
}
