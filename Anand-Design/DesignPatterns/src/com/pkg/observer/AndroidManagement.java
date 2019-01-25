package com.pkg.observer;

import java.util.ArrayList;
import java.util.List;

//Android Management is an Observable
public class AndroidManagement {
	private String androidVersion;
	private List<AndroidPhone> androidBrands = new ArrayList<>();
	
	public String getAndroidVersion() {
		return androidVersion;
	}

	public void setAndroidVersion(String androidVersion) {
		this.androidVersion = androidVersion;
	}

	public void addBrand(AndroidPhone phone) {
		this.androidBrands.add(phone);
	}

	public void removeBrand(AndroidPhone phone) {
		this.androidBrands.remove(phone);
	}

	public void notifyAndroidUpdate(String newVersion) {
		this.androidVersion = newVersion;
		for (AndroidPhone brand : this.androidBrands) {
			brand.setAndroidUpdate(this.androidVersion);
		}
	}
}
