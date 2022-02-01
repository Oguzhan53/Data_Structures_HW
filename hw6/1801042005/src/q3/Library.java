package q3;


import java.util.*;
/**This is Library class
 * @author Oguzhan SEZGIN - 1801042005
 *
 */

public class Library {
	private Map<String,Map<String,Set<Set<String>>>> outmap;
	private String password;
	
	/**
	 * This is Library class constructor.(It assign "12345" to password)
	 */
	public Library() {
		this.outmap=new HashMap<String,Map<String,Set<Set<String>>>>();
		this.password="12345";
	}
	/**
	 * This methods run the library system
	 */
	public void openLibray() {
		Scanner sc = new Scanner(System.in);
		String opt1,opt2,opt3,opt4,opt5;
		
		while(true) {
			System.out.println("Enter User Type Number (1/2) \n 1-Admin \n 2-Customer \n 3-Exit");
			opt1=sc.nextLine();
			
			if(opt1.equals("1")) {
				System.out.println("Please Enter Password");
				opt1=sc.nextLine();
				opt1=opt1.trim();
				if(opt1.equals(password)) {
					System.out.println("WELCOME ADMIN ");
					while(true) {
						
						System.out.println("\nChoose Operation Number\n 1-Add Book \n 2-Delete Book \n 3-Update Book Infornation\n 4-Return Menu");
						opt1=sc.nextLine();
						opt1=opt1.trim();
						if(opt1.equals("1")) {
							Set<String> inset = new HashSet<String>();
							System.out.println("Enter Book Writer");
							opt1=sc.nextLine();
							opt1=opt1.trim();
							
							System.out.print(("Enter Book Name  "));
							opt2=sc.nextLine();
							opt2.trim();
							System.out.print("Enter Corridor Number  ");
							opt3=sc.nextLine();
							opt3.trim();
							opt3="c:"+opt3;
							System.out.print("Enter Shelf Number  ");
							opt4=sc.nextLine();
							opt4.trim();
							opt4="s:"+opt4;
							
							
							System.out.print("Enter Status  :");
							while(true) {
								opt5=sc.nextLine();
								opt5 = opt5.trim();
								String st = Methods.isStatus(opt5);
								if(st!=null)
									break;
								else
									System.out.println("Invalid Status Type(Enter \"available\" ,\"not-available\" or \"reserved\") ");
							}
							
							
							inset.add(opt3);
							inset.add(opt4);
							inset.add(opt5);
							if(outmap.get(opt1)!=null) {
								if(outmap.get(opt1).get(opt2)!=null) {
									outmap.get(opt1).get(opt2).add(inset);
								}
								else {
									Set<Set<String>> outset= new HashSet<Set<String>>();
									outset.add(inset);
									outmap.get(opt1).put(opt2, outset);
									
								}
							}
							else {
								HashMap<String, Set<Set<String>>> inmap1 = new HashMap<String, Set<Set<String>>>();
								Set<Set<String>> outset= new HashSet<Set<String>>();
								outset.add(inset);
								inmap1.put(opt2,outset);
								outmap.put(opt1, inmap1);
							}
							System.out.println("DONE");
						

						}
						else if(opt1.equals("2")) {
							System.out.println("Enter Book Writer");
							opt1=sc.nextLine();
							opt1=opt1.trim();
							if(outmap.get(opt1)==null) {
								System.out.println("There is no this name writer");
							}
							else {
								System.out.print(("Enter Book Name  "));
								opt2=sc.nextLine();
								opt2.trim();
								if(outmap.get(opt1).get(opt2)==null) {
									System.out.println("There is no this name book");
								}
								else {
									outmap.get(opt1).remove(opt2);
									System.out.println("DONE");
								}
							}
							
							
							
						}
						
						else if(opt1.equals("3")) {
							System.out.println("Enter Book Writer");
							opt1=sc.nextLine();
							opt1=opt1.trim();
							if(outmap.get(opt1)==null) {
								System.out.println("There is no this name writer");
							}
							else {
								System.out.print(("Enter Book Name  "));
								opt2=sc.nextLine();
								opt2.trim();
								if(outmap.get(opt1).get(opt2)==null) {
									System.out.println("There is no this name book");
								}
								else {
									System.out.print("Enter Corridor Number  ");
									opt3=sc.nextLine();
									opt3.trim();
									opt3="c:"+opt3;
									System.out.print("Enter Shelf Number  ");
									opt4=sc.nextLine();
									opt4.trim();
									opt4="s:"+opt4;
							
									Methods.isThere(outmap, opt4, opt3, opt1, opt2,sc);
									System.out.println("DONE");
								
										
								}
							}
						}
						else if(opt1.equals("4"))
							break;
						else
							System.out.println("Invalid Input.Try again");
						
							
							
							
						
					}
				}
				else {
					System.out.println("Wrong password try again !!!!");
					
				}
				
			}
			
			else if(opt1.equals("2")) {
				System.out.println("WELCOME GTU LIBRARY \n ");
				while(true) {
					System.out.println("Choose Operation Number\n 1-Search With Writer Name \n 2-Search With Book Name\n 3-Return Main Menu");
					opt1=sc.nextLine();
					opt1 = opt1.trim();
					if(opt1.equals("1")) {
						System.out.print("Enter Writer Name ");
						opt1=sc.nextLine();
						opt1=opt1.trim();
						Methods.printBook(outmap, opt1, sc);
						
					}
					else if(opt1.equals("2")) {
						System.out.println("Enter Book Name");
						opt1=sc.nextLine();
						opt1=opt1.trim();
						Methods.printBookInfo(outmap, opt1);
					}
					
					else if(opt1.equals("3"))
						break;
					else
						System.out.println("Invalid Input Try Again");
				}
				
				
			}
			else if(opt1.equals("3")) {
				System.out.println("PROGRAM END - BYE ");
				break;
			}
			else
				System.out.println("Invalid Option .Please Try Again \n");
			
		}
		
		
		
		sc.close();
	}
	
}
