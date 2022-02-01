package hw2;

import java.util.ArrayList;

/**
 * This is test cases class
 * @author Oguzhan SEZGIN
 *
 */
public class test_cases {

	
	public ArrayList<branches>branch;  
	public ArrayList<transporter_pers> transport; 
	public ArrayList<customer> custom;   
	public admin ad;
	
	public test_cases( ) {
		ad=new admin("test","123");
		this.branch=new ArrayList<branches>() ;  
		this.transport= new ArrayList<transporter_pers>(); 
		this.custom = new ArrayList<customer>();   
	}
	
	
	/**
	 * This is admin test method
	 */
	public void admin_test() {
		System.out.println("--------- ADMIN TEST ---------");
		
		System.out.println("---------Add Branch---------");
		this.ad.add_Branch(branch, "Gebze");
		this.ad.add_Branch(branch, "Kadikoy");
		this.ad.add_Branch(branch, "Maltepe");
		methods.print_Braches(branch);
		System.out.println("---------Remove Branch---------");
		this.ad.remove_Branch(branch, "Maltepe");
		methods.print_Braches(branch);
		System.out.println("---------Add Branch Employee---------");
		this.ad.add_Branch_Employee(branch, "Oguzhan","Gebze");
		this.ad.add_Branch_Employee(branch, "Ayse","Gebze");
		this.ad.add_Branch_Employee(branch, "Hasan", "Kadikoy");
		methods.print_Employees(branch, transport);
		System.out.println("---------Remove Branch Employee---------");
		this.ad.remove_Branch_Employee(branch, "Ayse","Gebze");
		methods.print_Employees(branch, transport);
		System.out.println("---------Add Transportation Personnel---------");
		this.ad.add_Transp_Pers(transport, "Hatice", branch);
		this.ad.add_Transp_Pers(transport, "Ahmet", branch);
		methods.print_Employees(branch, transport);
		System.out.println("---------Remove Transportation Personnel---------");
		this.ad.remove_Transp_Pers(transport, "Ahmet");
		methods.print_Employees(branch, transport);
	}
	
	/**
	 * This is branch employee test method
	 */
	public void branch_emp_test() {
		System.out.println("--------- BRANCH EMPLOYEE TEST ---------");
		this.ad.add_Branch(branch, "Gebze");
		this.ad.add_Branch_Employee(branch, "Oguzhan","Gebze");
		branch_empl ins_emp=this.branch.get(0).getEmployees().get(0);
		System.out.println("---------Create Shipment---------");
		ins_emp.create_Ship("Melis","Burak", "in_branch", 10);
		ins_emp.create_Ship("Pelin","Berke", "on_road", 11);
		ins_emp.create_Ship("Huseyin","Mustafa", "in_brach", 12);
		methods.print_Shipment(branch.get(0));
		System.out.println("---------Change Shipment Status---------");
		ins_emp.update_Ship_Info("on_road", 10);
		methods.print_Shipment(branch.get(0));
		System.out.println("---------Remove Shipment---------");
		ins_emp.remove_Ship(10);
		methods.print_Shipment(branch.get(0));
		System.out.println("---------Create Customer---------");
		ins_emp.add_customer(this.custom, "Kemal");
		ins_emp.add_customer(this.custom, "Fatih");
		methods.print_customer(custom);
		System.out.println("---------Remove Customer---------");
		ins_emp.remove_Customer(custom, "Fatih");
		methods.print_customer(custom);
		
	}
	
	/**
	 * This is transportation personnel test method
	 */
	public void transp_per_test() {
		System.out.println("--------- TRANSPORTATION PERSONNEL TEST ---------");
		this.ad.add_Branch(branch, "Gebze");
		this.ad.add_Branch_Employee(branch, "Oguzhan","Gebze");
		this.ad.add_Transp_Pers(transport, "Hasan", branch);
		branch_empl ins_emp=this.branch.get(0).getEmployees().get(0);
		ins_emp.create_Ship("Melis","Burak", "in_branch", 10);
		methods.print_Shipment(branch.get(0));
		transporter_pers ins_pers=this.transport.get(0);
		System.out.println("---------Change Shipment Status---------");
		ins_pers.update_Ship_Info("delivered", 10);
		
	}
	
	/**
	 * This is customer test method
	 */
	public void customer_test() {
		System.out.println("--------- CUSTOMER TEST ---------");
		this.ad.add_Branch(branch, "Gebze");
		this.ad.add_Branch_Employee(branch, "Oguzhan","Gebze");
		branch_empl ins_emp=this.branch.get(0).getEmployees().get(0);
		ins_emp.create_Ship("Melis","Burak", "in_branch", 10);
		methods.print_Shipment(branch.get(0));
		System.out.println("---------See Shipment Information---------");
		ins_emp.add_customer(this.custom, "Fatih");
		this.custom.get(0).search_shipment(branch, 10);
	}
	
	
	
	

	
	
	
}
