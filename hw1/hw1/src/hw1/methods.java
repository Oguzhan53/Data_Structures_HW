package hw1;

/**
 * 
 * @author Oguzhan SEZGIN - 1801042005
 * This is methods class
 *
 */
public class methods {
	/**
	 * This methods prints shipments number and information in branch
	 * @param br This is shipment's branch 
	 */
	public static void print_Shipment(branches br) {
		int l = br.ship.length;
		for(int i=0;i<l;i++) {
			br.ship[i].print_in();
		}
		System.out.println("------------------");
	}
	
	/**
	 * This method prints branches information
	 * @param branch This is branch class array
	 */
	public static void print_Braches(branches [] branch) {
		if(branch!=null) {
			int l=branch.length;
			for(int i=0;i<l;i++) {
				branch[i].show_info();
			}
			
		}
		
		
		
	}
	/**
	 * This method prints all worker 
	 * @param branch This is branch class array
	 * @param transport This is transportation personnel class array
	 */
	public static void print_Employees(branches [] branch,transporter_pers [] transport) {
		System.out.println("Branch Employees :");
		if(branch!=null) {
			for(int i=0;i<branch.length;i++) {
				if(branch[i].employees!=null) {
						for(int i1=0;i1<branch[i].employees.length;i1++) {
								branch[i].employees[i1].show();
								System.out.println("work branch	:"+branch[i].getName());
						}
					}
				}
			}
		System.out.println("Transportation Employees :");
		if(transport!=null) {
			for(int i=0;i<transport.length;i++) {
				transport[i].show();
			}
		}
		
	}
	
	/**
	 * This method prints customers information
	 * @param cs This is customer class array
	 */
	public static void print_customer(customer [] cs) {
		if(cs!=null) {
			for(int i=0;i<cs.length;i++) {
				System.out.println("Name	:"+cs[i].getName() );
			}
		}
		
	}
	
	/**
	 * 	This methods finds transportation personnel .
	 * @param pr This is transportation personnel class array
	 * @param name This is transportation personnel's name which user search
	 * @return This methods returns transportation personnel number in array
	 */
	public static int find_transportation_per(transporter_pers[] pr,String name) {
		if(pr==null)
			return -1;
		else {
			for(int i=0;i<pr.length;i++) {
				if(name.equals(pr[i].getName()))
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
	public static int find_branch(branches[] br,String name ) {
		
		if(br==null)
			return -1;
		
		for(int i=0;i<br.length;i++) {
			if(name.equals(br[i].getName()))
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
		if(br.employees==null)
			return -1;
		for(int i=0;i<br.employees.length;i++) {
			if(name.equals(br.employees[i].getName()))
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
		
		if(br.ship==null)
			return -1;
		for(int i=0;i<br.ship.length;i++) {
			if(br.ship[i].getTrack_num()==t_num)
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
	public static int find_customer(customer [] cs,String name) {
		if(cs==null) {
			System.out.println("\n---------------------There is no customer !---------------------\n");
			return -1;
		}
			
		for(int i=0;i<cs.length;i++) {
			if(name.equals(cs[i].getName()))
				return i;
		}
		return -1;
	}

	
	
	
	
	
	
	
	
	


}
