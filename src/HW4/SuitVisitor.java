/**
 * SuitVisitor
 * Author: Feng Zhang
 * 11/14/2016
 * window 10 64bit, eclipse
 * This is SuitVisitor class. 
 */
package HW4;

public class SuitVisitor implements Visitor<Card>{

	@Override
	public void visit(Card card) {
		// TODO Auto-generated method stub
		System.out.println(card.getSuitName()+", "+card.getPipsName());
	}

}
