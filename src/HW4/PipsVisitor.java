/**
 * PipsVisitor
 * Author: Feng Zhang
 * 11/14/2016
 * window 10 64bit, eclipse
 * PipsVisitor class 
 */
package HW4;

public class PipsVisitor implements Visitor<Card>{

	@Override
	public void visit(Card card) {
		// TODO Auto-generated method stub
		
		System.out.println(card.toString());
	}

}
