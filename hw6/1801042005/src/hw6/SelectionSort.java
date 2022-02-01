package hw6;
import java.util.*;
public class SelectionSort {

	public<T extends Comparable<T>> void sort(List<T> table) {
		
		int n = table.size();
		for (int fill = 0; fill < n-1; fill++) {
			// Invariant: table[0 . . . fill-1] is sorted.
			int posMin = fill;
			for (int next = fill + 1; next < n; next++) {
					// Invariant: table[posMin ] is the smallest item in
					// table[fill . . . next - 1].
					if (table.get(next).compareTo ( table.get(posMin )) < 0) {
						posMin = next;
					}
			}
			// assert: table[posMin ] is the smallest item in
			// table[fill . . . n1].
			// Exchange table[fill] and table[posMin].
			T temp = table.get(fill);
			table.set(fill, table.get(posMin)); 
			table.set(posMin, temp); 
			// assert: table[fill] is the smallest item in
			// table[fill . . . n- 1].
		}
		// assert: table[0 . . . n-1] is sorted.
	}
}
