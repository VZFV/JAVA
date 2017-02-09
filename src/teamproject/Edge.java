package teamproject;

//@author Cody

class Edge<E> 
{
	Vertex<E> sourceVertex;
	Vertex<E> dstVertex;
	double capacity;
	double flow;
        boolean isBackwards;
	
	Edge(Vertex<E> srcVertex, Vertex<E> dtVertex,int cap,int f)
	{
		sourceVertex=srcVertex;
		dstVertex=dtVertex;
		capacity=cap;
		flow=f;
	}
	
	Edge(Vertex<E> srcVertex, Vertex<E> dtVertex)
	{
		sourceVertex=srcVertex;
		dstVertex=dtVertex;
		flow=0;
		capacity=srcVertex.adjList.get(dtVertex.data).second.doubleValue();
	}
        
        Edge(Vertex<E> srcVertex, Vertex<E> dtVertex, boolean backwards)
        {
            this(srcVertex, dtVertex);
            this.isBackwards = backwards;
        }
	
	
	boolean equals(Edge<E> obj)
	{
		if(obj.dstVertex.equals(dstVertex)&&obj.sourceVertex.equals(sourceVertex))
			return true;
		else return false;
	}
	
	void Incflow()
	{
		flow++;
	}
	
	double capacityRemain()
	{
		return capacity-flow;
	}

	public String toString()
	{
		return "From: "+sourceVertex.getData()+" To: "+dstVertex.getData()+" Flow: "+flow+" Capacity: "+capacity;
	}

	public void setCapacity(Double value)
        {
            capacity += value;
        }
}