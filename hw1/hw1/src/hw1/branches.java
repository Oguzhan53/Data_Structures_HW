/**
 * 
 */
package hw1;


/**
 * @author Oguzhan SEZGIN - 1801042005
 * This is branch class.There are branch name , employees class array and shipment class array.
 *  
 */
public class branches {
	private String name;
	public branch_empl [] employees ;
	public shipment [] ship;
	
	/**
	 * This is branches constructor 
	 * @param name This is branch's name
	 */
	public branches(String name) {
		this.name=name;
		this.employees= null;
		this.ship = null;
	}

	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	/**
	 * This method shows branch's information.It shows name , employee number in branch , shipment number in branch and employee's name
	 */
	public void show_info() {
		System.out.println("Branch Name 			: "+getName());
		if(employees==null)
			System.out.println("Employee Number 		: 0");
		else
			System.out.println("Employee Number 		: " +employees.length);
		if(ship==null)
			System.out.println("Shipment Number 		: 0");
		else
			System.out.println("Shipment Number 		: " +ship.length);
		System.out.println("Employees : ");
		if(this.employees!=null) {
			for(int i=0;i<employees.length;i++) {
				employees[i].show();
			}
			
		}
		
		System.out.println("------------");
		
	}
}
