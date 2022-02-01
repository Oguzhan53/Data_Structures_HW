package hw2;

import java.util.ArrayList;

/**
 * This is customer class.There is customer name.
 * @author Oguzhan SEZGIN - 1801042005
 * 
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
	 * @param br This is branch array
	 * @param track_num This is shipment tracking number
	 */
	public void search_shipment(ArrayList<branches>  br,int track_num) {
		
		if(br.size()!=0) {
			int i;
			
			for( i=0;i<br.size();i++) {
				ArrayList<shipment> ins_shp=br.get(i).getShip();
				for(int i1=0;i1<ins_shp.size();i1++) {
					if(ins_shp.get(i1).getTrack_num()==track_num) {
						ins_shp.get(i1).print_in();
						i=-1;
							
						break;
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
