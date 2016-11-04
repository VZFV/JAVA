public class BST<E extends DeepCloneable<E>>  //*****CHANGED for HW#4*****
	extends BinaryTree<E>
{

    private boolean foundNode; // helper variable
	// DECLARE A PRIVATE COMPARATOR INSTANCE VARIABLE HERE!

    /** Create a default binary tree */
    public BST() 
	{ // SEE HW#4 FOR WHAT TO CHANGE HERE
    }

    public BST(BST<E> sourceTree) // SEE HW#4 FOR WHAT TO CHANGE HERE
    {
        super(sourceTree);
		// SEE HW#4 FOR WHAT TO CHANGE HERE
    }

    @Override /** Returns true if the element is in the tree */
    public boolean contains(E e)
    {
    		BinaryNode<E> current = root; // Start from the root

    		while (current != null)
    		{
    			if (e.compareTo(current.getData()) < 0)//*****CHANGE THIS for HW#4*****
    			{
    				current = current.getLeftChild();
    			}
    			else if (e.compareTo(current.getData()) > 0)//*****CHANGE THIS for HW#4*****
    			{
    				current = current.getRightChild();
    			}
    			else // element matches current.getData()
    			return true; // Element is found
    		}

    		return false;
    }

	@Override
	/**
	 * Returns the data of the Node that equals the parameter, null if not found.
	 * */
	public E getEntry(E e)         // YOU WRITE FOR HW#4
	{
        // Call findNode starting with the root and save the return value
        // Check the return value to see if it's found or not
        // If it's found, return the return value's data
        //     Otherwise return null
	}

	// FOR EXERCISE: CALL A PRIVATE RECURSIVE METHOD THAT RETURNS A BinaryNode that equals THE PARAMETER
	//     If found, return the data in the returned BinaryNode

	private BinaryNode<E> _findNode(BinaryNode<E> node, E e )
	{
		if( node == null )
			return null;
		else if( e.compareTo(node.getData()) < 0 ) //*****CHANGE THIS for HW#4*****
				return _findNode( node.getLeftChild(), e );
		else if( e.compareTo(node.getData()) > 0 ) //*****CHANGE THIS for HW#4*****
				return _findNode( node.getRightChild(), e );
		else // found it!
			return node;
	}


	@Override
	/** Insert element e into the binary tree
	 * Return true if the element is inserted successfully */
	public boolean insert(E e)
	{
		root = _insert(root, e); // calls private insert that YOU write for HW#4
        size++;
		return true; // Element inserted successfully
	}

	// Private recursive method that returns an updated "root" node from where current node is
    private BinaryNode<E> _insert( BinaryNode<E> node, E e )
    {
        // YOU WRITE FOR HW#4, using this recursive algorithm: (HINT:see _delete)
		// MAKE SURE YOU COMPARE CORRECTLY MUST call the correct METHOD to compare!
        //      IF no more nodes THEN
        //                return a new Node(e)
        //      ELSE IF e < node's data THEN
        //                   set the node's left to _insert(node's left, e)
        //           ELSE
        //                   set the node's right to _insert(node's right, e)
        //           ENDIF
		//           RETURN node
        //       ENDIF

    }

	@Override
	/** Delete an element from the binary tree.
	 * Return true if the element is deleted successfully
	 * Return false if the element is not in the tree */
	public boolean delete(E e)
	{
		foundNode = false;		// initialize boolean instance variable
		root = _delete(root, e); //call private method to do actual deletion

		if( foundNode )
		{
			size--;// Element deleted successfully
		}
		return foundNode;
	}

	// Private recursive method that returns an updated "root" node from where current node is
    private BinaryNode<E> _delete( BinaryNode<E> node, E e )
    {
        if( node==null )
        {
            return null;
        }
        if ( e.compareTo(node.getData()) < 0 ) // <, so go left//*****CHANGE THIS for HW#4*****
             node.setLeftChild( _delete(node.getLeftChild(), e) );//recursive call
        else
            if( e.compareTo(node.getData()) > 0 ) // >, so go right//*****CHANGE THIS for HW#4*****
                node.setRightChild( _delete(node.getRightChild(), e) );//recursive call
            else
            {									// FOUND THE NODE
                foundNode = true;
                node = _deleteNode( node );
            }
        return node;
    } // end _delete

    // Private method that either "moves up" the left or right child, OR
    //    replaces the data in the nodeToDelete with the data in the rightmost child of
    //    the nodeToDelete's left child, then "removes" that node
    private BinaryNode<E> _deleteNode( BinaryNode<E> nodeToDelete )
    {
        if( nodeToDelete.isLeaf() ) // node to delete has no children
        {
           return null;
        }
        if( !nodeToDelete.hasLeftChild() ) // node to delete has no LEFT child
        {
            return nodeToDelete.getRightChild();
        }
        if( !nodeToDelete.hasRightChild() ) // node to delete has no RIGHT child
        {
            return nodeToDelete.getLeftChild();
        }
        // must have left and right children
        // Locate the rightmost node in the left subtree of
        // the node to delete and also its parent
        BinaryNode<E> parentOfRightMost = nodeToDelete;
        BinaryNode<E> rightMost = nodeToDelete.getLeftChild();

        while (rightMost.getRightChild() != null)
        {
            parentOfRightMost = rightMost;
            rightMost = rightMost.getRightChild(); // Keep going to the right
        }

        // Replace the element in nodeToDelete by the element in rightMost
        nodeToDelete.setData( rightMost.getData() ); // don't really delete the node, just change the data

        // Eliminate rightmost node
        if (parentOfRightMost.getRightChild() == rightMost)
            parentOfRightMost.setRightChild( rightMost.getLeftChild() );
        else
            // Special case: nodeToDelete's leftChild has no rightChild
            parentOfRightMost.setLeftChild( rightMost.getLeftChild() );

        return nodeToDelete;
    } // end private _deleteNode

    public E getFirst()// you finish (part of HW#4)
    {
    	// NON-recursive algorithm:
    	// If the tree is empty,  return null
    	// FIND THE LEFT-MOST LEFT CHILD
    	// WHEN you can't go left anymore, return the node's data to firstItem
    }
    
    public E getLast()// you finish (part of HW#4)
    {
    	// If the tree is empty, return null
    	// FIND THE RIGHT-MOST RIGHT CHILD
    	// WHEN you can't go right anymore, return the node's data to LastItem
    }

} // end class BST
