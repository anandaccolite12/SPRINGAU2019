package com.pkg;

public class Student {
	
	private int studentId;
	private String studentName;
	private String StudentStatus;
	
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getStudentStatus() {
		return StudentStatus;
	}
	public void setStudentStatus(String studentStatus) {
		StudentStatus = studentStatus;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Name : " + this.studentName + " id : "+this.studentId + " status : "+ this.StudentStatus;
	}
	

}
