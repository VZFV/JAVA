/**
 * LinkedQueue
 * Author: Feng Zhang
 * 10/14/2016
 * window 10 64bit, eclipse
 * This class defined linkedqueue which contains many methods such as deepClone 
 * method that returns another LinkedQueue<T>, enqueue method, dequeue method and
 * so on.
 */
package HW2;

public class LinkedQueue<T extends DeepCloneable<T>> 
	implements QueueInterface<T>, DeepCloneable<LinkedQueue<T>>
{
	private Node frontNode; // References node at front of queue
	private Node backNode;  // References node at back of queue
	private int count = 0;
  
	public LinkedQueue()
	{
		frontNode = null;
		backNode = null;
	} // end default constructor


	@Override
	public LinkedQueue<T> deepClone() { // FINISH
		LinkedQueue<T> cloneLinkedQueue;
		cloneLinkedQueue = new LinkedQueue<T>();
		
		return cloneLinkedQueue;
		// FOLLOW INSTRUCTIONS GIVEN IN HW#2
		// (SHOULD BE SEVERAL LINES)

	}


	public boolean enqueue(T newEntry)
	{
		Node oldlast = backNode;
		backNode = new Node(newEntry);
		
		if (isEmpty())
			frontNode = backNode;
		else
			oldlast.setNextNode(backNode);
			
		++count;
		return true;
	// ADD CODE TO add data to linked list HERE!
	// In addition to updating the frontNode, also
	//    make sure you check if the list was empty before adding this
	//    and update the correct variable if so

	} // end enqueue

	public T peekFront()
	{
		if (isEmpty())
			return null;
		else
            return frontNode.getData();
	} // end getFront

	public T dequeue()
	{
		T front = peekFront();
		
		if (count > 0){
		   frontNode = frontNode.getNextNode();
		   if (isEmpty())
			   backNode = null;
		   count--;
		}
		   return front;
	// ADD CODE TO remove data from linked list HERE!
	// In addition to updating the backNode, also
	//    make sure to check if the list becomes empty and
	//    update the correct variable if so
        

       
	} // end dequeue

	public boolean isEmpty()
	{
		return count==0;
	} // end isEmpty

    public int size()
    {
        return count;

    }
    
 
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


} // end Linkedqueue
