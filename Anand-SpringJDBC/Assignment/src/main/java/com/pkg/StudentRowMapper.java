package com.pkg;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class StudentRowMapper implements RowMapper{

	@Override
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Student student = new Student();
		
		student.setStudentId(rs.getInt("studentId"));
		student.setStudentName(rs.getString("studentName"));
		student.setStudentStatus(rs.getString("studentStatus"));
		return student;
	}

}
