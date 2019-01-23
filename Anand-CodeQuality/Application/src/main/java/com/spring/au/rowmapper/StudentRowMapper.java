package com.spring.au.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.spring.au.model.Student;

public class StudentRowMapper implements RowMapper {

	@Override
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		Student student = new Student();
		
		student.setStudentId(rs.getString("studentId"));
		student.setStudentName(rs.getString("studentName"));
		return student;
	}

}
