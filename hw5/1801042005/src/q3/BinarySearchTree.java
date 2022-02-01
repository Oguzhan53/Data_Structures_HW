package q3;

import java.io.Serializable;

/**
 * @author Oguzhan Sezgin - 1801042005
 *
 */
public class BinarySearchTree {

	/**
	 * This is inner node class
	 * @author Oguzhan SEZGIN -1801042005
	 *
	 */
	@SuppressWarnings("serial")
	protected static class AgeData implements Serializable{
		protected int data;
		protected int num;
		protected AgeData left;
		protected AgeData right;
		public AgeData(int data) {
			this.data=data;
			this.num=1;
			left = null;
			right = null;
		}
		/**AgeData class parameter constructor
		 * @param data Data which will node holds
		 * @param num Number of data
		 */
		public AgeData(int data,int num) {
			this.data=data;
			this.num=num;
			left = null;
			right = null;
		}
		/**
		 *This methods make node to string
		 */
		public String toString() {
			return String.valueOf(data)+"-"+String.valueOf(num);
		}
		/**
		 * This method increase number of data
		 */
		protected void increase_num() {
			this.num=this.num+1;
		}
		/**
		 * This method decrease number of data
		 */
		protected void decrease_num() {
			this.num=this.num-1;
		}
		
	}
	protected AgeData root;
	protected boolean addReturn ;
	protected int deleteReturn;
	
	/**
	 * This method find data with call find1 method
	 * @param target Element which user want to find
	 * @return Found data
	 */
	public int find1(int target) {
		return find1(root,target);
	}
	/**
	 * This method find data
	 * @param localRoot Searched node
	 * @param target  Data which user wants to.
	 * @return Found data
	 */
	private int find1(AgeData localRoot , int target) {
		if(localRoot==null) {
			if(target==-1)
				return 0;
			return -1;
		}
			
		if(target==localRoot.data)
			return localRoot.data;
		else if(target<localRoot.data) 
			return find1(localRoot.left,target);
		else
			return find1(localRoot.right,target);
	}
	
	/**
	 * This method adds data to tree with call add add function
	 * @param item Data which will add
	 * @return If it succeed return true else return false
	 */
	public boolean add(int item) {
		root=add(root,item);
		return addReturn;
	}
	
	/**
	 *  This method adds data to tree
	 * @param localRoot Searched root
	 * @param item  Data which will add
	 * @return Added root
	 */
	private AgeData add(AgeData localRoot,int item) {
		if(localRoot==null) {
			addReturn = true;
			return new AgeData(item);
		}
		else if(item==localRoot.data) {
			addReturn=true;
			return new AgeData(item);
		}
		else if(item<localRoot.data) {
			localRoot.left=add(localRoot.left,item);
			return localRoot;
		}
		else {
			localRoot.right=add(localRoot.right,item);
			return localRoot;
		}
	}
	
	/**
	 * This method delete data to tree with call delete method
	 * @param target Data which will delete
	 * @return Deleted data
	 */
	public int delete(int target) {
		root=delete(root,target);
		return deleteReturn;
	}
	
	/**
	 * This method delete data to tree 
	 * @param localRoot Searched root
	 * @param item  Data which will delete
	 * @return Deleted root
	 */
	private AgeData delete(AgeData localRoot , int item) {
		if(localRoot==null) {
			deleteReturn=-1;
			return localRoot;
		}
		if(item<localRoot.data) {
			localRoot.left=delete(localRoot.left,item);
			return localRoot;
		}
		else if(item>localRoot.data) {
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
	protected int findLargestChild(AgeData parent) {
		if(parent.right.right==null) {
			int returnvalue=parent.right.data;
			parent.right=parent.right.left;
			return returnvalue;
		}
		else
			return findLargestChild(parent.right);
	}
	
	
	
}
