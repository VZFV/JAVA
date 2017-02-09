package teamproject;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class MaxFlow<E> extends Graph<E>{
    private double maxflow;
    private LinkedList<Edge<E>> AllEdges=new LinkedList<>();
    private LinkedStack<Edge<E>> edgeStack=new LinkedStack<>();
    
    public MaxFlow()
    {
        super();
    }
    
    public MaxFlow(Scanner inFile)
    {
        while(inFile.hasNext())
        {
            this.addEdge((E)inFile.next(), (E)inFile.next(), Double.valueOf(inFile.next()));
        }
    }
    
    @Override
    public void addEdge(E source, E dest, double cost)
    {
        Vertex<E> src, dst;
        
        // put both source and dest into vertex list(s) if not already there
        src = addToVertexSet(source);
        dst = addToVertexSet(dest);
        
        // add dest to source's adjacency list
        src.addToAdjList(dst, cost);
        //dst.addToAdjList(src, cost); // ADD THIS IF UNDIRECTED GRAPH
        
        AllEdges.add(new Edge<E>(src,dst));
    }
    
    public void addEdge(E source, E dest, double cost, boolean backwards)
    {
        Vertex<E> src, dst;
        
        // put both source and dest into vertex list(s) if not already there
        src = addToVertexSet(source);
        dst = addToVertexSet(dest);
        
        // add dest to source's adjacency list
        src.addToAdjList(dst, cost);
        //dst.addToAdjList(src, cost); // ADD THIS IF UNDIRECTED GRAPH
        
        AllEdges.add(new Edge<E>(src,dst,backwards));
    }
    
    
    
    public void clear()
    {
        
    }
    
//    public boolean hasAugmentingPath(Vertex<E> s, Vertex<E> t)
//    {
//        Set<E> elementsSet=vertexSet.keySet();
//        Iterator<E> elementsIter=elementsSet.iterator();
//        while(elementsIter.hasNext())
//        {
//            E tempElem=elementsIter.next();
//            vertexSet.get(tempElem).unvisit();
//        }
//
//        LinkedQueue<Vertex<E>> queue= new LinkedQueue<>();
//        queue.enqueue(s);
//        s.visit();
//        while(!queue.isEmpty()&&!t.isVisited())
//        {
//            Vertex<E> nextVertex=queue.dequeue();
//            Iterator<Map.Entry<E, Pair<Vertex<E>, Double>>> iter=nextVertex.iterator();
//
//
//            while(iter.hasNext())
//            {
//                Vertex<E> neighborVertex=iter.next().getValue().first;
//                Edge<E> temp = null;
//                temp = findNormalEdge(nextVertex, neighborVertex);
//                if(temp != null && temp.capacityRemain() >0 && !neighborVertex.isVisited())
//                {
//                    queue.enqueue(neighborVertex);
//                    neighborVertex.visit();
//                    edgeStack.push(temp);
//                }
//                else
//                {
//                    temp = findBackwardsEdge(nextVertex, neighborVertex);
//                    if(temp != null && temp.capacityRemain() >0 && !neighborVertex.isVisited())
//                    {
//                        queue.enqueue(neighborVertex);
//                        neighborVertex.visit();
//                        edgeStack.push(temp);
//                    }
//                }
//            }
//        }
//
//        return t.isVisited();
//
//    }
    /*
    public boolean hasAugmentingPath(Vertex<E> s, Vertex<E> t)
    {
        unvisitAll();
        Vertex<E> thisVertex = null;
        Vertex<E> nextVertex = s;
        Iterator<Map.Entry<E, Pair<Vertex<E>, Double>>> iter;
        boolean tempFlag = true;
        
        while (nextVertex != null && nextVertex != t)
        {
            thisVertex = nextVertex;
            thisVertex.visit();
            iter = thisVertex.adjList.entrySet().iterator();
            tempFlag = true;
            
            while (tempFlag)
            {
                do
                {
                    if (!iter.hasNext())
                        return false;
                    nextVertex = iter.next().getValue().first;
                    
                } while (nextVertex.isVisited());
                
                Edge<E> thisEdge;
                if ((thisEdge = findNormalEdge(thisVertex, nextVertex))!= null && thisEdge.capacityRemain() > 0.0)
                {
                    edgeStack.push(thisEdge);
                    tempFlag = false;
                }
                else if ((thisEdge = findBackwardsEdge(thisVertex, nextVertex))!= null && thisEdge.capacityRemain() > 0.0)
                {
                    edgeStack.push(thisEdge);
                    tempFlag = false;
                }
                else if (!iter.hasNext())
                {
                    thisEdge = edgeStack.pop();
                    if (thisEdge == null)
                        return false;
                    nextVertex = thisEdge.sourceVertex;
                    tempFlag = false;
                }
            }
        }
        return true;
    }
    */
    public boolean hasAugmentingPath(Vertex<E> s, Vertex<E> t)
    {
        unvisitAll();
        Vertex<E> thisVertex = null;
        Vertex<E> nextVertex = s;
        Iterator<Map.Entry<E, Pair<Vertex<E>, Double>>> iter;
        boolean tempFlag = true;
        
        
        while (nextVertex != null && nextVertex != t)
        {
            thisVertex = nextVertex;
            thisVertex.visit();
            iter = thisVertex.adjList.entrySet().iterator();
            tempFlag = true;
            boolean moreFlag = true;
            Edge<E> thisEdge;
            
            
            while (tempFlag)
            {
                moreFlag = true;
                
                do
                {
                    if (!iter.hasNext())
                    {
                        thisEdge = edgeStack.pop();
                        if (thisEdge == null)
                            return false;
                        nextVertex = thisEdge.sourceVertex;
                        moreFlag = false;
                        tempFlag = false;
                        break;
                    }
                    nextVertex = iter.next().getValue().first;
                    
                } while (nextVertex.isVisited());
                
                if (moreFlag)
                {
                    if ((thisEdge = findNormalEdge(thisVertex, nextVertex))!= null && thisEdge.capacityRemain() > 0.0)
                    {
                        edgeStack.push(thisEdge);
                        tempFlag = false;
                    }
                    else if ((thisEdge = findBackwardsEdge(thisVertex, nextVertex))!= null && thisEdge.capacityRemain() > 0.0)
                    {
                        edgeStack.push(thisEdge);
                        tempFlag = false;
                    }
                    else if (!iter.hasNext())
                    {
                        thisEdge = edgeStack.pop();
                        if (thisEdge == null)
                            return false;
                        nextVertex = thisEdge.sourceVertex;
                        tempFlag = false;
                    }
                }
            }
        }
        return true;
    }
    public double fordFulkerson(Vertex<E> s, Vertex<E> t)
    {
        maxflow=0;
        LinkedQueue<Edge<E>> edgeQueue=new LinkedQueue<>();
        while(hasAugmentingPath(s,t))
        {
            double bottleneck = Double.POSITIVE_INFINITY;
            while(!edgeStack.isEmpty())
            {
                Edge<E> temp=edgeStack.peek();
                bottleneck=Math.min(edgeStack.pop().capacityRemain(), bottleneck);
                edgeQueue.enqueue(temp);
            }
            while(!edgeQueue.isEmpty())
            {
                Edge<E> tempEdge = edgeQueue.peekFront();
                Edge<E> tempEdge2;
                
                if (tempEdge.isBackwards)
                {
                    tempEdge.capacity -= bottleneck;
                    tempEdge2 = findNormalEdge(tempEdge.dstVertex, tempEdge.sourceVertex);
                    tempEdge2.flow = tempEdge.capacity;
                }
                else
                {
                    tempEdge.flow += bottleneck;
                    tempEdge2 = findBackwardsEdge(tempEdge.dstVertex, tempEdge.sourceVertex);
                    if (tempEdge2 == null)
                    {
                        addEdge(tempEdge.dstVertex.data, tempEdge.sourceVertex.data, tempEdge.flow, true);
                    }
                    else
                        tempEdge2.capacity = tempEdge.flow;
                }
                
                
                System.out.println(edgeQueue.dequeue());
            }
            System.out.println("bootleneck: "+bottleneck);
            maxflow+=bottleneck;
            //System.out.println();
        }
        DisplayAllEdges();
        System.out.println("Max flow is: " + maxflow);
        
        return maxflow;
    }
    
    public double getMaxFlow()
    {
        return maxflow;
    }
    
    public void setMaxFlow(int mf)
    {
        maxflow = mf;
    }
    
    public void DisplayAllEdges()
    {
        Iterator<Edge<E>> iter = AllEdges.iterator();
        while(iter.hasNext())
        {
            System.out.println(iter.next());
        }
    }
    
    public Edge<E> findNormalEdge(Vertex<E> s, Vertex<E> t)
    {
        Iterator<Edge<E>> iter = AllEdges.iterator();
        Edge<E> tempEdge;
        
        while (iter.hasNext())
        {
            tempEdge = iter.next();
            if (!tempEdge.isBackwards && tempEdge.sourceVertex == s && tempEdge.dstVertex == t)
                return tempEdge;
        }
        return null;
    }
    
    public Edge<E> findBackwardsEdge(Vertex<E> s, Vertex<E> t)
    {
        Iterator<Edge<E>> iter = AllEdges.iterator();
        Edge<E> tempEdge;
        
        while (iter.hasNext())
        {
            tempEdge = iter.next();
            if (tempEdge.isBackwards && tempEdge.sourceVertex == s && tempEdge.dstVertex == t)
                return tempEdge;
        }
        return null;
    }
    
    public void unvisitAll()
    {
        Iterator<Map.Entry<E, Vertex<E>>> iter = this.vertexSet.entrySet().iterator();
        while (iter.hasNext())
        {
            iter.next().getValue().unvisit();
        }
    }
    
    public boolean removeBackwardsEdges(E start, E end)
    {
        Vertex<E> startVertex;
        startVertex = vertexSet.get(start);
        
        if( startVertex != null )
        {
            Pair<Vertex<E>, Double> endPair = startVertex.adjList.remove(end);
        }
        return true;
    }
}
