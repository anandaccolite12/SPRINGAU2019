package com.spring.au.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.au.model.Student;
import com.spring.au.service.interfaces.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
	@Autowired
	StudentService studentService ;
	
	@GetMapping("/getName")
	public String getName() {
		return studentService.getName();
	}
	
	@PostMapping("/insert/studentDetails")
	public void insertStudent(@RequestBody Student student) {
		studentService.insertStudent(student);
	}
	
	@GetMapping("/getAllStudents")
	public List<Student> getAllStudents(){
		return studentService.getAllStudents();
	}
	
}
