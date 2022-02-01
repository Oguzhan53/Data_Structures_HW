package hw1;

/**
 * @author Oguzhan SEZGIN - 1801042005
 * This is admin class.There are admin name and password
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
	public void add_Branch_Employee(branches [] branch,String e_name,String b_name) {
		
		
		if(branch==null) {
			System.out.println("\n---------------------There is no branch !---------------------\n");
		}
		else {
			int i;
			
			for(i=0;i<branch.length;i++) {
				if(b_name.equals(branch[i].getName()))
					break;
			}
			if(i==branch.length) {
				System.out.println("\n---------------------There is no branch this name !---------------------\n");
			}
			else {
				branch_empl br =new branch_empl(e_name,"branch_emp",branch[i]);
				if(branch[i].employees==null) {
					branch[i].employees=new branch_empl[1];
					branch[i].employees[0]=br;
				}
					
				else {
					int l= branch[i].employees.length;
					branch_empl [] ex_br = new branch_empl [l+1];
					for(int i1=0;i1<l;i1++) {
						ex_br[i1]=branch[i].employees[i1];
					}
					branch[i].employees=ex_br;
					branch[i].employees[l]=br;
					ex_br=null;
					
				}
			}
			
		}
		
		
		
	}
	/**
	  * This method removes branch employee to the branch
	 * @param branch This is branch class array
	 * @param e_name This is employee name
	 * @param b_name This is branch name which employee removed
	 */
	public void remove_Branch_Employee(branches [] branch,String e_name,String b_name) {
		if(branch==null) {
			System.out.println("\n---------------------There is no branch !---------------------\n");
		}
		else {
			int i;
			int i4=0;
			for(i=0;i<branch.length;i++) {
				if(b_name.equals(branch[i].getName())) {
					i4=1;
					int i1;
					int i3=branch[i].employees.length;
					for( i1=0;i1<branch[i].employees.length;i1++) {
						if(e_name.equals(branch[i].employees[i1].getName())) {
							branch_empl [] ex_br_emp = new branch_empl [branch[i].employees.length-1];
							branch[i].employees[i1]=branch[i].employees[branch[i].employees.length-1];		
							for(int i2=0;i2<branch[i].employees.length-1;i2++ ) {
								ex_br_emp[i2]=branch[i].employees[i2];
							}
							branch[i].employees=ex_br_emp;
							ex_br_emp=null;
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
	 * @return This method returns added transportation personnel class array
	 */
	public transporter_pers [] add_Transp_Pers(transporter_pers [] transport,String e_name,branches [] branch) {
		transporter_pers new_transp = new transporter_pers(e_name, "transporter", branch);
		if(transport==null) {
			transport = new transporter_pers[1];
			transport[0] = new_transp;
		}
		else {
			transporter_pers [] ex_tr = new transporter_pers[transport.length+1];
			for(int i=0;i<transport.length;i++) {
				ex_tr[i]=transport[i];
			}
			ex_tr[transport.length]=new_transp;
			transport=ex_tr;
			ex_tr=null;
		}
		return transport;
	}
	
	/**
	* This methods removes transportation personnel.
	 * @param transport This is transportation personnel class array
	 * @param e_name This is personnel name
	 * @return This method returns removed transportation personnel class array
	 */
	public transporter_pers [] remove_Transp_Pers(transporter_pers [] transport, String e_name) {
		if(transport==null || transport.length==0) {
			System.out.println("\n---------------------There is no transportation personel !---------------------\n");
		}
		else {
			int i;
			int i3=transport.length;
			for( i=0;i<transport.length;i++) {
				if(e_name.equals(transport[i].getName())) {
					transport[i]=transport[transport.length-1];
					transporter_pers [] ex_tr = new transporter_pers[transport.length-1];
					for(int i1=0;i1<transport.length-1;i1++) {
						ex_tr[i1]=transport[i1];
					}
					transport=ex_tr;
					ex_tr=null;
					break;
				}
			}
			if(i==i3)
				System.out.println("\n---------------------There is no transportation personel this name !---------------------\n");
		}
		
		return transport;
		
	}
	
	
	/**
	 * This method adds branch
	 * @param branch This is branch class array
	 * @param br_name This is new branch name
	 * @return This method returns added branch class array
	 */
	public branches [] add_Branch(branches [] branch,String br_name) {
		branches br = new branches(br_name);
		if(branch!=null) {   //eger branch sayisi limit asarsa
			
			branches [] ex_br=new branches [branch.length+1];
			for(int i=0;i<branch.length;i++) {
				ex_br[i]=branch[i];
			}
			branch=ex_br;
			ex_br=null;
			branch[branch.length-1]=br;
		}
		else {  //daha once branch acilmadiysa
			branch = new branches[1];
			branch[0]=br;
			
		}
		
		return branch;
	
	}
	/**
	 * This method removes branch
	 * @param branch This is branch class array
	 * @param br_name This is new branch name
	 * @return This method returns removed branch class array
	 */
	public branches [] remove_Branch(branches [] branch ,String br_name) {
		
	
		if(branch==null) //branch yoksa
			System.out.println("\n---------------------There is no branch !---------------------\n");
		else {  
			
			int i;
			int l=branch.length;
			for( i=0;i<branch.length;i++) {
				
				
				
				if(br_name.equals(branch[i].getName())) {
					branch[i]=branch[branch.length-1];
					branches [] ex_br=new branches [branch.length-1];
					for(int i1=0;i1<branch.length-1;i1++) {
						ex_br[i1]=branch[i1];
					}
					branch=ex_br;
					ex_br=null;
					
					break;
				}
			}
			if(i==l)
				System.out.println("\n---------------------There is no branch this name !---------------------\n");
			
		}
		
		
		
		
		return branch;
	}

	
	
	
}
