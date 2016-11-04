package Newfolder;

public abstract class BinaryTree<E> implements TreeInterface<E> 
{
   protected BinaryNode<E> root=null; // reference to the root
   protected int size=0; // number of nodes in the tree
   public BinaryTree(){ }
    
   @Override /** Preorder traversal from the root */
   public void preorder(Visitor<E> visitor) // SEE CATALYST FOR HOW TO USE Visitor<E>
   {
       preorder(root, visitor);
   }
 
  // MORE METHODS ARE HERE  
   @Override /** Get the number of nodes in the tree */
   public int getSize() 
   {
       return size;
   }
 
   @Override /** Return true if the tree is empty */
   public boolean isEmpty() 
   {
       return getSize() == 0;
   }
/* only the internal preorder traversal will be shown here, called from the public preorder function: */

    /** Preorder traversal from a subtree */

    protected void preorder(BinaryNode<E> root, Visitor<E> visitor)
    {
        if (root == null)
             return;
        visitor.visit(root.getData());
        preorder(root.getLeftChild(), visitor);
        preorder(root.getRightChild(), visitor);
    }

class BinaryNode<T>
{
   private T             data;
   private BinaryNode<T> leftChild;  // Reference to left child
   private BinaryNode<T> rightChild; // Reference to right child
   public BinaryNode()
   {
      this(null); // Call next constructor
   } // end default constructor
   public BinaryNode(T dataPortion)
   {
      this(dataPortion, null, null); // Call next constructor
   } // end constructor
   public BinaryNode(T dataPortion, BinaryNode<T> newLeftChild,
           BinaryNode<T> newRightChild)
   {
      data = dataPortion;
      leftChild = newLeftChild;
      rightChild = newRightChild;
   } // end constructor
   /** Retrieves the data portion of this node.
   @return  The object in the data portion of the node. */
   public T getData()
   {
      return data;
   } // end getData
   /** Sets the data portion of this node.
   @param newData  The data object. */
   public void setData(T newData)
   {
      data = newData;
   } // end setData
   /** Retrieves the left child of this node.
   @return  The node��s left child. */
   public BinaryNode<T> getLeftChild()
   {
      return leftChild;
   } // end getLeftChild
   /** Sets this node��s left child to a given node.
   @param newLeftChild  A node that will be the left child. */
   public void setLeftChild(BinaryNode<T> newLeftChild)
   {
      leftChild = newLeftChild;
   } // end setLeftChild
   /** Retrieves the right child of this node.
   @return  The node��s right child. */
   public BinaryNode<T> getRightChild()
   {
      return rightChild;
   } // end getRightChild
   /** Sets this node��s right child to a given node.
   @param newRightChild  A node that will be the right child. */
   public void setRightChild(BinaryNode<T> newRightChild)
   {
      rightChild = newRightChild;
   } // end setRightChild
   /** Detects whether this node is a leaf.
   @return  True if the node is a leaf. */
   public boolean isLeaf()
   {
      return (leftChild == null) && (rightChild == null);
   } // end isLeaf
   // ETC. (MORE METHODS ARE IN THE COMPLETE CLASS IN CATALYST
} // end BinaryNode
}