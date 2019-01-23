package com.spring.au.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.au.dao.interfaces.StudentDao;
import com.spring.au.model.Student;
import com.spring.au.service.interfaces.StudentService;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	public StudentDao studentDao;
	
	@Override
	public String getName() {
		return studentDao.getName();
	}

	@Override
	public void insertStudent(Student student) {
		studentDao.insertStudent(student);
	}

	@Override
	public List<Student> getAllStudents() {
		return studentDao.getAllStudents();
	}

}
