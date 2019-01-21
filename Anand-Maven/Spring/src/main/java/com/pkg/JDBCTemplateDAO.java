package com.pkg;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.stereotype.Component;


@Component
public class JDBCTemplateDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public ArrayList<Driver> display() {
		List<Map<String, Object>> l = jdbcTemplate.queryForList("select * from driver");
		ArrayList<Driver> al = new ArrayList<Driver>();

		for (Map<String, Object> driver : l) {
			Driver d= new Driver();
			for (Iterator<Map.Entry<String, Object>> it = driver.entrySet().iterator(); it.hasNext();) {
				Map.Entry<String, Object> entry = it.next();
				String key = entry.getKey();
				Object value = entry.getValue();
				
				if(key.equals("driverId")) {
					System.out.println("Inside"+value);
					d.setDriverId((int)value);
				}
				if(key.equals("driverName")) {
					d.setDriverName((String)value);
				}
				if(key.equals("phoneNo")) {
					d.setPhoneNo((String)value);
				}
				if(key.equals("vehicleRegNo")) {
					d.setVehicleRegNo((String)value);
				}
			}
			al.add(d);
		}
		
		for(Driver dr:al) {
			System.out.println(dr.getDriverId());
		}
		System.out.println(al.size());
		
		return al;
		
	}
	
	public Passenger getDetail(String id) {
		String sql= "select * from passenger where passengerId = ? ";
		//Integer l=1;
		Integer l = Integer.parseInt(id);
		Passenger passenger = (Passenger)jdbcTemplate.queryForObject(sql, new Object[] { l }, new PassengerRowMapper());
		return passenger;
	}
}
