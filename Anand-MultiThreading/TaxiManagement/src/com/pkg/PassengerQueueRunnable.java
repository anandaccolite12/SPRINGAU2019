package com.pkg;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class PassengerQueueRunnable implements Runnable{

	TaxiStand globalTaxiStand;
	LinkedList<Passenger> passengerQueue;
    
    public PassengerQueueRunnable(LinkedList<Passenger> passengerQueue,TaxiStand s){
    	this.passengerQueue = passengerQueue;
    	this.globalTaxiStand = s;
	}

	@Override
    public void run(){
    	 System.out.println("\t\t*******Passenger Queue thread started*******");
    	
        while(true){
            try {
                Thread.sleep(3000);
            } catch (InterruptedException ie){
            	System.out.println(ie.getMessage());
            }
            
            //taking copy of globalTaxiStand list
            CopyOnWriteArrayList<Taxi> taxiStand = globalTaxiStand.getTaxistand();
        	LinkedList<Taxi> taxiQueue = globalTaxiStand.getTaxiQueue();
            
        	ListIterator<Taxi> iterator = taxiStand.listIterator();
        	
        	//Taxi timeout checking and producing new taxi stand and queue
        	while(iterator.hasNext()){
        		//taxi in the taxi stand
        		Taxi taxi = iterator.next();
	        	
        		if(taxi.getTaxiSize()>0){
		        	try {
		        		//checking timeout of taxi's in taxi stand 
						if(taxi.getTime() >= 60){
							System.out.println("Due to Timeout !!! The Taxi  is : " + taxi.getTaxiName() + " leaving to :" + taxi.getdestination());
							taxiStand.remove(taxi);
							if(taxiQueue.size() > 0){
								taxiStand.add(taxiQueue.removeFirst());
							}
						}
					} catch (ParseException e) {
						e.printStackTrace();
					}
	        	}
        	}
        	
            int pick = new Random().nextInt(Passenger.DESTINATION.values().length);

        	DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        	Date date = new Date();
        	System.out.println("\n\t Adding new passenger : "+dateFormat.format(date));
            
        	globalTaxiStand.setTaxiQueue(taxiQueue);
        	globalTaxiStand.setTaxistand(taxiStand);
        	
            Passenger p = new Passenger(Passenger.DESTINATION_VALUES[pick]);
            System.out.println("\n" + p.getPassengerName() + " looking for a destination " + p.getDestination());
            
            if(!globalTaxiStand.allocatePassenger(p)){
            	passengerQueue.add(p);
                System.out.println("No cab found for "+p.getPassengerName()+", So he/she added to Passenger queue");
            }
           
        }
    }
}
