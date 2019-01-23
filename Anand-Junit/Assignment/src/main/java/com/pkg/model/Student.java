package com.pkg.model;

import java.io.Serializable;

public class Student implements Serializable{
	private String studentCode;
	private String studentName;
	private String dob;
	
	public String getStudentCode() {
		return studentCode;
	}
	
	public void setStudentCode(String studentCode) {
		this.studentCode = studentCode;
	}
	
	public String getStudentName() {
		return studentName;
	}
	
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	
	public String getDob() {
		return dob;
	}
	
	public void setDob(String dob) {
		this.dob = dob;
	}

	@Override
	public String toString() {
		return "Student [studentCode=" + studentCode + ", studentName=" + studentName + ", dob=" + dob + "]";
	}
	
	
}
