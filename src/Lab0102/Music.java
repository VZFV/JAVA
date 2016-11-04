package Lab0102;

public class Music {
	private String title;
	private String composer;
	private int opus;
		
	public Music(){
		
	}
	
	// constructor
	public Music(String title, String composer, int opus){
		this.title = title;
		this.composer = composer;
		this.opus = opus;
	}
	
	// return title
	public String getTitle(){
		return title;
	}
	
	// return composer
	public String getComposer(){
		return composer;
	}
	
	// return opus
	public int getOpus(){
		return opus;
	}
	
	// set title
	public void setTitle(String newTitle){
		title = newTitle;
	}
	
	// set composer
	public void setComposer(String newComposer){
		composer = newComposer;
	}
	
	// set opus
	public void setOpus(int newOpus){
		opus = newOpus;
	}
	
	public boolean equals(Object obj) // overrides Object's equals method
	{
        Music other = (Music)obj;
		return title.equals(other.title) && composer.equals(other.composer);
	}
	
	// convert Music to String
	public String toString(){
		return String.format("%s, %s, %s",title, composer, opus);
	}
}
