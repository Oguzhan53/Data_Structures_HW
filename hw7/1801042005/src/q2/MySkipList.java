package q2;

import java.util.*;

/**
 * Implementation of New Skip List data structure
 * @author Oguzhan SEZGIN - 1801042005
 *
 *@param <E> The type of data stored. Must be a Comparable
 */
public class MySkipList<E extends Comparable<E>> {
	/**
	 * Head of the skip-list
	 */
	public SLNode<E> head;
	private int nodenum;
	/**
	 * Size of the skip list
	 */
	private int size;
	/**
	 * The maximum level of the skip-list
	 */
	private int maxLevel;
	/**
	 * Smallest power of 2 that is greater than the current skip-list size
	 */
	private int maxCap;
	/**
	 * Natural log of 2
	 */
	static final double LOG2 = Math.log(2.0);
	/**
	 * Minimum possible integer value for the head
	 */
	static final int MIN = Integer.MIN_VALUE;
	
	static final int order = 6;
	/**
	 * Random number generator
	 */
	private Random rand = new Random();
	
	//Constructor
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public MySkipList(){
		nodenum=0;
		size = 0;
		maxLevel = 0;
		maxCap = computeMaxCap(maxLevel);
		head = new SLNode(maxLevel, MIN,null);
	}
	
	/**
	 * Search for an item in the list
	 * @param target The item being sought
	 * @return An SLNode array which references the predecessors of the target at each level.
	 */
	@SuppressWarnings("unchecked")
	private SLNode<E>[] search(E target){
		SLNode<E>[] pred = (SLNode<E>[]) new SLNode[maxLevel];
		SLNode<E> current = head;
		for(int i = current.links.length - 1; i >= 0; i--){
			while(current.links[i] != null
					&& current.links[i].min.compareTo(target) < 0  && current.links[i].next!=null && current.links[i].next.compareTo(target)<0){
				current = current.links[i];
			}
			if(current.links[i]!=null   ) {
				current=current.links[i];
			}
					
			pred[i] = current;
		}
		return pred;
	}
	
	/**
	 * Find an object in the skip-list
	 * @param target The item being sought
	 * @return A reference to the object in the skip-list that matches
	 * 		   the target. If not found, null is returned 
	 */
	public E find(E target){
		SLNode<E>[] pred = search(target);
		if(pred[0].links != null ) {
			
			for(int i=0;i<5;i++) {
				
				if(pred[0].links[0] != null &&pred[0].links[0].data[i]!= null) {
					if(pred[0].links[0].data[i].compareTo(target) == 0)
						return pred[0].links[0].data[i];
				}
				
			}
		} 
		
		return null;
	}
	
	/**
	 * Inserts the given item
	 * @param item The item to add
	 * @return true as the item is added
	 */
	public boolean add(E item){
		size++;
		SLNode<E>[] pred = search(item);
		if(size > maxCap){
			maxLevel++;
			maxCap = computeMaxCap(maxLevel);
			head.links = Arrays.copyOf(head.links, maxLevel);
			pred = Arrays.copyOf(pred, maxLevel);
			pred[maxLevel - 1] = head;
		}
		
		if(nodenum!= 0 && (  head.links==null || size<=order || head.links[0].min.compareTo(item)>0 ||   head.links[0].next.compareTo(item)>0   )) {
			addArray(head.links[0].data, item);
			head.links[0].min=head.links[0].data[0];
			head.links[0].num++;
			if(head.links[0].num==order) {
				splitNode(head.links, 0);
			}
			
				
		}
		else {
			 if(  nodenum!=0 ){
					//flag = 0
				 int i4=0;
				 for(int i2=0;i2<pred.length;i2++) {
					 if(i2>=nodenum)
						 break;
					 if(pred[i2].min.compareTo(item) <0 &&(pred[i2].next==null || pred[i2].next.compareTo(item)>0) ) {
						 i4=1;
						 addArray(pred[i2].data, item);
						 pred[i2].min=pred[i2].data[0];
						pred[i2].num++;
						if(pred[i2].num==order){
							splitNode(pred,i2);
						}
							break;
					 }
				 }
				 if(i4==0) {
					 nodenum++;
						SLNode<E> newNode = new SLNode<E>(logRandom(), item,null);

						for(int i = 0; i < newNode.links.length; i++){
							newNode.links[i] = pred[i].links[i];
							pred[i].links[i] = newNode;
						}
				 }
					
					
				}
		
				else {
					nodenum++;
					SLNode<E> newNode = new SLNode<E>(logRandom(), item,null);

					for(int i = 0; i < newNode.links.length; i++){
						newNode.links[i] = pred[i].links[i];
						pred[i].links[i] = newNode;
					}

				}
		}
		
		return true;
	}
	
	/**
	 * This method split nodes when list is full 
	 * @param pred Previous lists 
	 * @param num  Index of the list to add the element
	 */
	private void splitNode(SLNode<E>[] pred ,int num) {
		nodenum++;
		SLNode<E> newNode = new SLNode<E>(logRandom(),null,null);
		int i1=0;
		
		for(int i=order/2;i<order;i++) {
			newNode.data[i1]=pred[num].data[i];
			pred[num].data[i]=null;
			i1++;
		}
		pred[num].num=order/2;
		newNode.num=order/2;
		E temp = pred[0].next;
		pred[num].next=newNode.data[0];
		newNode.next = temp;
			
		

		newNode.min=newNode.data[0];
		for(int i = 0; i < newNode.links.length; i++){
			if(pred[i]!=null) {
				newNode.links[i] = pred[i].links[i];
				pred[i].links[i] = newNode;
			}
			
			
		}
		
		
			
	}
	
	
	
	/**
	 * This method adds element to array and sorts array
	 * @param arr Array which will element add
	 * @param item Item which will add
	 */
	private void addArray(E [] arr,E item) {
		@SuppressWarnings("unchecked")
		E [] newarr = (E[]) new Comparable[order];
		for(int i=0;i<arr.length;i++) {
			if(arr[i]==null) {
				arr[i]=item;
				break;
			}
				
			if(arr[i].compareTo(item)>0) {
				newarr[i]=item;
				i++;
				for(;i<arr.length;i++)
					newarr[i] = arr[i-1];
				System.arraycopy(newarr, 0, arr, 0, order);
				break;
			}
			newarr[i]=arr[i];
		}
	}
	
	
	
	
	/**
	 * Removes an instance of the given item
	 * @param item The item to remove
	 * @return true if the item is removed, false if the item is not in the list
	 */
	public boolean remove(E item){
		SLNode<E>[] pred = search(item);
		int i2=0;
		if(pred[0].links != null ) {
			int i1=0;
				for(i2=0;i2<5;i2++) {
					if(pred[0].links[0].data[i2].compareTo(item) != 0)
						i1=1;
				}
				if(i1!=1)
					return false; //item is not in the list		
		} 
		 
		if(pred[0].links != null && pred[0].links[0].num==1) {
			size--; //don't re-adjust maxCap and level, as we may have nodes at these levels
			SLNode<E> deleteNode = pred[0];
			for(int i = 0; i < deleteNode.links.length; i++){
				if(pred[i].links[i] != null)
					pred[i].links[i] = pred[i].links[i].links[i];
			}
		}
		else if(pred[0].links != null ){
			
			pred[0].links[0].data[i2] = null;
		}
		
		return true;
		
	}

	
	/**
	 * Method to generate a logarithmic distributed integer between 1 and maxLevel.
	 *  I.E. 1/2 of the values are 1, 1/4 are 2, etc.
	 * @return a random logarithmic distributed int between 1 and maxLevel
	 */
	private int logRandom(){
		int r = rand.nextInt(maxCap);
		int k = (int) (Math.log(r + 1) / LOG2);
		if(k > maxLevel - 1)
			k = maxLevel - 1;
		return maxLevel - k;
	}
	
	/**
	 * Recompute the max cap
	 * @param level
	 * @return
	 */
	private int computeMaxCap(int level){
		return (int) Math.pow(2, level) - 1;
	}
	
	@SuppressWarnings("rawtypes")
	public String toString(){
		if(size == 0)
			return "Empty";
		StringBuilder sc = new StringBuilder();
		SLNode itr = head;
		sc.append("Head: " + maxLevel);
		int lineMaker = 0;
		while(itr.links[0] != null){
			itr = itr.links[0];
			sc.append(" --> " + itr.toString());
			lineMaker++;
			if(lineMaker == 10){
				sc.append("\n");
				lineMaker = 0;
			}
		}
		return sc.toString();
	}
	
	/**
	 * Static class to contain data and links
	 * 
	 *
	 * @param <E> The type of data stored. Must be a Comparable
	 */
	static class SLNode<E>{
		private SLNode<E>[] links;
		private E[] data;
		private E min;
		private int num;
		private E next;
		/**
		 * Create a node of level m
		 * @param m The level of the node
		 * @param data The data to be stored
		 */
		@SuppressWarnings("unchecked")
		public SLNode(int m, E data,E next){
			links = (SLNode<E>[]) new SLNode[m];
			this.data = (E[]) new Comparable[order];
			this.data[0]=data;
			this.min = data; 
			this.next = next;
			num=1;
		
			
			
		}
		
		public String toString(){
			String st="";
			for(E iter : this.data) {
				st+=iter+" ";
			}
			return (st + " |" + links.length + "|"); 
		}
	}
}
