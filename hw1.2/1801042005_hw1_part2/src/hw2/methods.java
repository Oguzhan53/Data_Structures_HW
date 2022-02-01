package hw2;

import java.util.ArrayList;

/**
 * This is methods class
 * @author Oguzhan SEZGIN - 1801042005
 */
public class methods {
	/**
	 * This methods prints shipments number and information in branch
	 * @param br This is shipment's branch 
	 */
	public static void print_Shipment(branches br) {
		ArrayList<shipment> ins_ship=br.getShip();
		int l = ins_ship.size();
		for(int i=0;i<l;i++) {
			ins_ship.get(i).print_in();
		}
		System.out.println("------------------");
	}
	
	/**
	 * This method prints branches information
	 * @param branch This is branch class array
	 */
	public static void print_Braches(ArrayList<branches> branch) {
	
		int l=branch.size();
		for(int i=0;i<l;i++) {
			branch.get(i).show_info();
		}
			
		
		
		
		
	}
	/**
	 * This method prints all worker 
	 * @param branch This is branch class array
	 * @param transport This is transportation personnel class array
	 */
	public static void print_Employees(ArrayList<branches> branch,ArrayList<transporter_pers> transport) {
		
		if(branch.size()!=0) {
			System.out.println("Branch Employees :");
			for(int i=0;i<branch.size();i++) {
				ArrayList<branch_empl> ins_emp=branch.get(i).getEmployees();
				if(ins_emp.size()!=0) {
						for(int i1=0;i1<ins_emp.size();i1++) {
							ins_emp.get(i1).show();
								System.out.println("work branch	:"+branch.get(i).getName());
								System.out.println("---------");
						}
					}
				}
			}
		
		if(transport.size()!=0) {
			System.out.println("Transportation Employees :");
			for(int i=0;i<transport.size();i++) {
				transport.get(i).show();
				System.out.println("---------");
			}
		}
		
	}
	
	/**
	 * This method prints customers information
	 * @param cs This is customer class array
	 */
	public static void print_customer(ArrayList<customer> cs) {
		if(cs.size()!=0) {
			for(int i=0;i<cs.size();i++) {
				System.out.println("Name	:"+cs.get(i).getName() );
			}
		}
		
	}
	
	/**
	 * 	This methods finds transportation personnel .
	 * @param pr This is transportation personnel class array
	 * @param name This is transportation personnel's name which user search
	 * @return This methods returns transportation personnel number in array
	 */
	public static int find_transportation_per(ArrayList<transporter_pers> pr,String name) {
		if(pr.size()==0)
			return -1;
		else {
			for(int i=0;i<pr.size();i++) {
				if(name.equals(pr.get(i).getName()))
					return i;
			}
			return -1;
		}
	}
	
	
	
	/**
	 * This method finds branch
	 * @param br This is branch class array
	 * @param name This is branch name which user search
	 * @return This method returns branch number in array
	 */
	public static int find_branch(ArrayList<branches> br,String name ) {
		
		if(br.size()==0)
			return -1;
		
		for(int i=0;i<br.size();i++) {
			if(name.equals(br.get(i).getName()))
				return i;
		}
		
		return -1;
		
	}
	/**
	 * This method finds branch employee
	 * @param br This is branch class array
	 * @param name This is employee's name which user search
	 * @return This methods returns branch employee number in array
	 */
	public static int find_employee(branches br,String name) {
		ArrayList<branch_empl> ins_emp=br.getEmployees();
		if(ins_emp.size()==0)
			return -1;
		for(int i=0;i<ins_emp.size();i++) {
			if(name.equals(ins_emp.get(i).getName()))
				return i;
		}
		
		return -1;
	}
	
	/**
	 * This method finds shipment
	 * @param br This is branch class array
	 * @param t_num This is tracking number of shipment which user search
	 * @return This methods returns shipment number in array
	 */
	public static int find_shipmet(branches br , int t_num) {
		
		ArrayList<shipment> ins_ship=br.getShip();
		for(int i=0;i<ins_ship.size();i++) {
			if(ins_ship.get(i).getTrack_num()==t_num)
				return i;
		}
		return -1;
		
	}
	
	
	/**
	 * This methods finds customer
	 * @param cs This is branch class array
	 * @param name This is customer name which user search
	 * @return This methods returns customer number in array
	 */
	public static int find_customer(ArrayList<customer> cs,String name) {
		if(cs.size()==0) {
			System.out.println("\n---------------------There is no customer !---------------------\n");
			return -1;
		}
			
		for(int i=0;i<cs.size();i++) {
			if(name.equals(cs.get(i).getName()))
				return i;
		}
		return -1;
	}

	
	
	
	
	
	
	
	
	


}
