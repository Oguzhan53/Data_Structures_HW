package hw6;

import java.util.List;

public class QuickSort {

	
	public <T extends Comparable <T>> void sort (List <T> table ) {
		quickSort (table, 0, table.size()-1);
	}
	
	protected <T extends Comparable<T>> void quickSort (List<T> table , int first, int last) {
		if (first < last) { 
			int pivIndex = partition(table, first,last);
			quickSort(table, first, pivIndex-1);
			quickSort(table, pivIndex + 1,last);
		}
	}
	
	protected <T extends Comparable<T>> int partition(List<T> table,int first,int last) {
		T  pivot = table.get(first);
		int up = first;
		int down = last;
		do {
			while ((up < last) && (pivot.compareTo (table.get(up)) >= 0))
				up++;
			
			while (pivot.compareTo (table.get(down)) < 0)
				down--;
			if (up < down)
				swap(table, up, down);
		}while(up<down);
		swap(table, first, down);
		return down;
	}
	
	public <T extends Comparable <T>> void swap (List <T> table,int i,int j) {
		T temp = table.get(i);
		table.set(i, table.get(j));
		table.set(j, temp);
	}
	
}
