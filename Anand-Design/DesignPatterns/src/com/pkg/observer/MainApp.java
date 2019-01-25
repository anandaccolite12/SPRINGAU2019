package com.pkg.observer;

public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AndroidPhone phone1 = new SamsungPhone("galaxy", 2, "2014", "nougat");
		AndroidPhone phone2 = new MotorolaPhone("Moto5", 2, "2015", "nougat");
		
		AndroidManagement am = new AndroidManagement();
		am.setAndroidVersion("nougat");
		am.addBrand(phone1);
		am.addBrand(phone2);
		
		System.out.println("\t\tBefore update\n");
		System.out.println(phone1);
		System.out.println(phone2);
		
		am.notifyAndroidUpdate("oreo");
		

		System.out.println("\n\tAfter update\n");
		
		System.out.println(phone1);
		System.out.println(phone2);
		
	}

}
