package q2;

import java.util.Iterator;

/**
 * This is deque iterator class.
 * @author Oguzhan SEZGÝN
 *
 * @param <E> This is type of iterator
 */
public class DequeIterator<E> implements Iterator<E> { 
	private Node<E> current; 
	
	
	/**
	 * This is initialize iterator .
	 * @param deque This is deque which iterator search. 
	 */
	public DequeIterator(MyDeque<E> deque) { 
		current = deque.getHead(); 
	} 
	
	
	/**
	 *This method returns false if next element does not exist 
	 */
	public boolean hasNext() { 
		return current != null; 
	} 
	
	
	/**
	 * This method return current data and update current node
	 */
	public E next() { 
		E data = current.getData(); 
		current = current.getNext(); 
		return data; 
	} 
	
	
	
	/**
	 *This method remove current node data.
	 */
	public void remove() {
		if(current!=null) {
			current=current.getPrev();
			current.setData(null);
		}
		
		
	} 
} 