package q2;

import java.io.File;

import java.util.*;
import java.util.logging.Logger;

//import q1.LinkedArrayList;

//import java.io.File;
import java.io.FileNotFoundException;


/**
 * This Sýmple text editor class
 * @author Oguzhan SEZGIN - 1801042005
 *
 */

public class SimpleTextEditor {
	
	
	/**
	 * @param list This is this is list which holds characters.
	 */
	private List<Character> list;

	/**
	 * This is SimpleTextEditor class constructor.
	 */
	public SimpleTextEditor(String type) {
		if(type.equals("Linkedlist"))
			this.list = new LinkedList<Character>() ;
		else
			this.list = new ArrayList<Character>() ;
			
	}

	public List<Character> getList() {
		return list;
	}

	public void setList(List<Character> list) {
		this.list = list;
	}
	
	
	
	
	/**
	 * This method adds the element to the given index using with iterator.
	 * @param index This is index number which user wants to add.
	 * @param elmnt This is element which user wants to add.
	 * @return It returns true if add correctly,if it can not add correctly returns false.
	 * @throws IndexOutOfBoundsException If user wants to  add out of list range , method throw exception.
	 */
	public boolean Add (int index,String elmnt,Logger log) throws IndexOutOfBoundsException {
		int i2=index;
		ListIterator<Character> iterator =  list.listIterator(index);
		for (char ch: elmnt.toCharArray()) {
			iterator.add(ch);
		}
		log.info("\""+elmnt+"\" element added to list with using iterator at "+i2+" index.");
		print_logfile(log);
		return true;
	}
	
	
	
	
	/**
	 * This method adds the element to the given index without iterator.
	 * @param index This is index number which user wants to add.
	 * @param elmnt This is element which user wants to add.
	 * @return It returns true if add correctly,if it can not add correctly returns false.
	 * @throws IndexOutOfBoundsException If user wants to  add out of list range , method throw exception.
	 */
	public boolean Add_without_iter(int index,String elmnt,Logger log) throws IndexOutOfBoundsException{
		int i2=index;
		for(int i=0;i<elmnt.length();i++) {
			list.add(index, elmnt.charAt(i));
			index++;
		}
		
		log.info("\""+elmnt+"\" element added to list without using iterator at "+i2+" index.");
		print_logfile(log);
		return true;
	}
	
	
	
	
	
	
	/**
	 * This method find element which user give, on list with using iterator.
	 * @param elmnt This element which user want to find.
	 * @return It returns index if it find element , if it can not find element it returns -1. 
	 */
	public int Find (String elmnt,Logger log) {
		log.info("Program searchs \""+elmnt+"\" with using iterator.");
		ListIterator<Character> iterator =  list.listIterator();
		while(iterator.hasNext()) {
			if(iterator.next()==elmnt.charAt(0) ) {
				int i1=0;
				for(int i=iterator.nextIndex()-1;i<list.size();i++) {
					if(i1==elmnt.length()) {
						log.info("Program finds \""+elmnt+"\" ,index is "+(iterator.nextIndex()-1));
						System.out.println(elmnt+" index is "+(iterator.nextIndex()-1));
						return iterator.nextIndex()-1;
					}
						
					if(list.get(i)!=elmnt.charAt(i1)) 	
						break;
					i1++;
				}
			}
		}
		System.out.println("There is no \""+elmnt+"\" in list !!!");
		log.warning("There is no \""+elmnt+"\".");
		return -1;
	}
	
	/**
	 * This method find element which user give, on list without iterator.
	 * @param elmnt This element which user want to find.
	 * @return It returns index if it find element , if it can not find element it returns -1. 
	 */
	public int Find_without_iter(String elmnt,Logger log) {
		log.info("Program searchs \""+elmnt+"\" without using iterator.");
		for(int i=0;i<list.size();i++) {
			if(list.get(i)==elmnt.charAt(0)) {
				int i3=i+1;
				for(int i1=1;i1<elmnt.length();i1++) {
					if(elmnt.charAt(i1)!=list.get(i3))
						break;
					if(i1==elmnt.length()-1 && elmnt.charAt(i1)==list.get(i3)) {
						System.out.println(elmnt+" index is "+i);
						log.info("Program finds \""+elmnt+"\",index is "+i);
						return i;
					}
						
					i3++;
				}
			}
		}
		System.out.println("There is no \""+elmnt+"\" in list !!!");
		log.warning("There is no \""+elmnt+"\".");
		return -1;
	}
	
	
	/**
	 * This method replaces the character given by the user and the character in the given index in the list with using iterator.
	 * @param index This is index which user wants to replace
	 * @param elmnt This is element which user wants to put list.
	 * @return It returns true if replaces correctly , it throws exception if user give index out of list size.
	 */
	public boolean Replace (int index,String elmnt,Logger log) {
		log.info("User want to replace "+index+". element to \""+elmnt+"\" with using iterator.");
		ListIterator<Character> iterator =  list.listIterator();
		int i=0,i1=0,i2=index;
		while(iterator.hasNext()) {
			iterator.next();
			if(i>=index && i1<elmnt.length()) {
				if(elmnt.length()>list.size()-i && i==index) {
					log.warning("User enter invalid index value");
					throw new IndexOutOfBoundsException();
				}
						
				iterator.set(elmnt.charAt(i1));
				i1++;
			}
			
			i++;
		}
		log.info("Program replaces "+i2+". element to \""+elmnt+"\" with using iterator.");
		print_logfile(log);
		return true;
	}
	
	
	
	/**
	 * This method replaces the character given by the user and the character in the given index in the list without iterator.
	 * @param index This is index which user wants to replace
	 * @param elmnt This is element which user wants to put list.
	 * @return It returns true if replaces correctly , it throws exception if user give index out of list size.
	 */
	public boolean Replace_without_iter(int index ,String elmnt,Logger log) throws IndexOutOfBoundsException{
		int i1=index;
		log.info("User want to replace "+index+". element to \""+elmnt+"\" without using iterator.");
		if(list.size()<(elmnt.length()+index)) {
			log.warning("User enter invalid index value");
			throw new IndexOutOfBoundsException();
		}
			
		
			
		
		for(int i=0;i<elmnt.length();i++) {	
			list.set(index,elmnt.charAt(i));
			index++;
		}
		
		log.info("Program replaces "+i1+". element to \""+elmnt+"\" without using iterator.");
		print_logfile(log);
		return true;
	}
	
	
	
	
	/**
	 * This method reads file and add list to character with using iterator.
	 * @param file This is  file name.
	 * @throws FileNotFoundException It throws exception if program can not finds file.
	 */
	public void Read(File file,Logger log) throws FileNotFoundException {
		 
		ListIterator<Character> iterator =  list.listIterator();
		Scanner sc = new Scanner(file); 
		while (sc.hasNext()) {
			for (char ch: sc.next().toCharArray()) {
				iterator.add(ch);
			}	    
	    }
		
		sc.close();
		log.info("Data read from \""+file.getName()+"\" file with using iterator");
		print_logfile(log);
	}
	
	/**
	 * This method reads file and add list to character without iterator.
	 * @param file This is  file name.
	 * @throws FileNotFoundException It throws exception if program can not finds file.
	 */
	public void Read_without_iter(File file,Logger log) throws FileNotFoundException {
		Scanner sc = new Scanner(file);
		while (sc.hasNext()) {
			for (char ch: sc.next().toCharArray()) {
				list.add(ch);
			}	    
	    }
		
		sc.close();
		log.info("Data read from \""+file.getName()+"\" file without using iterator");
		print_logfile(log);
	}
	
	/**
	 * This method print list elements.
	 */
	public void print_list() {
		
		ListIterator<Character> iterator =  list.listIterator();
		while(iterator.hasNext())
			System.out.print(iterator.next()+" ");
		
		//System.out.print("list :"+list);
	}
	public void print_logfile(Logger log) {
		ListIterator<Character> iterator =  list.listIterator();
		String str="";
		while(iterator.hasNext())
			str=str+iterator.next()+",";
		log.info("Current list stuation : \t"+str);
	}

	
	


}
