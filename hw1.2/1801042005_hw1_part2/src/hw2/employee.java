package hw2;

/**
 * This is employee interface.
 * Branch employee and transportation personnel implements this employee class.
 * @author Oguzhan SEZGIN - 1801042005
 * 
 * 
 */
interface employee {
	
	/**
	 * This methods print employee information
	 */
	public void show() ;
	
	
	/**
	 * This methods update shipment information information
	 * @param status This is the current status of the shipment.
	 * @param track This is tracking number of the shipment.
	 */
	public void update_Ship_Info(String status,int track);
	
	
}
