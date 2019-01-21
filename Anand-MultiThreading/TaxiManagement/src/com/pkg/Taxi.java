package com.pkg;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Taxi{
	private Passenger.DESTINATION destination;
	public static int taxiCount=1;
	private String taxiName;
	private int taxiSize;
	private String time;

	public Taxi(){
		this.setdestination(null);
		this.setTaxiSize(0);
		taxiName = "Taxi-" + taxiCount++;
		System.out.println("New Taxi name : " + taxiName);
		this.time= null;
	}
	
	public void setTime(){
		DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
    	Date date = new Date();
    	String time1= ""+dateFormat.format(date);
    	this.time=time1;
    	System.out.println(this.taxiName + " added time : " + time1);
	}
	
	public int getTime() throws ParseException{
		DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
    	Date date = new Date();
    	String time1= ""+dateFormat.format(date);
    	//System.out.println(this.getTaxiName() +" get time : " + "   " + time1);
    	SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
    	
    	Date date1 = format.parse(time1);
		Date date2 = format.parse(this.time);
    	long difference = date1.getTime() - date2.getTime(); 
    	return (int) (difference/1000);
	}

	public Passenger.DESTINATION getdestination(){
		return destination;
	}

	public void setdestination(Passenger.DESTINATION destination){
		this.destination = destination;
	}

	public String getTaxiName(){
		return taxiName;
	}

	public void setTaxiName(String taxi_name){
		this.taxiName = taxi_name;
	}

	public int getTaxiSize(){
		return taxiSize;
	}

	public void setTaxiSize(int taxiSize){
		this.taxiSize = taxiSize;
	}

	public void PassengerAdded(){
		this.taxiSize++;
	}

	public boolean isTaxiFull(){
		if(this.taxiSize == 4)
			return true;
		else
			return false;
	}

	public boolean addPassenger(){
		if(isTaxiFull()){
			System.out.println("Taxi is full");
			return false;
		}
		else{
			PassengerAdded();
			System.out.println(this.getTaxiName()+ " count is : " + this.getTaxiSize());
			return true;
		}
	}

	public boolean allocatePassenger(Passenger p){

		System.out.println(p.getPassengerName() + " destination : " + p.getDestination() + "\n"+this.getTaxiName()+" destination : " + this.destination);
		
		if(this.destination == null){
			System.out.println(this.getTaxiName()+" is empty, setting destination " + p.getDestination()+ " by 1st passenger " + p.getPassengerName());
			this.destination = p.getDestination();
			return addPassenger();
		}
		else{
			
			if(this.destination == p.getDestination()) {
				System.out.println("Found taxi with same destination " + this.destination);
				return addPassenger();
			}
			else{
				System.out.println(this.getTaxiName()+" is unable to allocate for " + p.getPassengerName() + " with the location " + p.getDestination());
				return false;
			}
		}
	}

}
