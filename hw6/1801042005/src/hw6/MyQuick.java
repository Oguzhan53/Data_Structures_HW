package hw6;

import java.util.List;

public class MyQuick {

	public <T extends Comparable <T>> void sort(List<T> lst) {
		quicksort (lst, 0, lst.size()-1);
	}
	
	
	
	private <T extends Comparable <T>> void quicksort(List<T> lst, int l, int h){ 
        if (l < h){ 
            int pi = partition(lst, l, h); 
            quicksort(lst, l, pi-1); 
            quicksort(lst, pi+1, h); 
        } 
    }
	public <T extends Comparable <T>>  int partition(List<T> lst, int l, int h){
        T pivot = lst.get(h);  
        int i = (l-1); 
        for (int j=l; j<h; j++){ 
            if (lst.get(j).compareTo(pivot)<1 ){ 
                i++; 
                swap(lst, i, j);
            } 
        } 
        swap(lst, i+1, h);
        return i+1; 
    }
	 public <T extends Comparable <T>> void swap (List <T> table,int i,int j) {
		T temp = table.get(i);
		table.set(i, table.get(j));
		table.set(j, temp);
	}
	
	
}
