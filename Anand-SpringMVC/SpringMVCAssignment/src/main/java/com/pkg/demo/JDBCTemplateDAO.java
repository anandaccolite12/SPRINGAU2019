package com.pkg.demo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

import com.pkg.demo.Student;


@Component
public class JDBCTemplateDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public int saveStudent(Student student){
		String query = "insert into student values ("+student.getStudentId()+",'"+student.getStudentName()+"','"+student.getStudentStatus()+"')";
		return jdbcTemplate.update(query);
	}
}
