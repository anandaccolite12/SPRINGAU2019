Taxi management system

Assumptions made :

	* Taxi stand can accommodate 5 taxis.
	* Taxi once assigned to the stand can wait for 60 seconds.
	* Setting First passenger destination in the taxi as taxi destination.
	* New taxi arrives and added to passenger queue in every 60 seconds.
	* Every 3 seconds new passenger will be generated.
	* If no passenger get same destination taxi will be added in the passenger queue.
	* Priority given to the passenger in the passenger queue.
	
Crictical Section : 
	* Taxi Stand Queue (Common resource for passenger and taxi)
		(CopyOnWriteArrayList) - omit concurrent modification exception 
		
2 threads are used-
	1. Passenger generater (Passenger queue)
	2. Taxi generater (Taxi queue)


Thread starter : By running TaxiStand.java file