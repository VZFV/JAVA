/**
 * BST
 * Author: Feng Zhang
 * 11/14/2016
 * window 10 64bit, eclipse
 * This is Binary search tree class which inherits binary tree. 
 */
package HW4;

import java.util.Comparator;

public class BST<E extends DeepCloneable<E>>  //*****CHANGED for HW#4*****
	extends BinaryTree<E>
{

    private boolean foundNode;  // helper variable
    private Comparator<E> comp;		// DECLARE A PRIVATE COMPARATOR INSTANCE VARIABLE HERE!
    
    /** Create a default binary tree */
    public BST(){ }
    
    
    public BST(Comparator<E> c) 
	{ 
    	comp = c;
    }

    public BST(BST<E> sourceTree) // SEE HW#4 FOR WHAT TO CHANGE HERE
    {
        super(sourceTree);
    
        this.comp = sourceTree.comp;
		// SEE HW#4 FOR WHAT TO CHANGE HERE
    }

    @Override /** Returns true if the element is in the tree */
    public boolean contains(E e)
    {
    		BinaryNode<E> current = root; // Start from the root

    		while (current != null)
    		{
    			if (comp.compare(e, current.getData()) < 0)// <, so go left
    			{
    				current = current.getLeftChild();		// get the node's left child
    			}
    			else if (comp.compare(e, current.getData()) > 0)// >, so go right
    			{
    				current = current.getRightChild();		// get the node's ritht child
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
	public E getEntry(E e)       
	{
		BinaryNode<E> current = root;	// assign root to local variable
		BinaryNode<E> getNode =_findNode(current, e);	// call findNode and save the return value
		if (getNode != null)	// check if found
			return getNode.getData();	// return data
		else
			return null;
      
	}

	// FOR EXERCISE: CALL A PRIVATE RECURSIVE METHOD THAT RETURNS A BinaryNode that equals THE PARAMETER
	//     If found, return the data in the returned BinaryNode

	private BinaryNode<E> _findNode(BinaryNode<E> node, E e )
	{
		if( node == null )	// no more node
			return null;
		else if( comp.compare(e, node.getData()) < 0 ) 		// <, so go left
				return _findNode( node.getLeftChild(), e );	//recursive call
		else if( comp.compare(e, node.getData()) > 0 ) 		// >, so go right
				return _findNode( node.getRightChild(), e );	//recursive call
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
    	if( node == null )
        {
            return new BinaryNode<E>(e);
        }
        if ( comp.compare(e, node.getData()) < 0 ) // <, so go left
             node.setLeftChild( _insert(node.getLeftChild(), e) ); //recursive call
        else  										// go right
             node.setRightChild( _insert(node.getRightChild(), e) ); //recursive call
           
        return node;
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
        if ( comp.compare(e, node.getData()) < 0 ) // <, so go left
             node.setLeftChild( _delete(node.getLeftChild(), e) );//recursive call
        else
            if( comp.compare(e, node.getData()) > 0 ) // >, so go right
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

    public E getFirst()
    {
    	
    	if (isEmpty())		// if the tree if empty
    		return null;
    	BinaryNode<E> current = root;
    	while(current.getLeftChild() != null)	// can't find left child
    		current = current.getLeftChild();	// get the node's left child
    	
    	return current.getData();				// return the node's data
    		
    }
    
    public E getLast()
    {
    	if (isEmpty())		// if the tree if empty
    		return null;
    	BinaryNode<E> current = root;
    	while(current.getRightChild() != null)	// can't find right child
    		current = current.getRightChild();	// get the node's right child
    	
    	return current.getData();				// return the node's data
    	
    }

} // end class BST
