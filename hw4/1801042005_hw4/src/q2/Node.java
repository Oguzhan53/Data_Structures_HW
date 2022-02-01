package q2;


/**
 * This is node class which form deque.
 * @author Oguzhan SEZGÝN
 * 
 * @param <E> Type of node
 */
public class Node<E>{ 
	private E data; 
	private Node<E> next;
	private Node<E> prev; 
	
	public Node() { 
		this.data = null; 
		this.next = this.prev = null; 
	} 
	
	public Node(E data) { 
		this.data = data; 
		this.next = this.prev = null; 
	} 

	public Node<E> getPrev() {
		return prev;
	}

	public void setPrev(Node<E> prev) {
		this.prev = prev;
	}

	public void setData(E data) { 
		this.data = data; 
	}
	
	public E getData() { 
		return data; 
	} 
	
	public void setNext(Node<E> next) { 
		this.next = next; 
	} 
		
	public Node<E> getNext() { 
		return next; 
	} 
} 