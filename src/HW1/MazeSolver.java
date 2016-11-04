package HW1;

/**
 * Name of program: HW 1
 * Programmer's namer: Feng Zhang
 * 10/10/2016
 * windows 10 64bit, Eclipse
 * The class is the solver of maze.
 */

import java.util.Scanner;

public class MazeSolver {
	private Maze maze; //Maze variable
	private Coordinates StartPosition = null; // assign null to start coordinates
	
	public MazeSolver(Maze maze){
		this.maze = maze;
		StartPosition = null;
	} //constructor
	
	public MazeSolver (Scanner FileScanner){
		Maze tempMaze = new Maze(FileScanner);
	} //constructor
	
	//set start coordinates method
	public void setStartCoordinates(Maze StartCoordinates){
		if(StartCoordinates == null){
			StartPosition = null;
		}else{
			StartPosition = StartCoordinates.findStartCoordinates();
		}	
	}
	
	//get start coordinates
	public Coordinates getStartCoordinates(){
		return StartPosition;
	}
	
	public Coordinates MazeSolver(Coordinates SolverCoordinates){
		
	}
	
}
