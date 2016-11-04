/**
 * WheelGames
 * Author: Feng Zhang
 * 10/30/2016
 * window 10 64bit, eclipse
 * This is wheel game class.
 */
package HW3;

import java.util.Scanner;

public class WheelGame {
	private int[] wheelArray;	// initialize wheel array
	private int currentIndex;	// initialize currentIndex
	private int currentValue;	// initialize currentValue
	private int numPlayers;		// initialize numPlayers
	private int maxSpins;		// initialize maxSpins
	CircularList2<Player> playerList = new CircularList2<Player>();	// initialize playerList
	
	public WheelGame(Scanner infile, int numPlyrs){
		numPlayers = numPlyrs;		// initialize numPlayers to numPlyrs
		maxSpins = numPlayers * 10;	// assign numPlayers *10 to maxSpins
		readWheelFromFile(infile);	// call the readWheelFromFile method
		createCircularList2();		// call the createCircularList2 method
		
	}	// end constructor
	
	public void spinWheel(){
		int randomNum = 0; 										// initialize randomNum
		randomNum = (int)(Math.random()*(wheelArray.length)); 	// get a random number from 0 to arraySize -1
		currentIndex = randomNum; 					//assign the random number to currentIndex
		currentValue = wheelArray[currentIndex]; //assign the array element at the currentIndex to the currentValue
	}	// end spinWheel
	
	public int getCurrentValue(){
		return currentValue;
	} // end getCurrentValue
	
	public int getNumPlayers(){
		return numPlayers;
	}	// end getNumPlayers
	
	public void playGame(){
		int counter = 0;				// initialize spin counter
		playerList.startIterator();		// call playerList's startIterator
		
		// loop until either there is only one player left, or
		// when you called spinWheel() more than "maxSpins" times
		while(numPlayers != 1 && counter < maxSpins){ 		
			 Player PrevPlayer = playerList.peekPrev();
			 Player CurrPlayer = playerList.next();
			 spinWheel(); // call the spinWheel method
			 System.out.printf("\nSpinning Wheel for ID # %s........ and it's %s!\n", 
					 CurrPlayer.getId(), currentValue);
			 if(currentValue < 0){
				 System.out.println("Reducing the previous Player's total by this amount");
				 // add the negative amount to the total of the Player who is BEFORE you
				 PrevPlayer.setTotal(PrevPlayer.getTotal() + currentValue);
				 System.out.printf("The previous player with ID# %s now has a total of %s\n", 
						 PrevPlayer.getId(), PrevPlayer.getTotal());
			 }
			 if(currentValue == 0){
				 System.out.println("Subtracting the last of this Player's value from the Player's total");
				 // subtract the current Player's currentValue from his total
				 CurrPlayer.setTotal(CurrPlayer.getTotal() - CurrPlayer.getCurrentValue());
				 System.out.println("Now the total is " + CurrPlayer.getTotal());
			 }
			 if(currentValue > 0){
				 System.out.println("Adding the wheel's current value to this Player");
				 // add that amount to the current Player's total
				 CurrPlayer.setTotal(CurrPlayer.getTotal() + currentValue);
				 System.out.println("This player now has " + CurrPlayer.getTotal());
			 }
			 
			 CurrPlayer.setCurrentValue(currentValue); // set the current player's currentValue to currentValue
			 
			 if(PrevPlayer.getTotal() < 0){
				 playerList.remove(PrevPlayer);
				 System.out.printf("!!!!! Removing player with ID# %s!!!!!\n", PrevPlayer.getId());
				 numPlayers--;
			 }
			 if(CurrPlayer.getTotal() < 0){
				 playerList.remove(CurrPlayer);
				 System.out.printf("!!!!! Removing player with ID# %s!!!!!\n", PrevPlayer.getId());
				 numPlayers--;
			 }
			 counter++;	// increment spin counter
		}
		if(numPlayers == 1)
			System.out.println("Winner: " + playerList.peekPrev().toString());
		else
			System.out.println("timed out, no winner");
	}	// end playGame
	 
	private void readWheelFromFile(Scanner infile){
		int num = infile.nextInt();		// read first number
		wheelArray = new int[num];		// store first number in the arraySize member variable
		for(int i = 0; i < wheelArray.length; i++){
			wheelArray[i] = infile.nextInt();	// 
		}
	}	// end readWheelFromFile
	
	private void createCircularList2(){
		for(int i = 0; i <  numPlayers; i++){
			Player player = null;
			player = new Player(i+1, 500, 0); // Each player has an ID, total is 500, currentValue is 0
			playerList.add(player);	// call the add method
		}
	}	// end createCircularList2
}
