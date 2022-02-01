package q2;

import java.util.AbstractCollection;
import java.util.Deque;
import java.util.Iterator; 
import java.lang.NullPointerException;
import java.util.NoSuchElementException;

/**
 * This MyDeque class.Its implements Deque interface and extends AbstractCollection class.
 * @author Oguzhan SEZGIN
 *
 * @param <E> This is deque type.
 */
public class MyDeque<E>  extends AbstractCollection<E> implements Deque<E>  { 
	private Node<E> head, tail; 

	
	public Node<E> getHead() {
		return head;
	}

	public void setHead(Node<E> head) {
		this.head = head;
	}

	public Node<E> getTail() {
		return tail;
	}

	public void setTail(Node<E> tail) {
		this.tail = tail;
	}

	/**
	 * This is default constructor.
	 */
	public MyDeque() {
		this.head = this.tail = null;
	}

	/**
	 * This is parameterized constructor.
	 * @param head This is head node of deque
	 */
	public MyDeque(Node<E> head) {
		this.head = head;
		this.tail = head;
	}

	
	/**
	 * This method adds node to the tail.
	 * @param node This is node which will add.
	 */
	public void addLastNode(Node<E> node) { 
	
		if (head == null) 
			tail = head = node; 
		else { 
			tail.setNext(node);
			node.setPrev(tail);
			tail = node; 
		}
		
	}
	/**
	 * This method adds node to the tail.
	 * @param node This is node which will add.
	 */
	public void addFirstNode(Node<E> node) {
		 
		if(head == null)
			tail = head = node;
		else {
			node.setNext(head);
			head.setPrev(node);
			head=node;
		}
		
	}
	/**
	 * This method adds element to head.If element is null , method throws NullPointerException.
	 * @param e This is element which will add.
	 */
	@Override
	public void addFirst(E e) {
		if(e == null)
			throw new NullPointerException("The argument cannot be null");
		head.setData(e);
		
	}

	/**
	 * This method adds element to tail.If element is null , method throws NullPointerException.
	 *  @param e This is element which will add.
	 */
	@Override
	public void addLast(E e) {
		if(e == null)
			throw new NullPointerException("The argument cannot be null");
		tail.setData(e);
		
	}
	/**
	 * This method adds element to head.
	 *  @param e This is element which will add.
	 */
	@Override
	public boolean offerFirst(E e) {
		
		//You have to call addFirstNode method before call this method.
		if(e == null)
			return false;
		head.setData(e);
		return true;
	}
	
	/**
	 * This method adds element to tail.
	 *  @param e This is element which will add.
	 */
	@Override
	public boolean offerLast(E e) {
		//You have to call addLastNode method before call this method.
		if(e == null)
			return false;
		tail.setData(e);
		return true;
	}

	
	
	
	
	/**
	 * This method discard empty node(contain null data) from deque and returns it.
	 * @return  Discarded node.
	 */
	public Node<E> removeNode(){
		if(this.is_empty())
			return null;
		if(head.getData()==null) {
			Node<E> temp = head;
			head=head.getNext();
			if(head!=null)
				head.setPrev(null);
			temp.setNext(null);
			return temp;
		}
		else if(tail.getData()==null) {
			Node<E> temp = tail;   
			if(tail==head)
				tail=head=null;
			else {
				tail=tail.getPrev();
				tail.setNext(null);
				temp.setPrev(null);
			}
			return temp;
		}
		else {
			Node<E> temp=head.getNext();
			while(temp.getNext()!=null) {
				if(temp.getData()==null) {
					temp.getPrev().setNext(temp.getNext());
					temp.getNext().setPrev(temp.getPrev());
					return temp;
				}
			}
			return null;
		}
		
			
		
	}

	
	/**
	 * This method return first element of deque.
	 * @return First element of deque
	 */
	public E getFirst() {
		if(this.is_empty())
			throw new NoSuchElementException();
		return head.getData(); 
	} 
	

	/**
	 * This method return last element of deque
	 * @return Last element of deque
	 */
	public E getLast() { 
		if(this.is_empty())
			throw new NoSuchElementException();
		return tail.getData(); 
	} 
	


	/**
	 * This method create iterator.
	 * @return Iterator.
	 */
	public Iterator<E> iterator() { 
		return new DequeIterator<E>(this); 
	}
	
	/**
	 * This method print all element of deque.
	 */
	public void print_deque() {
		DequeIterator<E> iter = (DequeIterator<E>) iterator() ;
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}

	}
	/**
	 * This method check if deque is empty or not.
	 * @return True if empty , False not empty.
	 */
	public boolean is_empty() {
		if(this.head==null)
			return true;
		return false;
	}



	@Override
	public Iterator<E> descendingIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * This method return first element of deque.
	 * @return First element of deque
	 */
	@Override
	public E element() {
		return head.getData();
	}

	/**
	 * This method adds element head of deque.
	 * @return True if it is successful
	 */
	@Override
	public boolean offer(E e) {
		//You have to call addFirstNode method before call this method.
		if(e == null)
			return false;
		head.setData(e);
		return true;
	}

	/**
	 * This method return first element of deque.
	 * @return First element of deque
	 */
	@Override
	public E peek() {
		if(is_empty())
			return null;	
		return head.getData();
	}

	/**
	 * This is method remove last element of deque and return it.
	 * @return Last element.
	 */
	@Override
	public E poll() {
		//You have to call pollLastNode method before call this method.
		if(is_empty())
			return null;
		E temp=tail.getData();
		tail.setData(null);
		return temp;
	}
	/**
	 * This is method remove first element of deque and return it.
	 * @return First element.
	 */
	@Override
	public E pop() {
		//You have to call pollFisrtNode after call this method.
		if(is_empty())
			return null;
		E temp=head.getData();
		head.setData(null);
		return temp;
		
	}

	/**
	 * This method add element to head.
	 */
	@Override
	public void push(E e) {
		//You have to call addFirstNode before call this method.
		head.setData(e);
		
	}

	/**
	 * This method remove last element of deque and return it.If deque is empty , it returns NoSuchElementException.
	 * @return Last element of deque
	 */
	@Override
	public E remove() {
		//You have to call pollLastNode method before call this method.
		if(is_empty())
			throw new NoSuchElementException();
		E temp = tail.getData();
		tail.setData(null);
		return temp;
	}

	/**
	 * This method find first occurence of element and remove it.
	 * @return True if successful
	 */
	@SuppressWarnings({ "unchecked" })
	@Override
	public boolean removeFirstOccurrence(Object o) { //you have to call removeNode method before call this method.
		
		if(peekFirst()==(E) o) {
			pollFirst();
			return true;
		}
		
		DequeIterator<E> iter = (DequeIterator<E>) iterator() ;
		while(iter.hasNext()) {	
			if(iter.next()==(E) o) {
				iter.remove();	
				return true;
			}
				
		}
		if(peekLast()==(E) o) {
			pollLast();
			return true;
		}
		
		return false;
	}

	@Override
	public boolean removeLastOccurrence(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * This method find number of element.
	 * @return size
	 */
	@Override
	public int size() {
		DequeIterator<E> iter = (DequeIterator<E>) iterator() ;
		int i=0;
		while(iter.hasNext()) {
			iter.next();
			i++;
		}
		return i;
	}

	/**
	 * This method return first element of deque.
	 * @return First element of deque
	 */
	@Override
	public E peekFirst() {
		if(is_empty())
			return null;	
		return head.getData();
	}

	/**
	 * This method return last element of deque.
	 * @return last element of deque
	 */
	@Override
	public E peekLast() {
		if(is_empty())
			return null;	
		return tail.getData();
	}

	/**
	 * This is method remove first element of deque and return it.
	 * @return First element.
	 */
	@Override
	public E pollFirst() {
		//You have to call pollFirstNode method before call this method.
		if(is_empty())
			return null;
		E temp=head.getData();
		head.setData(null);
		return temp;
	}

	/**
	 * This is method remove last element of deque and return it.
	 * @return Last element.
	 */
	@Override
	public E pollLast() {
		//You have to call pollLastNode method before call this method.
		if(is_empty())
			return null;
		E temp=tail.getData();
		tail.setData(null);
		return temp;
	}
	/**
	 * This method remove first element of deque and return it.If deque is empty , it returns NoSuchElementException.
	 * @return First element of deque
	 */
	@Override
	public E removeFirst() {
		//You have to call pollFirstNode method before call this method.
		if(is_empty())
			throw new NoSuchElementException();
		E temp=head.getData();
		head.setData(null);
		return temp;
	}
	/**
	 * This method remove last element of deque and return it.If deque is empty , it returns NoSuchElementException.
	 * @return Last element of deque
	 */
	@Override
	public E removeLast() {
		//You have to call pollLastNode method before call this method.
		if(is_empty())
			throw new NoSuchElementException();
		E temp=tail.getData();
		tail.setData(null);
		return temp;
	}
	
} 






