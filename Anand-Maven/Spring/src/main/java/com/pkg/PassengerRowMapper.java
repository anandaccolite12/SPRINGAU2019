package com.pkg;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class PassengerRowMapper implements RowMapper{
	
	@Override
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		Passenger passenger = new Passenger();
		passenger.setPassengerId(rs.getInt("passengerId"));
		passenger.setPassengerName(rs.getString("passengerName"));
		passenger.setPhoneNo(rs.getString("phoneNo"));
		passenger.setEmail(rs.getString("email"));
		passenger.setLocation(rs.getString("location"));
		return passenger;
	}

	
}
