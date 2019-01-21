package com.pkg;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.*;

public class TaxiStand{
	private int size;
	private CopyOnWriteArrayList<Taxi> taxiStand;
	private LinkedList<Taxi> taxiQueue;
	private LinkedList<Passenger> passengerQueue;

	public TaxiStand(int capacity, LinkedList<Taxi> taxiQueue, LinkedList<Passenger> passengerQueue) {
		this.size = capacity;
		this.taxiQueue = taxiQueue;
		this.passengerQueue = passengerQueue;
		taxiStand = new CopyOnWriteArrayList<Taxi>();
		
		//initial taxi's allocation
		for(int i=0; i<size; i++) {
			Taxi taxi = new Taxi();
			taxi.setTime();
			taxiStand.add(taxi);
		}
	}
	
	public CopyOnWriteArrayList<Taxi> getTaxistand(){
		return this.taxiStand;
	}
	
	public LinkedList<Taxi> getTaxiQueue(){
		return this.taxiQueue;
	}
	
	public void setTaxistand(CopyOnWriteArrayList<Taxi> updatedtaxiStand){
		this.taxiStand = updatedtaxiStand;
	}
	
	public void setTaxiQueue(LinkedList<Taxi> updatedtaxiQueue){
		this.taxiQueue = updatedtaxiQueue;
	}
	
	public boolean addTaxi(Taxi taxi){
		if(taxiStand.size() < 5){
			taxiStand.add(taxi);
			return true;
		}
		taxiQueue.add(taxi);
		return false;
	}

	public boolean isFull(){
		return (taxiStand.size() < size) ? false : true;
	}

	public boolean isEmpty(){
		return (taxiStand.size() == 0) ? true : false;
	}
	
	public void addNewTaxi() {
		Taxi taxi = new Taxi();
		DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
    	Date date = new Date();
    	System.out.println("\n\t Adding new taxi : "+dateFormat.format(date));
		taxi.setTime();
		if(addTaxi(taxi))
			System.out.println("Taxi added to Taxi Stand");
	}

	public boolean allocatePassenger(Passenger p){
		
		Passenger passenger = passengerQueue.poll();
		ListIterator<Taxi> iterator = taxiStand.listIterator();
		boolean passengerAdded = false;
		
		while(!passengerAdded && iterator.hasNext()){
			Taxi taxi = iterator.next();
		
			if(taxi.isTaxiFull()){
				System.out.println(taxi.getTaxiName()+" is full, So taxi leaving to its destination " + taxi.getdestination());
				taxiStand.remove(taxi);
				
				if (taxiQueue.size() > 0)
					taxiStand.add(taxiQueue.removeFirst());
				else
					this.addNewTaxi();
			}

			//priority to the passenger in passengerQueue
			else if((passenger != null) && passenger.getDestination() == taxi.getdestination()){
				System.out.println("***Destination is matched with passenger in passenger queue !!!");
				passengerQueue.removeFirst();
				taxi.allocatePassenger(passenger);
				passengerAdded = true;
				System.out.println("Length of the Passenger Queue : " + passengerQueue.size());
			}
			
			//for new passenger
			else if (taxi.allocatePassenger(p)){
				passengerAdded = true;
			}
			
		}
		
		return passengerAdded;
	}


	public static void main(String[] args){
		
		System.out.println("\t\t\t=======Starting simulaion of Taxi Management System=====\n");
		
		LinkedList<Taxi> taxiQueue = new LinkedList<Taxi>();
		LinkedList<Passenger> passengerQueue = new LinkedList<Passenger>();
		System.out.println("Creating taxi's");
		TaxiStand lot = new TaxiStand(5, taxiQueue, passengerQueue);
		
		TaxiQueueRunnable taxiQueueRunnable = new TaxiQueueRunnable(taxiQueue, lot);
		PassengerQueueRunnable passengerQueueRunnable = new PassengerQueueRunnable(passengerQueue, lot);
		Thread taxiThread = new Thread(taxiQueueRunnable);
		Thread passengerThread = new Thread(passengerQueueRunnable);
		
		/*
		 * passengerThread.setPriority(8); 
		 * taxiThread.setPriority(6);
		 */
		
		taxiThread.start();
		passengerThread.start();
	
	}
}
