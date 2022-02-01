/**
 * 
 */
package hw2;

import java.util.ArrayList;

/**
 * This is branch class.There are branch name , employees class array and shipment class array.
 * @author Oguzhan SEZGIN - 1801042005
 * 
 *  
 */
public class branches {
	private String name;
	private ArrayList<branch_empl> employees ;   	//	 branch_empl [] employees ;
	private  ArrayList<shipment> ship ; //  shipment [] ship;
	
	
	
	public ArrayList<shipment> getShip() {
		return ship;
	}
	public void setShip(ArrayList<shipment> ship) {
		this.ship = ship;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	public ArrayList<branch_empl> getEmployees() {
		return employees;
	}



	public void setEmployees(ArrayList<branch_empl> employees) {
		this.employees = employees;
	}


	
	
	/**
	 * This is branches constructor 
	 * @param name This is branch's name
	 */
	public branches(String name) {
		this.name=name;
		this.employees= new ArrayList<branch_empl>() ;
		this.ship = new ArrayList<shipment>();
	}

	
	
	
	
	
	/**
	 * This method shows branch's information.It shows name , employee number in branch , shipment number in branch and employee's name
	 */
	public void show_info() {
		System.out.println("Branch Name 			: "+getName());

		System.out.println("Employee Number 		: " +employees.size());

		System.out.println("Shipment Number 		: " +ship.size());
		System.out.println("Employees : ");
		
		for(int i=0;i<employees.size();i++) {
			employees.get(i).show();
			}
			
		
		
		System.out.println("------------");
		
	}
}
