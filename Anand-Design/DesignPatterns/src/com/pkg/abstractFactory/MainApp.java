package com.pkg.abstractFactory;

public class MainApp {

	public static void main(String[] args) {
		
		SmartPhone android = SmartPhoneFactory.createSmartPhone(new AndroidPhoneFactory());
		SmartPhone ios = SmartPhoneFactory.createSmartPhone(new IOSPhoneFactory());
	
		System.out.println("Model : "+android.getModel() + " **** Year : "+android.getReleaseYear() + " **** OS version : "+android.getOs());
		System.out.println("Model : "+ios.getModel() +" **** Year : "+ ios.getReleaseYear()+" **** OS version "+ios.getOs());
	
	}

}
