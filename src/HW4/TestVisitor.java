/**
 * TestComparator
 * Author: Feng Zhang
 * 11/14/2016
 * window 10 64bit, eclipse
 * TestComparator class 
 */
package HW4;

class TestVisitor implements Visitor<Card>
{
	@Override
	public void visit(Card obj) {
		obj.setPips(1);
	}
}