package hw6;

import java.util.List;

public class BubbleSort {
	public <T extends Comparable <T>> void sort (List<T> table ) {
		
		int pass = 1;
		boolean exchanges = false;
		do {
			exchanges = false;
			for(int i = 0; i<table.size()-pass;i++) {
				if(table.get(i).compareTo(table.get(i+1))>0) {
					T temp = table.get(i);
					table.set(i, table.get(i+1));
					table.set(i+1, temp);
					exchanges = true;
				}
			}
			pass++;
		}while(exchanges);
		
	}
}
