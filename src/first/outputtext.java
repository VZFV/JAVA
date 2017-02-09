package first;
import java.io.*;
public class outputtext {
	
	
	 	public static void main( String [] args ){
	  	FileOutputStream outFile=null;
	  	try {
	  		outFile = new FileOutputStream("info.txt");
	  	}catch( FileNotFoundException e ){
	               	System.err.println(e);
	               	return ;
	  	} //end catch
	  	PrintWriter prtWriter =
	          	new PrintWriter(outFile, true);
	  	prtWriter.println("Writing a String");
	  	prtWriter.println(Math.PI);
	  	prtWriter.println(true);
	 	} // end main
	} // end class TryOutputTextFile


