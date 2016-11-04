package HW1;

/**
 * Name of program: HW 1
 * Programmer's namer: Feng Zhang
 * 10/10/2016
 * windows 10 64bit, Eclipse
 * The class creates a sample maze.
 */

import java.util.*;

public class Maze {
	private char [][] maze; // default is null
	private int rowSize = -1;
	private int colSize = -1;
	
	public Maze(){
		
	}
	
	public Maze(Scanner fileScanner)
	{
		allocateAndRead(fileScanner);
	}
	
	public void allocateAndRead(Scanner fileScanner)
	{
		String inputLine;
		
		if( fileScanner == null ){
			return;
		}
		
		rowSize = fileScanner.nextInt();
		colSize = fileScanner.nextInt();
		fileScanner.nextLine();
		
		maze = new char[rowSize][colSize];
		for( int row = 0; row < rowSize; ++row )
		{
			inputLine = fileScanner.nextLine();
			for( int col = 0; col < colSize; ++col )
			{
				maze[row][col] = inputLine.charAt(col);
			}
		}
	}

	
	public int getRowSize(){ 
		return rowSize; 
		}
	
	public int getColSize(){
		return colSize; 
		}
	
	public boolean setCoordinatesValue(Coordinates coord,
								char val)
	{
		int row, col; 
		
		if( coord == null )
			return false;		
		row = coord.getRow(); // we know it's >=0
		col = coord.getCol(); // we know it's >=0
		if( row >= rowSize || col >= colSize )
			return false;
		maze[row][col] = val;
		return true;
	}
	
	public Coordinates getNextCoordinates(Coordinates coord)
	{
		int row, col; 
		
		if( coord == null )
			return null;		
		row = coord.getRow(); // we know it's >=0
		col = coord.getCol(); // we know it's >=0
		if( row >= rowSize || col >= colSize )
			return null;
		
		if((row-1 >= 0)  && (maze[row -1][col] == ' ')){ // trying to go North
			return new Coordinates(row - 1, col);
		}
		else{
			if((row+1 <= rowSize)  && (maze[row+1][col] == ' ')){ // trying to go South
				return new Coordinates(row +1, col);
			}else{
				if( (col- 1 >= 0 ) && (maze[row][col -1] == ' ')){ // trying to go East
					return new Coordinates(row, col-1);
				}else{
					if((col+ 1 <= colSize) && (maze[row][col +1] == ' ')){ //trying to go West
						return new Coordinates(row, col + 1);
					}else{
							return null; // can't go any direction here
					}
				}
				
			}
		}
		
		
		/*
			YOU WRITE, so you first check if the parameter isn't null
			    and return null if it is, and if not, 
			return a new Coordinates trying to go
			East, South, West, then North, but ONLY if
			the element is still in the maze and equals a space ' '
			(if you can't move anywhere, return null)
		*/

		
	}
	
	// Starting Coordinates may be ONLY on the LEFT or TOP edges of the maze
	// This method looks for an open space on the LEFT, then the TOP if none
	//     on the LEFT
	public Coordinates findStartCoordinates()
	{
		for (int row = 0; row < rowSize; ++row)
		{
			if (maze[row][0] == ' ')
				return new Coordinates(row, 0);
		}
		for (int col = 0; col < colSize; ++col){
			if (maze[0][col] == ' ')
				return new Coordinates(0, col);
		}
		return null; // none at left or top edge, so not solvable
	} // end getStartCoordinates


	// Ending Coordinates may be ONLY on the RIGHT or BOTTOM edges
	public boolean isEndingEdgeCoordinates(Coordinates coord)
	{
		return (coord.getRow() == (rowSize - 1) || coord.getCol() == (colSize - 1));
	}
	
	public void display()
	{
		if (maze == null)
		{
			System.out.println("No maze to display");
			return;
		}
		for (int row = 0; row < rowSize; ++row)
		{
			for (int col = 0; col < colSize; ++col)
				System.out.print(maze[row][col]);
			System.out.println();
		}
	}
	
}



