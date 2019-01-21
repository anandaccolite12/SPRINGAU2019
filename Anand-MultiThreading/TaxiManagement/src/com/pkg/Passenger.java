package com.pkg;

import java.util.*;


public class Passenger{
	public static int passengerCount=1;
	private DESTINATION Destination;
	private String passengerName;
	
	public static enum DESTINATION{
        WHITEFIELD, SARJAPUR, KRPURAM, INDIRANAGAR, MGROAD, HEBBAL, JAYANAGAR, PEENYA, HSRLAYOUT, KORAMANGLA
    }
	
	public static final DESTINATION[] DESTINATION_VALUES = DESTINATION.values();
    
	public Passenger(DESTINATION destination){
		this.setDestination(destination);
		this.passengerName = "Passenger-" + passengerCount++;
	}
	
	public DESTINATION getDestination(){
		return Destination;
	}
	
	public void setDestination(DESTINATION destination){
		this.Destination = destination;
	}
	
	public String getPassengerName(){
		return passengerName;
	}
	
	public void setName(String passengerName){
		this.passengerName = passengerName;
	}
}
