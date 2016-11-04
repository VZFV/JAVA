package HW1;

/**
 * Name of program: HW 1
 * Programmer's namer: Feng Zhang
 * 10/10/2016
 * windows 10 64bit, Eclipse
 * The main function tries to open the file and display the maze and the solver.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class MazeSolverFuction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    Scanner scanner = openInputFile();
	    Maze maze = new Maze(scanner);
	    maze.display();
	}
	
	public static Scanner openInputFile()
	{
		Scanner userScanner = new Scanner(System.in);
		
		String filename;
        Scanner scanner=null;
        
		System.out.print("Enter the input filename:  ");
		filename = userScanner.nextLine();
        	File file= new File(filename);

        	try{
        		scanner = new Scanner(file);
        	}// end try
        	catch(FileNotFoundException fe){
        	   System.out.println("Can't open input file\n");
       	    return null; // array of 0 elements
        	} // end catch
        	return scanner;
	}



}
