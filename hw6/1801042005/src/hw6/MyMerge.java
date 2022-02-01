package hw6;
import java.util.*;

public class MyMerge {

	public <T extends Comparable <T>> List<T> sort(List<T> lst) {
		if(lst.size()<2)
			return lst;
		else {
			int mid = lst.size()/2;
			List<T> rightlst = new LinkedList<T>();
			List<T> leftlst = new LinkedList<T>();
			int i;
			for(i=0;i<mid;i++)
				leftlst.add(lst.get(i));
			for( ;i<lst.size();i++)
				rightlst.add(lst.get(i));
			
			leftlst=sort(leftlst);
			rightlst = sort(rightlst);
			
			
			return lst;
		}
		
		
	}
	
	public <T extends Comparable <T>> List<T> merge(List<T> lst,List<T> rlst,List<T> llst){
		List <T> newlst=new LinkedList<T>();
		int l=0 , r=0;
		while(r<rlst.size() && l<llst.size()) {
			if(rlst.get(r).compareTo(llst.get(l))<1) {
				newlst.add(rlst.get(r));
				r++;
			}
				
			else {
				newlst.add(llst.get(l));
				l++;
			}
				
		}
	//	if()
		
		
		
		return lst;
	}
	
	
	public <T extends Comparable <T>> void sort1(List<T> lst){
		int size;
	
		size=lst.size();
		int n;
		for( n=2;n<size;n=n*2) {
			int i;
			for(i=0;i<lst.size();i=i+n) {
				merge1(i,n,lst,n);
				
			}
		
			
		}
		if(n>size) {
			int i;
			for(i=0;i<lst.size();i=i+n) {
				merge1(i,n,lst,n);
				
			}
		}
		
	}
	public <T extends Comparable <T>> void merge1(int i,int n,List<T> lst,int n1) {
		
		List<T> temp=new LinkedList<T>();
		int c3=i;
		for(int c=0;c<n;c++) {
			if(c3<lst.size()) {
				temp.add(lst.get(c3));
				c3++;
			}
			
		}
		int c1=i;
		int c=0;
		
		c3=n/2;
		while(c<n/2 && c3<temp.size()) {
			if(temp.get(c).compareTo(temp.get(c3))<1) {
				lst.set(c1, temp.get(c));
				c++;
				c1++;
			}
			else {
				lst.set(c1, temp.get(c3));
				c3++;
				c1++;
			}
			
		}
		if(c<n/2) {
			while(c<n/2) {
				if(c<temp.size()) {
					lst.set(c1, temp.get(c));
					c++;
					c1++;
				}
				else
					break;
				
			}
		}
		else {
			while( c3<temp.size()) {
				lst.set(c1, temp.get(c3));
				c3++;
				c1++;
			}
		}
			
		System.out.println("aa");
	}
	


}
