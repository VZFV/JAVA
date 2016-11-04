/**
 * CircularList2
 * Author: Feng Zhang
 * 10/30/2016
 * window 10 64bit, eclipse
 * This is circular linked list which does not have dummyNode. 
 */
package HW3;

public class CircularList2<T> implements ListInterface<T>, MyIterator<T> 
{

	private Node firstNode;            // Reference to first node of chain, NOT a dummy
	private int  numberOfEntries;
	private Node currentNode; 		// for iterating

	public CircularList2()
	{
		initializeDataFields();
	} // end default constructor

	@Override
	public void clear()
	{
		initializeDataFields();
	} // end clear

	@Override
	public void add(T newEntry) 	      // OutOfMemoryError possible
	{
		Node newNode = new Node(newEntry);

		if (isEmpty())
		{
			firstNode = newNode;
			firstNode.setNextNode(firstNode);
			firstNode.setPrevNode(firstNode);
		}
		else                              // Add to end of non-empty list
		{
			Node lastNode = firstNode.getPrevNode(); // updated for Circular list
			newNode.setNextNode(firstNode);	// make new node reference first node
			firstNode.setPrevNode(newNode);	// make first node reference new node
			newNode.setPrevNode(lastNode);	// make new node reference last node
			lastNode.setNextNode(newNode); 	// Make last node reference new node
		} // end if

		numberOfEntries++;
	}  // end add

	@Override
    public boolean add(int newPosition, T newEntry)
	{
 		if ((newPosition >= 1) && (newPosition <= numberOfEntries + 1))
		{
			Node newNode = new Node(newEntry);

			if (isEmpty())							// very first node
			{
				firstNode = newNode;
				firstNode.setNextNode(firstNode);
				firstNode.setPrevNode(firstNode);
			}
			else if (newPosition == 1)              // list isn't empty, insert at beginning
			{
				newNode.setNextNode(firstNode);
				newNode.setPrevNode(firstNode);
				firstNode.setNextNode(newNode);
				firstNode.setPrevNode(newNode);
				firstNode = newNode;
			}
				else								//  list is not empty
				{                                   // and newPosition > 1
		            Node nodeBefore = getNodeAt(newPosition - 1);
		            Node nodeAfter = nodeBefore.getNextNode();
					newNode.setNextNode(nodeAfter);		// make new node reference next node
					newNode.setPrevNode(nodeBefore);	// make new node reference previous node
					nodeAfter.setPrevNode(newNode);		// make next node reference new node
					nodeBefore.setNextNode(newNode);	// make previous node reference new node
				} // end if	

			numberOfEntries++;
			return true;
		}
      else
            return false;
   } // end add

	@Override
	public boolean remove(T anEntry)
	{
		Node nodeToDelete;
		Node nodeBefore;
		Node nodeAfter;
		boolean found = false;
		
		nodeToDelete = getNode(anEntry);
		if (getNode(anEntry) == null){
			return false;
		}else{
			if (numberOfEntries == 1){
				firstNode = null;
			}else{
				if(nodeToDelete == firstNode){
					firstNode = firstNode.getNextNode();
				}
				nodeBefore = nodeToDelete.getPrevNode();	
				nodeAfter = nodeToDelete.getNextNode();		
				nodeBefore.setNextNode(nodeAfter);			// make previous node reference next node
				nodeAfter.setPrevNode(nodeBefore);			// make next node reference previous node
			}
			found = true;
			numberOfEntries--;
		}
		return found;
	}	// end remove

	@Override
	public T remove(int givenPosition)
	{
      T result = null;                           // Return value

      if ((givenPosition >= 1) && (givenPosition <= numberOfEntries))
      {
         if (givenPosition == 1)                 // Case 1: Remove first entry
         {
	            result = firstNode.getData();        // Save entry to be removed
	            if( numberOfEntries == 1 )		// One left?
	            	firstNode = null;
	            else
	            {
	            	Node lastNode = firstNode.getPrevNode();
	            	firstNode = firstNode.getNextNode(); // Remove entry
	            	lastNode.setNextNode(firstNode);
	            	firstNode.setPrevNode(lastNode);
	            }
         }
         else                                    // Case 2: Not first entry
         {
            Node nodeBefore = getNodeAt(givenPosition - 1);
            Node nodeToRemove = nodeBefore.getNextNode();
            result = nodeToRemove.getData();     // Save entry to be removed
            Node nodeAfter = nodeToRemove.getNextNode();
            nodeBefore.setNextNode(nodeAfter);   // Remove entry
            nodeAfter.setPrevNode(nodeBefore);	 
         } // end if

         numberOfEntries--;                      // Update count
         return result;                          // Return removed entry
      }
      else
          return null;
	} // end remove


	@Override
   public T getEntry(int givenPosition)
   {
		if ((givenPosition >= 1) && (givenPosition <= numberOfEntries))
		{
            return getNodeAt(givenPosition).getData();
     	}
        else
            return null;
   } // end getEntry


   public T getEntry(T anEntry) // ***************YOU WRITE**************
   {
	   if (getNode(anEntry) != null){
		   return getNode(anEntry).getData();
	   }
	   else{
		   return null;
	   }
   }	// end getEntry
   
	@Override
	public boolean contains(T anEntry)// UPDATED FOR CIRCULAR DOUBLY LINKED LIST
	{
		boolean found = false;
		Node currentNode = firstNode;

		if(firstNode == null) 
			return false; // UPDATED FOR CIRCULAR DOUBLY LINKED LIST

		do
		{
			if (anEntry.equals(currentNode.getData()))
				found = true;
			else
				currentNode = currentNode.getNextNode();
		}while(!found && currentNode != firstNode);

		return found;
	} // end contains

	@Override
   public int getLength()
   {
      return numberOfEntries;
   } // end getLength

	@Override
   public boolean isEmpty()
   {
        return numberOfEntries==0;

   } // end isEmpty

	@Override
	public void display()
	{
		if(firstNode == null)  // ADDED FOR EXERCISE 4.1
			return; // ADDED FOR EXERCISE 4.1

		Node currNode;

		currNode = firstNode;
		do					 // CHANGED FOR EXERCISE 4.1
		{
			System.out.println(currNode.getData());
			currNode = currNode.getNextNode();
		}while( currNode != firstNode ); // CHANGED FOR EXERCISE 4.1
	} // end display

	
   // Initializes the class's data fields to indicate an empty list.
   private void initializeDataFields()
   {
		firstNode = null;
		numberOfEntries = 0;
   } // end initializeDataFields

   // Returns a reference to the node at a given position.
   // Precondition: The chain is not empty;
   //               1 <= givenPosition <= numberOfEntries.
	private Node getNodeAt(int givenPosition)
	{
		if((1 <= givenPosition) && (givenPosition <= numberOfEntries))
		{
            Node currentNode = firstNode;

            for (int counter = 1; counter < givenPosition; counter++)
                currentNode = currentNode.getNextNode();

            return currentNode;
        }
        else
            return null;
	} // end getNodeAt
	
	private Node getNode(T targetEntry) 
	{
		Node currNode = firstNode;
		
		for( int i = 0; i < numberOfEntries; ++i )
			if(targetEntry.equals(currNode.getData())){	// check if equals
				return currNode;
			}else{
				currNode = currNode.getNextNode();	// update currNode to the next one
			}
		
		return null;
	}


	@Override
	public void startIterator()
	{
		currentNode = firstNode;
	}
	
	@Override
	public boolean hasNext() {
		
		return (currentNode != null);
	}

	@Override
	public T next() {
		if( currentNode != null)
		{
			T currentData = currentNode.getData();
			currentNode = currentNode.getNextNode();
			return currentData;
		}
		return null;
	}	// end next

	// ADDED to look backwards,
	public T peekPrev() { 
		if(isEmpty()){
			return null;
		}else{
			return currentNode.getPrevNode().getData();
		}
	}	// end peekPrev
	
	private class Node // DOUBLY LINKED LIST VERSION
	{
      private T    data; // Entry in list
      private Node next; // Link to next node
      private Node prev;

      private Node(T dataPortion)
      {
         data = dataPortion;
         next = null;
      } // end constructor

      private Node(T dataPortion, Node nextNode)
      {
         data = dataPortion;
         next = nextNode;
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
      
      private Node getPrevNode()
      {
    	  return prev;
      }
      
      private void setPrevNode(Node prevNode)
      {
    	  prev = prevNode;
      }
	} // end Node

} // end CircularLList2
