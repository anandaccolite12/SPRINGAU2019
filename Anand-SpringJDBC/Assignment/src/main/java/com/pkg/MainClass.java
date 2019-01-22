package com.pkg;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		JDBCTemplateDAO jdbcTemplateDao = applicationContext.getBean(JDBCTemplateDAO.class);
		Student s =new Student();
		s.setStudentId(9);
		s.setStudentName("Jaga");
		s.setStudentStatus("A");
		
	//	jdbcTemplateDao.saveStudentUsingPreparedStatement(s);
	//	jdbcTemplateDao.saveStudent(s);
		
		//=======================================================
		//Using rowMapper retrieving single record from the table
		System.out.println(jdbcTemplateDao.getDetailUsingRowMapper(9).getStudentName());
		
		//=======================================================
		//Using resultSetEtractor retrieving multiple records from the table
		List<Student> studentList = jdbcTemplateDao.getAllDetailsUsingResultSet();
		for(Student st : studentList) {
			System.out.println(st.toString());
		}

	}

}
