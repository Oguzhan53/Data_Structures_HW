package q3;


/**
 * Implementation of Binary search Tree
 * @author Jacob / Koffman - Wolfgang
 *
 */

@SuppressWarnings("serial")
public class BinarySearchTree<E extends Comparable<E>> extends BinaryTree<E>  {
	/** Return va1ue from the public add method. */
	protected boolean addReturn ;
	/** Return va1ue from the public delete method. */
	protected E deleteReturn;
	
	/** Starter method find .
		pre: The target object must implement
		the Comparable interface .
		@param target The Comparable object being sought
		@return The object, if found, otherwise null
	*/
	public E find(E target) {
		return find(root,target);
	}
	/** Recursive find method.
		@param local Root The local subtree's root
		@param target The object being sought
	*/
	private E find(Node<E> localRoot , E target) {
		if(localRoot==null) {
			return null;
		}
		int compResult=target.compareTo(localRoot.data) ;
		
		if(compResult == 0)
			return localRoot.data;
		else if(compResult < 0 ) 
			return find(localRoot.left,target);
		else
			return find(localRoot.right,target);
	}
	
	
	private void printInorder(Node<E> node) 
    { 
        if (node == null) 
            return; 
        printInorder(node.left); 
        System.out.print(node.toString() + " "); 
        printInorder(node.right); 
    } 
	
	 public void printInorder()    {     
		 printInorder(root);   
	} 
	
	
	/**
	 * This method adds data to tree with call add add function
	 * @param item Data which will add
	 * @return If it succeed return true else return false
	 */
	public boolean add(E item) {
		root=add(root,item);
		return addReturn;
	}
	
	/**
	 *  This method adds data to tree
	 * @param localRoot Searched root
	 * @param item  Data which will add
	 * @return Added root
	 */
	private Node<E> add(Node<E> localRoot,E item) {
		if(localRoot==null) {
			// item is not in the tree - insert it.
			addReturn = true;
			return new Node<E>(item);
		}
		else if(item.compareTo(localRoot.data) ==0) {
			// item is equal to local Root.data
			addReturn=false;
			return localRoot;
		}
		else if(item.compareTo(localRoot.data) <0) {
			// item is 1ess than local Root.data
			localRoot.left=add(localRoot.left,item);
			return localRoot;
		}
		else {
			// item is greater than local Root.data
			localRoot.right=add(localRoot.right,item);
			return localRoot;
		}
	}
	
	/**
	 * This method delete data to tree with call delete method
	 * @param target Data which will delete
	 * @return Deleted data
	 */
	public E delete(E target) {
		root=delete(root,target);
		return deleteReturn;
	}
	
	/**
	 * This method delete data to tree 
	 * @param localRoot Searched root
	 * @param item  Data which will delete
	 * @return Deleted root
	 */
	private Node<E> delete(Node<E> localRoot , E item) {
		if(localRoot==null) {
			deleteReturn=null;
			return localRoot;
		}
		int compResult = item.compareTo(localRoot.data);
		if(compResult<0) {
			localRoot.left=delete(localRoot.left,item);
			return localRoot;
		}
		else if(compResult>0) {
			localRoot.right=delete(localRoot.right,item);
			return localRoot;
		}
		else {
			deleteReturn=localRoot.data;
			if(localRoot.left==null) {
				return localRoot.right;
			}
			else if(localRoot.right==null) {
				return localRoot.left;
			}
			else {
				if(localRoot.left.right==null) {
					localRoot.data=localRoot.left.data;
					localRoot.left=localRoot.left.left;
					return localRoot;
				}
				else {
					localRoot.data=findLargestChild(localRoot.left);
					return localRoot;
				}
			}
		}
	}
	
	/**
	 * This method find largest data .
	 * @param parent Searched root
	 * @return Largest data
	 */
	protected E findLargestChild(Node<E> parent) {
		if(parent.right.right==null) {
			E returnvalue=parent.right.data;
			parent.right=parent.right.left;
			return returnvalue;
		}
		else
			return findLargestChild(parent.right);
	}
	
	
	
}
