package Lab0102;

public class MusicVisitor implements Visitor<Music>{

	@Override
	public void visit(Music obj) {
		// TODO Auto-generated method stub
		
		
		System.out.println(obj.getTitle());
		System.out.println(obj.getComposer());
	}

}
