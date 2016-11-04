/**
 * WheelGamesTest
 * Author: Feng Zhang
 * 10/30/2016
 * window 10 64bit, eclipse
 * This is the main function which test the WheelGame.
 */

package HW3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WheelGameTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = openInputFile();
		WheelGame wheelgame = new WheelGame(scanner, 5); //instantiate a WheelGame, passing the Scanner and 5,
		wheelgame.playGame(); // call play game method
		testCircularList(); // test testCircularList method
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
	
	// TEST CircularLList2: CALL FROM MAIN (at the end of main):
	public static void testCircularList()
	{
		String strArray[] = { "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday" };
		CircularList2<String> list;
		String tempStr1;

		list = new CircularList2<String>();
		for (int i = 0; i < strArray.length ; ++i)
		{
			list.add(i+1, strArray[i]);
		}
		System.out.println( "\nThe test list has:" );
		list.display();
		tempStr1 = list.getEntry("Tuesday");
		if (tempStr1 != null)
			System.out.println( "Found " + tempStr1 + " in the list!");
		else
			System.out.println( "Error in the program: Tuesday wasn't found");
		if (list.remove("Monday"))
			System.out.println( "Monday was successfully removed from the list!");
		else
			System.out.println( "Error in the program: Monday couldn't be removed");
		if (list.remove("Sunday"))
			System.out.println(  "Sunday was successfully removed from the list!");
		else
			System.out.println( "Error in the program: Sunday couldn't be removed");
		if (list.remove("Thursday"))
			System.out.println( "Thursday was successfully removed from the list!");
		else
			System.out.println(  "Error in the program: Thursday couldn't be removed");
		System.out.println( "\nNow the test list has:");
		list.display();
		tempStr1 = list.getEntry("Mardi");
		if (tempStr1 != null)
			System.out.println( "Found " + tempStr1 + " in the list????");
		else
			System.out.println( "Good: Mardi wasn't found");

	}

}

/**
 * Enter the input filename: \d:\HW3TestInput1.txt

Spinning Wheel for ID # 1........ and it's 200!
Adding the wheel's current value to this Player
This player now has 700

Spinning Wheel for ID # 2........ and it's 900!
Adding the wheel's current value to this Player
This player now has 1400

Spinning Wheel for ID # 3........ and it's -500!
Reducing the previous Player's total by this amount
The previous player with ID# 2 now has a total of 900

Spinning Wheel for ID # 4........ and it's 850!
Adding the wheel's current value to this Player
This player now has 1350

Spinning Wheel for ID # 5........ and it's 300!
Adding the wheel's current value to this Player
This player now has 800

Spinning Wheel for ID # 1........ and it's 900!
Adding the wheel's current value to this Player
This player now has 1600

Spinning Wheel for ID # 2........ and it's 550!
Adding the wheel's current value to this Player
This player now has 1450

Spinning Wheel for ID # 3........ and it's -600!
Reducing the previous Player's total by this amount
The previous player with ID# 2 now has a total of 850

Spinning Wheel for ID # 4........ and it's 0!
Subtracting the last of this Player's value from the Player's total
Now the total is 500

Spinning Wheel for ID # 5........ and it's 800!
Adding the wheel's current value to this Player
This player now has 1600

Spinning Wheel for ID # 1........ and it's 750!
Adding the wheel's current value to this Player
This player now has 2350

Spinning Wheel for ID # 2........ and it's 350!
Adding the wheel's current value to this Player
This player now has 1200

Spinning Wheel for ID # 3........ and it's -600!
Reducing the previous Player's total by this amount
The previous player with ID# 2 now has a total of 600

Spinning Wheel for ID # 4........ and it's 300!
Adding the wheel's current value to this Player
This player now has 800

Spinning Wheel for ID # 5........ and it's 400!
Adding the wheel's current value to this Player
This player now has 2000

Spinning Wheel for ID # 1........ and it's 800!
Adding the wheel's current value to this Player
This player now has 3150

Spinning Wheel for ID # 2........ and it's 0!
Subtracting the last of this Player's value from the Player's total
Now the total is 250

Spinning Wheel for ID # 3........ and it's -650!
Reducing the previous Player's total by this amount
The previous player with ID# 2 now has a total of -400
!!!!! Removing player with ID# 2!!!!!

Spinning Wheel for ID # 4........ and it's 950!
Adding the wheel's current value to this Player
This player now has 1750

Spinning Wheel for ID # 5........ and it's 800!
Adding the wheel's current value to this Player
This player now has 2800

Spinning Wheel for ID # 1........ and it's 450!
Adding the wheel's current value to this Player
This player now has 3600

Spinning Wheel for ID # 3........ and it's 200!
Adding the wheel's current value to this Player
This player now has 700

Spinning Wheel for ID # 4........ and it's -650!
Reducing the previous Player's total by this amount
The previous player with ID# 3 now has a total of 50

Spinning Wheel for ID # 5........ and it's 450!
Adding the wheel's current value to this Player
This player now has 3250

Spinning Wheel for ID # 1........ and it's 250!
Adding the wheel's current value to this Player
This player now has 3850

Spinning Wheel for ID # 3........ and it's 50!
Adding the wheel's current value to this Player
This player now has 100

Spinning Wheel for ID # 4........ and it's 150!
Adding the wheel's current value to this Player
This player now has 1900

Spinning Wheel for ID # 5........ and it's 900!
Adding the wheel's current value to this Player
This player now has 4150

Spinning Wheel for ID # 1........ and it's 450!
Adding the wheel's current value to this Player
This player now has 4300

Spinning Wheel for ID # 3........ and it's 800!
Adding the wheel's current value to this Player
This player now has 900

Spinning Wheel for ID # 4........ and it's -500!
Reducing the previous Player's total by this amount
The previous player with ID# 3 now has a total of 400

Spinning Wheel for ID # 5........ and it's 0!
Subtracting the last of this Player's value from the Player's total
Now the total is 3250

Spinning Wheel for ID # 1........ and it's 900!
Adding the wheel's current value to this Player
This player now has 5200

Spinning Wheel for ID # 3........ and it's 200!
Adding the wheel's current value to this Player
This player now has 600

Spinning Wheel for ID # 4........ and it's 900!
Adding the wheel's current value to this Player
This player now has 2800

Spinning Wheel for ID # 5........ and it's 400!
Adding the wheel's current value to this Player
This player now has 3650

Spinning Wheel for ID # 1........ and it's 750!
Adding the wheel's current value to this Player
This player now has 5950

Spinning Wheel for ID # 3........ and it's 800!
Adding the wheel's current value to this Player
This player now has 1400

Spinning Wheel for ID # 4........ and it's 950!
Adding the wheel's current value to this Player
This player now has 3750

Spinning Wheel for ID # 5........ and it's 800!
Adding the wheel's current value to this Player
This player now has 4450

Spinning Wheel for ID # 1........ and it's 450!
Adding the wheel's current value to this Player
This player now has 6400

Spinning Wheel for ID # 3........ and it's 750!
Adding the wheel's current value to this Player
This player now has 2150

Spinning Wheel for ID # 4........ and it's 350!
Adding the wheel's current value to this Player
This player now has 4100

Spinning Wheel for ID # 5........ and it's 300!
Adding the wheel's current value to this Player
This player now has 4750

Spinning Wheel for ID # 1........ and it's 950!
Adding the wheel's current value to this Player
This player now has 7350

Spinning Wheel for ID # 3........ and it's 450!
Adding the wheel's current value to this Player
This player now has 2600

Spinning Wheel for ID # 4........ and it's 900!
Adding the wheel's current value to this Player
This player now has 5000

Spinning Wheel for ID # 5........ and it's 0!
Subtracting the last of this Player's value from the Player's total
Now the total is 4450

Spinning Wheel for ID # 1........ and it's 950!
Adding the wheel's current value to this Player
This player now has 8300

Spinning Wheel for ID # 3........ and it's 800!
Adding the wheel's current value to this Player
This player now has 3400
timed out, no winner

The test list has:
Monday
Tuesday
Wednesday
Thursday
Friday
Saturday
Sunday
Found Tuesday in the list!
Monday was successfully removed from the list!
Sunday was successfully removed from the list!
Thursday was successfully removed from the list!

Now the test list has:
Tuesday
Wednesday
Friday
Saturday
Good: Mardi wasn't found

 */
/**
 * Enter the input filename: \d:\HW3TestInput2.txt

Spinning Wheel for ID # 1........ and it's 1800!
Adding the wheel's current value to this Player
This player now has 2300

Spinning Wheel for ID # 2........ and it's -4400!
Reducing the previous Player's total by this amount
The previous player with ID# 1 now has a total of -2100
!!!!! Removing player with ID# 1!!!!!

Spinning Wheel for ID # 3........ and it's 420!
Adding the wheel's current value to this Player
This player now has 920

Spinning Wheel for ID # 4........ and it's 500!
Adding the wheel's current value to this Player
This player now has 1000

Spinning Wheel for ID # 5........ and it's -5200!
Reducing the previous Player's total by this amount
The previous player with ID# 4 now has a total of -4200
!!!!! Removing player with ID# 4!!!!!

Spinning Wheel for ID # 2........ and it's 3200!
Adding the wheel's current value to this Player
This player now has 3700

Spinning Wheel for ID # 3........ and it's 400!
Adding the wheel's current value to this Player
This player now has 1320

Spinning Wheel for ID # 5........ and it's 580!
Adding the wheel's current value to this Player
This player now has 1080

Spinning Wheel for ID # 2........ and it's 240!
Adding the wheel's current value to this Player
This player now has 3940

Spinning Wheel for ID # 3........ and it's 5600!
Adding the wheel's current value to this Player
This player now has 6920

Spinning Wheel for ID # 5........ and it's 580!
Adding the wheel's current value to this Player
This player now has 1660

Spinning Wheel for ID # 2........ and it's 580!
Adding the wheel's current value to this Player
This player now has 4520

Spinning Wheel for ID # 3........ and it's -4000!
Reducing the previous Player's total by this amount
The previous player with ID# 2 now has a total of 520

Spinning Wheel for ID # 5........ and it's 380!
Adding the wheel's current value to this Player
This player now has 2040

Spinning Wheel for ID # 2........ and it's 800!
Adding the wheel's current value to this Player
This player now has 1320

Spinning Wheel for ID # 3........ and it's 1400!
Adding the wheel's current value to this Player
This player now has 8320

Spinning Wheel for ID # 5........ and it's -4800!
Reducing the previous Player's total by this amount
The previous player with ID# 3 now has a total of 3520

Spinning Wheel for ID # 2........ and it's -4000!
Reducing the previous Player's total by this amount
The previous player with ID# 5 now has a total of -1960
!!!!! Removing player with ID# 5!!!!!

Spinning Wheel for ID # 3........ and it's -2200!
Reducing the previous Player's total by this amount
The previous player with ID# 2 now has a total of -880
!!!!! Removing player with ID# 2!!!!!
Winner: Player: ID# 3, Total = 3520, Current value = -2200

The test list has:
Monday
Tuesday
Wednesday
Thursday
Friday
Saturday
Sunday
Found Tuesday in the list!
Monday was successfully removed from the list!
Sunday was successfully removed from the list!
Thursday was successfully removed from the list!

Now the test list has:
Tuesday
Wednesday
Friday
Saturday
Good: Mardi wasn't found

 */
