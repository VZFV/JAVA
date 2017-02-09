package teamproject;


import java.util.*;
import java.text.*;


//------------------------------------------------------
public class GraphTester
{
	   // -------  main --------------
	   public static void main(String[] args)
	   {
	      // build graph
	      MaxFlow<Integer> myGraph1 = new MaxFlow<Integer>();
	      myGraph1.addEdge(0, 2, 5); 
	      myGraph1.addEdge(2, 3, 3);
	      myGraph1.addEdge(0, 3, 3); 
	      myGraph1.addEdge(3, 1, 5); 
	      myGraph1.addEdge(2, 1, 3); 
	      myGraph1.addEdge(2, 4, 3); 
	      myGraph1.addEdge(1, 4, 4);
	      
	      myGraph1.fordFulkerson(myGraph1.vertexSet.get(0), myGraph1.vertexSet.get(4));
	      System.out.println(myGraph1.getMaxFlow());
	   }

}

