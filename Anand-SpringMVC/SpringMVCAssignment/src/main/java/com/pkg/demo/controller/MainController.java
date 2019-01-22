package com.pkg.demo.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pkg.demo.JDBCTemplateDAO;
import com.pkg.demo.Student;

@Controller
public class MainController {
	
	@RequestMapping(value = "/student", method = RequestMethod.GET)
	public String student() {
		System.out.println("Welcome");
		return "new";
	}
	
	@RequestMapping(value = "/addStudent", method = RequestMethod.POST)
	public String addStudent(@ModelAttribute("student") Student student, ModelMap model) {
	System.out.println(student.getStudentName()+"  " +student.getStudentId() +"  "+ student.getStudentStatus());
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		JDBCTemplateDAO jdbcTemplateDao = applicationContext.getBean(JDBCTemplateDAO.class); 
		jdbcTemplateDao.saveStudent(student);	
		return "added";
	}
}
