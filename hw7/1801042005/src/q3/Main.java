package q3;


import java.util.ArrayList;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ConcurrentSkipListSet;

import q2.MySkipList;

public class Main {

	public static void main(String[] args) {
		
		calculateAvarageTime(80000);
		
		
		
		//------------------------------TREE TRAVERSE -----------------------------------------
		
		/*
		BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
		// ------------------------------ REGULAR BST ----------------------------------
		bst.add(10);
		bst.add(7);
		bst.add(30);
		bst.add(4);
		bst.add(9);
		bst.add(5);
		bst.add(8);
		bst.add(15);
		bst.add(14);
		bst.add(17);
		bst.printInorder();
		
		//-------------------------- RED-BLACK TREE IN BOOK ---------------------
		
		RedBlackTree<String> testOne = new RedBlackTree<String>();
		testOne.add("The");
		testOne.add("quick");
		testOne.add("brown");
		testOne.add("fox");
		testOne.add("apple");
		testOne.add("cat");
		testOne.add("hat");
		System.out.println(testOne.toString());  

		// --------------------------- SKIP LIST IN BOOK -----------------------------
		SkipList<Integer> test = new SkipList<Integer>();
		for(int i = 0; i < 100; i++){
			test.add(i);
		}
		for(int i = 0; i <95; i++){
			test.remove(i);
		}
		test.add(10);
		test.add(5);
		test.add(6);
		test.add(11);
		test.add(1);
		test.add(-1);
		test.add(-1);
		//System.out.println(test.find(15));
		
		System.out.println(test.toString());
		
		//----------------------------- SKIP LIST IN JAVA -------------------------------
		 ConcurrentSkipListSet<Integer> set = new ConcurrentSkipListSet<Integer>(); 
	     // Adding elements to this set 
	     set.add(78); 
	     set.add(64); 
	     set.add(12); 
	     set.add(45); 
	     set.add(8); 
	
	     // Printing the ConcurrentSkipListSet 
	     System.out.println("ConcurrentSkipListSet: " + set); 
	     */
		//--------------------------- MYSKIP LIST --------------------------------
		/*
		MySkipList<Integer> st = new MySkipList<Integer>();
				
		st.add(5);	
		st.add(2);
		st.add(10);
		st.add(-4);
		st.add(6);
		st.add(-5);
		st.add(11);
		st.add(12);
		st.add(3);
		st.add(8);
		System.out.println(st.toString());

	    */
		/*
		 //----------------------------BTree ---------------------------------
		BTree<Integer> btr = new BTree<Integer>(5);	
		
		btr.add(5);	
		btr.add(2);
		btr.add(10);
		btr.add(-4);
		btr.add(6);
		btr.add(-5);
		btr.add(11);
		btr.add(12);
		btr.add(3);
		
		System.out.println(btr.toString());
	    
	    
	    */
	    
	    
	

	    
		
		
	
	}
	
	
	
	/**
	 * This method calculate average add and remove time for all tree
	 * @param size Tree size
	 */
	public static void calculateAvarageTime(int size) {
		List<BinarySearchTree<Integer>> binary10 = new ArrayList<BinarySearchTree<Integer>>();
	    List<RedBlackTree<Integer>> redBlack10 = new ArrayList<RedBlackTree<Integer>>();
	    List<SkipList<Integer>> skipBook10 = new ArrayList<SkipList<Integer>>();
	    List<ConcurrentSkipListSet<Integer>> skipJava10 = new ArrayList<ConcurrentSkipListSet<Integer>>();
	    List<BTree<Integer>> bTrees10 = new ArrayList<BTree<Integer>>();
	    List<MySkipList<Integer>> mySkip10 = new ArrayList<MySkipList<Integer>>();
	    Random rand = new Random();
	    long startTime,endTime, timeElapsed,av1=0,av2=0,av3=0,av4=0,av5=0,av6=0,av1r=0,av2r=0,av3r=0,av4r=0;
	    

	    // ---------------------10.000 element -----------------------
	    for(int i=0;i<10;i++) {
	    	BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
	    	RedBlackTree<Integer> rb = new RedBlackTree<Integer>();
			SkipList<Integer> skpb = new SkipList<Integer>();
			ConcurrentSkipListSet<Integer> skpj = new ConcurrentSkipListSet<Integer>(); 
		    BTree<Integer> btr = new BTree<Integer>(5);	
		    MySkipList<Integer> myskp = new MySkipList<Integer>();
	    	for(int i1=0;i1<size;i1++) {
	    		int c = rand.nextInt();
	    		bst.add(c);
	    		rb.add(c);
	    		skpb.add(c);
	    		skpj.add(c);
	    		btr.add(c);
	    		myskp.add(c);
	    	}
	    	
	    	binary10.add(bst);
	 	    redBlack10.add(rb);
	 	    skipBook10.add(skpb);
	 	    skipJava10.add(skpj);
	 	    bTrees10.add(btr);
	 	    mySkip10.add(myskp);

	    }
	    
	    for(int i=0;i<10;i++) {
	    	int c [] = new int [10];
	    	for(int i1=0;i1<10;i1++) {
	    		c[i1]=rand.nextInt();
	    	}
	    	BinarySearchTree<Integer> bst  = binary10.get(i);
	    	RedBlackTree<Integer> rb = redBlack10.get(i);
	    	SkipList<Integer> skpb = skipBook10.get(i);
	    	ConcurrentSkipListSet<Integer> skpj = skipJava10.get(i);
	    	BTree<Integer> btr = bTrees10.get(i);
	    	MySkipList<Integer> myskp =  mySkip10.get(i);
	    	
	    	startTime = System.nanoTime();
	    	for(int i1=0;i1<10;i1++) {
	    		bst.add(c[i1]);
	    	}
	    	endTime = System.nanoTime();
			timeElapsed = endTime - startTime;
			System.out.println(i+" Binary search tree add (10.000) : "+timeElapsed+"\n" );
			av1+=timeElapsed;
			
			startTime = System.nanoTime();
	    	for(int i1=0;i1<10;i1++) {
	    		bst.delete(c[i1]);
	    	}
	    	endTime = System.nanoTime();
			timeElapsed = endTime - startTime;
			System.out.println(i+" Binary search tree remove (10.000) : "+timeElapsed+"\n" );
			av1r+=timeElapsed;
			
			startTime = System.nanoTime();
	    	for(int i1=0;i1<10;i1++) {
	    		
	    		rb.add(c[i1]);
	    	}
	    	endTime = System.nanoTime();
			timeElapsed = endTime - startTime;
			System.out.println(i+" Red Black Tree add (10.000) : "+timeElapsed+"\n" );
			av2+=timeElapsed;
			
			startTime = System.nanoTime();
	    	for(int i1=0;i1<10;i1++) {
	    		
	    		rb.delete(c[i1]);
	    	}
	    	endTime = System.nanoTime();
			timeElapsed = endTime - startTime;
			System.out.println(i+" Red Black Tree remove ("+size+") : "+timeElapsed+"\n" );
			av2r+=timeElapsed;
			
			
			startTime = System.nanoTime();
	    	for(int i1=0;i1<10;i1++) {
	    		
	    		skpb.add(c[i1]);
	    	}
	    	endTime = System.nanoTime();
			timeElapsed = endTime - startTime;
			System.out.println(i+" Skiplist(book) add ("+size+") : "+timeElapsed+"\n" );
			av3+=timeElapsed;
			
			startTime = System.nanoTime();
	    	for(int i1=0;i1<10;i1++) {
	    		
	    		skpb.remove(c[i1]);
	    	}
	    	endTime = System.nanoTime();
			timeElapsed = endTime - startTime;
			System.out.println(i+" Skiplist(book) remove ("+size+") : "+timeElapsed+"\n" );
			av3r+=timeElapsed;
			
			startTime = System.nanoTime();
	    	for(int i1=0;i1<10;i1++) {
	    	
	    		skpj.add(c[i1]);
	    	}
	    	endTime = System.nanoTime();
			timeElapsed = endTime - startTime;
			System.out.println(i+" Skiplist(java) add ("+size+") : "+timeElapsed+"\n" );
			av4+=timeElapsed;
			
			startTime = System.nanoTime();
	    	for(int i1=0;i1<10;i1++) {
	    	
	    		skpj.remove(c[i1]);
	    	}
	    	endTime = System.nanoTime();
			timeElapsed = endTime - startTime;
			System.out.println(i+" Skiplist(java) remove ("+size+") : "+timeElapsed+"\n" );
			av4r+=timeElapsed;
			
			startTime = System.nanoTime();
	    	for(int i1=0;i1<10;i1++) {
	    		
	    		btr.add(c[i1]);
	    	}
	    	endTime = System.nanoTime();
			timeElapsed = endTime - startTime;
			System.out.println(i+" BTree add ("+size+") : "+timeElapsed+"\n" );
			av5+=timeElapsed;
			
			startTime = System.nanoTime();
	    	for(int i1=0;i1<10;i1++) {
	    		
	    		myskp.add(c[i1]);
	    	}
	    	endTime = System.nanoTime();
			timeElapsed = endTime - startTime;
			System.out.println(i+" Skiplist(mine) add ("+size+") : "+timeElapsed+"\n" );
			av6+=timeElapsed;
			
	    	
	    }
	    
	    av1=av1/10;
	    av2=av2/10;
	    av3=av3/10;
	    av4=av4/10;
	    av5=av5/10;
	    av6=av6/10;
	    
	    av1r=av1r/10;
	    av2r=av2r/10;
	    av3r=av3r/10;
	    av4r=av4r/10;
	    
	    System.out.println("Binary search tree add average("+size+") time : "+av1+" ns");
	    System.out.println("Red Black Tree add average("+size+") time : "+av2+" ns");
	    System.out.println("Skiplist(book) add average("+size+") time : "+av3+" ns");
	    System.out.println("Skiplist(java) add average("+size+") time : "+av4+" ns");
	    System.out.println("BTree  add average("+size+") time : "+av5+" ns");
	    System.out.println("Skiplist(mine) add average("+size+") time : "+av6+" ns");
	    
	    System.out.println("-------------------------------------");
	    System.out.println("Binary search tree remove average("+size+") time : "+av1r+" ns");
	    System.out.println("Red Black Tree remove average("+size+") time : "+av2r+" ns");
	    System.out.println("Skiplist(book) remove average("+size+") time : "+av3r+" ns");
	    System.out.println("Skiplist(java) remove average("+size+") time : "+av4r+" ns");
	    
	}
	

}
