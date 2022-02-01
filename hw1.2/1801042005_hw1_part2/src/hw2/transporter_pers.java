package hw2;

import java.util.ArrayList;

/**
 * This is transportation personnel array.There are personnel's name , personnel's job and branch class array
 * @author Oguzhan SEZGIN - 1801042005
 * 
 *
 */
public class transporter_pers implements employee{
	private ArrayList<branches> trp_bra;
	private String name;
	private String job;
	public ArrayList<branches> getTrp_bra() {
		return trp_bra;
	}
	public void setTrp_bra(ArrayList<branches> trp_bra) {
		this.trp_bra = trp_bra;
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
	/**
	 * This is transportation personnel constructor
	 * @param name This is personnel's name
	 * @param job This is personnel's job
	 * @param trp_bra This is branch class array
	 */
	public transporter_pers(String name, String job,ArrayList<branches> trp_bra) {
		this.job=job;
		this.name=name;
		this.trp_bra=trp_bra;
		
	}
	/**
	 * This method updates shipment current status 
	 * @param status This is shipment's current status
	 * @param track This is shipment's tracking number
	 */
	public void update_Ship_Info(String status,int track) {
		

			int i;
			for(i=0;i<trp_bra.size();i++) {
				ArrayList<shipment> ins_ship=trp_bra.get(i).getShip();
				if(ins_ship.size()!=0) {
					int i1;
					for( i1=0;i1<ins_ship.size();i1++) {
						if(ins_ship.get(i1).getTrack_num()==track) {
							ins_ship.get(i1).setCurrent_status(status);
							System.out.println("DONE");
							ins_ship.get(i1).print_in();
							break;
						}
						
					}
					if(i1!=ins_ship.size())
						break;
				}
				else
					System.out.println("\n---------------------There is no shipment !---------------------\n");
				
			}
			if(i==trp_bra.size())
				System.out.println("\n---------------------There is no shipment this number !---------------------\n");
		
		
	}
	
	public void show() {
		System.out.println("Employee Name 	:"+getName());
		System.out.println("Employee Job 	:"+ getJob());
		
	}
	
	
	

}
