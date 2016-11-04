package first;

public class Music implements Comparable<Music>{
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
		return "\"" + title + "\"" + " by " + composer 
				+ ", Opus No. " + opus;

	}

	@Override
	public int compareTo(Music per) {
		int result = this.composer.compareToIgnoreCase(per.composer);
		if(result == 0){
			result = this.title.compareToIgnoreCase(per.title);		
		}
		// TODO Auto-generated method stub
		return result;
	}
}
