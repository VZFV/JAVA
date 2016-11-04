/**
 * AirportSimulartorTest
 * Author: Feng Zhang
 * 10/14/2016
 * window 10 64bit, eclipse
 * This is he main function which test the airportsimulator.
 */
package HW2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class AirportSimulartorTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scanner = openInputFile();
		AirportSimulator airportSimulator = new AirportSimulator(scanner);
		airportSimulator.runSimulation();
		cloneTester();
		
	}
	
	public static Scanner userScanner = new Scanner(System.in);
	
	public static Scanner openInputFile()
	{
		String filename;
        	Scanner scanner=null;
        
		System.out.print("Enter the input filename: ");
		filename = userScanner.nextLine();
        	File file= new File(filename);

        	try{
        		scanner = new Scanner(file);
        	}// end try
        	catch(FileNotFoundException fe){
        	   System.out.println("Can't open input file\n");
       	    return null; // array of 0 elements
        	} // end catch
        	return scanner;
	}

	
	public static void cloneTester()
	{
		LinkedQueue<Event> theQueue = new LinkedQueue<Event>();
		Scanner infile;
		int id;
		double start;
		double dur;
		Event currEvent=null;

		infile = openInputFile();
		if ( infile == null) // open the same file you used for the simulation
		{
			System.out.println("Unable to open input file for testing clone()\n");
			return;
		}
		while (infile.hasNext())
		{
			id = infile.nextInt();
			start = infile.nextDouble();
			dur = infile.nextDouble();
			currEvent = new Event(id, start, dur);
			theQueue.enqueue(currEvent);
		}
		infile.close();
		LinkedQueue<Event> copyQueue = theQueue.deepClone();
		System.out.println( "\nContents of the copy queue:\n");
		clearAndDisplayQueue(copyQueue);
		System.out.println( "\nContents of the source queue:\n");
		clearAndDisplayQueue(theQueue);
		System.out.println("\nAdding back the last in the file: ");
		theQueue.enqueue(currEvent);
		currEvent = theQueue.peekFront();
		System.out.println( currEvent );
	}

	public static void clearAndDisplayQueue(LinkedQueue<Event> queue)
	{
		Event event;
		int id;
	 
		while (!queue.isEmpty())
		{
			event = queue.peekFront();
			id = event.getId();
			System.out.println( event );
			event.setId(id*10); // shouldn't change output anywhere
			queue.dequeue();
		}
		System.out.println("Queue has been emptied\n");
	}
}


/**
 * Enter the input filename: HW2TestInput1.txt
Starting simulation at 0.0
Starting takeoff ID# -100 at 17.0
Completed takeoff ID# -100 at 23.0
Starting takeoff ID# -102 at 23.0
Completed takeoff ID# -102 at 30.0
Starting landing ID# 200 at 30.0
Completed landing ID# 200 at 35.0
Starting takeoff ID# -105 at 35.0
Completed takeoff ID# -105 at 40.0
Starting landing ID# 203 at 40.0
Completed landing ID# 203 at 48.0
Starting takeoff ID# -106 at 55.0
Completed takeoff ID# -106 at 61.0
Starting landing ID# 204 at 65.0
Completed landing ID# 204 at 72.0
Starting takeoff ID# -108 at 72.0
Completed takeoff ID# -108 at 80.0
Starting landing ID# 209 at 88.0
Completed landing ID# 209 at 94.0
Starting landing ID# 211 at 94.0
Completed landing ID# 211 at 99.0
Starting takeoff ID# -110 at 99.0
Completed takeoff ID# -110 at 107.0
Starting takeoff ID# -112 at 107.0
Completed takeoff ID# -112 at 114.0
Ended simulation at 114.0
Total Runway Idle Time: 36.0
Number of planes: 12
Total Wait Time: 37.0
Average Wait Time per plane: 3.0833333333333335
Enter the input filename: HW2TestInput1.txt

Contents of the copy queue:

Queue has been emptied


Contents of the source queue:

Event: -100, 17.0, 6.0
Event: -102, 22.0, 7.0
Event: 200, 25.0, 5.0
Event: -105, 29.0, 5.0
Event: 203, 31.0, 8.0
Event: -106, 55.0, 6.0
Event: 204, 65.0, 7.0
Event: -108, 67.0, 8.0
Event: 209, 88.0, 6.0
Event: 211, 92.0, 5.0
Event: -110, 97.0, 8.0
Event: -112, 100.0, 7.0
Queue has been emptied


Adding back the last in the file: 
Event: -1120, 100.0, 7.0
*/
