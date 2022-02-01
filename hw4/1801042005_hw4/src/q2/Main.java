package q2;

import java.util.NoSuchElementException;

public class Main {
	
	
	
	
	

	
	
	
	public static void main(String[] args) {
		Methods<String> method=new Methods<String>();
	
		MyDeque<String> deque= new MyDeque<String>();
		MyDeque<String> garbage= new MyDeque<String>();
		
		//----------------- SYSTEM TEST --------------------- 
		try {
			method.addFirst(deque, garbage, "1");
			method.addFirst(deque, garbage, "2");
			method.addFirst(deque, garbage, "3");
			method.addLast(deque, garbage, "4");
			method.addLast(deque, garbage, "5");
			method.addLast(deque, garbage, "6");
			method.pollLast(deque, garbage);
			method.pollLast(deque, garbage);
			deque.print_deque();
			System.out.println("garbage size : " +garbage.size());

		}
		catch(NoSuchElementException e) {
			e.printStackTrace();
		}catch(NullPointerException e) {
			e.printStackTrace();
		}
		
		
		//---------------- UNIT TEST -------------------------
	/*	
		method.addNodeFirst(deque);
        deque.addFirst("1");
        method.addNodeFirst(deque);
        deque.addFirst("2");
        method.addNodeLast(deque);
		deque.addLast("3");
		method.addNodeFirst(deque);
		deque.offerFirst("4");
		method.addNodeLast(deque);
		deque.offerLast("5");
		method.addNodeFirst(deque);
		deque.push("6");
		deque.print_deque();
		
		
		*/
		
		
		
		/*
		System.out.println("peekFirst :"+deque.peekFirst());
		System.out.println("peekLast :"+deque.peekLast());
		System.out.println("getFirst :"+deque.getFirst());
		System.out.println("peekLast :"+deque.getLast());
		System.out.println("is empty :"+deque.is_empty());
		System.out.println("size : "+deque.size());
		
		*/
		
		/*
		deque.pollFirst();
		deque.removeNode();
		deque.pollLast();
		deque.removeNode();
		deque.removeFirst();
		deque.removeNode();
		deque.removeLast();
		deque.removeNode();
		deque.print_deque();
		*/
	}

}
