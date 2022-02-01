package q1;


/**
 * This is main class
 * @author Oguzhan SEZGIN
 *
 * @param <T>
 */
public class Main <T>{

	public static void main(String[] args) {
		
		
		
 
        
		
        
		
		// -------------------------- SYSTEM TESTING --------------------------
		
		
		String [] temp = new String [10];
		LinkedArrayList<String> L_a_r= new LinkedArrayList<String>(temp);
		for(int i1=0;i1<10;i1++) { //ADD ELEMENT
			L_a_r.add_new_element(Integer.toString(i1+1));
		}
		
		L_a_r.add_new_element("53");
		L_a_r.add_new_element("54");
		L_a_r.add_new_element("55");
		L_a_r.add_new_element("56");
		L_a_r.remove_element("5");
		
		for(int i1=10;i1<20;i1++) { //ADD ELEMENT
			L_a_r.add_new_element(Integer.toString(i1+1));
		}
		
		L_a_r.remove_element("54");
		L_a_r.remove_element("20");

	
		L_a_r.print_node();
		
		/*
		//--------------------- EXCEPTION TEST ---------------------
		String [] temp = new String [10];
		LinkedArrayList<String> L_a_r= new LinkedArrayList<String>(temp);
		// Remove element in empty list 
	//	L_a_r.remove_element("54");
		//Remove non-existent element 
		
		L_a_r.add_new_element("cse");
		L_a_r.add_new_element("data");
		L_a_r.add_new_element("structure");
		L_a_r.remove_element("element");
		*/
		/*
		//----------------- NODE COMPONENT TEST -----------------
		Integer [] temp = new Integer [10];
		LinkedArrayList<Integer> L_a_r= new LinkedArrayList<Integer>(temp);
		L_a_r.getHead().add_element(1);
		L_a_r.getHead().add_element(2);
		L_a_r.getHead().add_element(3);
		L_a_r.getHead().remove_node_element(3);
		L_a_r.getHead().remove_node_element(4);
		System.out.println("search \"2\"  index result: "+L_a_r.getHead().find_element(2));
		System.out.println("search \"3\"  index result: "+L_a_r.getHead().find_element(3));
		L_a_r.getHead().print_arr();
		*/
	}

}
