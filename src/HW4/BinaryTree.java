public abstract class BinaryTree<E extends DeepCloneable<E>> implements TreeInterface<E> {
	protected BinaryNode<E> root=null; // reference to the root
    protected int size=0; // number of nodes in the tree

    public BinaryTree(){ }

    public BinaryTree(BinaryTree<E> sourceTree)
    {
    	// YOU WRITE (should do a DEEP COPY by calling deepCopyTree)
    	
    }

    /** Clears the whole tree */
    public void clear()
    {
    	//FINISH FOR HOMEWORK #4 // !!!!!!
    }
    
    protected BinaryNode<E> deepCopyTree(BinaryNode<E> node)
    {
    	BinaryNode<E> newRoot;
    	
    	// YOU FINISH: to make a deep copy, you need make new instances of each Node
    	//     AND each Node's data!
    	
    	return newRoot;
    }

    @Override /** Preorder traversal from the root */
    public void preorder(Visitor<E> visitor) 
    {
        preorder(root, visitor);
    }

    @Override /** Inorder traversal from the root*/
    public void inorder(Visitor<E> visitor) 
    {
        inorder(root, visitor);
    }

    @Override /** Postorder traversal from the root */
    public void postorder(Visitor<E> visitor) 
    {
    		postorder(root, visitor);
    }

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

    /** Preorder traversal from a subtree */
    protected void preorder(BinaryNode<E> root, Visitor<E> visitor) 
    {
    		if (root == null)
    			return;
    		visitor.visit(root.getData());
    		preorder(root.getLeftChild(), visitor);
    		preorder(root.getRightChild(), visitor);
    }

     /** Inorder traversal from a subtree */
    protected void inorder(BinaryNode<E> root, Visitor<E> visitor) 
    {
         // you finish (part of HW#4), SEE preorder above this

    }

     /** Posorder traversal from a subtree */
    protected void postorder(BinaryNode<E> root, Visitor<E> visitor) 
    {
         // you finish (part of HW#4)

    }
} // end abstract BinaryTree class
