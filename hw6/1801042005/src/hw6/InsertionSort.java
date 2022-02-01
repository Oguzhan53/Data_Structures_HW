package hw6;

import java.util.List;

public class InsertionSort {
	public <T extends Comparable <T>> void sort (List<T> table ) {
		for(int nextPos = 1; nextPos < table.size() ; nextPos ++) {
			insert(table, nextPos);
		}
	}
	
	private static <T extends Comparable <T>> void insert(List<T> table,int nextPos ) {
		T nextVal = table.get(nextPos) ; // Element
		while(nextPos > 0 && nextVal.compareTo(table.get(nextPos-1)) < 0) {
			table.set(nextPos, table.get(nextPos-1)) ; 
			nextPos--;
		}
		table.set(nextPos, nextVal);
	}

}



