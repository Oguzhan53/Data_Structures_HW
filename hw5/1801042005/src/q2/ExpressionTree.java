package q2;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;


/**
 * This is Expression tree class.It extends Binary tree class
 * @author Oguzhan SEZGIN - 1801042005
 *
 */
@SuppressWarnings("serial")

public class ExpressionTree extends BinaryTree{
	private int flag;
	/**
	 * Non=parameter constructor
	 */
	public ExpressionTree() {
		super();
	}
	/**
	 * Parameter constructor.It construct tree with call readBinaryTree method.
	 * @param str Expression tree data
	 */
	public ExpressionTree(String str) {
		
		
		String delim = "[ ]";
		String [] token	 = str.split(delim);
		if(!is_operator(token[0])) {
			str=strReverse(str);
			flag=1; // post order 
		}
		else {
			flag = 0;//pre order
		}
		str=str.trim();
		Scanner scan = new Scanner(str);
		
		this.setRoot(readBinaryTree(scan).getRoot());
		
	}
	/**
	 * Root parameter constructor
	 * @param root Root node
	 */
	protected ExpressionTree(Node root) { 
		super(root);
	}
	/**
	 * Parameter constructor.
	 * @param data Data which will hold in root node 
	 * @param leftTree Left subtree
	 * @param rightTree Right subtree
	 */
	public ExpressionTree(String data, BinaryTree leftTree,BinaryTree rightTree) {
		
		super(data,leftTree,rightTree);
		
	}
	
	/**
	 * This method checks data is operator or not.
	 * @param str data will check
	 * @return If data is operator return true else return false
	 */
	private  boolean is_operator(String str) {
		if(str.equals("*") || str.equals("/") || str.equals("+") || str.equals("-") )
			return true;
		return false;
	}
	
	/**
	 * This method reverse expression
	 * @param str Expression which will reverse
	 * @return Reversed expression
	 */
	private  String strReverse(String str) { 
		
		String delim = "[ ]";
		String [] token	 = str.split(delim);
		
		String reverse = "";
        for(int i = token.length - 1; i >= 0; i--){
            reverse = reverse +" "+ token[i];
        }
		return reverse;
	}
	
	/**
	 * This methods read data and construct binary tree and return
	 * It throws exception if give missing number
	 */
	public  ExpressionTree readBinaryTree(Scanner scan){
			
			//System.out.println(scan.hasNext());
			String data =scan.next();
			
			if(!scan.hasNext() && data==null) {
				throw new NoSuchElementException(); 
			}
			else if(isNumeric(data)) {
				return new ExpressionTree(data, null, null);
				
			}
				
			else if(is_operator(data)){
				if(this.flag==0) {
					BinaryTree leftTree = readBinaryTree(scan);
					BinaryTree rightTree = readBinaryTree(scan);
					return new ExpressionTree(data, leftTree, rightTree);
				}
				else {
					BinaryTree rightTree= readBinaryTree(scan);
					BinaryTree leftTree = readBinaryTree(scan);
					return new ExpressionTree(data, leftTree, rightTree);
				}
			}	
			else
				throw new InputMismatchException();
			
	}
	/**
	 * This method check data is numeric or not
	 * @param strNum Data which will check
	 * @return If data numeric return true else return false
	 */
	public  boolean isNumeric(String strNum) {
	    if (strNum == null) {
	        return false;
	    }
	    try {
	        @SuppressWarnings("unused")
			double d = Double.parseDouble(strNum);
	    } catch (NumberFormatException nfe) {
	        return false;
	    }
	    return true;
	}
	
	/**
	 * This method make tree to string with using postorder traverse method.
	 * @return Tree string
	 */
	public  String toString2() {
		StringBuilder sb = new StringBuilder();
		postOrderTraverse(this.getRoot(), sb);
		return sb.toString();
	}
	
	/**
	 * This method  traverse tree with using postorder method
	 * @param node Searched node
	 * @param sb String builder to create string
	 */
	private  void postOrderTraverse(Node node,StringBuilder sb) {
		if(node==null) {
			return;
		}
		else {
			postOrderTraverse(node.left,sb );
			postOrderTraverse(node.right,sb);
			sb.append(node.toString()+" ");
		}
		
	}

	
	/**
	 * This method evaluate expression
	 * @param node Searched node
	 * @return Evaluation result
	 */
	private double evaluator(Node node) {
		
		if(!is_operator(node.toString()))
			return Double.parseDouble(node.toString());
		else {
			if(node.toString().equals("+")) {
				return evaluator(node.left)+evaluator(node.right);
			}
			else if(node.toString().equals("-")) {
				return evaluator(node.left)-evaluator(node.right);
			}
			else if(node.toString().equals("*")) {
				return evaluator(node.left)*evaluator(node.right);
			}
			else  {
				return evaluator(node.left)/evaluator(node.right);
			}
		}
		
		
		
	}
	
	/**
	 * This method evaluate expression with call evaluator method.
	 * @return	Evaluation result
	 */
	public double eval() {
		if(this.getRoot()!=null) {
			double res= evaluator(this.getRoot());
			return res;
		}
		else 
			return 0;
		
		
	}
}
