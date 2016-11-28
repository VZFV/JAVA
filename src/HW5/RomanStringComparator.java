/**
 * Roman String Comparator
 * Author: Feng Zhang
 * 11/23/2016
 * window 10 64bit, eclipse
 * This is Roman String Comparator class. 
 */
package HW5;

import java.util.Comparator;

class RomanStringComparator implements Comparator<RomanNumeral>{

	@Override
	public int compare(RomanNumeral o1, RomanNumeral o2) {
		// TODO Auto-generated method stub
		int result = o1.getRomNumStr().compareToIgnoreCase(o2.getRomNumStr());
		return result;
	}

}
