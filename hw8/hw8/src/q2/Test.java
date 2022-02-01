package q2;

import java.util.*;

/**This is test class
 * @author Oguzhan SEZGIN
 *
 */
public class Test {
	/**
	 * This method create graph randomly and print matrix representation , BFS and DFS traversal .
	 */
	public static void createGraph() {
		System.out.println("\n---------------------- CREATE RANDOM GARPH ----------------------\n ");
		Random rand = new Random();
		Scanner scan = new Scanner(System.in);
		int size = 3+rand.nextInt(10);
		Integer data[]=new Integer[size];
		for(int i=0;i<size;i++) {
			data[i]=rand.nextInt(100);
		}
		int i1=rand.nextInt(2);
		boolean isdirected;
		if(i1==0)
			isdirected=true;
		else
			isdirected=false;
		
		int [][] edges=new int [size][2];
		
		LinkedGraph<Integer> test= (LinkedGraph<Integer>) AbstractGraph.createGraph(scan, isdirected, "list", data,size);
		int i2,i3;
		boolean flag = false;
		for(int i=0;i<size;i++) {
			
			i2=rand.nextInt(size);
			i3=rand.nextInt(size);
			for(int i5=0;i5<i;i5++) {
				if(edges[i5][0]==data[i2] && edges[i5][1]==data[i3] )
					flag=true;
			}
			if(flag) {
				i--;
				flag=false;
			}
				
			
			else {
				edges[i][0]=data[i2];
				edges[i][1]=data[i3];
				test.addEdge(data[i2], data[i3]);
			}
			
		}
		
		System.out.println("MATRIX TYPE : "+ isdirected+ "\nVERTICES :  ");

		for(int i:data)
			System.out.print(i+" - ");
		
		System.out.println("\nEDGES : ");
		for(int i=0;i<size;i++) {
			System.out.print(edges[i][0]+","+edges[i][1]+" - ");
		}
		System.out.println("\n---------------- MATRIX  REPRESENTATION ----------------");
		test.print();
		
		i2=rand.nextInt(size);
		System.out.println("Initial vertex : "+data[i2]);
		System.out.println("\n---------------- BFS  REPRESENTATION ----------------");
		test.BFS(data[i2]);
		System.out.println("\n---------------- DFS  REPRESENTATION ----------------");
		test.DFS(data[i2]);
	
	}
	
	/**
	 * This method tests vertex methods.
	 */
	public static void TestVertex() {
	System.out.println("\n-----------------VERTEX OPERATION TEST ---------------------\n");
	int size = 5;
	String [] data = {"v1","v2","v3","v4","v5"};
	LinkedGraph<String> test= (LinkedGraph<String>) AbstractGraph.createGraph(null, true,"list", data, size);
	test.addEdge("v1", "v3");
	test.addEdge("v2", "v3");
	test.addEdge("v2", "v5");
	test.addEdge("v5", "v1");
	test.addEdge("v4", "v2");
	test.addVertex("v6");
	test.addEdge("v6", "v2");
	test.print();
	System.out.println("\nAdd exist vertex result (v1) :"+test.addVertex("v1"));
	System.out.println("Add non-exist vertex result (v7) :"+test.addVertex("v7"));
	System.out.println("Remove non-exist vertex result (v8) :"+test.removeVertex("v8"));
	System.out.println("Remove exist vertex result (v3):"+test.removeVertex("v3"));
	
	System.out.println("\nAfter above operation, matrix graph ");
	test.print();
	}
	
	/**
	 * This methods test edge methods.
	 */
	public static void TestEdge() {
		System.out.println("\n-----------------EDGE OPERATION TEST ---------------------\n");
		int size = 5;
		String [] data = {"v1","v2","v3","v4","v5"};
		//non-directed graph
		LinkedGraph<String> test= (LinkedGraph<String>) AbstractGraph.createGraph(null, false,"list", data, size);
		test.addEdge("v1", "v3");
		test.addEdge("v2", "v3");
		test.addEdge("v2", "v5");
		test.addEdge("v5", "v1");
		test.addEdge("v4", "v2");
		test.addEdge("v2", "v2");
		System.out.println("-----------UNDIRECTED GRAPH ------------------------");
		System.out.println("Add edge wýthout vertýces 'v1,v50' and 'v40,v30'");
		test.addEdge("v1", "v50");
		test.addEdge("v40", "v30");
		
		
		
		System.out.println("Matrix Representation");
		test.print();
		
		
		System.out.println("\nDfs Traverse: (Initial vertex = v4)");	 
		
		test.DFS("v4");
		System.out.println("\n\nRemove 'v4,v2' and 'v1,v3' edge from graph");
		test.removeEdge("v4", "v2");
		test.removeEdge("v1", "v3");
		System.out.println("\nRemove 'v10,v12 and 'v1,v5' edge from graph (not exist)");
		test.removeEdge("v10", "v12");
		test.removeEdge("v1", "v5");
		System.out.println("\nBfs traverse after deletion :  (Initial vertex = v3)");
		test.BFS("v3");
		System.out.println("");
		
		
		
		//directed graph
		System.out.println("\n-----------DIRECTED GRAPH ---------------");
		LinkedGraph<String> test1= (LinkedGraph<String>) AbstractGraph.createGraph(null, true,"list", data, size);
		test1.addEdge("v1", "v3");
		test1.addEdge("v2", "v3");
		test1.addEdge("v2", "v5");
		test1.addEdge("v5", "v1");
		test1.addEdge("v4", "v2");
		test1.addEdge("v2", "v2");
		
		System.out.println("Add edge without vertices 'v1,v50' and 'v40,v30'");
		test1.addEdge("v1", "v50");
		test1.addEdge("v40", "v30");
		
		System.out.println("Matrix Representation");
		test1.print();
		System.out.println("\nDfs Traverse: (Initial vertex = v4)");	 
		
		test1.DFS("v4");
		System.out.println("\n\nRemove 'v4,v2' and 'v1,v3' edge from graph");
		test1.removeEdge("v4", "v2");
		test1.removeEdge("v1", "v3");
		System.out.println("Remove 'v10,v12 and 'v1,v5' edge from graph (not exist)");
		test1.removeEdge("v10", "v12");
		test1.removeEdge("v1", "v6");
		System.out.println("\nBfs traverse after deletion :  (Initial vertex = v3)");
		test1.BFS("v3");
	
		
	}

	/**
	 * This methods tests BFS and DFS methods.
	 */
	public static void TestSearch() {
		System.out.println("\n---------------------- SEARCH TEST --------------------------\n");
		int size = 10;
		Integer data [] = new Integer [size];
		for(int i=0;i<size;i++) {
			data[i]=i;
		}
		//DIRECTED GRAPH
		LinkedGraph<Integer> test= (LinkedGraph<Integer>) AbstractGraph.createGraph(null, true, "list", data,size);
		test.addEdge(7,6);
		test.addEdge(7,9);
		test.addEdge(7,1);
		test.addEdge(2,10);
		test.addEdge(2,7);
		test.addEdge(0,6);
		test.addEdge(8,3);
		test.addEdge(1,0);
		test.addEdge(3,1);
		test.addEdge(3,5);
		test.addEdge(3,2);
		test.addEdge(0,8);
		System.out.println("DIRECTED GRAPH");
		test.print();
		
		
		
		System.out.println("\nInitial vertex = 0 - BFS");
		test.BFS(0);
		System.out.println("\nInitial vertex = 3 - BFS");
		test.BFS(3);
		System.out.println("\nInitial vertex = 0 - DFS");
		test.DFS(0);
		System.out.println("\nInitial vertex = 3 - DFS");
		test.DFS(3);
		System.out.println("\nInitial vertex = 15(non-exist) - DFS");
		test.DFS(15);
		System.out.println("\nInitial vertex = 53(non-exist) - BFS");
		test.BFS(53);
		
		
		//UNDIRECTED GRAPH
		LinkedGraph<Integer> test1= (LinkedGraph<Integer>) AbstractGraph.createGraph(null, false, "list", data,size);
		test1.addEdge(7,6);
		test1.addEdge(7,9);
		test1.addEdge(7,1);
		test1.addEdge(2,10);
		test1.addEdge(2,7);
		test1.addEdge(0,6);
		test1.addEdge(8,3);
		test1.addEdge(1,0);
		test1.addEdge(3,1);
		test1.addEdge(3,5);
		test1.addEdge(3,2);
		test1.addEdge(0,8);
		System.out.println("\n");
		System.out.println("UNDIRECTED GRAPH");
		test1.print();
		
		System.out.println("\nInitial vertex = 0 - BFS");
		test1.BFS(0);
		System.out.println("\nInitial vertex = 3 - BFS");
		test1.BFS(3);
		System.out.println("\nInitial vertex = 0 - DFS");
		test1.DFS(0);
		System.out.println("\nInitial vertex = 3 - DFS");
		test1.DFS(3);
		System.out.println("\nInitial vertex = 15(non-exist) - DFS");
		test1.DFS(15);
		System.out.println("\nInitial vertex = 53(non-exist) - BFS");
		test1.BFS(53);
		
		
	}
	
}
