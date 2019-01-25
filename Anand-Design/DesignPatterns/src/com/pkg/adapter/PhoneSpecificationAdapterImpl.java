package com.pkg.adapter;

public class PhoneSpecificationAdapterImpl implements PhoneSpecificationAdapter {
	private PhoneSpecification phoneSpecification;
	
	public PhoneSpecificationAdapterImpl(PhoneSpecification phoneSpecification) {
		super();
		this.phoneSpecification = phoneSpecification;
	}



	@Override
	public String getCallDetails() {
		// TODO Auto-generated method stub
		return phoneSpecification.getCallDetails()+", Hd Call support added";
	}

}
