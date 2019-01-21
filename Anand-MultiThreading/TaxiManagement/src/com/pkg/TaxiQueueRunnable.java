package com.pkg;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;

public class TaxiQueueRunnable implements Runnable{
	
    private LinkedList<Taxi> taxiQueue;
    private TaxiStand taxiStand;

    public TaxiQueueRunnable(LinkedList<Taxi> taxiQueue, TaxiStand taxiStand){
        this.taxiQueue = taxiQueue;
        this.taxiStand = taxiStand;
    }

    @Override
    public void run(){
        System.out.println("\n\t\t*******Taxi Queue thread started*******");
        
        while(true){
            try{
                Thread.sleep(60000);
            } catch (InterruptedException ie) {
            	System.out.println(ie.getMessage());
            }
            
            //Every one minute new taxi will be added to taxi stand
            Boolean addTaxiStatus = true;
            
			if(addTaxiStatus){
				Taxi taxi = new Taxi();
				DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
	        	Date date = new Date();
	        	System.out.println("\n\t Adding new taxi : "+dateFormat.format(date));
				taxi.setTime();
				addTaxiStatus = taxiStand.addTaxi(taxi);
				System.out.println("Taxi added to Taxi Stand");
			}
			else{
				System.out.println("Taxi stand is full. So Taxi added to the queue");
			}
        }
    }
}
