package hw2;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * This is main function.
 * 
 * @author Oguzhan SEZGIN - 1801042005
 * 
 */
public class Main {

	/**
	 * User select to profile number and use the program with this function
	 */
	
	
	public static void main(String[] args) {
		
		
		
		System.out.println("-------- WELCOME GTU CARGO --------");
		ArrayList<branches>branch=new ArrayList<branches>() ;  
		ArrayList<transporter_pers> transport= new ArrayList<transporter_pers>(); 
		ArrayList<customer> custom = new ArrayList<customer>();   
		admin ad =new admin("oguzhan","cse222");
		
		
		
		
		/**
		 * n ,n1,i_selection This numbers are user-selected numbers
		 *
		 */
		int n=0,n1=0;
		int i_selection=-1;
		/**
		 * This numbers to stay on the user-selected profile
		 */
		int mark=0; 
		
		/**
		 * This is main loop.If user do not enter 5 can not exit program.
		 */
		Scanner scan = new Scanner(System.in);
		while(true) {
			
			
			if(mark==0) {
				
				
				
				
				System.out.println("Enter User Profile Number \n 1-Admin \n 2-Branch Employee \n "
						+ "3-Trasnporter Personnel \n 4-Customer \n 5-Exit");
							
				i_selection= scan.nextInt();
				
			}
			
			else if(mark==1)
				i_selection=1;
			else if(mark==2)
				i_selection=2;
			else if(mark==3)
				i_selection=3;
			else if(mark==4)
				i_selection=4;
			
			
			String s_selection;
			if(i_selection == 1) { 
				String pas;
				if(mark==1)
					pas="cse222";
				else {
					System.out.print("Welcome Admin \nEnter Password :");
					pas=scan.next();
				}
					
				if(pas.equals(ad.getPassword())){
					System.out.println("Enter Transaction Number \n 1-Add Branch \n 2-Remove Branch \n 3-Add Branch Employee"
							+ "\n 4-Remove Branch Employee \n 5-Add Transportation Personel \n 6-Remove Transportation Personel"
							+ "\n 7-Return Main Menu");
					
					i_selection=scan.nextInt();
					mark=1;
					if(i_selection==1) {
						System.out.print("Enter Branch Name :");
						s_selection=scan.next();
						ad.add_Branch(branch,s_selection);
						methods.print_Braches(branch);
					}
					else if(i_selection==2) {
						System.out.print("Enter Branch Name :");
						s_selection=scan.next();
						ad.remove_Branch(branch,s_selection);
						methods.print_Braches(branch);
					}
					else if(i_selection==3) {
						String s_selection2;
						System.out.print("Enter Branch Employee Name :");
						s_selection=scan.next();
						System.out.print("Enter Branch Name :");
						s_selection2=scan.next();
						ad.add_Branch_Employee(branch, s_selection, s_selection2);
						methods.print_Employees(branch, transport);
						
						
					}
					else if(i_selection==4) {
						String s_selection2;
						System.out.print("Enter Branch Employee Name :");
						s_selection=scan.next();
						System.out.print("Enter Branch Name :");
						s_selection2=scan.next();
						ad.remove_Branch_Employee(branch, s_selection, s_selection2);
						methods.print_Employees(branch, transport);
					}
					else if(i_selection==5) {
						System.out.print("Enter Transportation Personel Name :");
						s_selection=scan.next();
						ad.add_Transp_Pers(transport, s_selection, branch);
						methods.print_Employees(branch, transport);
					}
					else if(i_selection==6) {
						System.out.print("Enter Transportation Personel Name :");
						s_selection=scan.next();
						ad.remove_Transp_Pers(transport, s_selection);
						methods.print_Employees(branch, transport);
					}
					else
						mark=0;
					
				}
				else {
					
					System.out.println("\n--------------------- Password is wrong !---------------------\n");
				}
			}
			else if(i_selection==2) { 
				if(mark!=2) {
					System.out.print("Enter the name of the branch where you work : ");
					s_selection = scan.next();
					n=methods.find_branch(branch, s_selection);
				}
				
				
				if(n==-1) {
					System.out.println("\n---------------------There is no branch this name !---------------------\n");
				}
				else {
					if(mark!=2) {
						System.out.print("Enter your name : ");
						String s_selection2=scan.next(); 
						n1=methods.find_employee(branch.get(n), s_selection2);
					}
					
					
					if(n1==-1) {
						System.out.println("\n---------------------There is no employee this name in this branch !---------------------\n");
					}
					else {
						ArrayList<branch_empl> ins_emp =branch.get(n).getEmployees();
						System.out.println("Enter Transaction Number \n 1-Create Shipment \n 2-Change Shipment Info"
								+ "\n 3-Remove Shipment \n 4-Create Customer \n 5-Remove Customer \n 6-Return Main Menu");
						i_selection=scan.nextInt();
						mark=2;
						if(i_selection==1) {
							
							System.out.print("Enter Sender : ");
							String s_selection3=scan.next();
							System.out.print("Enter Receiver : ");
							String s_selection4=scan.next();							
							System.out.print("Enter Tracking Number : ");
							int i_selection5 =scan.nextInt();
							System.out.print("Enter Status : ");
							String s_selection6=scan.next();
							
							ins_emp.get(n1).create_Ship(s_selection3, s_selection4, s_selection6,i_selection5 );
							methods.print_Shipment(branch.get(n));
						}
						else if(i_selection==2) {
							System.out.println("Enter Shipment Tracking Number : ");
							int i_selection3=scan.nextInt();
							int n2 = methods.find_shipmet(branch.get(n), i_selection3);
							if(n2==-1)
								System.out.println("\n---------------------There is no shipment this number !---------------------\n");
							else {
								System.out.println("Enter Shipment Status ");
								String s_selection4=scan.next();
								ins_emp.get(n1).update_Ship_Info(s_selection4, i_selection3);
								methods.print_Shipment(branch.get(n));
							}
							
							
						}
						else if(i_selection==3) {
							
							System.out.println("Enter Shipment Tracking Number : ");
							int i_selection3=scan.nextInt();
							int n2 = methods.find_shipmet(branch.get(n), i_selection3);
							if(n2==-1)
								System.out.println("\n---------------------There is no shipment this number !---------------------\n");
							else {
								
								ins_emp.get(n1).remove_Ship(i_selection3);
								methods.print_Shipment(branch.get(n));
							}
							
							
						}
						
						else if(i_selection==4) {
							System.out.println("Enter Customer Name : ");
							String s_selection3=scan.next();
							ins_emp.get(n1).add_customer(custom, s_selection3);
							methods.print_customer(custom);
						}
						else if(i_selection==5) {
							System.out.println("Enter Customer Name : ");
							String s_selection3=scan.next();
							ins_emp.get(n1).remove_Customer(custom, s_selection3);
							methods.print_customer(custom);
						}
						else
							mark=0;
						
					}
					
				}
			}
			
			else if(i_selection==3) { 
				if(mark!=3) {
					System.out.print("Enter Your Name : ");
					s_selection = scan.next();
					n=methods.find_transportation_per(transport, s_selection);
				}
				
				if(n==-1)
					System.out.println("\n---------------------There is no transportation personnel !---------------------\n");
				else {
					mark=3;
					System.out.print("Enter Transaction Number \n 1-Change Shipment Info \n 2-Return Main Menu \n");
					i_selection=scan.nextInt();
					if(i_selection==1) {
						System.out.print("Enter Tracking Number : ");
						int tr=scan.nextInt();
						System.out.print("Enter Shipment Status : ");
						String s_selection3=scan.next();
						transport.get(n).update_Ship_Info(s_selection3, tr);
						
					}
					else
						mark=0;
					
					
				}
			}
			else if(i_selection==4) { 
				if(mark!=4) {
					System.out.print("Enter Your Name : ");
					String s_selection3=scan.next();
					n=methods.find_customer(custom, s_selection3);
				}
				
				if(n!=-1) {
					mark=4;
					System.out.print("Enter Transaction Number \n 1-Search Shipment Info \n 2-Return Main Menu \n ");
					i_selection=scan.nextInt();
					if(i_selection==1) {
						System.out.print("Enter Tracking Number : ");
						n1=scan.nextInt();
						custom.get(n).search_shipment(branch, n1);
					}
					else {
						mark=0;
					}
					
				}
				else
					System.out.println("\n---------------------There is no customer !---------------------\n");
			}
			else
				break;
			
			
		}
		scan.close();
		System.out.println("Program End");
		
		/*
		 * -------------- TEST CASES ---------------------
		test_cases test=new test_cases();
		test.admin_test();
		test.branch_emp_test();
		test.transp_per_test();
		test.customer_test();
		
		*/

	}

}
