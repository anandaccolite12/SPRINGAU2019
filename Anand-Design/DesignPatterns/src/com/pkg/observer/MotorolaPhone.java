package com.pkg.observer;


//Observer
public class MotorolaPhone extends AndroidPhone{

	public MotorolaPhone(String brandName, int ram, String releaseYear, String androidVersion) {
		super(brandName, ram, releaseYear, androidVersion);
	}

	//it will get notify on android version update 
	@Override
	public void setAndroidUpdate(String androidVersion) {
		if(this.getRam()>=2) {
			this.setAndroidVersion(androidVersion);
		}
	}

	@Override
	public String toString() {
		return "Name : "+this.getBrandName()+", Android version : "+this.getAndroidVersion();
	}

	
}
