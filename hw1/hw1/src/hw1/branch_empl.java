package hw1;

/**
 * @author Oguzhan SEZGIN - 1801042005
 * This is branch employee class.There are employee's name , employee's job and employee's branch
 *
 */


public class branch_empl extends employee{
	
	private branches work_branch; 
	
	/**
	 * This is branch employee constructor
	 * @param name This is employee's name
	 * @param job This is employee's job
	 * @param work_branch This is the class of the place where the employee works
	 */
	public branch_empl(String name, String job,branches work_branch) {
		super(name, job);
		this.work_branch=work_branch;
		
	}
	
	/**
	 * This method add customer by branch employee
	 * @param cs This is the customer's class
	 * @param name This is the name of customer
	 * @return This methods return added customer list
	 */
	public customer[] add_customer (customer [] cs , String name) {
		
		customer new_cs=new customer(name);
		if(cs == null) {
			cs = new customer[1];
			cs[0]=new_cs;
		}
		
		else {
			int l =cs.length;
			customer [] ex_cs=new customer[l+1];
			for(int i=0;i<l;i++) {
				ex_cs[i]=cs[i];
			}
			ex_cs[l]=new_cs;
			cs=ex_cs;
			ex_cs=null;
		}
		
		
		return cs;
	}
	
	/**
	 * This method remove customer by branch employee
	 * @param cs This is the customer's class
	 * @param name This is the name of customer
	 * @return This methods return removed customer list
	 */
	public customer[] remove_Customer(customer [] cs,String name) {
		
		if(cs==null) {
			System.out.println("\n---------------------There is no branch !---------------------\n");
		}
		else {
			int l=cs.length;
			int i;
			for(i=0;i<l;i++) {
				if(name.equals(cs[i].getName())) {
					cs[i]=cs[l-1];
					customer [] ex_cs=new customer[l-1];
					for(int i1=0;i1<l-1;i1++) {
						ex_cs[i1]=cs[i1];
					}
					cs=ex_cs;
					ex_cs=null;
					i=-1;
					break;
				}
			}
			if(i!=-1) {
				System.out.println("\n---------------------There is no customer this name !---------------------\n");
			}
			
		}
		
		return cs;
	}
	
	
	
	/**
	 * This method change the shipment status by branch employee
	 * @param status This is shipment's current status
	 * @param track This is shipment's tracking number
	 */
	public void enter_info(String status,int track) {
		
		if(work_branch.ship==null)
			System.out.println("\n---------------------There is no shipment !---------------------\n");
		else {
			int i;
			for( i=0;i<work_branch.ship.length;i++) {
				if(work_branch.ship[i].getTrack_num()==track) {
					work_branch.ship[i].setCurrent_status(status);
					i=-1;
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
		if(work_branch.ship==null) {
			work_branch.ship=new shipment[1];
			work_branch.ship[0]=new_shp;
		}
		else {
			int l = work_branch.ship.length;
			shipment [] ex_shp = new shipment[l+1];
			for(int i=0;i<l;i++) {
				ex_shp[i]=work_branch.ship[i];
			}
			ex_shp[l]=new_shp;
			work_branch.ship=ex_shp;
			ex_shp=null;
		}
		
		
		
	}
	
	/**
	 * This method remove shipment by branch employee
	 * @param e_track This is shipment's tracking number
	 */
	public void remove_Ship(int e_track) {
		
		if(work_branch.ship==null) {
			System.out.println("There is no shipment in branch");
		}
		else {
			int l=work_branch.ship.length;
			int i;
			for( i=0;i<l;i++) {
				if(work_branch.ship[i].getTrack_num()==e_track) {
					work_branch.ship[i]=work_branch.ship[l-1];
					break;
				}
			}
			if(i==l) {
				System.out.println("there is no this num shipment");
			}
			else {
				shipment [] ex_shp=new shipment[l-1];
				for(i=0;i<l-1;i++) {
					ex_shp[i]=work_branch.ship[i];
				}
				work_branch.ship=ex_shp;
				ex_shp=null;
			}
			
			
		}
		
		
	}
	
	
	public void setWork_branch(branches work_branch) {
		this.work_branch = work_branch;
	}
	
	


}
