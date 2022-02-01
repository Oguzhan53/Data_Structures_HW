package q3;

import java.util.*;

/**
 * There are some methods for library system in this class.
 * @author Oguzhan SEZGIN - 1801042005
 *
 */
public class Methods {


	/**
	 * This method checks is there searched book or another book. 
	 * @param lib Library Map
	 * @param shelf Searched book's shelf number 
	 * @param corridor Searched book's corridor number
	 * @param writer Searched book's writer name
	 * @param book Searched book's name
	 * @param sc1 Scanner
	 * @return True if the location is  right else return false
	 */
	public static boolean isThere (Map<String,Map<String,Set<Set<String>>>> lib,String shelf,String corridor,String writer,String book,Scanner sc1) {
		if(lib==null)
			return false;
		else {
			Set<Set<String>> outset= new HashSet<Set<String>>();
			Set<String> inset = new HashSet<String>();
			inset.add(shelf);
        	inset.add(corridor);
        	String opt1,opt2,opt3;
        	
			for(Map.Entry<String,Map<String,Set<Set<String>>>> m:lib.entrySet()){
				if(m.getKey().equalsIgnoreCase(writer)) {
					
					for(Map.Entry<String, Set<Set<String>>> m1 : m.getValue().entrySet()) {
						if(m1.getKey().equalsIgnoreCase(book)) {
							
							inset.add("available");
				        	outset.add(inset);
				        	if(m1.getValue().containsAll(outset)) {
				        		m1.getValue().removeAll(outset);
				        		System.out.println("Enter New Corridor Number");
				        		opt1=sc1.nextLine();
				        		opt1=opt1.trim();
				        		opt1="c:"+opt1;
				        		System.out.println("Enter New Shelf Number");
				        		opt2=sc1.nextLine();
				        		opt2=opt2.trim();
				        		opt2="s:"+opt2;
				        		System.out.println("Enter New Status");
				        		opt3=sc1.nextLine();
				        		opt3=opt3.trim();
				        		inset = new HashSet<String>();
				        		outset= new HashSet<Set<String>>();
				        		inset.add(opt1);
				        		inset.add(opt2);
				        		inset.add(opt3);
				        		m1.getValue().add(inset);
				        		return true;
				        	}
				        	outset.remove(inset);
				        	inset.remove("available");
				        	
				        	inset.add("not-available");
				        	outset.add(inset);
				        	if(m1.getValue().containsAll(outset)) {
				        		m1.getValue().removeAll(outset);
				        		System.out.println("Enter New Corridor Number");
				        		opt1=sc1.nextLine();
				        		opt1=opt1.trim();
				        		opt1="c:"+opt1;
				        		System.out.println("Enter New Shelf Number");
				        		opt2=sc1.nextLine();
				        		opt2=opt2.trim();
				        		opt2="s:"+opt2;
				        		System.out.println("Enter New Status");
				        		opt3=sc1.nextLine();
				        		opt3=opt3.trim();
				        		inset = new HashSet<String>();
				        		outset= new HashSet<Set<String>>();
				        		inset.add(opt1);
				        		inset.add(opt2);
				        		inset.add(opt3);
				        		m1.getValue().add(inset);
				        		return true;
				        	}
				        	outset.remove(inset);
				        	inset.remove("not-available");
				        	
				        	inset.add("reserved");
				        	outset.add(inset);
				        	if(m1.getValue().containsAll(outset)) {
				        		m1.getValue().removeAll(outset);
				        		System.out.println("Enter New Corridor Number");
				        		opt1=sc1.nextLine();
				        		opt1=opt1.trim();
				        		opt1="c:"+opt1;
				        		System.out.println("Enter New Shelf Number");
				        		opt2=sc1.nextLine();
				        		opt2=opt2.trim();
				        		opt2="s:"+opt2;
				        		System.out.println("Enter New Status");
				        		opt3=sc1.nextLine();
				        		opt3=opt3.trim();
				        		inset = new HashSet<String>();
				        		outset= new HashSet<Set<String>>();
				        		inset.add(opt1);
				        		inset.add(opt2);
				        		inset.add(opt3);
				        		m1.getValue().add(inset);
				        		return true;
				        	}
				        	outset.remove(inset);
				        	inset.remove("reserved");
						}
			        	
			        		
			        }
				}
		              
		    } 
			System.out.println("Wrong Location !!!");
			return false;
		}
			
		
	}
	
	/** This method prints writer's book and location of these books.
	 * @param lib Library map
	 * @param name Writer name
	 * @param sc Scanner
	 */
	public static void printBook(Map<String,Map<String,Set<Set<String>>>> lib,String name,Scanner sc) {
		if(lib==null)
			System.out.println("The Library is Empty");
		else {
			if(lib.get(name)!=null) {
				int i=1;
				
				if(lib.get(name).size()!=0) {
					System.out.println("Choose The Book Name");
					for(Map.Entry<String, Set<Set<String>>> m1 : lib.get(name).entrySet()) {
			        	System.out.println(i+"-"+m1.getKey());
			        	i++;
			        }
					while(true) {
						String opt1 = sc.nextLine();
						opt1=opt1.trim();
						if(lib.get(name).get(opt1)!=null) {
							int i1=1;
							for (Set<String> s : lib.get(name).get(opt1)) {
								System.out.print(i1+" Location : ");
								for (String s1 : s) {
								    System.out.print(s1+" ");
								}
								i1++;
							    System.out.println();
							}
						break;
						}
						else
							System.out.println("There is no this name book.Try Again");
					}
				}
				else
					System.out.println("There is no this writer's book ");
				

			}
			else {
				System.out.println("There is no this name writer");
			}
					
				
			
		}
		
	}
	
	/**
	 * This method write book information
	 * @param lib Library map
	 * @param name Book name
	 */
	public static void printBookInfo(Map<String,Map<String,Set<Set<String>>>> lib,String name) {
		
		if(lib==null)
			System.out.println("Library is empty");
		else {
			int i=0;
			for(Map.Entry<String,Map<String,Set<Set<String>>>> m:lib.entrySet()){

				for(Map.Entry<String, Set<Set<String>>> m1 : m.getValue().entrySet()) {
		        	if(m1.getKey().equals(name)) {
		        		i=1;
		        		int i1=1;
		        		System.out.println("Writer : "+m.getKey());
		        		for (Set<String> s : m1.getValue()) {
							System.out.print(i1+" Location : ");
							for (String s1 : s) {
							    System.out.print(s1+" ");
							}
							i1++;
						    System.out.println();
						}
		        		
		        	}
		        }
				
		        
			}
			if(i==0)
				System.out.println("There is no this name book");
		}
		
	}

	/**This method checks is the entered status valid
	 * @param st Entered status
	 * @return If it is valid return status else return null
	 */
	public static String isStatus(String st) {
		if(st.equalsIgnoreCase("available"))
			return "available";
		else if (st.equalsIgnoreCase("not-available"))
			return "not-available";
		else if (st.equalsIgnoreCase("reserved"))
			return "reserved";
		
		return null;
	}

}

	





