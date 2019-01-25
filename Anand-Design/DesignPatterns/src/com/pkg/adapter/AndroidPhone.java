package com.pkg.adapter;

public class AndroidPhone implements PhoneSpecification {

	private String brandName;
	private int ram;
	private String releaseYear;
	private String androidVersion;
	
	public AndroidPhone(String brandName, int ram, String releaseYear, String androidVersion) {
		super();
		this.brandName = brandName;
		this.ram = ram;
		this.releaseYear = releaseYear;
		this.androidVersion = androidVersion;
	}
	
	public String getAndroidVersion() {
		return androidVersion;
	}

	public void setAndroidVersion(String androidVersion) {
		this.androidVersion = androidVersion;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public int getRam() {
		return ram;
	}

	public void setRam(int ram) {
		this.ram = ram;
	}

	public String getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(String releaseYear) {
		this.releaseYear = releaseYear;
	}

	
	@Override
	public String getCallDetails() {
		// TODO Auto-generated method stub
		return "New features added to the call";
	}

}
