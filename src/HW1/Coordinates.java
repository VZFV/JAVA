package HW1;
/**
 * Name of program: HW 1
 * Programmer's namer: Feng Zhang
 * 10/10/2016
 * windows 10 64bit, Eclipse
 * This class defines coordinates to determine the location of path.
 */
	public class Coordinates {
		private int row; // default 0
		private int col; // default 0
		
		public Coordinates(){
			
		}
		
		public Coordinates(int r, int c)
		{
			setRow(r);
			setCol(c);
		}
		
		public int getRow(){ 
			return row; 
			}
		
		public int getCol(){ 
			return col; 
			}
		
		public void setRow(int r){ 
			if( r >= 0 ) 
				row = r; 
			}
		
		public void setCol(int c){
			if( c >= 0 ) 
				col = c; 
			}
	
	}
