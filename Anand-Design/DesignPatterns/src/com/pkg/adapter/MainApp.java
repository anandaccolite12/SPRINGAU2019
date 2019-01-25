package com.pkg.adapter;

public class MainApp {
	public static void main(String[] args) {
		AndroidPhone ps = new AndroidPhone("Samsung", 3, "2017", "Oreo");
		PhoneSpecificationAdapter psa = new PhoneSpecificationAdapterImpl(ps);
		
		System.out.println("Before adapter : " + ps.getCallDetails());
		
		System.out.println("After adapter : "+ psa.getCallDetails());
		
		
	}
}
