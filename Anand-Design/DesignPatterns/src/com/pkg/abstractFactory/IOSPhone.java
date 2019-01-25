package com.pkg.abstractFactory;

import java.awt.peer.FramePeer;

public class IOSPhone implements SmartPhone{
	private String model;
	private String releaseYear;
	private String os;
	
	public IOSPhone(String model, String releaseYear, String os) {
		super();
		this.model = model;
		this.releaseYear = releaseYear;
		this.os = os;
	}
	
	@Override
	public String getOs() {
		return os;
	}

	public void setOs(String os) {
		this.os = os;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public void setReleaseYear(String releaseYear) {
		this.releaseYear = releaseYear;
	}

	@Override
	public String getModel() {
		return this.model;
	}

	@Override
	public String getReleaseYear() {
		return this.releaseYear;
	}
}
