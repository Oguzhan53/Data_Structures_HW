/**
 * 
 */
package q2;

/**
 * This is methods class.
 * @author Oguzhan SEZGÝN
 *
 */
public class Methods<E>  {

	/**
	 * This method take one garbage and set its data then add tail of deque.
 	 * @param deque Deque which user want to add.
	 * @param garbage Dequr which holds garbage nodes.
	 * @param element Element which user want to add deque.
	 */
	public void addLast(MyDeque<E> deque,MyDeque<E> garbage,E element) {
		Node<E> temp;
		if(garbage.is_empty()) {
			temp = new Node<E>();
			deque.addLastNode(temp);
			deque.addLast(element);
		}
		else {
			temp = garbage.removeNode();
			deque.addLastNode(temp);
			deque.addLast(element);
		}
	}
	
	public void addNodeFirst(MyDeque<E> deque) {
		Node<E> temp =new Node<E>();
		deque.addFirstNode(temp);
	}
	public void addNodeLast(MyDeque<E> deque) {
		Node<E> temp =new Node<E>();
		deque.addLastNode(temp);
	}
	
	
	/**
	 * This method take one garbage and set its data then add head of deque.
 	 * @param deque Deque which user want to add.
	 * @param garbage Dequr which holds garbage nodes.
	 * @param element Element which user want to add deque.
	 */
	public void addFirst(MyDeque<E> deque,MyDeque<E> garbage,E element) {
		Node<E> temp;
		if(garbage.is_empty()) {
			temp = new Node<E>();
			deque.addFirstNode(temp);
			deque.addFirst(element);
		}
		else {
			temp = garbage.removeNode();
			deque.addFirstNode(temp);
			deque.addFirst(element);
			
		}
	}
	/**
	 * This method discard first element of deque and add it to garbage deque. 
 	 * @param deque Deque which user want to remove element.
	 * @param garbage Dequr which holds garbage nodes.
	 * 
	 */
	
	public void pollFirst(MyDeque<E> deque,MyDeque<E> garbage){
		if(!(deque.is_empty())) {
			deque.pollFirst();
			garbage.addLastNode(deque.removeNode());
		}
			
		else 
			System.out.println("MyDeque is empty !!!");
	}
	
	
	/**
	 * This method discard last element of deque and add it to garbage deque. 
 	 * @param deque Deque which user want to remove element.
	 * @param garbage Dequr which holds garbage nodes.
	 * 
	 */
	public void pollLast(MyDeque<E> deque,MyDeque<E> garbage){
		if(!(deque.is_empty())) {
			deque.pollLast();
			garbage.addLastNode(deque.removeNode());
		}
			
		else 
			System.out.println("MyDeque is empty !!!");
	}


}
