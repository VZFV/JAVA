package Newfolder;

public abstract class BST<E extends Comparable<E>>
         extends BinaryTree<E>
{
    private boolean foundNode; // helper variable
    /** Create a default binary tree */
    public BST() {
    }
 
   @Override /** Returns true if the element is in the tree */
   public boolean contains(E e) 
   {
       BinaryNode<E> current = root; // Start from the root
       while (current != null) 
       {
           if (e.compareTo(current.getData()) < 0) 
           {
               current = current.getLeftChild();
           }
           else if (e.compareTo(current.getData()) > 0) 
                {
                    current = current.getRightChild();
                }
                else // element matches current.getData()
                    return true; // Element is found
        } // end while
        return false;
   }
   @Override
   /**
   * Returns the data of the Node that equals the parameter, null if not found.
   * */
   public E getEntry(E e) 
   {
       BinaryNode<E> foundNode = _findNode(root, e); // YOU WRITE FOR LAB EX. 7.3
       if( foundNode != null)
           return foundNode.getData();
       return null;
   }

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

   private BinaryNode<E> _delete( BinaryNode<E> node, E e )
   {
	   if( node==null )
	   {
		   return null;
	   }
	   if ( e.compareTo(node.getData()) < 0 ) // <, so go left
		   node.setLeftChild( _delete(node.getLeftChild(), e) );//recursive call
	   else
		   if( e.compareTo(node.getData()) > 0 ) // >, so go right
			   node.setRightChild( _delete(node.getRightChild(), e) );//recursive call
		   else
		   {									// FOUND THE NODE
			   foundNode = true;
			   node = _deleteNode( node );
		   }
	   return node;
   } // end _delete

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


   private BinaryNode<E> _findNode( BinaryNode<E> node, E targetData ) {
	   if (node == null)
		   return null;
	   else if(targetData.compareTo(node.getData()) < 0)
		   return _findNode(node.getLeftChild(), targetData);
	   else if(targetData.compareTo(node.getData()) > 0)
		   return _findNode(node.getRightChild(), targetData);
	   else
		   return node;	
   }
   
   public boolean isIdentical(BinaryNode<E> someTree){
	   return isIdentical(root, someTree);
   }
   
   public boolean isIdentical(BinaryNode<E> firstTree, 
		   BinaryNode<E> secondTree){
	   if((firstTree == null)&&(secondTree == null))
			return true;
	   else if((firstTree == null)&&(secondTree != null))
		   return false;
	   else if((firstTree != null)&&(secondTree == null)) 
		   return false;
	   else if(!(firstTree.getData().equals(secondTree.getData())))
		   return false;
	   else{
		   BinaryNode<E> firstLeft = firstTree.getLeftChild();
		   BinaryNode<E> secondLeft = secondTree.getLeftChild();
		   BinaryNode<E> firstRight = firstTree.getRightChild();
		   BinaryNode<E> secondRight = secondTree.getRightChild();
		   
		   return (isIdentical(firstLeft, secondLeft)&&
				   isIdentical(firstRight,secondRight));
	   }
   }
}
