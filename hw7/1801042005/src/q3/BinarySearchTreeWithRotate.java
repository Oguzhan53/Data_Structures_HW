package q3;


/** This c 1ass extends the BinarySearchTree by adding the rotate
*	operations . Rotation will change the balance of a search
*	tree whi1e preserving the search tree property.
*	Used as a common base c1ass for se1f-ba1ancing trees .
*/
@SuppressWarnings("serial")
public class BinarySearchTreeWithRotate<E extends Comparable<E>> extends BinarySearchTree<E> {

	// Methods
	/** Method to perform a right rotation .
	*pre : root is the root of a binary search tree .
	*post: root.right is the root of a binary search tree,
	*	root.right.right is raised one 1eve 1 ,
	*	root.right . left does not change 1eve 1s,
	*	root.left is 1owered one 1eve 1 ,
	*	the new root i s returned.
	*@param root The root of the binary tree to be rotated
	*@return The new root of the rotated tree
	*/
	protected Node<E> rotateRight(Node<E> root) {
		Node<E> temp = root.left ;
		root.left = temp.right ;
		temp.right = root ;
		return temp ;
	}
	/** Method to perform a right rotation .*/
	protected Node<E> rotateLeft(Node<E> root) {
		Node<E> temp = root.right ;
		root.right = temp.left ;
		temp.left = root ;
		return temp ;
	}
	
	
}
