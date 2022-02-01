package hw1;

/**
 * @author  Oguzhan SEZGIN - 1801042005
 * This is shipment class.There are shipment sender name ,shipment receiver name , shipment tracking number and shipment current status
 *
 */
public class shipment {
	private String sender;
	private String receiver;
	private String current_status;
	private int track_num;
	
	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public String getCurrent_status() {
		return current_status;
	}

	public void setCurrent_status(String current_status) {
		this.current_status = current_status;
	}

	public int getTrack_num() {
		return track_num;
	}

	public void setTrack_num(int track_num) {
		this.track_num = track_num;
	}

	/** This is shipment constructor
	 * @param sender This is sender name
	 * @param receiver This is receiver name
	 * @param current_status This is current status
	 * @param track_num This is tracking number
	 */
	public shipment(String sender, String receiver, String current_status, int track_num) {
		this.sender = sender;
		this.receiver = receiver;
		this.current_status = current_status;
		this.track_num = track_num;
	}
	/**
	 * This method prints shipment info
	 */
	public void print_in() {
		System.out.println("Receiver	:"+receiver);
		System.out.println("Sender 		:"+sender);
		System.out.println("Status 		:"+current_status);
		System.out.println("Tracking Number      :"+track_num);
	}
}