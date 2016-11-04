package QueueCodeFiles;

import QueueCodeFiles.LinkedQueue.Node;

public class LinkedQueueDummy<T> implements QueueInterface<T>
{
      private Node frontNode; // References node at front of queue
      private Node backNode;  // References node at back of queue
      private int count = 0;

	public LinkedQueueDummy()
	{
		frontNode = backNode = new Node(null); // MY CHANGE!!!
	} // end default constructor

	public boolean enqueue(T newEntry)
	{
		Node newNode = new Node(newEntry);
		backNode.setNextNode(newNode);
		backNode = newNode;

		++count;
		return true;
	} // end enqueue

	public T peekFront()
	{
		if (isEmpty())
			return null;
		else
            return frontNode.getNextNode().getData();//***********************
	} // end getFront

	public T dequeue()
	{
	   T front = peekFront();
         if( count > 0 )
         {
		Node nodeToRemove = frontNode.getNextNode();//*************	
		frontNode.setNextNode(nodeToRemove.getNextNode()); //*******************
		
    	      if( count == 1 )
    		   backNode = null;//************************
            --count;
         }

         return front;
	} // end dequeue

	private class Node
	{
		private T    data; // Entry in queue
		private Node next; // Link to next node

		private Node(T dataPortion)
		{
			data = dataPortion;
			next = null;
		} // end constructor

		private Node(T dataPortion, Node linkPortion)
		{
			data = dataPortion;
			next = linkPortion;
		} // end constructor

		private T getData()
		{
			return data;
		} // end getData

		private void setData(T newData)
		{
			data = newData;
		} // end setData

		private Node getNextNode()
		{
			return next;
		} // end getNextNode

		private void setNextNode(Node nextNode)
		{
			next = nextNode;
		} // end setNextNode
	} // end Node

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}
}