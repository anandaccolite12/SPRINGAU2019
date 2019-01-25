package com.pkg.abstractFactory;

public class SmartPhoneFactory {
	public static SmartPhone createSmartPhone(SmartPhoneAbstract smartPhone) {
		return smartPhone.getSmartPhone();
	}
}
