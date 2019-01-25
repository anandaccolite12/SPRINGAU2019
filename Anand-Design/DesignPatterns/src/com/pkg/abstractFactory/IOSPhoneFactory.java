package com.pkg.abstractFactory;

public class IOSPhoneFactory extends SmartPhoneAbstract{
	@Override
	public SmartPhone getSmartPhone() {
		return new IOSPhone("iPhone5s","2016","IOS-12");
	}
}
