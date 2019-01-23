package com.pkg.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class StudentMarkList implements Serializable{
	private Student student;
	Map<String, Integer> subjectMarks = new HashMap<String, Integer>();
	
	public Student getStudent() {
		return student;
	}
	
	public void setStudent(Student student) {
		this.student = student;
	}
	
	public Map<String, Integer> getSubjectMarks() {
		return subjectMarks;
	}
	
	public void setSubjectMarks(Map<String, Integer> subjectMarks) {
		this.subjectMarks = subjectMarks;
	}
	
	@Override
	public String toString() {
		return "StudentMarkList [student=" + student + ", subjectMarks=" + subjectMarks + "]";
	}	
	
	
}
