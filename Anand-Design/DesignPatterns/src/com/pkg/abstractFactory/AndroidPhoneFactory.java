package com.pkg.abstractFactory;

public class AndroidPhoneFactory extends SmartPhoneAbstract{
	@Override
	public SmartPhone getSmartPhone() {
		return new AndroidPhone("Android One", "2018", "Oreo");
	}
}
