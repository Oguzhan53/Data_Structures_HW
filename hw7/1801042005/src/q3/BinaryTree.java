package q3;

import java.io.Serializable;
import java.util.Scanner;


@SuppressWarnings("serial")
public class BinaryTree<E>  implements Serializable{
	/** Class to encapsulate a tree node. */
	protected static class Node<E> implements Serializable {
		// Data Fields
		/** The information stored in this node . */
		protected E data ;
		/** Reference to the left ch1 1d. */
		protected Node<E> left ;
		/** Reference to the right ch i ld. */
		protected Node<E> right ;
		//Constructors
		/** Construct a node with given data and no chi ldren .
		@param data The data to store in th is node
		*/
		public Node(E data) {
			this.data=data ;
			left = null ;
			right = null ;
		}
		
		//Methods
		/** Return a string representation of the node .
		@return A string representation of the data fie 7ds
		*/
		public String toString () {
			return data.toString() ;
		}
		
	
	}
	
	// Data Fie 1d
	/** The root of the binary tree */
	protected Node<E> root ;
	
	public BinaryTree() {
		root = null;
	}
	
	protected BinaryTree(Node<E> root) {
		this.root = root ;
	}
	/** Constructs a new binary tree with data in its root leftTree
	as its left subtree and rightTree as its right subtree .
	*/
	public BinaryTree(E data, BinaryTree<E> leftTree ,BinaryTree<E> rightTree) {
		root = new Node<E>(data) ;
		if(leftTree != null ) {
			root.left = leftTree.root ;
		}
		else{
			root.left = null;
		}
		if(rightTree != null ) {
			root.right = rightTree.root ;
		} 
		else {
			root.right = null ;
		}
	}
	
	/** Return the left subtree.
	@return The 7eft subtree or null if either the root or
	the left subtree is null
	*/
	public BinaryTree<E> getLeftSubtree () {
	
		if(root!= null && root.left != null) {
			return new BinaryTree<E>(root.left) ;
		} 
		else{
			return null ;
		}
	
	}
	
	/**
	 * This method return right subtree
	 * @return right subtree
	 */
	public BinaryTree<E> getRightSubtree() {
		if (root != null && root.right != null) {
			return new BinaryTree<E>(root.right);
		} else {
			return null;
		}
	}
	
	
	/** Determine whether this tree is a 1eaf.
		@return true if the root has no children
	*/
	public boolean isleaf() {
		return (root.left == null && root.right == null);
	}
	
	public String toString() {
	
	StringBuilder sb = new StringBuilder() ;
		preOrderTraverse(root , 1 , sb) ;
		return sb.toString () ;
	}
	
	/**
	 * This method traverse tree with preorder method
	 * @param node Searched node
	 * @param depth Used for spaces
	 * @param sb String builder to use make string
	 */
	private void preOrderTraverse(Node<E> node, int depth,StringBuilder sb) {
		
		for (int i = 1; i < depth ; i++) {
				sb.append(" ") ;
		}
		if (node == null) {
			return;
			}
		else {
			sb.append(node.toString()+" ");			
			preOrderTraverse(node.left , depth + 1,sb);
			preOrderTraverse(node.right , depth + 1,sb);
		}
			
	}
	
	
	/**
	 * This method read data and create binary tree
	 * @param scan Use for take data
	 * @return Binary tree
	 */
	public  BinaryTree<String> readBinaryTree(Scanner scan){
		
		String data =scan.next();
		if(data.equals("null"))
			return null;
		else {
			BinaryTree<String> leftTree = readBinaryTree(scan);
			BinaryTree<String> rightTree = readBinaryTree(scan);
			return new BinaryTree<String>(data, leftTree, rightTree);
		}
	}
	
	
}
