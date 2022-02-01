package q1;
import java.util.*;


/**
 * This is Linked Array List Class.It has own iterator and add,remove class.
 * @author Oguzhan SEGIN - 1801042005
 *
 * @param <E> This is the type off Linked list.
 */
public class LinkedArrayList<E>  extends AbstractList<E> implements List<E> {
	
	/**
	 * This is inner Node class which creates linked list.
	 *
	 */
	/**
	 * @author mance
	 *
	 */
	class Node{
		/**
		 * @param id_num This is node's id number.
		 * @param next This is hold next node address.
		 * @param prev This is hold previous node address.
		 * @param arr This is array which is holds element in nodes.
		 * @param arr_size This is array size number.
		 */
		public E  data;
		private int id_num;
		private Node next;
		private Node prev;
		private E array[];
		public static final int arr_size= 10;
		
		public int getid_Num() {
			return id_num;
		}

		public void setid_Num(int id_num) {
			this.id_num = id_num;
		}

		public Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}

		public Node getPrev() {
			return prev;
		}

		public void setPrev(Node prev) {
			this.prev = prev;
		}

		public E[] getInt_array() {
			return array;
		}

		public void setInt_array(E[] array) {
			this.array = array;
		}

	
		/**
		 * This is Node constructor
		 * @param arr This is array which is holds element in nodes.
		 */
		public Node (E [] arr) { 

			this.array = arr;
			this.id_num=0;
			this.next=null;
			this.prev=null;
		}
		
		/**
		 * This method removes element in the array.
		 * @param elmnt This is element which user want to remove.
		 * @return It returns 1 if remove correctly , if it can not remove correctly it return -1.
		 */
		public int remove_node_element(E elmnt ) {
			if(!(is_empty())) {
				int index=find_element(elmnt);
				if(index!=-1) {
					array[index]=null;
					int i;
					for(i=index;i<arr_size-1;i++) {
						if(array[i+1]==null) {
							break;
						}
						array[i]=array[i+1];
					}
					array[i]=null;
					return 1;
				}
					
				else 
					System.out.println("There is no  "+ elmnt+" in array !!" );
			}
			else
				System.out.println("Array is empty !! ");
			return -1;
		}
		
		
		/**
		 * This method add element on array.
		 * @param elmnt This is element which user want to add.
		 * @return It returns 1 if add correctly , if it can not add correctly it return -1.
		 */
		public int add_element(E elmnt) {
			if(!(is_full())) {
				for(int i=0;i<arr_size;i++) {
					if(array[i]==null) {
						array[i]=elmnt;
					
						return 0;
					}
				}
			}
			
			return -1;
		}
		
		/**
		 * This method finds element in array.
		 * @param elmnt This is element which user want to find.
		 * @return It returns index if finds element , if it can not find it returns -1. 
		 */
		public int find_element( E elmnt) {
			
			for(int i=0;i<arr_size;i++) {
				if(array[i]==null)
					break;
				else if(array[i].equals(elmnt))
					return i;
			}
			return -1;
		}
		
		/**
		 * This method check if array is empty or not.
		 * @return It returns true if array is empty,if it is not empty it returns false.
		 */
		public boolean is_empty(){
			int i;
			for(i=0;i<arr_size;i++) {
				if(array[i]!=null)
					break;
			}
			if(i==arr_size)
				return true;
			
			return false;
				
			
		}
		/**
		 * This method check if array is full or not.
		 * @return It returns true if array is full,if it is not full it returns false.
		 */
		public boolean is_full() {
			int i;
			for(i=0;i<arr_size;i++) {
				if(array[i]==null)
					break;
			}
			if(i==arr_size)
				return true;
			
			return false;
				
		}
		/**
		 * This method print array elements.
		 */
		public void print_arr() {
			for(int i=0;i<arr_size;i++) {
				
				
				System.out.print(" "+(i+1)+" :  \""+array[i]+"\" --");
			}
		}
		
		
		
	}
	
	
	/**
	 * This is Linked Array List constructor.
	 * 
	 */
	public LinkedArrayList (E[] ar ){ 
		this.head=new Node(ar);
		this.l_size=1;
	
	}
	
	
	/**
	 * @param head This is linked list head node.
	 * @param l_size This is linked list node number.
	 */
	private Node head;
	private int l_size;
	
	
	public Node getHead() {
		return head;
	}
	public void setHead(Node head) {
		this.head = head;
	}
	
	
	/**
	 * This is Linked Array List  iterator class.
	 *
	 */
	class ListIterator implements Iterator<E>{

		Node current = head;
		
		public Iterator<E> iterator() {
	        return new ListIterator();
	    }
		
		
		/**
		 *This is methods returns true node has next node.
		 */
		@Override
		public boolean hasNext() {
		
		//	System.out.println("ada");
			if( current.getNext()!=null) {
				current=current.next;
				return true;
			}
			
			return false;
				
				
		}

		/**
		 * This methods returns next node data. 
		 */
		@Override
		public E next() {
			if (hasNext()) {
                E data = current.data;
                current = current.next;
                return data;
            }
			return null;
		}
		
		/**
		 * This method adds new node to linked array list.
		 * @param r This node array.
		 */
		public void add(E[] r) { 
			
			Node n1=new Node(r);
			n1.setid_Num(l_size);
			if(head==null){
				head=n1;
				head.setNext(null);
				head.setPrev(null);
				
			}
			else {
				
				 Node  iter=head;
				 
				 while(iter.getNext()!=null) {
					iter=iter.getNext();

				}
					
				iter.setNext(n1);
				iter.getNext().setNext(null);
				iter.getNext().setPrev(iter);
				iter=iter.next;
				
			
			}

			l_size++;
			
					 
		}
		
		/**
		 * This method returns the node in the given index.
		 * @param index This is index which user want to get node's.
		 * @return It return node
		 */
		public Node get(int index){
			Node iter = head;
			if(index>=l_size)
				throw new IndexOutOfBoundsException("Out of linked list bound");
			
			for(int i=0;i<index && iter!=null ;i++) {
				iter=iter.getNext();
			}
			
			return iter;
		}
		public boolean remove(int id) {
			
			Node iter = head;
			if(iter.getid_Num()==id) {
				head=head.getNext();
				head.setPrev(null);
				l_size--;
				return true;
			}
			
			for(int i=0;i<l_size && iter!=null ;i++) {
				if(iter.getid_Num()==id)
					break;
				iter=iter.getNext();
			}
			if(iter==null)
				throw new IndexOutOfBoundsException("Out of linked list bound");
			
			
			else if(iter.getNext()!=null) {
				iter.getPrev().setNext(iter.getNext());
				iter.getNext().setPrev(iter.getPrev());
				iter=null;
			}
			else {
				iter.getPrev().setNext(null);
				iter=null;
				
			}
			l_size--;

			return true;
		}
		
		
		
		
		
	}
	 
	
	/**
	 * This method prints all elements.
	 */
	public void print_node() {
		
		
		Node temp=head;
		if(temp==null)
				System.out.println("There is no node and array !!!");
		else {
			System.out.println("Number of node : "+size());
			int i=0;
			if(temp.getNext()==null) {
				System.out.println("\n------ "+1+". node elements  ------");
				temp.print_arr();
			}
			else {
				while(temp.getNext()!=null) {
					
					System.out.println("\n------ "+(i+1)+". node elements  ------");
					temp.print_arr();
					temp=temp.getNext();
					i++;
				}
				System.out.println("\n------ "+(i+1)+". node elements  ------");
				temp.print_arr();
			}
			
			
			
			
		}
		
		
	}
	

	@Override
	public E get(int index) {
		
	return  null;
	}

	
	
	/**
	 * This method returns Linked array list size.
	 */
	@Override
	public int size() {
		 Node iter=head;
		
		if(iter==null)
			return 0;
		else {
			int i=0;
			while(iter.getNext()!=null) {
				iter=iter.getNext();
				i++;
				
			}
			
			return i+1;
			
		}
		
		
		
	}
	
	/**
	 * This method adds element on linked array list.
	 * @param elmnt This is element which user want to add.
	 * @return It returns 1 if add correctly , if it can not add correctly it return -1.
	 * 
	 */
	@SuppressWarnings("unchecked")
	public boolean add_new_element(E elmnt) {
		
		ListIterator iterator= new ListIterator();
		
		int i;
		for( i=0;i<size();i++) {
			if(!(iterator.get(i).is_full())) {
				iterator.get(i).add_element(elmnt);
				return true;
			}
		}
		
		iterator.add( ((E[])new Object [10]));
		iterator.get(i).add_element(elmnt);
		return true;
	}

	
	
	/**
	 * This method removes element on linked array list.
	 * @param elmnt This is element which user want to remove.
	 * @return It returns 1 if remove correctly , if it can not removes correctly it return -1.
	 * 
	 */
	public boolean remove_element(E elmnt) {
		ListIterator iterator= new ListIterator();
		for(int i=0;i<size();i++) {
			if(iterator.get(i).find_element(elmnt)!=-1) {
				iterator.get(i).remove_node_element(elmnt);
				if(iterator.get(i).is_empty()) {
					iterator.remove(iterator.get(i).getid_Num());
				}
				return true;
			}
				
		}
		System.out.println("There is no element");
		return false;
	}
	


}
	



