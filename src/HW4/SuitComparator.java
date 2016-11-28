/**
 * SuitComparator
 * Author: Feng Zhang
 * 11/14/2016
 * window 10 64bit, eclipse
 * SuitComparator class 
 */
package HW4;

import java.util.Comparator;

public class SuitComparator implements Comparator<Card>{

	@Override
    public int compare(Card left, Card right) {
		int result;
		result = left.getSuitNum() - right.getSuitNum();
		
		while(result != 0){
			return result;
		}
		
		return left.getPips() - right.getPips();
		
		
	}
}
