package teamproject;


public class VertexVisitor<E> implements Visitor<E> {

	@Override
	public void visit(E obj) {
		System.out.println(obj);
	}		   


}
