package hw2;

import java.util.ArrayList;
	


/**
 *  This is branch employee class.There are employee's name , employee's job and employee's branch
 * @author Oguzhan SEZGIN - 1801042005
 *
 */


public class branch_empl implements employee{
	private String name;
	private String job;
	private branches work_branch; 
	
	/**
	 * This is branch employee constructor
	 * @param name This is employee's name
	 * @param job This is employee's job
	 * @param work_branch This is the class of the place where the employee works
	 */
	public branch_empl(String name, String job,branches work_branch) {
		this.name=name;
		this.job=job;	
		this.work_branch=work_branch;
		
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public branches getWork_branch() {
		return work_branch;
	}

	public void setWork_branch(branches work_branch) {
		this.work_branch = work_branch;
	}

	/**
	 * This method add customer by branch employee
	 * @param cs This is the customer's class
	 * @param name This is the name of customer
	 */
	public void add_customer (ArrayList<customer> cs , String name) {
		
		customer new_cs=new customer(name);
		cs.add(new_cs);
		System.out.println("DONE");
	}
	
	/**
	 * This method remove customer by branch employee
	 * @param cs This is the customer's class
	 * @param name This is the name of customer
	 */
	public void remove_Customer(ArrayList<customer>  cs,String name) {
		
		if(cs.size()==0) {
			System.out.println("\n---------------------There is no customer !---------------------\n");
		}
		else {
			int i;
			for(i=0;i<cs.size();i++) {
				if(name.equals(cs.get(i).getName())) {
					cs.remove(i);
					System.out.println("DONE");
					i=-1;
					break;
				}
			}
			if(i!=-1) {
				System.out.println("\n---------------------There is no customer this name !---------------------\n");
			}
			
		}
		
	}
	
	
	
	/**
	 * This method change the shipment status by branch employee
	 * @param status This is shipment's current status
	 * @param track This is shipment's tracking number
	 */
	public void update_Ship_Info(String status,int track) {
		ArrayList<shipment> ins_ship=work_branch.getShip();
		if(ins_ship.size()==0)
			System.out.println("\n---------------------There is no shipment !---------------------\n");
		else {
			
			int i;
			for( i=0;i<ins_ship.size();i++) {
				if(ins_ship.get(i).getTrack_num()==track) {
					ins_ship.get(i).setCurrent_status(status);
					i=-1;
					System.out.println("DONE");
					break;
				}
			}
			if(i!=-1)
				System.out.println("\n---------------------There is no shipment this number !---------------------\n");
		}
	}
	
	/**
	 * This method create new shipment by branch employee
	 * @param e_sender This is sender's name
	 * @param e_receiver This is receiver's name
	 * @param status This is shipment's current status
	 * @param e_track This is shipment's tracking number
	 */
	public void create_Ship(String e_sender,String e_receiver,String status,int e_track) { 
		shipment new_shp=new shipment(e_sender,e_receiver,status,e_track);
		ArrayList<shipment> ins_ship=work_branch.getShip();
		ins_ship.add(new_shp);
		System.out.println("DONE");
						
	}
	
	/**
	 * This method remove shipment by branch employee
	 * @param e_track This is shipment's tracking number
	 */
	public void remove_Ship(int e_track) {
		
		ArrayList<shipment> ins_ship=work_branch.getShip();	
		int l=ins_ship.size();
		int i;
		for( i=0;i<l;i++) {
			if(ins_ship.get(i).getTrack_num()==e_track) {
				ins_ship.remove(i);
				System.out.println("DONE");
				break;
			}
		}
			
	}
	
	/**
	 * This methods print employee information
	 */
	public void show() {
		System.out.println("Employee Name 	:"+getName());
		System.out.println("Employee Job 	:"+ getJob());
		
	}
	


}
