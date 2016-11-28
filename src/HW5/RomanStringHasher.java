/**
 * Roman String Hasher
 * Author: Feng Zhang
 * 11/23/2016
 * window 10 64bit, eclipse
 * This is Roman String Hasher class. 
 */
package HW5;

class RomanStringHasher implements Hasher<RomanNumeral>{

	@Override
	public int hash(RomanNumeral elem) {
		// TODO Auto-generated method stub
		String key = elem.getRomNumStr();
		int retVal = 0;

	    for(int k = 0; k < key.length(); k++ )
	        retVal = 37 * retVal + key.charAt(k);

	    return retVal;
		
	}

}
