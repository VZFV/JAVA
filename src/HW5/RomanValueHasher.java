/**
 * Roman value Hasher
 * Author: Feng Zhang
 * 11/23/2016
 * window 10 64bit, eclipse
 * This in Roman value Hasher class. 
 */
package HW5;

class RomanValueHasher implements Hasher<RomanNumeral>{

	@Override
	public int hash(RomanNumeral elem) {
		// TODO Auto-generated method stub
		return elem.getValue();
	}

}
