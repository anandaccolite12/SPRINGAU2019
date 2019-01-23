package com.spring.au.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.spring.au.constant.CommonConstant;
import com.spring.au.dao.interfaces.StudentDao;
import com.spring.au.model.Student;

@Repository
public class StudentDaoImpl implements StudentDao{

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public String getName() {
		return jdbcTemplate.queryForObject(CommonConstant.SEARCHBYNAME, String.class);
	}
	
	

	@Override
	public void insertStudent(Student student) {
		String query = "insert into student values ("+student.getStudentId()+",'"+student.getStudentName()+"')";
		jdbcTemplate.update(query);
	}



	@SuppressWarnings("unchecked")
	@Override
	public List<Student> getAllStudents() {
		return jdbcTemplate.query(CommonConstant.SEARCH, new ResultSetExtractor<List>() {
			@Override
			public List<Student> extractData(ResultSet rs) throws SQLException {
				List<Student> studentList = new ArrayList<>();
				while(rs.next()) {
					Student s = new Student();
					s.setStudentId(rs.getString("studentId"));
					s.setStudentName(rs.getString("studentName"));
					studentList.add(s);
				}
				return studentList;
			}
		});
	}



}
