/**
 * Card
 * Author: Feng Zhang
 * 11/14/2016
 * window 10 64bit, eclipse
 * This is card class.
 */
package HW4;

public class Card implements DeepCloneable<Card>{
	public static int MAX_PIPS = 13;
	public static int NUM_SUITS = 4;
	public static String[] suitNames = { "Clubs", "Diamonds", "Hearts", "Spades" };
	public static String[] pipsNames = { "", "Ace", "2", "3",
	"4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King" };

	private int pips;
	private int suitNum;


	public Card()
	{
		pips = 1;
		suitNum = 0;
	}

	public Card(int pNum, int sNum)
	{
		pips = 1;
		suitNum = 0;
		setPips(pNum);
		setSuit(sNum);
	} // end constructor #2

	int getPips() { return pips; }
	int getSuitNum() { return suitNum; }

	public String getPipsName() 
	{
		return pipsNames[pips];
	}

	public String getSuitName() 
	{
		return suitNames[suitNum];
	}

	boolean setPips(int pNum)
	{
		if (pNum >= 1 && pNum <= MAX_PIPS){
			pips = pNum;
			return true;
		}
		return false;
	}

	public boolean setSuit(int sNum)
	{
		if (sNum >= 0 && sNum < NUM_SUITS){
			suitNum = sNum;
			return true;
		}// end if
		return false;
	}

	public int compareTo(Card card)
	{
		int diff = this.pips - card.pips;
		if( diff == 0 )
		{
			diff = this.suitNum - card.suitNum;
		}
		return diff;
	}
	
	public String toString()
	{
		return pipsNames[pips] + " of " + suitNames[suitNum];
	}

	@Override
	public Card deepClone() {
		return new Card(pips, suitNum);
	}
}

