package q4;

import java.util.*;

/**
 * This is Heap class.It holds array list for heap
 * @author Oguzhan SEZGIN - 1801042005
 *
 */
public class MaxHeap {

	private List<AgeData> heap ;
	
	/**
	 * This is non parameter constructor
	 */
	public MaxHeap() {
		heap=new ArrayList<AgeData>();
	}
	/**
	 * This method adds new age to heap
	 * @param node Data which will be add
	 */
	public 	void add(AgeData node) {
		for(int i=0;i<this.heap.size();i++) {
			if(heap.get(i).data==node.data) {
				heap.get(i).increase_num();
				return;
			}
		}
		heap.add(node);
		int child= heap.size()-1; 
		int parent=(child-1)/2;
		while(parent>= 0 && comparator(heap.get(parent), heap.get(child)) <0) {
			swap(heap.get(parent), heap.get(child));
			child=parent;
			parent=(child-1)/2;
		}
	}
	
	/**
	 * This method compare to nodes age
	 * @param node1 Compared 1
	 * @param node2 Compared 2
	 * @return Return compare result.
	 */
	private int comparator(AgeData node1,AgeData node2) {
		if(node1.num>node2.num)
			return 1;
		else if(node1.num==node2.num)
			return 0;
		else
			return -1;
	}
	
	/** This method swap two nodes.
	 * @param node1 Swap element 1
	 * @param node2	Swap element 2
	 */
	private void swap(AgeData node1,AgeData node2) {
		int tempNum=node1.num;
		int tempAge=node1.data;
		
		node1.data=node2.data;
		node1.num=node2.num;
		
		node2.data=tempAge;
		node2.num=tempNum;
		
	}
	
	
	/**
	 * This method removes age which given
	 * @param age Age which will remove
	 * @return If it successful it return true else return false 
	 */
	public boolean remove(int age) {
		for(int i=0;i<this.heap.size();i++) {
			if(heap.get(i).data==age) {
				if(heap.get(i).num>=2)
					heap.get(i).decrease_num();
				else {
					swap(heap.get(i), heap.get(heap.size()-1));
					heap.remove(heap.size()-1);
					int parent =0;
					while(true) {
						int leftchild = 2*parent+1;
						int rightchild = leftchild+1;
						if(leftchild>=heap.size())
							break;
						int minChild=leftchild;
						if(rightchild<heap.size() && comparator(heap.get(rightchild), heap.get(leftchild)) <0 ) {
							minChild=rightchild;
						}
						if(comparator(heap.get(parent), heap.get(minChild)) > 0) {
							swap(heap.get(parent),heap.get(parent));
							parent=minChild;
						}
						else
							break;
					}
				}
				return true;
			}
			
		}
		System.out.println("There is no this number age");
		return false;
	}
	
	/**This method find age data and return it
	 * @param node Data which will find
	 * @return Found data
	 */
	public AgeData find(AgeData node) {
		int temp=node.data;
		for(int i=0;i<heap.size();i++) {
			if(heap.get(i).data==temp) {
				return heap.get(i);
			}
		}
		throw new NullPointerException();
	}
	
	/**This method prints younger age number than given age
	 * @param data Data which want to know younger age 
	 * @return Younger age number
	 */
	public int youngerThan(int data) {
		int res=0;
		for(int i=0;i<heap.size();i++) {
			if(heap.get(i).data<data)
				res+=heap.get(i).num;
		}
		return res;
	}
	
	/**This method prints older age number than given age
	 * @param data Data which want to know older age 
	 * @return older age number
	 */
	public int olderThan(int data) {
		int res=0;
		for(int i=0;i<heap.size();i++) {
			if(heap.get(i).data>data)
				res+=heap.get(i).num;
		}
		return res;
	}
	
	/**
	 *This method make heap to String
	 */
	public String toString() {
		StringBuilder sb  =new StringBuilder();
		for(int i=0;i<heap.size();i++) {
			sb.append(heap.get(i).toString()+"\n");
		}
		return sb.toString();
	}
	
	


}
