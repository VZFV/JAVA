package Lab0102;

public class myMusic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LList<Music> newList = new LList<Music>();
		MusicVisitor vistor = new MusicVisitor();
		Music [] musicArray = {
	              new Music("Moonlight Sonata",  "Beethoven", 27),
	              new Music("Brandenburg Concerto #3", "Bach", 1048),
	              new Music("Prelude in e minor", "Chopin", 28) };
		
		for( int i=0; i  < 3; ++i )
			newList.add(musicArray[i]);
		
		newList.traverse(vistor);
		
	}

}
