package q3;

import java.lang.NullPointerException;

/**
 * This is Age Search Tree class.It holds ages and ages of number.It extends BinarySearchTree class
 * @author Oguzhan SEZGIN - 1801042005
 *
 */
public class AgeSearchTree extends BinarySearchTree {

	/**
	 * Non-parameter constructor
	 */
	public AgeSearchTree() {
		this.root=null;
	}
	/**
	 * Parameter constructor
	 * @param data Data which will hold in root data
	 */
	public AgeSearchTree(int data) {
		this.add(data);
	}
	
	/**
	 * This method adds data to tree with call add add function
	 * @param node Data which will add
	 * @return If it succeed return true else return false
	 */
	public boolean add(AgeData node) {
		int item=node.data;
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
			localRoot.increase_num();
			return localRoot;
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
	public int remove(int target) {
		root=delete(root,target);
		if(deleteReturn==-1)
			System.out.println("Program can not delete.There is no this number age");
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
			if(localRoot.num<=1) {
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
			else {
				localRoot.decrease_num();
				return localRoot;
			}
				
			
		}
	}
	
	/**
	 * This method find data with call find1 method
	 * @param node Element which user want to find
	 * @return Found data
	 */
	public AgeData find(AgeData node) {
		int target=node.data;
		AgeData temp = find(root,target); 
		if(temp==null)
			throw new NullPointerException();
		return temp;
		
	}
	
	/**
	 * This method find data
	 * @param localRoot Searched node
	 * @param target  Data which user wants to.
	 * @return Found data
	 */
	private AgeData find(AgeData localRoot , int target) {
		if(localRoot==null) {
			return null;
		}
			
		if(target==localRoot.data)
			return localRoot;
		else if(target<localRoot.data) 
			return find(localRoot.left,target);
		else
			return find(localRoot.right,target);
	}
	
	/**
	 * This method find younger age than given age with call younger method
	 * @param data Data which will find younger age
	 * @return number of younger age
	 */
	public int youngerThan(int data) {
		int res=younger(root,data,0);
		return res;
	}
	
	/**This method find younger age than given age
	 * @param node Searched node
	 * @param data Data which will find younger age
	 * @param res number of younger age
	 * @return number of younger age
	 */
	private int younger(AgeData node,int data,int res){
		if (node == null)
			return 0;
			
		else {
			if(node.data<data) {
				res=younger(node.left,data,res);
				res+=younger(node.right,data,res);
				return res+node.num;
			}
			else {
				return younger(node.left,data,res);	
			}
		}
	}
	
	/**
	 * This method find older age than given age with call older method
	 * @param data Data which will find older age
	 * @return number of older age
	 */
	public int olderThan(int data) {
		int res=older(root,data,0);
		return res;
	}
	
	
	/**This method find older age than given age
	 * @param node Searched node
	 * @param data Data which will find older age
	 * @param res number of older age
	 * @return number of older age
	 */
	private int older(AgeData node,int data,int res){
		if (node == null)
			return 0;
			
		else {
			if(node.data>data) {
				res=older(node.right,data,res);
				res+=older(node.left,data,res);
				return res+node.num;
			}
			else {
				return older(node.right,data,res);	
			}
		}
	}
	
	
	
	/**
	 *This method make tree to string with using preorder traverse method
	 *@return Tree string
	 */
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		preOrderTraverse(root,sb);
		return sb.toString();
		}
	/**
	 * This method traverse tree with using preorder method
	 * @param node Searched node
	 * @param sb String builder to create string
	 */
	private void preOrderTraverse(AgeData node,StringBuilder sb) {
	
		if (node == null) {
			sb.append("null\n");	
			return;
			}
		else {
			sb.append(node.toString()+"\n");			
			preOrderTraverse(node.left ,sb);
			preOrderTraverse(node.right ,sb);
		}
			
	}
	
	
}
