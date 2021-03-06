package GraphCodeFiles;


import java.util.*;
import java.util.Map.Entry;
interface Visitor<T>
{
    public void visit(T obj);
}

// --- assumes definition of simple class Pair<E, F> 

// --- Vertex class ------------------------------------------------------
class Vertex<E>
{
   public static final double INFINITY = Double.MAX_VALUE;
   public HashMap<E, Pair<Vertex<E>, Double> > adjList 
      = new HashMap<E, Pair<Vertex<E>, Double> >();
   public E data;
   public double dist;  // used for particular graph problems, NOT the graph itself
   public Vertex<E> nextInPath;    // used for particular graph problems, NOT the graph itself

   public Vertex( E x )
   {
      data = x;
      dist = INFINITY;
      nextInPath = null;
   }
   public Vertex() { this(null); }

   public void addToAdjList(Vertex<E> neighbor, double cost)
   {
	   if( adjList.get(neighbor.data) == null)
		   adjList.put(neighbor.data, new Pair<Vertex<E>, Double> (neighbor, cost) );
	   // Note: if you want to change the cost, you'll need to remove it and then add it back
   }
   
   public void addToAdjList(Vertex<E> neighbor, int cost)
   {
      addToAdjList( neighbor, (double)cost );
   }
   
   public boolean equals(Object rhs)
   {
      Vertex<E> other = (Vertex<E>)rhs;

      return (data.equals(other.data));

   }
   
   public int hashCode()
   {
         return (data.hashCode());
   }

   public void showAdjList()
   {
      Iterator<Entry<E, Pair<Vertex<E>, Double>>> iter ;
      Entry<E, Pair<Vertex<E>, Double>> entry;
      Pair<Vertex<E>, Double> pair;

      System.out.print( "Adj List for " + data + ": ");
      iter = adjList.entrySet().iterator();
      while( iter.hasNext() )
      {
         entry = iter.next();
         pair = entry.getValue();
         System.out.print( pair.first.data + "(" 
            + String.format("%3.1f", pair.second)
            + ") " );
      }
      System.out.println();
   }
   

}


public class Graph<E>
{
   // the graph data is all here --------------------------
   protected HashMap<E, Vertex<E> > vertexSet;

   // public graph methods --------------------------------
   public Graph ()
   {
      vertexSet = new HashMap<E, Vertex<E> >();
   }
   
   public Graph( Edge<E>[] edges )
   {
      this();
      int k, numEdges;
      numEdges = edges.length;

      for (k = 0; k < numEdges; k++)
         addEdge( edges[k].source.data,  
            edges[k].dest.data,  edges[k].cost);
   }
   
   public void addEdge(E source, E dest, double cost)
   {
      Vertex<E> src, dst;

      // put both source and dest into vertex list(s) if not already there
      src = addToVertexSet(source);
      dst = addToVertexSet(dest);

      // add dest to source's adjacency list
      src.addToAdjList(dst, cost);
      //dst.addToAdjList(src, cost); // ADD THIS IF UNDIRECTED GRAPH
   }
   
   public void addEdge(E source, E dest, int cost)
   {
      addEdge(source, dest, (double)cost);
   }
   
   // adds vertex with x in it, and always returns ref to it
   public Vertex<E> addToVertexSet(E x)
   {
      Vertex<E> retVal=null;
      Vertex<E> foundVertex;

      // find if Vertex already in the list:
      foundVertex = vertexSet.get(x);
      
      if ( foundVertex != null ) // found it, so return it
      {
         return foundVertex;
      }

      // the vertex not there, so create one
      retVal = new Vertex<E>(x);
      vertexSet.put(x, retVal);

      return retVal;   // should never happen
   }
   
   public boolean remove(E start, E end)
   {
	   Vertex<E> startVertex = vertexSet.get(start);
	   boolean removedOK = false;
	   
	   if( startVertex != null )
	   {
		   Pair<Vertex<E>, Double> endPair = startVertex.adjList.remove(end);
		   removedOK = endPair!=null; 
	   }
	   /*// Add if UNDIRECTED GRAPH:
		Vertex<E> endVertex = vertexSet.get(end);
		if( endVertex != null )
		{
			Pair<Vertex<E>, Double> startPair = endVertex.adjList.remove(start);
			removedOK = startPair!=null ;
		}
		*/

	   return removedOK;
   }
   
   public void showAdjTable()
   {
      Iterator<Entry<E, Vertex<E>>> iter;

      System.out.println( "------------------------ ");
      iter = vertexSet.entrySet().iterator();
      while( iter.hasNext() )
      {
         (iter.next().getValue()).showAdjList();
      }
      System.out.println();
   }
   

   public void clear()
   {
      vertexSet.clear();
   }
   
   /** Breadth-first traversal from the parameter startElement*/
   public void breadthFirstTraversal(E startElement, Visitor<E> visitor)
   {
	   Vertex<E> currVertex;
   }

   /** Postorder traversal from the parameter startElement */
   public void depthFirstTraversal(E startElement, Visitor<E> visitor)
   {
	   
   }

 
}
