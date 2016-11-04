/**
 * AirportSimulartor
 * Author: Feng Zhang
 * 10/14/2016
 * window 10 64bit, eclipse
 * This class is airportsimulator which can read, get, process event and display main information 
 * for users.
 * 
 */
package HW2;

import java.util.*;

public class AirportSimulator implements QSimulatorInterface
{
	private LinkedQueue<Event> runwayQueue = new LinkedQueue<Event>(); // for holding "takeoffs" and "landings"

	private Event runway = new Event();;  
	private double idleTimeTotal;	// accumulator for trafficController's idle time
	private double waitTimeTotal;	// accumulator for planes' wait time
	private int numEvents; 		// number of "planes"
	private double currTime; 	// current time during a simulation
	Scanner infile; 	// file being used for simulation

	public AirportSimulator(){  }
	
	public AirportSimulator(Scanner file)
	{
		infile = file;
	}
	
	public void setInputFile(Scanner file)
	{
		infile = file;
	}
	
	
	public Event readEvent()
	{
		int id;
		double startTime;
		double duration;
		Event event = null;
	
		if (infile == null || !infile.hasNext())
			return null;
	
		try
		{
			id = infile.nextInt();
			startTime = infile.nextDouble();
			duration = infile.nextDouble();
			event = new Event(id, startTime, duration);
		}
		catch( InputMismatchException ioe )
		{
			return null;
		}
		return event;
	}
	
	// to run simulation
	public void runSimulation()
	{
		idleTimeTotal = 0.0; 	// initialize idleTimeTotal
		waitTimeTotal = 0.0; 	// initialize waitTimeTotal
		numEvents = 0;		 	// initialize numEvents
		currTime = 0.0;		 	// initialize currTime
		runway.id = 0;		 	// initialize runway's id
		runway.startTime = 0.0;	// initialize runway's startTime
		runway.duration = 0.0;	// initialize runway's duration
		
		// display original information
		System.out.println("Starting simulation at " + currTime);
		Event var = getEvent(); // get event
		while (var!=null){ 		// to determine the event is null or not
			processEvent(var);  // process the event
			var = getEvent();	// get next event
		} //end loop
		
		displayStatistics();

	}
	// to get event from file
	public Event getEvent()
	{
		Event var1 = null; // Initialize local Event variables var1
		Event var2 = null; // Initialize local Event variables var2
		
		if (runway.id != 0){ // to determine the runway is processing a plane
			return runway;
		}
		else{
			if(!runwayQueue.isEmpty()){	
				var1 = runwayQueue.peekFront(); // to get first event
				runwayQueue.dequeue();	// remove first event
			}else{
				var1 = readEvent();		// read the event
			} // end if
			
			var2 = readEvent();			// read the event
			
			if (var2 != null){
				runwayQueue.enqueue(var2);	// enqueue the event to runwayQueue
			} // end if
			
			return var1;
		} // end if
		
	}
	// to process event which has been called from getEvent method
	public void processEvent(Event currEvent)
	{
		if(currEvent == runway){
			currTime = runway.startTime + runway.duration;
			
			if (currEvent.id < 0){ // determine a takeoff
				System.out.println("Completed takeoff ID# " + currEvent.id + " at " + currTime); // display completed takeoff information
			}
			
			if (currEvent.id > 0){ // determine a landing
				System.out.println("Completed landing ID# " + currEvent.id + " at " + currTime); // display completed landing information
			}
			
			runway.id = 0;
			runway.startTime = currTime;
		}else{
			double requestTime = currEvent.startTime;
			
			if (currTime < requestTime){
				currTime = requestTime;
			}
			
			idleTimeTotal += currTime - runway.startTime;
			waitTimeTotal += currTime - currEvent.startTime;
			
			numEvents++;
			
			if (currEvent.id < 0){ // determine a takeoff
				System.out.println("Starting takeoff ID# " + currEvent.id + " at " + currTime); // display Starting takeoff information
			}
			
			if (currEvent.id > 0){ // determine a landing
				System.out.println("Starting landing ID# " + currEvent.id + " at " + currTime); // display Starting landing information
			}
			
			runway.id = currEvent.id;
			runway.startTime = currTime;
			runway.duration = currEvent.duration;
		}

	}
	// display currTime, idleTimeTotal, numEvents, waitTimeTotal and Average Wait Time
	public void displayStatistics()
	{
		
		System.out.printf("Ended simulation at %s\n", currTime);
		System.out.printf("Total Runway Idle Time: %s\n", idleTimeTotal);
		System.out.printf("Number of planes: %s\n", numEvents);
		System.out.printf("Total Wait Time: %s\n", waitTimeTotal);
		System.out.printf("Average Wait Time per plane: %.16f\n", waitTimeTotal/numEvents);

	}
}