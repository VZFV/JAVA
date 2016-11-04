package Lab0103;

public class Musicmain {
	public static <T> void displayArray(T []myArray)
	   {
	        for( int i =0; i < myArray.length; ++i )
	        {
	              System.out.println(myArray[i]);
	        }

	   }
	
	   public static void main( String [] args )
	   {
	        Music [] musicArray = {
	              new Music("Moonlight Sonata",  "Beethoven", 27),
	              new Music("Brandenburg Concerto #3", "Bach", 1048),
	              new Music("Prelude in e minor", "Chopin", 28) };
	        LList<Music>  musicList = new LList<Music>(); // creates LinkedList!
	        Music tempMusic;
		    System.out.println("\nThe list as displayed in LList.java: ");
	        displayArray(musicArray);// template is Music here

	        for( int i=0; i  < 3; ++i )
	              musicList.add(musicArray[i]);

	        musicList.display();
			tempMusic = musicList.getEntry(2);
	        if( tempMusic != null  )
	              System.out.println("\nFound " + tempMusic.getTitle() );
	        else
	              System.out.println( "\nUnable to find " + musicArray[1].getTitle() );
	        // you'll need  to test more in an exercise!
	        
	        musicList.add(1, new Music("Symphony No. 9", "Dvorak", 95));
	        Music newMusic = new Music("Symphony No. 9", "Dvorak", 0);
	        if( musicList.contains(newMusic))
	        System.out.println("\nFound "+newMusic.getTitle());
	        else
	        System.out.println("\n"+newMusic.getTitle() + " not found(error)");
	        
	        System.out.println("\nNow the list has:");
	        musicList.display();
	        
	        if( musicList.remove(newMusic) )
	        System.out.println("\nRemoved " + newMusic.getTitle());
	        else
	        System.out.println("\nUnable to remove " + newMusic.getTitle()
	        + " (error)");
	   
	        System.out.println("\nThe list after trying to remove has:");
	        musicList.display();
	          
	   } // end main 
}	  
