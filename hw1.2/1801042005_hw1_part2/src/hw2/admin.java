package hw2;

import java.util.ArrayList;

/**
 * This is admin class.There are admin name and password.
 * @author Oguzhan SEZGIN - 1801042005
 * 
 */
public class admin {
	private String name;
	private String password;
	
	/**
	 * This is admin class constructor 
	 * @param name This is admin name
	 * @param password This admin password
	 */
	public  admin (String name,String password) {
		this.name=name;
		this.password=password;
	}
	
	
	
	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	/**
	 * This method adds branch employee to the branch
	 * @param branch This is branch class array
	 * @param e_name This is employee name
	 * @param b_name This is branch name which employee added
	 */
	public void add_Branch_Employee(ArrayList<branches> branch,String e_name,String b_name) {
		
		
		if(branch.size()==0) {
			System.out.println("\n---------------------There is no branch !---------------------\n");
		}
		else {
			int i;
			
			for(i=0;i<branch.size();i++) {
				if(b_name.equals(branch.get(i).getName()))
					break;
			}
			if(i==branch.size()) {
				System.out.println("\n---------------------There is no branch this name !---------------------\n");
			}
			else {
				branch_empl br =new branch_empl(e_name,"branch_emp",branch.get(i));
				ArrayList<branch_empl> ins_emp=branch.get(i).getEmployees();
				ins_emp.add(br);
				System.out.println("DONE");
				
					
				
			}
			
		}
		
		
		
	}
	/**
	  * This method removes branch employee to the branch
	 * @param branch This is branch class array
	 * @param e_name This is employee name
	 * @param b_name This is branch name which employee removed
	 */
	public void remove_Branch_Employee(ArrayList<branches>  branch,String e_name,String b_name) {
		if(branch.size()==0) {
			System.out.println("\n---------------------There is no branch !---------------------\n");
		}
		else {
			int i;
			int i4=0;
			for(i=0;i<branch.size();i++) {
				if(b_name.equals(branch.get(i).getName())) {
					ArrayList<branch_empl> ins_emp=branch.get(i).getEmployees();
					i4=1;
					int i1;
					int i3=ins_emp.size();
					for( i1=0;i1<ins_emp.size();i1++) {
						if(e_name.equals(ins_emp.get(i1).getName())) {
							ins_emp.remove(i1);
							System.out.println("DONE");
							break;
						}
						
					}
					if(i1==i3) {
						System.out.println("\n---------------------There is no branch employee this name !---------------------\n");
						break;
					}
					
				}
			}
			if(i4==0)
				System.out.println("\n---------------------There is no branch this name !---------------------\n");
		}
	}
	
	/**
	 * This methods adds transportation personnel.
	 * @param transport This is transportation personnel class array
	 * @param e_name This is personnel name
	 * @param branch This is branch class array
	 */
	public void add_Transp_Pers(ArrayList<transporter_pers> transport,String e_name,ArrayList<branches>  branch) {
		transporter_pers new_transp = new transporter_pers(e_name, "transporter", branch);
		transport.add(new_transp);
		System.out.println("DONE");
	}
	
	/**
	* This methods removes transportation personnel.
	 * @param transport This is transportation personnel class array
	 * @param e_name This is personnel name
	 */
	public void  remove_Transp_Pers(ArrayList<transporter_pers> transport, String e_name) {
		if(transport.size()==0) {
			System.out.println("\n---------------------There is no transportation personel !---------------------\n");
		}
		else {
			int i;
			int i3=transport.size();
			for( i=0;i<transport.size();i++) {
				if(e_name.equals(transport.get(i).getName())) {
					transport.remove(i);
					System.out.println("DONE");
					break;
				}
			}
			if(i==i3)
				System.out.println("\n---------------------There is no transportation personel this name !---------------------\n");
		}

	}
	
	
	/**
	 * This method adds branch
	 * @param branch This is branch class array
	 * @param br_name This is new branch name
	 */
	public void add_Branch(ArrayList<branches>branch,String br_name) {
		branches br = new branches(br_name);
		branch.add(br);
		System.out.println("DONE");
		
		
	
	}
	/**
	 * This method removes branch
	 * @param branch This is branch class array
	 * @param br_name This is new branch name
	 */
	public  void remove_Branch(ArrayList<branches> branch ,String br_name) {
		
	
		if(branch.size()==0) //branch yoksa
			System.out.println("\n---------------------There is no branch !---------------------\n");
		else {  
			
			int i;
			int l=branch.size();
			for( i=0;i<branch.size();i++) {

				if(br_name.equals(branch.get(i).getName())) {
					branch.remove(i);
					System.out.println("DONE");
					break;
				}
			}
			if(i==l)
				System.out.println("\n---------------------There is no branch this name !---------------------\n");
			
		}
		

		
	}

	
	
	
}
