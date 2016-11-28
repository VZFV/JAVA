/**
 * BinaryTree
 * Author: Feng Zhang
 * 11/14/2016
 * window 10 64bit, eclipse
 * This is Binary tree class. 
 */
package HW4;

public abstract class BinaryTree<E extends DeepCloneable<E>> implements TreeInterface<E> {
	protected BinaryNode<E> root=null; // reference to the root
    protected int size=0; // number of nodes in the tree

    public BinaryTree(){ }

    public BinaryTree(BinaryTree<E> sourceTree)
    {
    	sourceTree.deepCopyTree(root);
    	
    }

    /** Clears the whole tree */
    public void clear()
    {
    	this.root = null;
    	
    }
    
    protected BinaryNode<E> deepCopyTree(BinaryNode<E> node)
    {	
    	if(node == null)	// check node is null
    		return null;
    	
    	BinaryNode<E> newRoot = new BinaryNode<E>(); // instantiate newRoot
    	
    	E cloneData = node.getData().deepClone(); // deep clone data
    	
    	newRoot.setData(cloneData);					// set node data	
    	newRoot.setLeftChild(deepCopyTree(node.getLeftChild()));	// recursion for node's left child
    	newRoot.setRightChild(deepCopyTree(node.getRightChild()));	// recursion for node's right child
    	
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
    	if (root == null)
			return;
    	
    	inorder(root.getLeftChild(), visitor);
    	visitor.visit(root.getData());
    	inorder(root.getRightChild(), visitor);

    }

     /** Posorder traversal from a subtree */
    protected void postorder(BinaryNode<E> root, Visitor<E> visitor) 
    {
       
    	if (root == null)
			return;
    	
    	visitor.visit(root.getLeftChild().getData());
    	inorder(root.getRightChild(), visitor);
    	inorder(root, visitor);
    
    }
} // end abstract BinaryTree class
