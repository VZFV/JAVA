/**
 * Player
 * Author: Feng Zhang
 * 10/30/2016
 * window 10 64bit, eclipse
 * This is player class which define id, total, current value.
 */
package HW3;

public class Player {
	private int id;
	private int total;
	private int currentValue;
	
	public Player(){  }
	
	public Player(int i, int t, int c)
	{
		id = i;
		total = t;
		currentValue = c;
	}
	
	public void setId(int i) { id = i; }
	
	public void setTotal(int t) { total = t; }
	
	public void setCurrentValue(int c) { currentValue = c; }
	
	public int getId() { return id; }
	
	public int getTotal()  { return total; }
	
	public int getCurrentValue()  { return currentValue; }

	public boolean equals(Object param)
	{
		if(param instanceof Player)
			return this.id == ((Player)param).id;
		return false;
	}	

	public String toString()
	{
		return "Player: ID# " + id + ", Total = " + total + ", Current value = " + currentValue;
	}

} // end Player class
