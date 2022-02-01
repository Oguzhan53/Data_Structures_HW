package q2;

import java.io.Serializable;
import java.util.*;

/**
 * This is Binary tree class
 * @author Oguzhan SEZGIN - 1801042005
 *
 */
@SuppressWarnings("serial")
public class BinaryTree  implements Serializable  {

	/**
	 * This is inner node class.Nodes combined to create binary tree
	 * @author Oguzhan SEZGIN - 1801042005
	 *
	 */
	protected static class Node implements Serializable{
		protected String data;
		protected Node left;
		protected Node right;
		/**
		 * Inner node class constructor
		 * @param data Data which will node hold
		 */
		public Node(String data) {
			this.data=data;
			left = null;
			right = null;
		}
		/**
		 *This method convert node data to string
		 */
		public String toString() {
			return data.toString();
		}
	}
	private Node root;
	public Node getRoot() {
		return root;
	}
	public void setRoot(Node root) {
		this.root = root;
	}
	public BinaryTree() {
		root = null;
	}
	protected BinaryTree(Node root) {
		this.root=root;
	}
	/**
	 * Binary tree parameter constructor
	 * @param data Data which will hold root node
	 * @param leftTree Left child node
	 * @param rightTree Right child node
	 */
	public BinaryTree(String data, BinaryTree leftTree,BinaryTree rightTree) {
		root = new Node(data);
		if (leftTree != null) {
			root.left= leftTree.root;
		} 
		else {
			root.left = null;
		}
		if (rightTree != null) {
			root.right = rightTree.root;
		} 
		else {
			root.right = null;
		}
	}
	/**
	 * This method return left subtree
	 * @return left subtree
	 */
	public BinaryTree getLeftSubtree() {
		if (root != null && root.left != null) {
			return new BinaryTree(root.left);
		} else {
			return null;
		}
	}
	/**
	 * This method return right subtree
	 * @return right subtree
	 */
	public BinaryTree getRightSubtree() {
		if (root != null && root.right != null) {
			return new BinaryTree(root.right);
		} else {
			return null;
		}
	}
	/**
	 * This method checks node is leaf or tree
	 * @return Return true if node is leaf else return false
	 */
	public boolean isLeaf() {
		return (root.left == null && root.right == null);
	}
	/**
	 *	This method makes tree to string 
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder();
		preOrderTraverse(root, 1,sb);
		return sb.toString();
		}
	/**
	 * This method traverse tree with preorder method
	 * @param node Searched node
	 * @param depth Used for spaces
	 * @param sb String builder to use make string
	 */
	private void preOrderTraverse(Node node, int depth,StringBuilder sb) {
	
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
	public  BinaryTree readBinaryTree(Scanner scan){
		
		String data =scan.next();
		if(data.equals("null"))
			return null;
		else {
			BinaryTree leftTree = readBinaryTree(scan);
			BinaryTree rightTree = readBinaryTree(scan);
			return new BinaryTree(data, leftTree, rightTree);
		}
	}
	
	
	
}
