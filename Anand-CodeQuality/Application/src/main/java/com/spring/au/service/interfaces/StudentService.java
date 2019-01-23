package com.spring.au.service.interfaces;

import java.util.List;

import com.spring.au.model.Student;


public interface StudentService {
	public String getName();
	public void insertStudent(Student student);
	public List<Student> getAllStudents();
}