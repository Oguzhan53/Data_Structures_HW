package hw1;

/**
 * @author Oguzhan SEZGIN - 1801042005
 * This is customer class.There is customer name.
 */
public class customer {
	private String name;

	/**
	 * This is customer class constructor
	 * @param name This is customer name
	 */
	public customer (String name) {
		this.name=name;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	/**
	 * This method print shipment current status
	 * @param br This is brach array
	 * @param track_num This is shipment tracking number
	 */
	public void search_shipment(branches [] br,int track_num) {
		
		if(br!=null) {
			int i;
			for( i=0;i<br.length;i++) {
				if(br[i].ship !=null) {
					for(int i1=0;i1<br[i].ship.length;i1++) {
						if(br[i].ship[i1].getTrack_num()==track_num) {
							br[i].ship[i1].print_in();
							i=-1;
							
							break;
						}
					}
				}
				if(i==-1)
					break;

			}
			if(i!=-1)
				System.out.println("\n---------------------There is no this number shipment !---------------------\n");
		}
		else
			System.out.println("\"\\n---------------------There is no shipment !---------------------\\n\"");
		
		
		
	}
	
	
	


}
