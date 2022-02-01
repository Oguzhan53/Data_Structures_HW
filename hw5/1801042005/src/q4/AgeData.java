package q4;




/**
 * This is AgeData class.It holds age and number of age
 * @author Oguzhan SEZGIN - 1801042005
 *
 */
public class AgeData {
	protected int data;
	protected int num;
	public AgeData(int data) {
		this.data=data;
		this.num=1;

	}
	/**AgeData class parameter constructor
	 * @param data Data which will node holds
	 * @param num Number of data
	 */
	public AgeData(int data,int num) {
		this.data=data;
		this.num=num;

	}
	/**
	 *This methods make node to string
	 */
	public String toString() {
		return String.valueOf(data)+"-"+String.valueOf(num);
	}
	/**
	 * This method increase number of data
	 */
	protected void increase_num() {
		this.num=this.num+1;
	}
	/**
	 * This method decrease number of data
	 */
	protected void decrease_num() {
		this.num=this.num-1;
	}
	
}