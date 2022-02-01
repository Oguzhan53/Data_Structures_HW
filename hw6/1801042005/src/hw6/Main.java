package hw6;


import java.util.*;
//import java.util.concurrent.TimeUnit;

public class Main {

	public static void main(String[] args) {
		SelectionSort selection = new SelectionSort();
		BubbleSort bubble = new BubbleSort();
		InsertionSort insertion = new InsertionSort();
		ShellSort shell = new ShellSort();
		MergeSort merge = new MergeSort();
		HeapSort heap = new HeapSort();
		QuickSort quick = new QuickSort();
		MyQuick myq = new MyQuick();
		List <Integer> test = new LinkedList<Integer>();
		List <Integer> testc = new LinkedList<Integer>();
		long startTime,endTime, timeElapsed;
		MyMerge mer=new MyMerge();
		
		Random rand = new Random();
		
		
		
		/*
		
		//---------------------- MYQUÝCK SORT -------------------------------------- 
				int size = 1800;
				
				for(int i=0;i<size;i++) {
					test.add(i*2);
				}
				startTime = System.currentTimeMillis();
				myq.sort(test);
				endTime = System.currentTimeMillis();
				timeElapsed = endTime - startTime;
				System.out.println("MYQUÝCK SORT TIME : "+timeElapsed+"\n" );

		
		
		
		
		
		/*
		//---------------------- MYMERGE SORT -------------------------------------- 
				int size = 180000;
				
				for(int i=0;i<size;i++) {
					test.add(i*2);
				}
				startTime = System.currentTimeMillis();
				mer.sort(test);
				endTime = System.currentTimeMillis();
				timeElapsed = endTime - startTime;
				System.out.println("MYMERGE SORT TIME : "+timeElapsed+"\n" );

	
		//---------------------- SELECTION SORT -------------------------------------- 
		
		
		for(int i=0;i<size;i++) {
			test.add(i*2);
		}
		startTime = System.currentTimeMillis();
		selection.sort(test);
		endTime = System.currentTimeMillis();
		timeElapsed = endTime - startTime;
		System.out.println("SELECTION SORT TIME : "+timeElapsed+"\n" );
		
		//---------------------- BUBBLE SORT --------------------------------------
		/*
		for(int i=0;i<size;i++)
			test.set(i, i*2);
		startTime = System.currentTimeMillis();
		bubble.sort(test);
		endTime = System.currentTimeMillis();
		timeElapsed = endTime - startTime;
		System.out.println("BUBBLE SORT TIME : "+timeElapsed+"\n" );*/
		//---------------------- INSERTION SORT --------------------------------------
		/*int size = 10000;
		for(int i=0;i<size;i++) 
			test.add(i*2);
		
		startTime = System.currentTimeMillis();
		insertion.sort(test);
		endTime = System.currentTimeMillis();
		timeElapsed = endTime - startTime;
		System.out.println("INSERTION SORT TIME : "+timeElapsed+"\n" );
		*/
		//---------------------- SHELL SORT --------------------------------------
		/*
		int size = 180000;
		for(int i=0;i<size;i++) 
			test.add(i*2);
		for(int i=0;i<size;i++)
			test.set(i, i*2);
		startTime = System.currentTimeMillis();
		shell.sort(test);
		endTime = System.currentTimeMillis();
		timeElapsed = endTime - startTime;
		System.out.println("SHELL SORT TIME : "+timeElapsed+"\n" );
		*/
		//---------------------- MERGE SORT --------------------------------------
	/*	int size = 10000;
		for(int i=0;i<size;i++) 
			test.add(i*2);
		
		for(int i=0;i<size;i++)
			test.set(i, i*2);
		startTime = System.currentTimeMillis();
		merge.sort(test);
		endTime = System.currentTimeMillis();
		timeElapsed = endTime - startTime;
		System.out.println("MURGE SORT TIME : "+timeElapsed+"\n" );	
		*/
		//---------------------- HEAP SORT --------------------------------------
		
		
		/*
		startTime = System.currentTimeMillis();
		heap.sort(test);
		endTime = System.currentTimeMillis();
		timeElapsed = endTime - startTime;
		System.out.println("HEAP SORT TIME : "+timeElapsed+"\n" );	
	*/
		//---------------------- QUÝCK SORT --------------------------------------
		
		/*
		int size = 10000;
		for(int i=0;i<size;i++)
			test.add(i*2);
		System.out.println("asda");
		startTime = System.currentTimeMillis();
		quick.sort(test);
		endTime = System.currentTimeMillis();
		timeElapsed = endTime - startTime;
		System.out.println("QUÝCK SORT TIME : "+timeElapsed+"\n" );	
		
		*/
		
		int size = 100;
		for(int i=0;i<20;i++) {
			test = new LinkedList<Integer>();
			testc = new LinkedList<Integer>();
			for(int i1=0;i1<size;i1++) {
				int x= rand.nextInt();
				test.add(x);
				testc.add(x);
			}
			
			startTime = System.currentTimeMillis();
			bubble.sort(test);
			endTime = System.currentTimeMillis();
			timeElapsed = endTime - startTime;
			System.out.println(i+" bubble SORT TIME : "+timeElapsed+"\n" );	
			for(int i1=0;i1<size;i1++){
				test.set(i1, testc.get(i1));
			}
			
			startTime = System.currentTimeMillis();
			insertion.sort(test);
			endTime = System.currentTimeMillis();
			timeElapsed = endTime - startTime;
			System.out.println(i+" insertion SORT TIME : "+timeElapsed+"\n" );	
			for(int i1=0;i1<size;i1++){
				test.set(i1, testc.get(i1));
			}
			
			startTime = System.currentTimeMillis();
			shell.sort(test);
			endTime = System.currentTimeMillis();
			timeElapsed = endTime - startTime;
			System.out.println(i+"("+size+" ) shell SORT TIME : "+timeElapsed+"\n" );	
			
			for(int i1=0;i1<size;i1++){
				test.set(i1, testc.get(i1));
			}
			startTime = System.currentTimeMillis();
			merge.sort(test);
			endTime = System.currentTimeMillis();
			timeElapsed = endTime - startTime;
			System.out.println(i+" merge SORT TIME : "+timeElapsed+"\n" );	
			for(int i1=0;i1<size;i1++){
				test.set(i1, testc.get(i1));
			}
			
			
			startTime = System.currentTimeMillis();
			quick.sort(test);
			endTime = System.currentTimeMillis();
			timeElapsed = endTime - startTime;
			System.out.println("QUÝCK SORT TIME : "+timeElapsed+"\n" );	
			for(int i1=0;i1<size;i1++){
				test.set(i1, testc.get(i1));
			}
		
			startTime = System.currentTimeMillis();
			selection.sort(test);
			endTime = System.currentTimeMillis();
			timeElapsed = endTime - startTime;
			System.out.println("SELECTION SORT TIME : "+timeElapsed+"\n" );
			
			for(int i1=0;i1<size;i1++){
				test.set(i1, testc.get(i1));
			}
			
			startTime = System.currentTimeMillis();
			myq.sort(test);
			endTime = System.currentTimeMillis();
			timeElapsed = endTime - startTime;
			System.out.println("MYQUÝCK SORT TIME : "+timeElapsed+"\n" );
			for(int i1=0;i1<size;i1++){
				test.set(i1, testc.get(i1));
			}
			
			
			startTime = System.currentTimeMillis();
			heap.sort(test);
			endTime = System.currentTimeMillis();
			timeElapsed = endTime - startTime;
			System.out.println(i+" heap SORT TIME : "+timeElapsed+"\n" );	
			for(int i1=0;i1<size;i1++){
				test.set(i1, testc.get(i1));
			}
			startTime = System.currentTimeMillis();
			mer.sort(test);
			endTime = System.currentTimeMillis();
			timeElapsed = endTime - startTime;
			System.out.println(i+" mymerge SORT TIME : "+timeElapsed+"\n" );	
			for(int i1=0;i1<size;i1++){
				test.set(i1, testc.get(i1));
			}
			
			
			
			
		}
	
	
	
	
	}
	
	
	

}
