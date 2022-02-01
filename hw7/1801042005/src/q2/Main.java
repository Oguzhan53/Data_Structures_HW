package q2;

public class Main {

	public static void main(String[] args) {
		
		MySkipList<Integer> st = new MySkipList<Integer>();
		
		st.add(5);	
		st.add(2);
		st.add(10);
		st.add(-4);
		st.add(6);
		
	/*	for(int i=0;i<100000;i++)
			st.add(i);	*/
		st.add(-5);
		
		st.add(11);
		st.add(12);
		st.add(3);
		st.add(8);
		st.add(-8);
		st.add(14);
		st.add(16);
		st.add(17);
		st.add(-1);
	
		
		//st.add(8);
	
		
	/*	for(int i=0;i<50;i++)
			st.add(i);
		*/
		System.out.println(st.toString());
	}

}
