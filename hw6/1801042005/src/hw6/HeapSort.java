package hw6;

import java.util.List;

public class HeapSort {

	
	
	public <T extends Comparable <T>> void sort (List <T> table ) {
		buildHeap(table);
		shrinkHeap(table);
	}
	
	
	private <T extends Comparable<T>> void buildHeap (List<T> table) {
		int n = 1;
		while (n <table.size() ) {
			n++; 
			int child = n-1;
			int parent = (child-1) / 2;
			while (parent >= 0 && table.get(parent).compareTo (table.get(child)) < 0) {
				swap(table, parent, child);
				child = parent;
				parent = (child-1) / 2;
			}
		}
	}
	
	
	private <T extends Comparable<T>> void shrinkHeap (List <T> table) {
		int n = table.size();
		while (n > 0) {
			n--;
			swap(table, 0, n);
			int parent = 0;
			while (true) {
				int leftChild = 2 * parent + 1;
				if (leftChild >= n)
					break;
				int rightChild = leftChild +1;
				int maxChild = leftChild;
				if (rightChild < n && table.get(leftChild).compareTo (table.get(rightChild)) < 0)
					maxChild = rightChild;
				if (table.get(parent).compareTo (table.get(maxChild)) < 0) {
					swap(table, parent,maxChild);
					parent = maxChild ;
				}
				else
					break;
			}
		}
	}
	
	
	
	public <T extends Comparable <T>> void swap (List <T> table,int i,int j) {
		T temp = table.get(i);
		table.set(i, table.get(j));
		table.set(j, temp);
	}
	
}
