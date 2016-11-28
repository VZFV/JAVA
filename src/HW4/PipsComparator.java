/**
 * PipsComparator
 * Author: Feng Zhang
 * 11/14/2016
 * window 10 64bit, eclipse
 * PipsComparator class 
 */
package HW4;

import java.util.Comparator;

public class PipsComparator implements Comparator<Card>{

	@Override
    public int compare(Card left, Card right) {
		int result;
		
		result = left.compareTo(right);
		
		return result; 
     }
}
