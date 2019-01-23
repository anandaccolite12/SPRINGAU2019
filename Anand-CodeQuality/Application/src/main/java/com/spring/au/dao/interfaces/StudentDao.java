package com.spring.au.dao.interfaces;

import java.util.List;

import com.spring.au.model.Student;

public interface StudentDao {
	public String getName();
	public void insertStudent(Student student);
	public List<Student> getAllStudents();
}
