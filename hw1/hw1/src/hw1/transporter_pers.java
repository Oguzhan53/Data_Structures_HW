package hw1;

/**
 * @author Oguzhan SEZGIN - 1801042005
 * This is transportation personnel array.There are personnel's name , personnel's job and branch class array
 *
 */
public class transporter_pers extends employee{
	private branches [] trp_bra;
	
	/**
	 * This is transportation personnel constructor
	 * @param name This is personnel's name
	 * @param job This is personnel's job
	 * @param trp_bra This is branch class array
	 */
	public transporter_pers(String name, String job,branches [] trp_bra) {
		super(name, job);
		this.trp_bra=trp_bra;
		
	}
	/**
	 * This method updates shipment current status 
	 * @param status This is shipment's current status
	 * @param track This is shipment's tracking number
	 */
	public void update_Ship_Info(String status,int track) {
		if(trp_bra==null)
			System.out.println("\n---------------------There is no shipment !---------------------\n");
		else {
			int i;
			for(i=0;i<trp_bra.length;i++) {
				if(trp_bra[i].ship!=null) {
					int i1;
					for( i1=0;i1<trp_bra[i].ship.length;i1++) {
						if(trp_bra[i].ship[i1].getTrack_num()==track) {
							trp_bra[i].ship[i1].setCurrent_status(status);
							trp_bra[i].ship[i1].print_in();
							break;
						}
						
					}
					if(i1!=trp_bra[i].ship.length)
						break;
				}
				else
					System.out.println("\n---------------------There is no shipment !---------------------\n");
				
			}
			if(i==trp_bra.length)
				System.out.println("\n---------------------There is no shipment this number !---------------------\n");
		}
		
	}
	
	
	
	
	

}
