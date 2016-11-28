/**
 * Roman value Comparator
 * Author: Feng Zhang
 * 11/23/2016
 * window 10 64bit, eclipse
 * This is Roman value Comparator class. 
 */
package HW5;

import java.util.Comparator;

class RomanValueComparator implements Comparator<RomanNumeral>{

	@Override
	public int compare(RomanNumeral o1, RomanNumeral o2) {
		// TODO Auto-generated method stub
		int result = o1.getValue()-o2.getValue();
		return result;
	}

}
