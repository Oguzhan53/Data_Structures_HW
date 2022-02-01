package hw6;
import java.util.*;

public class MergeSort {

	public <T extends Comparable <T>> void sort (List <T> table ) {
		if (table.size() > 1) {
			int halfSize = table.size() /2;
			List<T> leftTable =  new LinkedList<T>();
			List<T> rightTable =  new LinkedList<T>();
			
			for(int i=0;i<halfSize;i++) 
				leftTable.add(table.get(i));
			for(int i=halfSize;i<table.size();i++)
				rightTable.add(table.get(i));
			
			sort(leftTable);
			sort(rightTable);
			merge(table, leftTable, rightTable);
		}
	}
	
	public <T extends Comparable <T>> void merge(List<T> outputSequence,List<T> leftSequence,List<T> rightSequence ) {
		int i=0;
		int j=0;
		int k=0;
		
		while (i < leftSequence.size() && j < rightSequence.size()) {
			if(leftSequence.get(i).compareTo (rightSequence.get(j)) < 0) {
				outputSequence.set(k++, leftSequence.get(i++));
			}
			else {
				outputSequence.set(k++, rightSequence.get(j++));
			}
		}
		while(i < leftSequence.size() ) {
			outputSequence.set(k++, leftSequence.get(i++));
		}
		while(j < rightSequence.size() ) {
			outputSequence.set(k++, rightSequence.get(j++));
		}
	}
}
