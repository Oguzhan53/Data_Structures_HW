package hw1;

/**
 * @author Oguzhan SEZGIN - 1801042005
 * 
 * This is employee class.There are employee name and employee job
 * Branch employee and transportation personnel extends this employee class.
 * 
 */
abstract class employee {
	private String name;
	private String job;
	
	/**
	 * This is employee class constructor
	 * @param name This is employee name
	 * @param job This is employee job
	 */
	public employee(String name, String job) {
		this.name = name;
		this.job = job;
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
	 * This methods print employee information
	 */
	public void show() {
		System.out.println("Employee Name 	:"+getName());
		System.out.println("Employee Job 	:"+ getJob());
		
	}
	
	
}
