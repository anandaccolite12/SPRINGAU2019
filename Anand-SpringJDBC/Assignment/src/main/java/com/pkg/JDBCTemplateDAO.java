package com.pkg;

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

@Component
public class JDBCTemplateDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public int saveStudent(Student student){
		String query = "insert into student values ("+student.getStudentId()+",'"+student.getStudentName()+"','"+student.getStudentStatus()+"')";
		return jdbcTemplate.update(query);
	}
	
	public Boolean saveStudentUsingPreparedStatement(final Student student){
		String query = "insert into attendence(studentId,studentName,studentStatus) values (?,?,?)";
		return jdbcTemplate.execute(query, new PreparedStatementCallback<Boolean>() {

			public Boolean doInPreparedStatement(PreparedStatement ps)
					throws SQLException, DataAccessException {
				ps.setLong(1, student.getStudentId());
				ps.setString(2, student.getStudentName());
				ps.setString(3, student.getStudentStatus());
				return ps.execute();
			}
		});
	}
	
	public Student getDetailUsingRowMapper(int id) {
		String sql= "select * from student where studentId = ? ";
		//Integer l=1;
		//Integer l = Integer.parseInt(id);
		Student student = (Student)jdbcTemplate.queryForObject(sql, new Object[] { id }, new StudentRowMapper());
		return student;
	}
	
	public List<Student> getAllDetailsUsingResultSet(){
		return jdbcTemplate.query("select * from student", new ResultSetExtractor<List>() {
			public List extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<Student> studentList = new ArrayList();
				while(rs.next()) {
					Student s = new Student();
					s.setStudentId(rs.getInt("studentId"));
					s.setStudentName(rs.getString("studentName"));
					s.setStudentStatus(rs.getString("studentStatus"));
					studentList.add(s);
				}
				return studentList;
			}
		});
	}
}
